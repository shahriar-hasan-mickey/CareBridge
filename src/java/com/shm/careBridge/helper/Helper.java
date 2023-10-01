/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author akhlaq-aqidah
 */
public class Helper {

//    TODO : the function is made static so that it could be called from outside directly
    public static Boolean deleteFile(String path){
        Boolean deleteState = false;
        try{
            File file = new File(path);
            deleteState = file.delete();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return deleteState;
        
    }

    
    
    public static Boolean saveFile(InputStream inputStream, String path){
        Boolean saveState = false;
        try{
            byte b[] = new byte[inputStream.available()];
            inputStream.read(b);
            
            try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
                fileOutputStream.write(b);
                fileOutputStream.flush();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            saveState = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return saveState;
    }
    
}
