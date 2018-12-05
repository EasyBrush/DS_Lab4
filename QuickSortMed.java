/**
 * 
 * @author Bryan Cheung 
 *
 */
public class QuickSortMed
{
    /**
     * gets pivot, median item  of 3 of the partition 
     * partition needs to be size >1.
     */
    public int getPivot(int[] data, int start, int stop)
    {      
        int n = (int) (Math.floor(stop-start)/2);
        int median = Math.max(Math.min(start,n), Math.min(Math.max(start,n), stop));   
        return median;
        
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
        int pivot = getPivot(data, start,stop);
        
        //swap(data, pivot, lowPartition);
        while(lowPartition < stop)
        {
            while(lowPartition < highPartition && data[lowPartition] <= data[pivot])
            {
                lowPartition += 1;
            }
            while(data[highPartition] > data[pivot])
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
        swap(data, pivot, highPartition);
        return highPartition;     
     
    }
    
    /**
     * Recursively sorts partitions
     * 
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
            //insertSort.InsertSort(data, start, stop);
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
    }
}
