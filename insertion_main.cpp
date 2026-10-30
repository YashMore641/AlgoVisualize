#include <iostream>
using namespace std;

extern "C" {
    void insertionSortSteps(int arr[], int n);
}

int main() {
    int arr[] = {14, 27, 5, 84, 9};
    int n = sizeof(arr) / sizeof(arr[0]);

    insertionSortSteps(arr, n);

    return 0;
}
