package com.example.sortingvisualizer.dto;

/**
 * Request body for POST /sort.
 * Only "algo" is required; "array" is optional and defaults to the demo array.
 */
public record SortRequest(String algo, int[] array) {
}
