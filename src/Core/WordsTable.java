/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hongnhung
 */
public class WordsTable extends AbstractTableModel
{
    private String[] columnNames = {"English","From Dictionary", "Vietnamese", "Context", "Notes"};
    private DictionaryKeep dictionary;
    private ArrayList<String> keysArrayList;
    
    public WordsTable(DictionaryKeep dictionary) {
//pass an array of objects to the constructor
        this.dictionary = dictionary;
        this.keysArrayList = Question.readAllKeys(this.dictionary);
    }
    
    
    public ArrayList<String> getKeysArrayList(){
        return keysArrayList;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        int size;
        if (dictionary == null) {
            size = 0;
        } else {
            size = dictionary.getDictionaryKeepByEngKey().size();
        }
        return size;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = dictionary.getDictionaryKeepByEngKey().get((getKeysArrayList().get(row))).getEnglishMeaning();
        } else if (col == 1) {
            temp = dictionary.getDictionaryKeepByEngKey().get((getKeysArrayList().get(row))).getDictionaryMeaning();
        } else if (col == 2) {
            temp = dictionary.getDictionaryKeepByEngKey().get((getKeysArrayList().get(row))).getVietMeaning();
        } else if (col == 3) {
            temp = dictionary.getDictionaryKeepByEngKey().get((getKeysArrayList().get(row))).getContext();
        } else if (col == 4) {
            temp = dictionary.getDictionaryKeepByEngKey().get((getKeysArrayList().get(row))).getNotes();
        }
        return temp;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }   

    @Override
    public Class getColumnClass(int col) {
        return String.class;
    }
    
}
