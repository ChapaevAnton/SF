public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 7}, 9));

        // Пример вызова метода рекурсии
        int[] arr1 = {-5, -2, 1, 5, 6, 8, 10, 20};
        System.out.println(binarySearchRecursion(arr1, 1, 0, arr1.length - 1)); // начальные low и high надо передавать в аргументы
    }

    //Линейный поиск
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    //Бинарный поиск
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key < arr[middle]) {
                high = middle - 1;
            } else if (key > arr[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //Бинарный поиск через рекурсию
    public static int binarySearchRecursion(int[] arr, int key, int low, int high) {
        //Считаем индекс центрального элемента
        int middle = low + (high - low) / 2;
        //base case(Условие выхода) - регион поиска пустой
        if (low > high) {
            //Не нашли элемента который равен ключу
            return -1;
        }
        if (key == arr[middle]) {
            //В случае если элемент в центре равняется ключу(Нашли элемент)
            return middle;
        } else if (key < arr[middle]) {
            //Рекурсивный вызов для левого подмассива
            return binarySearchRecursion(arr, key, low, middle - 1);
        } else {
            // Рекурсивный вызов для правого подмассива
            return binarySearchRecursion(arr, key, middle + 1, high);
        }
    }
}

