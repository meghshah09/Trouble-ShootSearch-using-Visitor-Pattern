/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package troubleShootSearch.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Megh Shah
 */
public class FilesLoader {
    
    private FileProcessor fileProcessor;
    private List<String> userInputs = new ArrayList<>();
   public FilesLoader(FileProcessor fpIn){
        this.fileProcessor = fpIn;
    }
    
    public List<String> loadInputs(String file){
        fileProcessor.setFileName(file);
        fileProcessor.setCount(0);
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
}
