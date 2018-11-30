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
    //0, 49 0
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
        
        /*while(!done)
        {            
            while(pivot <= data[highPartition])
            {
                --highPartition;
            }
            
            //swap(data, lowPartition, highPartition);

            
            //System.out.println(pivot);
            //System.out.println("Before data[lowPartition]: " + data[lowPartition] + " low partition value: " + lowPartition);
            while(data[lowPartition] <= pivot)
            {    
                //System.out.println("data[lowPartition]: " + data[lowPartition] + " low partition value: " + lowPartition);
                ++lowPartition;   
                
            }
            
            
            swap(data, highPartition, lowPartition);
            

            
            if(lowPartition >= highPartition)
            {
                //data[highPartition] = pivot;
                done = true;
            }
            
  
            
            /*else
            {   //r
                
                //swap data[lowPartition] and data[highPartition]
                //update pointers
                swap(data,lowPartition, highPartition);
                
                ++lowPartition;
                --highPartition;
            }
        }
        return highPartition;*/
        
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
        
        /*(//r) int temp = data[lowPartition];
        data[lowPartition] = data[highPartition];
        data[highPartition] = temp;*/
    }

}
