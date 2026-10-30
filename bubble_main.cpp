#include <iostream>
using namespace std;

extern "C" {
    void bubbleSortSteps(int arr[], int n);
}

int main() {
    int arr[] = {34, 21, 51, 83, 9};
    int n = sizeof(arr) / sizeof(arr[0]);

    bubbleSortSteps(arr, n);

    return 0;
}
