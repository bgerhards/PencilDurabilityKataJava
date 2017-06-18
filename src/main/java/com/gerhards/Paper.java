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
        int positionOfTextOnPaper = this.text.lastIndexOf(text);
        if (positionOfTextOnPaper < 0)
            return;

        char[] textCharArray = this.text.toCharArray();

        for(int i = this.text.lastIndexOf(text) + (text.length() - 1); i >= positionOfTextOnPaper; i--){
            if(pencil.erase(textCharArray[i]))
                textCharArray[i] = ' ';
            else
                break;
        }
        this.text = String.copyValueOf(textCharArray);
    }

}
