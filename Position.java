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
public class Position {
    private PageEntry p;
    private int wordIndex;
    public Position(PageEntry p,int wordIndex){
        this.p = p;
        this.wordIndex = wordIndex;
    }
    public PageEntry getPageEntry(){
        return this.p;
    }
    public int getWordIndex(){
        return this.wordIndex;
    }
}
