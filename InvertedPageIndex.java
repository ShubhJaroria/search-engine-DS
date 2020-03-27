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
public class InvertedPageIndex {
    LinkedList<PageEntry> PageList = new LinkedList<PageEntry>();
    MyHashTable h = new MyHashTable();
    public void addPage(PageEntry p){
        this.PageList.insertEnd(p);
        //System.out.print(this.PageList.getIndex(0).data.pageIndex.wordentries.size);
        for(int i=0;i<p.pageIndex.wordentries.size;i++){
            WordEntry w = p.pageIndex.wordentries.getIndex(i).data;
            h.addPositionsForWord(w);
        }
    }
    public Myset<PageEntry> getPagesWhichContainWord(String str) throws WordNotFoundException{
        boolean r=true;
        Myset<PageEntry> m = new Myset<PageEntry>();
        try{
        WordEntry w = h.getWordEntry(str);
        for(int i=0;i<w.positionlist.size;i++){
            m.Insert(w.positionlist.getIndex(i).data.getPageEntry());
        }
       
        }catch(Exception e){
            throw new WordNotFoundException("No webpage contains word "+str);
        }
        return m;
    }
}
