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
public class PageNotFoundException extends Exception {
    private String message;
    public PageNotFoundException(String msg){
        message=msg;
    }
    public void getMsg(){
        System.out.println(message);
    }
}
