package ru.geekbrains.java3;

public class Main {
    public static void main(String[] args) {
        int[] array = { 4, 1, 2, 3};
        int[] arrayTwo = {1,4,5,7,8,1,2};
        int[] resultArray = new ReturnArrayConsistsAllAfterLastFour().getResultArray(array);


        for (int i = 0; i < resultArray.length; i++) {
            System.out.printf("[ %s ] \n", resultArray[i]);

        }
        System.out.println(new CheckArrayForContentOneAndFour().doCheck(arrayTwo));
    }
}