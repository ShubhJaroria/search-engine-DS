/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;
import java.io.*; 
import java.util.Scanner;

/**
 *
 * @author Shubh
 */
public class PageEntry {
    public PageIndex pageIndex = new PageIndex();
    String pageName;
    public PageEntry(String pageName) throws FileNotFoundException{
        this.pageName=pageName;
        File file = new File("./webpages/"+pageName);
       Scanner sc = new Scanner(file); 
       String st="";
    while(sc.hasNextLine()){
      st=st+" "+sc.nextLine();  
    }   
    for(int i=0;i<st.length();i++){
        if(st.charAt(i)=='{'||st.charAt(i)=='}'||st.charAt(i)=='('||st.charAt(i)==')'||st.charAt(i)=='['||st.charAt(i)==']'||st.charAt(i)=='<'||st.charAt(i)=='>'||st.charAt(i)==','||st.charAt(i)=='.'||st.charAt(i)=='='||st.charAt(i)==':'||st.charAt(i)==';'||st.charAt(i)=='"'||st.charAt(i)=='!'||st.charAt(i)=='?'||st.charAt(i)=='#'||st.charAt(i)=='-'){
            st=st.substring(0, i)+" "+st.substring(i+1);
        }
    }
    String[] arr = st.split("   |  | ");
      for(int i=0;i<arr.length;i++){
        if(arr[i].equals("stacks")){arr[i]="stack";}
        else if(arr[i].equals("structures")){arr[i]="structure";}
        else if(arr[i].equals("applications")){arr[i]="application";}
        else{
            if(arr[i].equals("a")||arr[i].equals("an")||arr[i].equals("the")||arr[i].equals("they")||arr[i].equals("these")||arr[i].equals("this")||arr[i].equals("for")||arr[i].equals("is")||arr[i].equals("are")||arr[i].equals("was")||arr[i].equals("of")||arr[i].equals("or")||arr[i].equals("and")||arr[i].equals("does")||arr[i].equals("will")||arr[i].equals("whose")){}
            else{
            Position p = new Position(this,i);
        this.pageIndex.addPositionForWord(arr[i].toLowerCase(),p);
        //System.out.print(arr[i]+" ");
            }
        }
    }
    }
    public PageIndex getPageIndex(){
        return this.pageIndex;
    }
}

