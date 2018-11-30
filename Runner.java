import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Runner
{
    //3 param: input file, output file, type of sort
    //ReadME will explain type of sort
    
    //the changing output file names is so that we can multiple output files, maybe there's a better way?
    

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        //String input = args[0];
        //String output = args[1];
        //String sortType = args[2];
        
        String input = "ran5K.dat";
        String output ="OutFileTEST.txt";
        String sortType = "QuickSort3";
        
        try
        {
            //scanner might be better than buffered Reader and buffered writer, let's try that.
            BufferedReader inFile = new BufferedReader(new FileReader(input));
            BufferedWriter outFile = new BufferedWriter(new FileWriter(output));
            
            /*
             * read data here
             * read line by line and parse entire thing and put into an array? 
             */
            
            //int[] Data = new int[10];
            //int limit = 10;
            
            String line = ""; 
            String dataString = "";
            
            while((line = inFile.readLine()) != null)
            {                
                dataString += line + " ";
            }
            //dataString += line + " ";
            

            //parse
            String[] dataArrayString = dataString.trim().split("\\s+");
            
            System.out.println(Arrays.toString(dataArrayString));
            
            int[] Data = new int[dataArrayString.length];                  
            
            for(int i = 0; i< dataArrayString.length; i++)
            {//converts array of string to array of int
                Data[i] = Integer.parseInt(dataArrayString[i].trim());
            }
            
            //at this point we have data array
            
            System.out.println(Arrays.toString(Data) + " " + "k");
            
            QuickSort1 quickSort = new QuickSort1();
            InsertionSort insertSort = new InsertionSort();
            QuickSort2 quickSort2 = new QuickSort2();
            QuickSort3 quickSort3 = new QuickSort3();
            
            
            
            //quickSort.sort(Data, 0, Data.length-1);
            
            //insertSort.InsertSort(Data, 0, Data.length-1);
            //System.out.println(Arrays.toString(Data));
            
            
            
            /*
             * time stuff
             */
            long startTime = 0;
            long endTime = 0;
            
            
            switch(sortType)
            {
                case "QuickSort1":
                    quickSort.sort(Data,  0, Data.length-1);
                    
                case "QuickSort2":
                    if(Data.length <= 100)
                    {
                        System.out.println("insertion sort, thing is less than 100 to begin with");
                        insertSort.InsertSort(Data, 0, Data.length-1);
                    }
                    else
                    {
                        System.out.println(Data.length);
                        quickSort2.sort(Data, 0, Data.length-1);                      
                        
                    }
                    System.out.println(Arrays.toString(Data));
                    
                case "QuickSort3":
                    if(Data.length <= 50)
                    {
                        System.out.println("insertion sort, thing is less than 50 to begin with");
                        insertSort.InsertSort(Data, 0, Data.length-1);
                    }
                    else
                    {
                        System.out.println(Data.length);
                        quickSort2.sort(Data, 0, Data.length-1);                      
                        
                    }
                    System.out.println(Arrays.toString(Data));
                case "QuickSort4" :
                    
            }
            
            
            
            
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
