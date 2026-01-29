package org.doctorajan;

public class Main {
    static void main() {

        Main main = new Main();
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

        number = 10;
        int newNumber = main.add(number, 20);
        System.out.println("New number is " + newNumber);

        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100.0);
        bankAccount.getBalance();
        bankAccount.withdraw(50.0);
        bankAccount.getBalance();
    }

    public int add(int a, int b) {
        return a + b;
    }
}
