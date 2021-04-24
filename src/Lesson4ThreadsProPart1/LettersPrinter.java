package Lesson4ThreadsProPart1;

public class LettersPrinter {

        private final Object monitor = new Object();
        private volatile char currentLetter = 'A';
        private final int numberOfLoops = 5;


        public void printLetterA() {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < numberOfLoops; i++) {
                        while (currentLetter != 'A') {
                            monitor.wait();
                        }
                        System.out.print(i+1 + " A");
                        currentLetter = 'B';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printLetterB() {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < numberOfLoops; i++) {
                        while (currentLetter != 'B') {
                            monitor.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'C';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    public void printLetterC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < numberOfLoops; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C" + "\n");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
