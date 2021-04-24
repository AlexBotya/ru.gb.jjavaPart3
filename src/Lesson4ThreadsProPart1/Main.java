package Lesson4ThreadsProPart1;

public class Main {
    public static void main(String[] args) {

        LettersPrinter lettersPrinter = new LettersPrinter();
        Thread thread1 = new Thread(lettersPrinter::printLetterA);
        Thread thread2 = new Thread(lettersPrinter::printLetterB);
        Thread thread3 = new Thread(lettersPrinter::printLetterC);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

