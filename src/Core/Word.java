package Core;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.util.*;
import java.io.IOException;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONString;



public class Word implements Serializable {
    private String englishMeaning;
    private String dictionaryMeaning;
    private String vietMeaning;
    private String context;
    private String notes;
    
    public Word(String englishMeaning, String dictionaryMeaning, String vietMeaning, String context, String notes){
        this.englishMeaning = englishMeaning;
        this.dictionaryMeaning = dictionaryMeaning;
        this.vietMeaning = vietMeaning;
        this.context = context;
        this.notes = notes;
    }
    
    public String getEnglishMeaning(){
        return englishMeaning;
    }
    
    public String getDictionaryMeaning(){
        return dictionaryMeaning;
    }
    
    public String getVietMeaning(){
        return vietMeaning;
    }
    
    public String getContext(){
        return context;
    }
    
    public String getNotes(){
        return notes;
    }
    
    public String getFullVietMeaning() {
        String fullVietMeaning = String.join("\n", vietMeaning, dictionaryMeaning);
        return fullVietMeaning;
    }
    
    public static void addWordToDict(String englishMeaning, String dictionaryMeaning, String vietMeaning, String context, String notes) {
        Word word = new Word(englishMeaning, dictionaryMeaning, vietMeaning, context, notes);
        VocabularyApp.getDictionary().getDictionaryKeepByEngKey().put(englishMeaning, word);
    }
    
    
    @Override
    public String toString(){
        return "Word{" + "english= '" + englishMeaning + '\'' + ", vietnamese='" + vietMeaning + '\'' + "}";
    }
    
    public static String getWordData(String word) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20220201T201800Z.e88c0765cc58230d.77205ba94b1a7962d5e73561bf7cae791f81a1c4&lang=en-vi&text=" + word).openConnection();
        
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();
            
            JSONObject responseObject = new JSONObject(response);
            JSONArray responseText = responseObject.getJSONArray("text");
            String responseTranslation = responseText.toString();
            responseTranslation = responseTranslation.substring(2, responseTranslation.length()-2);
                    
            return responseTranslation;
        }
        
        return null;
    }
}