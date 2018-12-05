//import java.util.Arrays;

/**
 * quick sort with 1st item as pivot
 * partition size 1 and 2 stopping case
 * @author Bryan
 *
 */
public class QuickSort1
{
    //private int[] data;
   
    public QuickSort1()//int[] Data)
    {
        //this.data = Data;     
        //pivot = data[0];
    }
    
    
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
        //boolean done = false;
        int lowPartition = start;
        int highPartition = stop;
        int pivot = getPivot(data, start);
        //int temp;
        
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
     * Recursively sorts high partitions and low partitions
     * @param int[] data
     * @param start : beginning of array
     * @param stop : end of array
     */
    public void sort(int[] data, int start, int stop)
    {
        int low = start;
        int high = stop;
        //recursion
        //base case: if 1 or 0 elements to sort -> already sorted
        if(start >= stop)
        {
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
     * swaps the data points at index i and j
     * @param data
     * @param i
     * @param j
     */
    public void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        
        /*(//r) int temp = data[lowPartition];
        data[lowPartition] = data[highPartition];
        data[highPartition] = temp;*/
    }

}
