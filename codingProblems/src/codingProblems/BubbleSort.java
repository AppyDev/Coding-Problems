package codingProblems;

public class BubbleSort {
	public static void main(String args[])
	{
		int[] arr = {10,6,8,23,6};
		BubbleSortMethod(arr);
		for(int n:arr)
			System.out.print(n+" ");
	}
	public static void BubbleSortMethod(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }
	public static void sort(int[] array) {
        int unsortedBelow = array.length;
        while (unsortedBelow != 0) {
            int lastSwap = 0;
            for (int i = 1; i < unsortedBelow; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i, i - 1);
                    lastSwap = i;
                }
            }
            unsortedBelow = lastSwap;
        }
    }
    private static void swap(int[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
