/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.io.IOException;
import java.util.*;

public class VocabularyApp{
    public static DictionaryKeep dictionary;
    
    public static void start(){
        dictionary = FileKeep.readKeep();
        if(dictionary==null){
            dictionary = new DictionaryKeep();
        }
    }
    
    public static DictionaryKeep getDictionary() {
        return dictionary;
    }
    
}