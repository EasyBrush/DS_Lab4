/**
 * median-of-3 pivot
 * size 1 and 2 stopping case
 * 
 * @author Bryan
 *
 */
public class QuickSort4
{

    /**
     * gets pivot 
     * 
     */
    public int getPivot(int[] data, int start,int stop)
    {
        return (start+stop)/2;
    }
    
    public int partition(int[] data, int start, int stop)
    {

        int lowPartition = start;
        int highPartition = stop;
        int pivot = getPivot(data, start, stop);

        
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
    
    public void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        
    }    

}
