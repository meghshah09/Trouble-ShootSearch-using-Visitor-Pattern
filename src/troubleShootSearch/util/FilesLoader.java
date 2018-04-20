/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package troubleShootSearch.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Megh Shah
 */
public class FilesLoader {
    
    private FileProcessor fileProcessor;
    private List<String> userInputs = new ArrayList<>();
    //private Map<String,List<String>> syn = new HashMap<>();
   public FilesLoader(FileProcessor fpIn){
        this.fileProcessor = fpIn;
    }
    
    public List<String> loadInputs(String file){
        fileProcessor.setFileName(file);
        fileProcessor.setCount(0);
        userInputs.clear();
        String str = fileProcessor.readLine();
        if(str!= null){
                
                while(str !=null){
                        userInputs.add(str);
                    str = fileProcessor.readLine();
                }
        }
        else{
                System.out.println("Input File is Empty.");
                System.out.println("Please Kindly enter the Data in the input and run it.");
                System.exit(0);
        }
        fileProcessor.close();
        return userInputs;
    }
    
    public Map<String,List<String>> loadSynFile(String fileIn){
        Map<String,List<String>> syn = new HashMap<>();
        
        fileProcessor.setFileName(fileIn);
        fileProcessor.setCount(0);
        syn.clear();
        String str = fileProcessor.readLine();
        if(str!= null){
                
                while(str !=null){
                    String [] arr = str.split(":");
                    String [] list = arr[1].split(" ");
                    List <String> temp = new ArrayList<String>();
                    for(String s :list)
                        temp.add(s);
                    syn.put(arr[0],temp);
                    str = fileProcessor.readLine();
                   // temp.clear();
                }
        }
        else{
                System.out.println("Input File is Empty.");
                System.out.println("Please Kindly enter the Data in the input and run it.");
                System.exit(0);
        }
        fileProcessor.close();
        return syn;
    }
    
    
}
