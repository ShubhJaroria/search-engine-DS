/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shubh
 */
public class SearchEngine {
    InvertedPageIndex ipg;
    public SearchEngine(){
        ipg = new InvertedPageIndex();
    }
    public void performAction(String str){
       
        String arr[] = str.split(" ");
        if(arr.length==2){
            if("addPage".equals(arr[0])){
                try {
                    PageEntry p  = new PageEntry(arr[1]);
                    this.ipg.addPage(p);
                } catch (FileNotFoundException ex) {
                   System.out.println(ex.getMessage());
                }  
            }
            if("queryFindPagesWhichContainWord".equals(arr[0])){
                try{
                Myset<PageEntry> m;
                    m = ipg.getPagesWhichContainWord(arr[1].toLowerCase());
                   String s="";
                   for(int i=0;i<m.size;i++){
                       PageEntry p = m.getIndex(i).data;
                       s=s+p.pageName+", ";
                   }
                   s=s.substring(0, s.length()-2);
                   System.out.println(s);
                }catch(WordNotFoundException e){
                    e.getMsg();
                }
            }
        }
        else if(arr.length==3){
            if("queryFindPositionsOfWordInAPage".equals(arr[0])){
                String word = arr[1].toLowerCase(); String d = arr[2].toLowerCase();String s ="";
                
                try{
                Boolean tmp =false;
                for(int k=0;k<this.ipg.PageList.size;k++){
                    if(d.equals(this.ipg.PageList.getIndex(k).data.pageName)){
                        tmp=true;break;
                    }
                }
                if(tmp==false){
                    throw new PageNotFoundException("No webpage "+d+" found");
                }
                
                
                WordEntry w;
                w = this.ipg.h.getWordEntry(word);
                if(w==null){throw new WordNotFoundException("Webpage "+d+" does not contain word "+word);}
                for(int i=0;i<w.positionlist.size;i++){
                    if(d.equals(w.positionlist.getIndex(i).data.getPageEntry().pageName)){
                    int idx = w.positionlist.getIndex(i).data.getWordIndex();
                    System.out.print("");
                        s=s+idx+", ";
                    }
                }
                String k = s.substring(0, s.length()-2);s=k;
                System.out.println(s);
                }catch(PageNotFoundException e){
                    e.getMsg();
                }
                catch(WordNotFoundException e){
                    e.getMsg();
                }
                
                   
                
                
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SearchEngine s = new SearchEngine();
       s.performAction("addPage stackoverflow");
    }
    
}
