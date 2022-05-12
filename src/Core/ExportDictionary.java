/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author hongnhung
 */
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Collections;

public class ExportDictionary implements Serializable{
    static OutputStream outStream;
    
    public static void writeToExternal() throws IOException{
        ArrayList<String> keysWordArrayList = Question.readAllKeys(VocabularyApp.getDictionary());
        Collections.sort(keysWordArrayList);
        
        PrintWriter printw = null;
        try {
            outStream = new FileOutputStream("SavedDictionary.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        StringBuilder strbuilder = new StringBuilder();
        String nameColumnsList = "English word, Dictionary Meaning, Vietnamese Mwaning, Word in Context, Notes";
        
        strbuilder.append(nameColumnsList + "\n");
        
        for (int i=0; i<keysWordArrayList.size(); i++){
            Word tempWord = VocabularyApp.getDictionary().getDictionaryKeepByEngKey().get(keysWordArrayList.get(i));
            
            strbuilder.append(tempWord.getEnglishMeaning()+",");
            strbuilder.append(tempWord.getDictionaryMeaning()+",");
            strbuilder.append(tempWord.getVietMeaning()+",");
            strbuilder.append(tempWord.getContext()+",");
            strbuilder.append(tempWord.getNotes());
            strbuilder.append('\n');
        }
        
        outStream.write(strbuilder.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println("All saved items exported succesfully");
    }
}
