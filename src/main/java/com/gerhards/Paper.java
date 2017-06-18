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
        if(text.trim().length() == 0){
            return;
        }
        char[] textCharArray = text.toCharArray();
        for(int i = 0; i < textCharArray.length; i ++){
            if(pencil.write(textCharArray[i]))
                this.text += textCharArray[i];
            else
                this.text += ' ';
        }
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
