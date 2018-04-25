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
import troubleShootSearch.enums.DebugLevel;

/**
 *
 * @author Megh Shah & Shashwat Maru
 */
public class FilesLoader {
    
    private FileProcessor fileProcessor;
    private List<String> userInputs = new ArrayList<>();
/**
 * 
 * @param fpIn FileProcessor Object
 */
   public FilesLoader(FileProcessor fpIn){
        this.fileProcessor = fpIn;
        Logger.writeMessage("In File Loader Constructor", DebugLevel.CONSTRUCTOR);
    }
    /**
     * 
     * @param file take the file name as input.
     * @return the List of all inputs
     */
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
                 Logger.writeMessage("Input File Is empty", DebugLevel.NONE );
                Logger.writeMessage("Please Kindly enter the Data in the input and run it.", DebugLevel.NONE );
                System.exit(0);
        }
        fileProcessor.close();
        return userInputs;
    }
    /**
     * 
     * @param fileIn takes the file name as input
     * @return returns the Key value data structure
     */
    public Map<String,List<String>> loadSynFile(String fileIn){
        Map<String,List<String>> syn = new HashMap<>();
        
        fileProcessor.setFileName(fileIn);
        fileProcessor.setCount(0);
        syn.clear();
        String str = fileProcessor.readLine();
        if(str!= null){
                
                while(str !=null){
                    String [] arr = str.split(":");
                    String [] list = arr[1].trim().split(" ");
                    List <String> temp = new ArrayList<String>();
                    for(String s :list)
                        temp.add(s);
                    syn.put(arr[0],temp);
                    str = fileProcessor.readLine();
  
                }
        }
        else{
                Logger.writeMessage( "Input File is Empty", DebugLevel.NONE);
                Logger.writeMessage("Please Kindly enter the Data in the input and run it",DebugLevel.NONE);
                System.exit(0);
        }
        fileProcessor.close();
        return syn;
    }
/**
 * 
 * @return object in string form. 
 */    
    @Override
  public String toString(){
      String str= "In Class File Loader";
      return str;
  }  
}
