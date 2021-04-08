/**
 * * 3. Большая задача:
 *  * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 *  * b. Класс Box в который можно складывать фрукты,
 *  * коробки условно сортируются по типу фрукта,
 *  * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 *  * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 *  * d. Сделать метод getWeight() который высчитывает вес коробки,
 *  * зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 *  * e. Внутри класса коробка сделать метод compare,
 *  * который позволяет сравнить текущую коробку с той,
 *  * которую подадут в compare в качестве параметра,
 *  * true - если их веса равны, false в противном случае
 *  * (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 *  * f. Написать метод, который позволяет пересыпать
 *  * фрукты из текущей коробки в другую коробку
 *  * (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
 *  * соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 */

package ru.geekbrains.java3.lesson1Generics.task3;

public class doTask3 {
    public static void main(String[] args) {

        Box<Fruit> box1 = new Box<>();
        Box<Fruit> box2 = new Box<>();
        for (int i = 0; i < 20; i++) {
            box1.add(new Apple());
            box2.add(new Orange());

        }

        box1.add(new Orange());
        System.out.println(box1.getWeight());

        System.out.println(box2.getWeight());

        box2.exchangeContent(box1);


        System.out.println(box1.getWeight());

        System.out.println(box2.getWeight());
        for (int i = 0; i < box2.getContentOfBox().size(); i++) {
            System.out.println(box2.getContentOfBox().get(i));

        }

    }
}
