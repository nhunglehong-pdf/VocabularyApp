/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.ArrayList;

public class Quiz {
    private int noOfQuestions;
    private int scoreEng;
    private int scoreViet;
    private ArrayList<Question> quizQuestionsArrayList;
    private ArrayList<String> selectedOptionsArrayList;
    private DictionaryKeep dictionaryKeep;
    
    public Quiz(int noOfQuestions, DictionaryKeep dictionaryKeep) {
        this.noOfQuestions=noOfQuestions;
        this.dictionaryKeep = dictionaryKeep;
        this.quizQuestionsArrayList = new ArrayList<Question>();
        this.selectedOptionsArrayList = new ArrayList<String>();
        this.scoreEng=0;
        this.scoreViet=0;
        this.generateQuiz();
    }
    
    private void generateQuiz(){
        int i=0;
        while(i<this.noOfQuestions){
            Question question = new Question(this.dictionaryKeep);
            if(isQuestionUnique(question)){
                this.quizQuestionsArrayList.add(question);
                i++;
            }
        }
    }
    
    private boolean isQuestionUnique(Question question){
        for(int i=0;i<this.quizQuestionsArrayList.size();i++){
            if(this.quizQuestionsArrayList.get(i).getEngQuestionWord().equals(question.getEngQuestionWord())){
                return false;
            }
        }
        return true;
    }
    
    public void allSelectedOptions(String selectedOption){
        this.selectedOptionsArrayList.add(selectedOption);
    }
    
    public int calculateScoreEngMode(){
        for (int i=0;i<this.quizQuestionsArrayList.size();i++){
            String selectedOption=this.selectedOptionsArrayList.get(i);
            if (this.quizQuestionsArrayList.get(i).isVietOptionCorrect(selectedOption)){
                this.scoreEng+=10;
            }
        }
        return this.scoreEng;
    }
    
    public int calculateScoreVietMode(){
        for (int i=0;i<this.quizQuestionsArrayList.size();i++){
            String selectedOption=this.selectedOptionsArrayList.get(i);
            if (this.quizQuestionsArrayList.get(i).isEngOptionCorrect(selectedOption)){
                this.scoreViet+=10;
            }
        }
        return this.scoreViet;
    }
    
    public int getScoreEngMode(){
        return this.scoreEng;
    }
    
    public int getScoreVietMode(){
        return this.scoreViet;
    }
    
    public int getNoOfQuestions(){
        return noOfQuestions;
    }
    
    public ArrayList<String> getSelectedOptions(){
        return selectedOptionsArrayList;
    }
    public ArrayList<Question> getQuizQuestionsArrayList(){
        return quizQuestionsArrayList;
    }
}
