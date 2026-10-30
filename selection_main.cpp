#include <iostream>
using namespace std;

extern "C" {
    void selectionSortSteps(int arr[], int n);
}

int main() {
    int arr[] = {34, 2, 5, 8, 9};
    int n = sizeof(arr) / sizeof(arr[0]);

    selectionSortSteps(arr, n);

    return 0;
}
