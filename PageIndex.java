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
public class PageIndex {
    public LinkedList<WordEntry> wordentries = new LinkedList<WordEntry>();
    public void addPositionForWord(String str, Position p){
            if(this.containsWord(str)){
                for(int i =0;i<this.wordentries.size;i++){
                if(this.wordentries.getIndex(i).data.word.equals(str)){
                    this.wordentries.getIndex(i).data.addPosition(p);
                    break;
                }
                }
            }
            else{
                WordEntry x = new WordEntry(str);
                x.addPosition(p);
                this.wordentries.insertEnd(x);
            }
        }
    public boolean containsWord(String str){
        boolean r = false;
        for(int i =0;i<this.wordentries.size;i++){
                if(this.wordentries.getIndex(i).data.word.equals(str)){
                    r=true;
                    break;
                }
        }
        return r;
    }
    public LinkedList<WordEntry> getWordEntries(){
        return this.wordentries;
    }
}
