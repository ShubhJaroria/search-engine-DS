package searchengine;


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shubh
 */
public class Myset<X> extends LinkedList<X> {
    public boolean isEmpty(){
        return this.size==0;
    }
    public boolean isMember(X o){
        Node<X> n = new Node<X>(o,null);
        boolean c = false;
        Node<X> ptr = this.start;
        for(int i=0;i<size;i++){
            if(o==ptr.data){
                c=true;
                break;
            }
            ptr=ptr.next;
        }
        return c;
    }
    public void Delete(X o) {
        
            if(this.isMember(o)){
        Node<X> n = new Node<X>(o,null);
        Node<X> ptr = this.start;
        int k=0;
        for(int i=0;i<size;i++){
            if(o==ptr.data){
                k=i;
                break;
            }
            ptr=ptr.next;
        }  
        this.deleteIndex(k);
            }
        
    }
    public void Insert(X o){
        if(this.isMember(o)==false){
            this.insertEnd(o);
        }
    }
    public Myset<X> Union(Myset<X> a){
        Myset<X> smaller,larger = new Myset<X>();
        if(this.size>a.size){
            larger=this;
            smaller=a;
        }
        else{
            larger=a;
            smaller=this;
        }
        Node<X> ptr = larger.start;
        for(int i=0;i<larger.size;i++){
            smaller.Insert(ptr.data);
            ptr=ptr.next;
        }
        return smaller;    
    }
    public Myset<X> Intersection(Myset<X> a) {
        Myset<X> smaller,larger = new Myset<X>();
        if(this.size>a.size){
            larger=this;
            smaller=a;
        }
        else{
            larger=a;
            smaller=this;
        }
        Node<X> ptr = larger.start;
        for(int i=0;i<larger.size;i++){
            if(larger.isMember(ptr.data)){
                smaller.Insert(ptr.data);
            }
            else{
                if(smaller.isMember(ptr.data)){
                        smaller.Delete(ptr.data);    
                }
            }
            ptr=ptr.next;
        }
        return smaller;
    }
  
}
