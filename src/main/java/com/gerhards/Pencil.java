package com.gerhards;

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
    public int getPointDurability(){
        return this.pointDurability;
    }
    public int getLength(){
        return 20;
    }
    public boolean write(){
        if(pointDurability == 0)
            return false;

        pointDurability--;
        return true;
    }
}
