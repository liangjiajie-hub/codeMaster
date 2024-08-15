package com.jiejieren.acm_model;

import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        while (scanner.hasNextLine()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (scanner.nextLine().isEmpty()) break;
        }
        System.out.println("a + b = " + (a + b));
    }
}
