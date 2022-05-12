/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.*;
import java.util.stream.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public final class Question implements Serializable {
    private String engQuestionWord, vietQuestionWord;
    private String vietOptionA, engOptionA;
    private String vietOptionB, engOptionB;
    private String vietOptionC, engOptionC;
    private String vietOptionD, engOptionD;
    private String correctVietOption, correctEngOption;
    private DictionaryKeep DictionaryKeep;
    private int noOfWordsAvailable;
    private int randomNo1, randomNo2, randomNo3, randomNo4; //to generate random options for a quiz
    private String randomKey1, randomKey2, randomKey3, randomKey4;
    private Random rand = new Random();
    private ArrayList<String> keysArrayList;
    private ArrayList<String> vietOptionsArrayList;
    private ArrayList<String> engOptionsArrayList;
    private Word wordQuestionWord;
    
    public Question (DictionaryKeep dictionaryKeep) {
        this.DictionaryKeep = dictionaryKeep;
        this.noOfWordsAvailable = dictionaryKeep.getDictionaryKeepByEngKey().size();
        this.keysArrayList = new ArrayList<String>();
        this.vietOptionsArrayList = new ArrayList<String>();
        this.engOptionsArrayList = new ArrayList<String>();
        this.generateRandomNumbers();
        this.keysArrayList = readAllKeys(this.DictionaryKeep);
        this.assignRandomKeys();
        this.generateQuestion();
    }
    
    public static ArrayList<String> readAllKeys(DictionaryKeep dictionaryKeep){
        ArrayList<String> keyWordsArrayList = new ArrayList<String>();
        for (String key: dictionaryKeep.getDictionaryKeepByEngKey().keySet()){
            keyWordsArrayList.add(key);
        }
        return keyWordsArrayList;
    }
    
    public ArrayList<String> getKeysArrayList(){
        return keysArrayList;
    }
    
    //generate random numbers for the quiz questions
    private void generateRandomNumbers(){
        ArrayList<Integer> randomUniqueNumbers = this.RandomUniqueNumbers(0,noOfWordsAvailable-1,4);
        randomNo1 = randomUniqueNumbers.get(0);
        randomNo2 = randomUniqueNumbers.get(1);
        randomNo3 = randomUniqueNumbers.get(2);
        randomNo4 = randomUniqueNumbers.get(3);
    }
    
    
    //add all answer choices to an arrayList so they can be randomized
    private void readAllVietOptions(){
        this.vietOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1).getVietMeaning());
        this.vietOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey2).getVietMeaning());
        this.vietOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey3).getVietMeaning());
        this.vietOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey4).getVietMeaning());
    }
    
    private void readAllEngOptions(){
        this.engOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1).getEnglishMeaning());
        this.engOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey2).getEnglishMeaning());
        this.engOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey3).getEnglishMeaning());
        this.engOptionsArrayList.add(this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey4).getEnglishMeaning());
    }
    
    private void generateVietOptionList(){
        boolean run = true;
        
        int min = 0;
        int max = 3;
        
        ArrayList<Integer> randomUniqueNumbers = this.RandomUniqueNumbers(0, 3, 4);
        int no1 = randomUniqueNumbers.get(0);
        int no2 = randomUniqueNumbers.get(1);
        int no3 = randomUniqueNumbers.get(2);
        int no4 = randomUniqueNumbers.get(3);
        
        this.vietOptionA = this.vietOptionsArrayList.get(no1);
        this.vietOptionB = this.vietOptionsArrayList.get(no2);
        this.vietOptionC = this.vietOptionsArrayList.get(no3);
        this.vietOptionD = this.vietOptionsArrayList.get(no4);
    }
    
    private void generateEngOptionList(){
        boolean run = true;
        
        int min = 0;
        int max = 3;
        
        ArrayList<Integer> randomUniqueNumbers = this.RandomUniqueNumbers(0, 3, 4);
        int no1 = randomUniqueNumbers.get(0);
        int no2 = randomUniqueNumbers.get(1);
        int no3 = randomUniqueNumbers.get(2);
        int no4 = randomUniqueNumbers.get(3);
        
        this.engOptionA = this.engOptionsArrayList.get(no1);
        this.engOptionB = this.engOptionsArrayList.get(no2);
        this.engOptionC = this.engOptionsArrayList.get(no3);
        this.engOptionD = this.engOptionsArrayList.get(no4);
    }
    
    public void generateQuestion(){
            this.engQuestionWord = this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1).getEnglishMeaning();
            this.wordQuestionWord = this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1);
            this.correctVietOption = this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1).getVietMeaning();
                this.readAllVietOptions();
                this.generateVietOptionList();
                
            this.vietQuestionWord = this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1).getVietMeaning();
            this.correctEngOption = this.DictionaryKeep.getDictionaryKeepByEngKey().get(randomKey1).getEnglishMeaning();
                this.readAllEngOptions();
                this.generateEngOptionList();
    }
    
    //to check if the selected option is correct
    public boolean isVietOptionCorrect(String selectedOption){
        if(selectedOption.equals(this.correctVietOption)){
            return true;
        }
        else return false;
    }
    
    public boolean isEngOptionCorrect(String selectedOption){
        if(selectedOption.equals(this.correctEngOption)){
            return true;
        }
        else return false;
    }
    
    //getters to retrieve values
    public String getEngQuestionWord(){
        return engQuestionWord;
    }
    
    public String getVietOptionA(){
        return vietOptionA;
    }
    
    public String getEngOptionA(){
        return engOptionA;
    }
    
    public String getVietOptionB(){
        return vietOptionB;
    }
    
    public String getEngOptionB(){
        return engOptionB;
    }
    
    public String getVietOptionC(){
        return vietOptionC;
    }
    
    public String getEngOptionC(){
        return engOptionC;
    }
    
    public String getVietOptionD(){
        return vietOptionD;
    }
    
    public String getEngOptionD(){
        return engOptionD;
    }
    
    public String getCorrectVietOption(){
        return correctVietOption;
    }
    
    public Word getWordQuestionWord(){
        return this.wordQuestionWord;
    }
    
    private void assignRandomKeys(){
        this.randomKey1 = this.keysArrayList.get(randomNo1);
        this.randomKey2 = this.keysArrayList.get(randomNo2);
        this.randomKey3 = this.keysArrayList.get(randomNo3);
        this.randomKey4 = this.keysArrayList.get(randomNo4);
    }
    
    //to get random numbers in a range
    public ArrayList<Integer> RandomUniqueNumbers(int from, int to, int noOfNumbers){
        ArrayList<Integer> randomUniqueNumbers = new ArrayList<Integer>();
            ArrayList<Integer> roll = new ArrayList<Integer>();
            for (int i=from; i<=to; i++){
                roll.add(i); //list of index
            }
            Collections.shuffle(roll); //randomize order of index
            for (int i=0; i<noOfNumbers; i++){
                randomUniqueNumbers.add(roll.get(i)); //get the correct number of index on top of the randomized list
            }
        return randomUniqueNumbers;
    }
}