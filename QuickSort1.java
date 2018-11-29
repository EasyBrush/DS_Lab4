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
    public int getPivot(int[] data, int start, int stop)
    {
        return data[start];
    }
    
    public int partition(int[] data, int start, int stop)
    {
        boolean done = false;
        int lowPartition = start;
        int highPartition = stop;
        int pivot = getPivot(data, start, stop);
        
        while(!done)
        {
            while(data[lowPartition] <= pivot)
            {
                ++lowPartition;
            }
            
            while(pivot < data[highPartition])
            {
                --highPartition;
            }
            
            if(lowPartition >= highPartition)
            {
                done = true;
            }
            else
            {   //r
                
                //swap data[lowPartition] and data[highPartition]
                //update pointers
                swap(data,lowPartition, highPartition);
                
                ++lowPartition;
                --highPartition;
            }
        }
        return highPartition;
    }
    
    /**
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
        
        int j = partition(data, low, high);
        
        //recursively sort low partition (low to j)
        //recursively sort high partition (j+1 to high)
        sort(data, low, j);
        sort(data, j+1, high);
    }
    
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
