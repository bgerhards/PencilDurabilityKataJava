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
        if(text.trim().length() < 1){
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

    public int erase(String text, Pencil pencil){
        int positionOfTextOnPaper = this.text.lastIndexOf(text);
        if (positionOfTextOnPaper < 0)
            return -1;

        char[] textCharArray = this.text.toCharArray();

        for(int i = this.text.lastIndexOf(text) + (text.length() - 1); i >= positionOfTextOnPaper; i--){
            if(pencil.erase(textCharArray[i]))
                textCharArray[i] = ' ';
            else
                break;
        }
        this.text = String.copyValueOf(textCharArray);
        return positionOfTextOnPaper;
    }

    public void edit(String text, int positionOfEdit, Pencil pencil){
        if (text.trim().length() < 1)
            return;
        char[] currentTextArray = this.text.toCharArray();
        char[] editTextArray = text.toCharArray();

        for (int i = 0; i < editTextArray.length; i++){
            if(pencil.write(editTextArray[i]))
                currentTextArray[positionOfEdit + i] = editTextArray[i];
            else
                break;
            currentTextArray[positionOfEdit + i] = editTextArray[i];
        }
        this.text = String.copyValueOf(currentTextArray);
    }

}
