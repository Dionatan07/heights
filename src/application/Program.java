package application;

import entities.People;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("How many people you'll type? ");
        int n = input.nextInt();

        People[] vector = new People[n];
        double sumHeight = 0d;
        int under16 = 0;

        for (int i = 0; i < vector.length; i++) {
            System.out.println("Person data #" + (i + 1));
            input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Age: ");
            int age = input.nextInt();

            System.out.print("Height: ");
            double height = input.nextDouble();

            vector[i] = new People(name, age, height);
            sumHeight += height;

            if (age < 16) {
                under16++;
            }
        }

        double totalUnder16 = ((double)under16 / vector.length) * 100;

        double averageHeight = sumHeight / vector.length;
        System.out.println();
        System.out.printf("Average height: %.2f%n", averageHeight);
        System.out.print("People under the age of 16: " + String.format("%.1f", totalUnder16) + "%");

        System.out.println();
        for (People people : vector) {
            if (people.getAge() < 16) {
                System.out.println(people.getName());
            }
        }
    }
}
