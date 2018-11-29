import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
        
        String input = "";
        String output ="OutFileTEST.txt";
        String sortType = "";
        
        try
        {
            //scanner might be better than buffered Reader and buffered writer, let's try that.
            BufferedReader inFile = new BufferedReader(new FileReader(input));
            BufferedWriter outFile = new BufferedWriter(new FileWriter(output));
            
            /*
             * read data here
             * read line by line and parse entire thing and put into an array? 
             */
            
            
            /*
             * time stuff
             */
            long startTime = 0;
            long endTime = 0;
            
            
            
            
            
            
            
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
