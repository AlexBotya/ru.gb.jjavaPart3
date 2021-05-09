package ru.geekbrains.java3;

import java.lang.annotation.Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1. Создать класс, который может выполнять «тесты», в качестве тестов выступают классы
 * с наборами методов с аннотациями @Test.
 * Для этого у него должен быть статический метод start(),
 * которому в качестве параметра передается или объект типа Class,
 * или имя класса. Из «класса-теста» вначале должен быть запущен метод
 * с аннотацией @BeforeSuite, если такой имеется,
 * далее запущены методы с аннотациями @Test,
 * а по завершению всех тестов – метод с аннотацией @AfterSuite.
 * К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
 * в соответствии с которыми будет выбираться порядок их выполнения,
 * если приоритет одинаковый, то порядок не имеет значения.
 * Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
 * иначе необходимо бросить RuntimeException при запуске «тестирования».
 */
public class TestRunner {

    public static void main(String[] args) {
        String beforeSuite = "BeforeSuite";
        String test = "Test";
        String afterSuite = "AfterSuite";

        TestableClass testableClass = new TestableClass();
        Method[] methods = testableClass.getClass().getDeclaredMethods();
        String[] annotations = new String[methods.length];


        for (int i = 0; i < methods.length; i++) {
            Annotation[] tempAnnotation = methods[i].getDeclaredAnnotations();

            annotations[i] = tempAnnotation[0].toString();
            int lastPointPosition = annotations[i].lastIndexOf('.');
            int lastBracketPosition = annotations[i].lastIndexOf('(');
            annotations[i] = annotations[i].substring(lastPointPosition + 1, lastBracketPosition);
        }


        if (doQuantityMethodsCheck(annotations, beforeSuite) ||
                doQuantityMethodsCheck(annotations, afterSuite))
            throw new RuntimeException();

        doTestMethodByAnnotationName(testableClass, methods, annotations, beforeSuite);
        doTestMethodByAnnotationName(testableClass, methods, annotations, test);
        doTestMethodByAnnotationName(testableClass, methods, annotations, afterSuite);

    }

    public static void doTestMethodByAnnotationName(Object o, Method[] methods, String[] annotations, String runnableAnnotationName) {
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i].equals(runnableAnnotationName)) {
                start(o, methods[i].getName());
            }
        }
    }

    public static boolean doQuantityMethodsCheck(String[] annotations, String searchingAnnotationName) {
        int i = 0;
        for (String annotation : annotations) {
            if (annotation.equals(searchingAnnotationName)) {
                i++;
            }
        }

        return (i != 1);
    }

    public static void start(Object o, String methodName) {

        Method startedMethod;
        try {
            startedMethod = o.getClass().getDeclaredMethod(methodName);
            startedMethod.invoke(o);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

