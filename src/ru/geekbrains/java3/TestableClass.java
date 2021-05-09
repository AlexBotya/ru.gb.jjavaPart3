package ru.geekbrains.java3;

public class TestableClass {
    private int priority;
    public TestableClass() {
    }

    @Test
    public void testFunction1() {
        int priority = 1;
        System.out.println("Run testFunction1 method...");
    }

    @Test
    public void testFunction2() {
        int priority = 2;
        System.out.println("Run testFunction2 method...");
    }

    @Test
    public void testFunction3() {
        int priority = 3;
        System.out.println("Run testFunction3 method...");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Run beforeSuite method...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Run afterSuite method...");

    }


}
