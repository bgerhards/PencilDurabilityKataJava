package com.gerhards;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
        if (text.trim().length() < 1)
            return;

        ArrayList<Character> inputTextParsedToChar = parseText(text);
        for (char inputCharacter: inputTextParsedToChar)
            this.text += pencil.write(inputCharacter) ? inputCharacter : ' ';
    }

    public int erase(String text, Pencil pencil) {
        int positionOfTextOnPaper = this.text.lastIndexOf(text);
        if (positionOfTextOnPaper < 0)
            return -1;

        ArrayList<Character> currentTextParsedToChar = parseText(this.text);

        for (int i = positionOfTextOnPaper + (text.length() - 1); i >= positionOfTextOnPaper; i--) {
            if (pencil.erase(currentTextParsedToChar.get(i)))
                currentTextParsedToChar.set(i, ' ');
            else
                break;
        }
        this.text = joinParsedText(currentTextParsedToChar);
        return positionOfTextOnPaper;
    }

    public void edit(String text, int positionOfEdit, Pencil pencil) {
        if (text.trim().length() < 1)
            return;
        ArrayList<Character> currentTextParsedToChar = parseText(this.text);
        ArrayList<Character> newTextToAdd = parseText(text);

        for (int i = 0; i < newTextToAdd.size(); i++) {
            if (pencil.write(newTextToAdd.get(i))) {
                if (currentTextParsedToChar.get(positionOfEdit + i) == newTextToAdd.get(i)
                        || currentTextParsedToChar.get(positionOfEdit + i) == ' ')
                    currentTextParsedToChar.set(positionOfEdit + i, newTextToAdd.get(i));
                 else if (currentTextParsedToChar.get(positionOfEdit + i) == '\n')
                    currentTextParsedToChar.add(positionOfEdit + i, newTextToAdd.get(i));
                 else
                    currentTextParsedToChar.set(positionOfEdit + i, '@');
            } else {
                if (currentTextParsedToChar.get(positionOfEdit + i) == '\n')
                    currentTextParsedToChar.add(positionOfEdit + i, ' ');
            }
        }
        this.text = joinParsedText(currentTextParsedToChar);
    }

    private ArrayList<Character> parseText(String text){
        ArrayList<Character> newlyParsedText = new ArrayList();
        for(char character: text.toCharArray()){
            newlyParsedText.add(character);
        }
        return newlyParsedText;
    }

    private String joinParsedText(ArrayList<Character> parsedText){
        String joinedParsedText = "";
        for(char character: parsedText)
            joinedParsedText += character;
        return joinedParsedText;
    }
}
