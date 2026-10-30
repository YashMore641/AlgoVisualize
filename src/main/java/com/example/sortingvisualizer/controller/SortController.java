package com.example.sortingvisualizer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sortingvisualizer.dto.SortRequest;
import com.example.sortingvisualizer.service.SortingService;

/**
 * Replacement for the original Flask server.py:
 *   GET  /      -> renders templates/index.html
 *   POST /sort  -> returns sorting steps as JSON
 */
@Controller
public class SortController {

    private final SortingService sortingService;

    public SortController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/sort")
    @ResponseBody
    public ResponseEntity<?> sort(@RequestBody SortRequest request) {
        try {
            int[] array = (request.array() == null || request.array().length == 0)
                    ? sortingService.defaultArrayFor(request.algo())
                    : request.array();

            List<int[]> steps = sortingService.sort(request.algo(), array);
            return ResponseEntity.ok(steps);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
