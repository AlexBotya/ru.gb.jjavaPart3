package ru.geekbrains.java3;

public class ReturnArrayConsistsAllAfterLastFour {
    int[] array;
    int numberOfLastFour = -1;

    ReturnArrayConsistsAllAfterLastFour() {

    };

    private void findLastFourNumber(int[] array){

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) numberOfLastFour = i;
        }
        if (numberOfLastFour == -1) throw new RuntimeException("Array should contain at least one 4...");
    }

    public  int[] getResultArray(int[] array){
        this.array = array;
        findLastFourNumber(array);
        int[] resultArray = new int[array.length - numberOfLastFour -1];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = array[numberOfLastFour + i +1];
        }
        return resultArray;
    }
}
