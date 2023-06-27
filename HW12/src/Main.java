
public class Main {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }


    public static void cocktailShakerSort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 6};


        quickSort(arr, 0, arr.length - 1);
        System.out.println("Швидке сортування:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();


        int[] arr2 = {5, 2, 9, 1, 3, 6};
        cocktailShakerSort(arr2);
        System.out.println("Сортування перемішуванням (Шейкерне сортування):");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        }
    }

