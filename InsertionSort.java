/**
 * Insertion Sort
 * 
 * @author Bryan
 *
 */
public class InsertionSort
{
    public void InsertSort(int[] data, int start, int end)
    {
        for(int i= start; i<end; i++)
        {
            int item = data[i];
            int pointer = i;
            
            while(pointer > start && data[pointer-1] > item)
            {
                data[pointer] = data[pointer-1];
                pointer--;
            }
            
            data[pointer] = item;
        }
    }
    

}
