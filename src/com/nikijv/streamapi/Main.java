package com.nikijv.streamapi;

import com.nikijv.streamapi.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        task1();
//        task2();
//        task3();
        task4();

    }

    public static void task1() {

        Random randomizer = new Random();
        List<Integer> numbers = new ArrayList<Integer>();

        for(int i = 0; i < 20; i++)
            numbers.add(randomizer.nextInt(1000));

        for(int i = 0; i < 20; i++)
            System.out.print(numbers.get(i) + " ");

        System.out.println();
        info(numbers);
    }

    public static void task2() {

        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        generateProducts(products);

        while(true) {

            System.out.print("""
                    Choose an option: \
                    
                    1. View products
                    2. View products with name size less than 5
                    3. Get certain product count
                    4. Get products by certain letter
                    5. Get all milk products
                    6. Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 1:
                    products.forEach(System.out::print);
                    System.out.println();
                    break;

                case 2:
                    products.stream()
                            .filter(p -> p.name.length() < 5)
                            .forEach(System.out::print);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    long count = 0;

                    if(products.stream().noneMatch(p -> p.name.equals(name)))
                        System.out.println("No such products found");

                    else {

                        count = products.stream().filter(p -> p.name.equals(name))
                                .count();
                        System.out.println(count + " products found");

                    }
                    break;

                case 4:
                    System.out.print("Enter first letter: ");
                    char letter = scanner.nextLine().charAt(0);

                    if(products.stream().noneMatch(p -> p.name.charAt(0) == letter))
                        System.out.println("No such products found");

                    else {

                        products.stream().filter(p -> p.name.charAt(0) == letter)
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 5:
                    products.stream().filter(p -> p.category.equals("Milk"))
                            .forEach(System.out::print);
                    System.out.println();
                    break;

                case 6: break;

                default: System.out.println("Invalid choice\n");

            }

            if(choice == 6)
                break;

        }

        scanner.close();

    }

    public static void task3() {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        List<Device> devices = new ArrayList<>();
        generateDevices(devices);

        while(true) {

            System.out.print("""
                    Choose an option: \
                    
                    1. Get all devices
                    2. Get devices by colour
                    3. Get devices by year
                    4. Get devices that are more expensive than definite price
                    5. Get devices by type
                    6. Get devices by year range
                    7. Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 1:
                    devices.forEach(System.out::print);
                    System.out.println();
                break;

                case 2:
                    System.out.print("Enter colour: ");
                    String colour = scanner.nextLine();

                    if(devices.stream().noneMatch(p -> p.colour.equals(colour)))
                        System.out.println("No such devices found");

                    else {
                        devices.stream().filter(p -> p.colour.equals(colour))
                                .forEach(System.out::print);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    if(devices.stream().noneMatch(p -> p.productionYear == year))
                        System.out.println("No such devices found");

                    else {

                        devices.stream().filter(p -> p.productionYear == year)
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 4:
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    if(devices.stream().noneMatch(p -> p.price > price))
                        System.out.println("No such devices found");

                    else {

                        devices.stream().filter(p -> p.price > price)
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 5:
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();

                    if(devices.stream().noneMatch(p -> p.type.equals(type)))
                        System.out.println("No such devices found");

                    else {

                        devices.stream().filter(p -> p.type.equals(type))
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 6:
                    System.out.print("Enter starting year: ");
                    int startingYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter ending year: ");
                    int endingYear = scanner.nextInt();
                    scanner.nextLine();

                    if(startingYear > endingYear){

                        int temp = startingYear;
                        startingYear = endingYear;
                        endingYear = temp;

                    }

                    int finalStartingYear = startingYear;
                    int finalEndingYear = endingYear;

                    if(devices.stream().noneMatch(p -> p.productionYear >= finalStartingYear && p.productionYear <= finalEndingYear))
                        System.out.println("No such devices found");

                    else {

                        devices.stream().filter(p -> p.productionYear >= finalStartingYear && p.productionYear <= finalEndingYear)
                                .forEach(System.out::print);
                        System.out.println();

                    }

                    break;

                case 7: break;

                default: System.out.println("Invalid choice\n");

            }

            if(choice == 7)
                break;


        }

        scanner.close();

    }

    public static void task4() {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        List<Projector> projectors = new ArrayList<>();
        generateProjectors(projectors);

        while(true) {

            System.out.print("""
                    Choose an option: \
                    
                    1. Get all projectors
                    2. Get projectors by manufacturer
                    3. Get projectors by recent year
                    4. Get projectors that are more expensive than certain price
                    5. Get projectors sorted by price, ascending
                    6. Get projectors sorted by price, descending
                    7. Get projectors sorted by production year, ascending
                    8. Get projectors sorted by production year, descending
                    9. Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 1:
                    projectors.forEach(System.out::print);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();

                    if(projectors.stream().noneMatch(p -> p.manufacturer.equals(manufacturer)))
                        System.out.println("No such projectors found");

                    else {

                        projectors.stream().filter(p -> p.manufacturer.equals(manufacturer))
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 3:

                    if(projectors.stream().noneMatch(p -> p.productionYear == 2025))
                        System.out.println("No such projectors found");

                    else {

                        projectors.stream().filter(p -> p.productionYear == 2025)
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 4:
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    if(projectors.stream().noneMatch(p -> p.price > price))
                        System.out.println("No such projectors found");

                    else {

                        projectors.stream().filter(p -> p.price > price)
                                .forEach(System.out::print);
                        System.out.println();

                    }
                    break;

                case 5:
                    projectors.stream()
                            .sorted((p1, p2) -> Double.compare(p1.price, p2.price))
                            .forEach(System.out::print);
                    System.out.println();
                    break;

                case 6:
                    projectors.stream()
                            .sorted((p1, p2) -> Double.compare(p1.price, p2.price) * -1)
                            .forEach(System.out::print);
                    System.out.println();
                    break;

                case 7:
                    projectors.stream()
                            .sorted((p1, p2) -> Integer.compare(p1.productionYear, p2.productionYear))
                            .forEach(System.out::print);
                    System.out.println();
                    break;

                case 8:
                    projectors.stream()
                            .sorted((p1, p2) -> Integer.compare(p1.productionYear, p2.productionYear) * -1)
                            .forEach(System.out::print);
                    System.out.println();
                    break;

                case 9: break;

                default: System.out.println("Invalid choice\n");

            }

            if(choice == 9)
                break;

        }

        scanner.close();

    }

    private static void info(List<Integer> numbers) {
        long count = 0;
        count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Even numbers: " + count);

        count = numbers.stream()
                .filter(n -> n % 2 != 0)
                .count();
        System.out.println("Odd numbers: " + count);

        count = numbers.stream()
                .filter(Main::isTwoDigit)
                .count();
        System.out.println("Two-digit numbers: " + count);

        count = numbers.stream()
                .filter(Main::isPalindrome)
                .count();
        System.out.println("Palindrome numbers: " + count);
    }

    private static void generateProducts(List<Product> products) {

        products.add(new Product("Mk111111", "Milk"));
        products.add(new Product("Mk222", "Milk"));
        products.add(new Product("M33333", "Meat"));
        products.add(new Product("M33333", "Meat"));
        products.add(new Product("M5", "Meat"));
        products.add(new Product("F66", "Fish"));
        products.add(new Product("Mk777777", "Milk"));
        products.add(new Product("F66", "Fish"));

    }

    private static void generateDevices(List<Device> devices) {

        devices.add(new Device("N1", 2000, 20.0, "C1", "T1"));
        devices.add(new Device("N2", 2002, 20.3, "C2", "T2"));
        devices.add(new Device("N3", 2003, 20.1, "C3", "T3"));
        devices.add(new Device("N4", 2022, 23.2, "C3", "T3"));
        devices.add(new Device("N5", 2014, 30.3, "C1", "T2"));
        devices.add(new Device("N6", 2011, 40.1, "C2", "T1"));
        devices.add(new Device("N7", 2008, 38.7, "C3", "T2"));
        devices.add(new Device("N8", 2010, 64.2, "C1", "T3"));
        devices.add(new Device("N9", 2001, 10.9, "C2", "T3"));
        devices.add(new Device("N10", 2001, 11.9, "C1", "T1"));

    }

    private static void generateProjectors(List<Projector> projectors) {

        projectors.add(new Projector("P1", 2000, 20.0, "M1"));
        projectors.add(new Projector("P2", 2025, 20.0, "M2"));
        projectors.add(new Projector("P3", 2003, 20.3, "M3"));
        projectors.add(new Projector("P4", 2022, 20.1, "M3"));
        projectors.add(new Projector("P5", 2025, 30.3, "M3"));
        projectors.add(new Projector("P6", 2011, 40.9, "M1"));
        projectors.add(new Projector("P7", 2025, 38.7, "M2"));
        projectors.add(new Projector("P8", 2010, 64.2, "M3"));
        projectors.add(new Projector("P9", 2011, 10.9, "M2"));
        projectors.add(new Projector("P10", 2000, 11.9, "M1"));

    }

    private static boolean isPalindrome(Integer number) {

        String str = String.valueOf(number);
        int length = str.length();

        for(int i = 0; i < length / 2; i++) {

            if(str.charAt(i) != str.charAt(length-i-1))
                return false;

        }

        return true;
    }

    private static boolean isTwoDigit(Integer number) {

        String str = String.valueOf(number);
        int length = str.length();
        return length == 2;

    }

}
