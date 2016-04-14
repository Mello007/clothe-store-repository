package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Car> listOfCar = new ArrayList<>();
        Integer counter;
        Integer counterMarok;
        System.out.println("Сколько моделей автомобилей вы хотите добавить в список?");
        Scanner scanner = new Scanner(System.in);
        counter = scanner.nextInt();
        for (int i = 0; i < counter; i++){
            Car car = new Car();
            System.out.println(i+1 + " ая модель автомобиля");
            System.out.println("Введите ее модель: ");
            car.setAvto(scanner.next());
            System.out.println("введите количество марок машины: ");
            counterMarok = scanner.nextInt();
            for (int g = 0; g < counterMarok; g++){
                System.out.println("Введите марку машины: ");
            }
        }

        Map<String, Car> stringCarMap = new LinkedHashMap<>();
        Integer counterTwo;
        Integer counterMarokTwo;
        System.out.println("Сколько моделей автомобилей вы хотите добавить в список?");
        Scanner scanner = new Scanner(System.in);
        counter = scanner.nextInt();
        for (int i = 0; i < counter; i++){
            Car car = new Car();
            System.out.println(i+1 + " ая модель автомобиля");
            System.out.println("Введите ее модель: ");
            car.setAvto(scanner.next());
            System.out.println("введите количество марок машины: ");
            counterMarok = scanner.nextInt();
            for (int g = 0; g < counterMarok; g++){
                System.out.println("Введите марку машины: ");
            }
        }


    }
}
