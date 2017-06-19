package com.gerhards;

import java.util.ArrayList;

public class Paper {
    String text = "";

    public Paper() {
    }

    public Paper(String text) {
        this.text = text;
    }

    public String text() {
        return this.text;
    }

    public void write(String text, Pencil pencil) {
        if (text.trim().length() < 1) {
            return;
        }
//        char[] textCharArray = text.toCharArray();
        ArrayList<Character> inputTextParsedToChar = parseText(text);
        for (int i = 0; i < inputTextParsedToChar.size(); i++) {
            if (pencil.write(inputTextParsedToChar.get(i)))
                this.text += inputTextParsedToChar.get(i);
            else
                this.text += ' ';
        }
    }

    public int erase(String text, Pencil pencil) {
        int positionOfTextOnPaper = this.text.lastIndexOf(text);
        if (positionOfTextOnPaper < 0)
            return -1;

        char[] textCharArray = this.text.toCharArray();

        for (int i = this.text.lastIndexOf(text) + (text.length() - 1); i >= positionOfTextOnPaper; i--) {
            if (pencil.erase(textCharArray[i]))
                textCharArray[i] = ' ';
            else
                break;
        }
        this.text = String.copyValueOf(textCharArray);
        return positionOfTextOnPaper;
    }

    public void edit(String text, int positionOfEdit, Pencil pencil) {
        if (text.trim().length() < 1)
            return;
        char[] currentTextArray = this.text.toCharArray();
        char[] editTextArray = text.toCharArray();

        for (int i = 0; i < editTextArray.length; i++) {
            if (pencil.write(editTextArray[i])) {
                if (currentTextArray[positionOfEdit + i] == editTextArray[i]
                        || currentTextArray[positionOfEdit + i] == ' ') {
                    currentTextArray[positionOfEdit + i] = editTextArray[i];
                } else {
                    currentTextArray[positionOfEdit + i] = '@';
                }

            } else
                break;
        }
        this.text = String.copyValueOf(currentTextArray);
    }

    private ArrayList<Character> parseText(String text){
        ArrayList<Character> newlyParsedText = new ArrayList();
        for(char character: text.toCharArray()){
            newlyParsedText.add(character);
        }
        return newlyParsedText;
    }
}
