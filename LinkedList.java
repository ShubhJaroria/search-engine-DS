package searchengine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shubh
 */
public class LinkedList<X> {
    public int size;
    Node<X> start;
    Node<X> end;
    public LinkedList(){
        this.start=null;
        this.end=null;
        this.size=0;
    }
    public boolean isEmpty(){
        return start==null;
    }
    public int getSize(){
        return this.size;
    }
    public void insertStart(X val){
        Node<X> n = new Node<X>(val,null);
        if(this.isEmpty()){
            this.start=n;
            this.end=this.start;
            this.size++;
        }
        else{
            n.setNext(this.start);
            this.start=n;
            this.size++;
        }
    }
    public boolean contains(X val){
        boolean r=false;
        for(int i=0;i<this.size;i++){
            if(this.getIndex(i).data==val){
                r=true;
                break;
            }
        }
        return r;
    }
    public boolean containsString(String val){
        boolean r=false;
        for(int i=0;i<this.size;i++){
            if(this.getIndex(i).data.equals(val)){
                r=true;
                break;
            }
        }
        return r;
    }
    public void insertEnd(X val){
        Node<X> n = new Node<X>(val,null);
        if(this.isEmpty()){
            this.start=n;
            this.end=this.start;
            this.size++;
        }
        else{
            this.end.setNext(n);
            this.end=n;
            this.size++;
        }
    }
    public void insertIndex(X val, int i){
        Node<X> n = new Node<X>(val,null);
        Node<X> ptr= this.start;
        i=i-1;
        for(int k =0;k<this.size-1;k++){
            if(k==i){
              Node<X> tmp = ptr.getNext();
              n.setNext(tmp);
              ptr.setNext(n);
              break;
            }
            ptr=ptr.getNext();
        }
        this.size++;
    }
    public void deleteIndex(int i){
       if(i==0){
          this.start=this.start.next;
       }
       else if(i==this.size-1){
           Node<X> ptr = this.start;
           for(int k=0;k<=this.size-2;k++){
               ptr=ptr.getNext();
           }
           this.end.setNext(null);
           this.end=ptr;
           //this.size--;
       }
       else{
           Node<X> ptr = this.start;
           i=i-1;
            for (int k = 0; k < this.size - 2; k++) 
        {
            if (i == k) 
            {
                Node<X> tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
       }
       this.size-- ;
    }
    public Node<X> getIndex(int i){
        Node<X> ptr = this.start;
        for(int k=0;k<this.size;k++){
            if(k==i){
                break;
            }
            ptr=ptr.next;
        }
        return ptr;
    }
}
