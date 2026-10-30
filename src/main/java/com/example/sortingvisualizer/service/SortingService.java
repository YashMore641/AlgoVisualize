package com.example.sortingvisualizer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Pure Java port of the original C++ sorting routines (sorting.cpp).
 * Each algorithm records a snapshot of the array after every pass,
 * producing the same step-by-step output the compiled .exe files printed.
 */
@Service
public class SortingService {

    /** Default demo array for each algorithm (same values the original .exe files used). */
    public int[] defaultArrayFor(String algo) {
        return switch (algo) {
            case "bubble" -> new int[]{34, 21, 51, 83, 9};
            case "selection" -> new int[]{34, 2, 5, 8, 9};
            case "insertion" -> new int[]{14, 27, 5, 84, 9};
            default -> throw new IllegalArgumentException("Invalid algorithm");
        };
    }

    /** Runs the chosen algorithm on a copy of the array and returns every intermediate step. */
    public List<int[]> sort(String algo, int[] input) {
        int[] arr = input.clone();
        return switch (algo) {
            case "bubble" -> bubbleSortSteps(arr);
            case "selection" -> selectionSortSteps(arr);
            case "insertion" -> insertionSortSteps(arr);
            default -> throw new IllegalArgumentException("Invalid algorithm");
        };
    }

    public List<int[]> bubbleSortSteps(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            steps.add(arr.clone()); // print current step after each pass
        }
        return steps;
    }

    public List<int[]> selectionSortSteps(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
            steps.add(arr.clone()); // print current step after each pass
        }
        return steps;
    }

    public List<int[]> insertionSortSteps(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            steps.add(arr.clone()); // print current step after inserting key
        }
        return steps;
    }
}
