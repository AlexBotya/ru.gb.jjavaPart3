package ru.geekbrains.java3.lesson1Generics.task3;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> contentOfBox = new ArrayList<>();
    private float boxWeight = 0;

    public void add(T that) {
        if ( contentOfBox.isEmpty()) {
            contentOfBox.add(that);
        }else if (contentOfBox.get(0).getClass() == that.getClass()){
            contentOfBox.add(that);
        }
        else {
            System.out.println("You should put object of other class");
        }
    }

    public List<T> getContentOfBox(){
        return contentOfBox;
    }


    //Метод добавляет яблоки к апельсинам... это неправильно
    public void addFromLesson(T fruit){
        contentOfBox.add(fruit);
    }


    public float getWeight(){
        if (contentOfBox.isEmpty()){
            return 0.0f;
        }
        for (int i = 0; i < contentOfBox.size(); i++) {
            boxWeight = boxWeight + contentOfBox.get(i).getWeight();
        }
        return boxWeight;
    }
    public boolean compare(Box< ? extends Fruit> that){
        return getWeight() == that.getWeight();

    }

    public void exchangeContent(Box<T> that){
        if (contentOfBox.get(0).equals(that.contentOfBox.get(0))){
        contentOfBox.addAll(that.getContentOfBox());
        that.contentOfBox.clear();
        } else {
            contentOfBox.clear();
            contentOfBox.addAll(that.getContentOfBox());
            that.contentOfBox.clear();
        }
    }

}
