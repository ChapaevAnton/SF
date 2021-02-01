public class MergeSort {

    public static void main(String[] args) {

    }

    /**
     * @param src1      - Первый массив
     * @param src1Start - с какого элемента начинать слияние
     * @param src2      - второй массив
     * @param src2Start - с какого эдемента начинать слияние
     * @param dest      -массив приемник
     * @param destStart - с какого элемента начинать запись в массив приемник
     * @param size      - указывает какого размера подмассивы мы хотим сливать
     */

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                              int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1end = Math.min(src1Start + size, src1.length);
        int src2end = Math.min(src2Start + size, src2.length);

        int iterationCount = src1end - src1Start + src2end - src2Start;
        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1end && (index2 >= src2end || src1[index1] < src2[index2])) {
                dest[i] = src1[index1++];
            } else {
                dest[i] = src2[index2++];
            }
        }
    }

    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size *= 2;

            System.out.println(arrayToString(currentSrc));
        }
        return currentSrc;
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
