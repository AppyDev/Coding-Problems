package codingProblems;

import java.util.Random;

public class QuickSort 
{
    public void sort(int[] inputArr) 
    {
        if (inputArr == null || inputArr.length == 0) 
        {
            return;
        }
        quickSort(inputArr, 0, inputArr.length - 1);
    }
 
    private void quickSort(int[] array, int lowerIndex, int higherIndex) 
    {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Random ran = new Random();
        int n = higherIndex - lowerIndex;
        int k = ran.nextInt(higherIndex) % n;
        int pivot = array[lowerIndex +k];
        //int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) 
        {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) 
            {
                i++;
            }
            while (array[j] > pivot) 
            {
                j--;
            }
            if (i <= j) 
            {
                swapNumbers(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
 
    private void swapNumbers(int[] array, int i, int j) 
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[])
    {
        QuickSort sorter = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.sort(input);
        for(int i:input)
        {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}