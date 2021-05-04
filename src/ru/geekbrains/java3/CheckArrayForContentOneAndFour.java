package ru.geekbrains.java3;

public class CheckArrayForContentOneAndFour {
    int[] array;
    boolean isFourContent;
    boolean isOneContent;


    public boolean doCheck(int[] array){
        this.array = array;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) isOneContent = true;
            if (array[i] == 4) isFourContent = true;

        }
        return (isFourContent && isOneContent);
    }
}
