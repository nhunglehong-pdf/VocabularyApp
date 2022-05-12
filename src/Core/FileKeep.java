/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.io.*;

public class FileKeep {
    public static void writeKeep() {
        Object objectKeep = VocabularyApp.getDictionary();
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(new File("dictionary.dat"));
            
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            //write object to file
            objectOut.writeObject(objectKeep);
            
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException e){
            System.out.println("");
        } catch (IOException e){
            System.out.println("");
        }
    }
    
    public static DictionaryKeep readKeep(){
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(new File("dictionary.dat"));
            
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            //read from saved object
            DictionaryKeep keptDictionary = (DictionaryKeep) objectIn.readObject();
            
            objectIn.close();
            fileIn.close();
            
            return keptDictionary;
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e){
            System.out.println("");
        } catch (ClassNotFoundException e){
            System.out.println("");
        }
        return null;
    }
}
