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
public class Node<X> {
    X data;
    Node<X> next;
    public Node(){
        next = null;
        data = null;
    }
    public Node(X o,Node<X> n){
        next = n;
        data = o;
    }
    public Object getData(){
        return this.data;
    }
    public void setData(X o){
        this.data = o;
    }
    public void setNext(Node<X> n){
        this.next=n;
    }
    public Node<X> getNext(){
        return this.next;
    }
   
}
