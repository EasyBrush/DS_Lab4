//import java.util.Arrays;

/**
 * quick sort: 1st item as pivot
 * partition size 100 stopping case: insertion sort to finish
 * @author Bryan Cheung
 *
 */
public class QuickSort2
{      
    /**
    * gets pivot, first item of partition 
    * partition needs to be size >1.
    */
    public int getPivot(int[] data, int start)
    {
        return data[start];
    }
    /**
     * Partitions array into a high partition and low partition
     *  returns the highPartition start index
     * @param data
     * @param start
     * @param stop
     * @return
     */
    public int partition(int[] data, int start, int stop)
    {
        int lowPartition = start;
        int highPartition = stop;
        int pivot = getPivot(data, start);
            
        //swap(data, start, lowPartition);
        while(lowPartition < stop)
        {
           while(lowPartition < highPartition && data[lowPartition] <= pivot)
            {
                lowPartition += 1;
            }
            while(data[highPartition] > pivot)
            {
                highPartition -= 1;
            }
            if(lowPartition < highPartition)
            {                
                swap(data,lowPartition, highPartition);
            }
            else
            {
                break;
            }
        }
        swap(data, start, highPartition);
        return highPartition;
        
    }
    
    /**
     * Recursively sorts highPartition and lowPartition
     * base case: partition size<= 100. 
     * Insertion sort to completion
     * @param int[] data
     * @param start : beginning of array
     * @param stop : end of array
     */
    public void sort(int[] data, int start, int stop)
    {
        InsertionSort insertSort = new InsertionSort();
        int low = start;
        int high = stop;
        //recursion
        
        //base case: if partition size <= 100
        if(low-high <= 100 || high-low <=100)
        {
            //System.out.println("Doing Insert Sort");
            insertSort.InsertSort(data, start, stop);
            //System.out.println(Arrays.toString(data) + "Start: " + start + "Stop: " + stop);
            return;
        }    
        //System.out.println(Arrays.toString(data));
        
        int j = partition(data, low, high); 
        
        //System.out.println(Arrays.toString(data) + " " + "j value: " + j);
        
        //recursively sort low partition (low to j)
        //recursively sort high partition (j+1 to high)            
        sort(data, low, j-1);
        sort(data, j+1, high);        
    }
    /**
     * swaps data items at index i with j
     * @param data
     * @param i
     * @param j
     */
    public void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        
    }

    

}
