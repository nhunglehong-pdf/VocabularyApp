/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryKeep implements Serializable {
    private HashMap<String, Word> dictionaryKeepByEngKey;
    
    public DictionaryKeep(){
        this.dictionaryKeepByEngKey = new HashMap<String, Word>();
    }
    
    public HashMap<String, Word> getDictionaryKeepByEngKey(){
        return dictionaryKeepByEngKey;
    }
    
    //to search for an English word entered
    
    public Word getByEnglishWord(String engWordToSearch){
        return this.dictionaryKeepByEngKey.get(engWordToSearch);
    }
    
    
}