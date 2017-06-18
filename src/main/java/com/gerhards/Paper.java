package com.gerhards;

public class Paper {
    String text = "";

    public Paper(){}

    public Paper(String text){
        this.text = text;
    }

    public String text(){
        return this.text;
    }

    public void write(String text, Pencil pencil){
        this.text += text;
    }

    public void erase(String text, Pencil pencil){
        this.text = "     ";
    }

}
