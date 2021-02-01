public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};
        bubbleSort1(array);
        System.out.println(arrayToString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
          //  System.out.println(arrayToString(array)); Здесь можно увидеть по шагам
        }
    }

    public static void bubbleSort1(int[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = array.length - 1; j >= i;  j--) {
                if(array[j - 1] > array[j]){
                    swap(array, j);
                }
            }
        }
    }

    private static void swap(int[] array, int i){
        int temp = array[i - 1];
        array[i - 1] = array[i];
        array[i] = temp;
    }

    private static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if(i > 0) sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
