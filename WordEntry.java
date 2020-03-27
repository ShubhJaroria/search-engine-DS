/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

/**
 *
 * @author Shubh
 */
public class WordEntry {
    public String word;
    public LinkedList<Position> positionlist = new LinkedList<Position>();
    public WordEntry(String word){
        this.word=word;
    }
    public void addPosition(Position p){
        this.positionlist.insertEnd(p);
    }
    public LinkedList<Position> getAllPositionsForThisWord(){
        return positionlist;
    }
}
