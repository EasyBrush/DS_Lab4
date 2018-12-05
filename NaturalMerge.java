import java.util.ArrayList;

/**
 * Natural Merge using linked list
 * Uses ArrayList for a linked implementation
 * -Approved by Professor Cost in Discussion
 * @author Bryan Cheung
 *
 */
public class NaturalMerge
{

    /**
     * convert array into linked list,
     */
    //not needed in this class since we
    // are using ArrayList
     
    public linkedList arrayToNode(int[] data)
    {
        linkedList list = new linkedList();
        for(int i =0; i<data.length; i++)
        {
            Node node = new Node();
            node.setData(data[i]);           
            
            list.append(node);          
        }        
        return list;
    }

    /**
     * creates sublists, recognized by pointers
     * 1,2,3,4|,3,5,6,|4,8,9,10|,2 
     * @param list
     */
    public void Partition(ArrayList<Integer> list)
    {
        int endPtr = -1;        

        for(int i=0; i< list.size(); i++)
        {           
            if((i+1) == list.size() || ((i+1) < list.size() && list.get(i) > list.get(i+1)))
            {
                //int temp = list.get(i);
                //System.out.println(temp);
                
                if(endPtr > -1)
                {//watching the array being sorted is pretty neat, 
                 //uncomment if you want to observe
                    //System.out.println("Before: " + list.toString());
                    merge(list, endPtr, i); 
                    //System.out.println("After:  " + list.toString());
                    endPtr = i;
                }
                endPtr = i;    
            } 
        }
        
        
        
    }
    
    /**
     * sorts lists using merge method
     * takes list and the end pointers of 2 sub-lists
     * merges in place.
     * 
     * @param list
     * @param lo
     * @param high
     */
    public void merge(ArrayList<Integer> list, int lo, int high)
    {
        int leftPtr =0;
        int rightPtr = lo+1;
        
        while(leftPtr != high)
        {
            if(list.get(leftPtr) <= list.get(rightPtr))
            {
                leftPtr+=1;
            }
            else
            {
                swap(list, rightPtr, leftPtr);
                leftPtr +=1;
            }
            
            if(leftPtr == rightPtr && rightPtr < high)
            {
                leftPtr = 0;
                rightPtr +=1;
            }
        }
        
    }
    /**
     * swaps ptr1 with ptr2
     * and vice versa
     * @param list
     * @param ptr1
     * @param ptr2
     */
    public void swap(ArrayList<Integer> list, int ptr1, int ptr2)
    {
        int temp = list.get(ptr1);
        list.set(ptr1, list.get(ptr2));
        list.set(ptr2, temp);
    }
    
    
  
    /**
     * prints whole list: useful for linked list class
     * @param node
     */
    /*
     *Not used: used ArrayList instead of own linked list 
     * 
     */
    public void printList(Node node)
    {
        if(node != null)
        {
            System.out.println(node.data + " ");
            while(node.next != null)
            {
                System.out.println(node.next.data + " ");
                node= node.next;
            }
            System.out.println();
        }
    }

}
