package com.gerhards;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pencil {
    private int pointDurability;
    private int maximumPointDurability;
    private int length;
    private int eraserDurability;

    public Pencil(int pointDurability, int maximumPointDurability, int length, int eraserDurability){
        this.pointDurability = pointDurability;
        this.maximumPointDurability = maximumPointDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
    }

    public boolean write(char letter){

        if(Pattern.compile("[A-Z]").matcher(Character.toString(letter)).matches()){
            if (this.pointDurability < 2)
                return false;
            this.pointDurability -= 2;
        }

        if(Pattern.compile("\\s").matcher(Character.toString(letter)).matches())
            return true;

        if(pointDurability == 0)
            return false;

        pointDurability--;
        return true;
    }

    public boolean sharpen(){
        if (length == 0)
            return false;
        length--;
        this.pointDurability = this.maximumPointDurability;
        return true;
    }
}
