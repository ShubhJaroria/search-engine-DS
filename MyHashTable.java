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
public class MyHashTable {
    LinkedListWord [] hash;

    public MyHashTable() {
        this.hash = new LinkedListWord[1000];
        for(int i =0;i<1000;i++){
            this.hash[i]=new LinkedListWord();
        }
    }
    public int getHashIndex(String str){
        int x =0;int n = str.length();
        for(int i=0;i<n;i++){
            x=(int) (x+((Math.pow(26, n-i))*str.charAt(i)));
        }
        x=x%1000;
        return x;
    }
    public boolean hashcontainsword(WordEntry w,int x){
        boolean r = false;
        for(int i = 0;i<hash[x].size;i++){
                if(((hash[x].getIndex(i).data)).word.equals(w.word)){
                    r=true;
                }
        }
        return r;
    }
    public void addPositionsForWord(WordEntry w) {
        String word = w.word;
        int x = this.getHashIndex(word);//if((w.word).equals("function")){System.out.print(x);}
            if(this.hashcontainsword(w,x)){ 
               // System.out.print("sf ");
                for(int i = 0;i<hash[x].size;i++){
                if(((hash[x].getIndex(i).data)).word.equals(word)){
                    WordEntry tmp = hash[x].getIndex(i).data;
                    for(int j =0;j<w.positionlist.size;j++){
                        if(tmp.positionlist.contains(w.positionlist.getIndex(j).data)==false){
                            tmp.positionlist.insertEnd(w.positionlist.getIndex(j).data);
                        }
                    }
                }
             }
            }
                else{
                 //if(w.word.equals("function")){System.out.print("safd ");}
                    this.hash[x].insertEnd(w);
                    //for(int i=0;i<this.hash[x].end.data.positionlist.size;i++){
                    //Position p = this.hash[x].end.data.positionlist.getIndex(i).data;
                    //    this.hash[x].getIndex(this.hash[x].size - 1).data.addPosition(p);
                    //}
                }
            }
        
    
    public WordEntry getWordEntry(String w) {
        
        boolean r = false;WordEntry t = null;
        int x = this.getHashIndex(w);
        for(int i=0;i<this.hash[x].size;i++){
            if((((this.hash[x].getIndex(i).data)).word).equals(w)){
               r=true; t=this.hash[x].getIndex(i).data;
            }
            else{
               
            }
        }
        return t;
        
        
    }
}
