/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Scanner;
import java.util.Optional;

public class Flashcard implements Serializable {
    private ArrayList<Question> flashcardQuestionsArrayList;
    private DictionaryKeep dictionaryKeep;
    
    public Flashcard (DictionaryKeep dictionaryKeep){
        this.dictionaryKeep = dictionaryKeep;
        this.flashcardQuestionsArrayList = new ArrayList<Question>();
        
        //make flashcards if dictionary has at least 3 words
        if(this.dictionaryKeep.getDictionaryKeepByEngKey().size()>=4){
            this.generateCard();
        }
    }
    
    private void generateCard(){
        int i=0;
        while(i<dictionaryKeep.getDictionaryKeepByEngKey().size()){
            Question question = new Question(this.dictionaryKeep);
            if(isQuestionUnique(question)){
                this.flashcardQuestionsArrayList.add(question);
                i++;
            }
        }
    }
    
    //check if a question is unique
    private boolean isQuestionUnique(Question question){
        for(int i=0; i<this.flashcardQuestionsArrayList.size(); i++){
            if(this.flashcardQuestionsArrayList.get(i).getEngQuestionWord().equals(question.getEngQuestionWord())){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Question> getFlashcardQuestionsArrayList(){
        return flashcardQuestionsArrayList;
    }
    
}