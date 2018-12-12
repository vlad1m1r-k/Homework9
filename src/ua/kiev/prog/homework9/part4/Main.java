package ua.kiev.prog.homework9.part4;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addLast("S");
        queue.addLast("L");
        queue.addLast("V");
        queue.addLast("K");
        queue.addLast("P");
        System.out.println("0 cola = " + queue);
        for (int i = 1; i < 11; i++){
            String temp = queue.pollFirst();
            queue.addLast(temp);
            queue.addLast(temp);
            System.out.println(i + " cola = " + queue);
        }
    }
}
