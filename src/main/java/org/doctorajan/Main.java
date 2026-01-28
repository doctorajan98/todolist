package org.doctorajan;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        int number = 20;

        if (number > 10) {
            System.out.println("number is greater than 10");
        }
        if (number < 10) {
            System.out.println("number is less than 10");
        }
        if (number == 10) {
            System.out.println("number is equal to 10");
        }

        char grade = 'D';
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            default:
                System.out.println("Fail you idiot");
                break;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.println("Iterations " + i);
        }

        while (number > 0) {
            System.out.println("number is " + number);
            number--;
        }

        number = 10;
        do {
            System.out.println("Do number is " + number);
            number--;
        } while (number > 0);
    }
}
