#include <iostream>
using namespace std;

extern "C" {
    void bubbleSortSteps(int arr[], int n);
    void selectionSortSteps(int arr[], int n);
    void insertionSortSteps(int arr[], int n);
}

int main() {
    int arr1[] = {34, 21, 51, 83, 9};
    int arr2[] = {34, 2, 5, 8, 9};
    int arr3[] = {34, 27, 57, 84, 91};

    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    int n2 = sizeof(arr2) / sizeof(arr2[0]);
    int n3 = sizeof(arr3) / sizeof(arr3[0]);

    bubbleSortSteps(arr1, n1);
    cout << endl;

    selectionSortSteps(arr2, n2);
    cout << endl;

    insertionSortSteps(arr3, n3);
    cout << endl;

    return 0;
}
