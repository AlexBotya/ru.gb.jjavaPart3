package ru.geekbrains.java3.lesson1Generics;


import java.util.ArrayList;

/**
 * 1. Написать метод, который меняет два элемента массива местами.
 * (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;

 * g. Не забываем про метод добавления фрукта в коробку.
 */


public class doTask1and2 {
    public static void main(String[] args) {
        String[] array = new String[]{"one", "two", "three"};
        printArray(array);
        doArrayElementExchange(array, 0,2);
        printArray(array);

        ArrayList convertedArray = convertArrayToArrayList(array);
        System.out.println(convertedArray);


    }

    public static void doArrayElementExchange (Object[] array, int firstElement, int secondElement){
        if (array.length > firstElement & array.length > secondElement){
            Object t = array[firstElement];
            array[firstElement] = array[secondElement];
            array[secondElement] = t;
        } else {
            System.out.println("Incorrect numbers of elements");

        }

    }

    public static ArrayList convertArrayToArrayList(Object[] array){
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);

        }
        return arrayList;
    }
    public static void printArray(Object[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

