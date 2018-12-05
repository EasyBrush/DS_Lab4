/**
 * Runner class responsible for initiating sorting methods
 * 
 * @author Bryan Cheung
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Runner
{
    //3 param: input file, output file, type of sort
    //ReadME will explain type of sort
    
    //the changing output file names is so that we can multiple output files, maybe there's a better way?
    

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String input = args[0];
        String output = args[1];
        String sortType = args[2];
        
        //String input = "ran10K.dat";
        //String output ="OutFileTEST.txt";
        //String sortType = "NaturalMergeSort";
        
        try
        {

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
            QuickSortMed quickSort4 = new QuickSortMed();
            
            NaturalMerge natMerg = new NaturalMerge();
                      
            /*
             * time stuff
             */
            long startTime = 0;
            long totalTime = 0;
            
            /*
             * conditional: depending on sort type, respective sort
             * is executed
             */
            switch(sortType)
            {
                case "QuickSort1":
                    
                    startTime = System.nanoTime();
                    quickSort.sort(Data,  0, Data.length-1);
                    totalTime = System.nanoTime()  - startTime;
                    //System.out.println(totalTime);
                    print(outFile, Data, totalTime, "QuickSort1");
                    break;
                case "QuickSort2":
                    if(Data.length <= 100)
                    {
                        //System.out.println("insertion sort, thing is less than 100 to begin with");
                        
                        startTime = System.nanoTime();
                        insertSort.InsertSort(Data, 0, Data.length-1);
                        totalTime = System.nanoTime()  - startTime;
                        //System.out.println(totalTime);
                        print(outFile, Data, totalTime, "QuickSort2");
                    }
                    else
                    {
                        //System.out.println(Data.length);
                        
                        startTime = System.nanoTime();                       
                        quickSort2.sort(Data, 0, Data.length-1);
                        totalTime = System.nanoTime()  - startTime;
                        //System.out.println(totalTime);
                        
                        print(outFile, Data, totalTime,"QuickSort2");
                        
                    }
                    //System.out.println(Arrays.toString(Data));
                    break;
                case "QuickSort3":
                    if(Data.length <= 50)
                    {
                        System.out.println("insertion sort, thing is less than 50 to begin with");
                        
                        startTime = System.nanoTime();
                        insertSort.InsertSort(Data, 0, Data.length-1);
                        totalTime = System.nanoTime()  - startTime;
                        //System.out.println(totalTime);
                        print(outFile, Data, totalTime,"QuickSort3");
                    }
                    else
                    {
                        //System.out.println(Data.length);
                        
                        startTime = System.nanoTime();
                        quickSort3.sort(Data, 0, Data.length-1);
                        totalTime = System.nanoTime()  - startTime;
                        //System.out.println(totalTime);
                        print(outFile, Data, totalTime, "QuickSort3");
                        
                    }
                    //System.out.println(Arrays.toString(Data));
                    break;
                case "QuickSort4" :
                    
                    startTime = System.nanoTime();
                    quickSort4.sort(Data,0, Data.length-1);
                    totalTime = System.nanoTime()  - startTime;
                    //System.out.println(Arrays.toString(Data));
                    //System.out.println(totalTime);
                    print(outFile, Data, totalTime, "QuickSort4");
                    
                    break;
                case "NaturalMergeSort" :
                                        
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for(int i=0; i< Data.length; i++)
                    {
                        list.add(Data[i]);
                    }
                    
                    startTime = System.nanoTime();
                    natMerg.Partition(list);
                    System.out.println(Arrays.toString(list.toArray()));
                    totalTime = System.nanoTime()  - startTime;
                    //System.out.println(totalTime);
                    outFile.write("Natural Merge Sort");
                    outFile.newLine();
                    outFile.write(Arrays.toString(list.toArray()));
                    outFile.newLine();
                    outFile.write("Time to run: " + totalTime);
                    
                    break;
                    
                default:
                    break;
                    
            }
            inFile.close();
            outFile.close();
            
            
            
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
        
    /**
     * print function to write to outFile    
     * @param outFile
     * @param Data
     * @param totalTime
     * @param sortType
     */
    public static void print(BufferedWriter outFile, int[] Data, long totalTime, String sortType)
    {
        String buffer = "";
        for(int i=0; i<Data.length; i++)
        {
            buffer += Data[i] + " ";
        }
        try
        {
            outFile.write(sortType);
            outFile.newLine();
            outFile.write(buffer);
            outFile.newLine();
            outFile.write("Time to run: " + totalTime);
            
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
