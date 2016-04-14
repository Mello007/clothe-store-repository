package ru.study.service;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        Integer counter;
        Integer allPrice;
        List<Clothes> listofclothes = new ArrayList<>();
        System.out.println("Сколько одежды вы хотите добавить? ");
        Scanner scanner = new Scanner(System.in);
        counter = scanner.nextInt();
        for (int i = 0; i < counter; i++){
            System.out.println(i+1 + " тип одежды: \n ");
            System.out.println("Введите размер одежды: ");
            Integer clotheSize = scanner.nextInt();
            System.out.println("Введите тип одежды: юбка, штаны, или кофта ");
            String clotheType = scanner.next();
            System.out.println("Введите цену одежды: ");
            Integer clothePrice = scanner.nextInt();
            Clothes clothes = new Clothes(clotheType, clotheSize, clothePrice);
            listofclothes.add(clothes);
        }

        Map<String, List<Clothes>> mapStringToClothes = new LinkedHashMap<>();
        //Map<String, Clothes> mapStringToClothes = new LinkedHashMap<>();
        for(Clothes value : listofclothes) {
                String key = value.getType();
                List<Clothes> clothes;
                boolean mapContainsKey = mapStringToClothes.containsKey(key);
                if (mapContainsKey) {
                    clothes = mapStringToClothes.get(key);
                } else {
                    clothes = new ArrayList<>();
                }
                clothes.add(value);
                mapStringToClothes.put(value.getType(), clothes);
        }
        for (Map.Entry value : mapStringToClothes.entrySet() ) {
            System.out.println(value);
        }
    }
}


