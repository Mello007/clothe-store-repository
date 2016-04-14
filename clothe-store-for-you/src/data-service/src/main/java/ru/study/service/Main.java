package ru.study.service;
import org.apache.commons.lang3.math.NumberUtils;
import ru.study.entity.Clothes;
import java.io.IOException;
import java.util.*;
import lombok.Data;

@Data
public class Main {

    private static final ClothesService CLOTHES_SERVICE = new ClothesService();

    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int userChoice = showMenu(scanner);
            switch (userChoice) {
                case UserMenu.ADD_CLOTHE:
                    showResultByBoolen(CLOTHES_SERVICE.addClothe(enterParameters(scanner)));
                    break;
                case UserMenu.DELETE_CLOTHE:
                    showResultByBoolen(CLOTHES_SERVICE.deleteClothe(enterParameters(scanner)));
                    break;
                case UserMenu.FIND_CLOTHE:
                    showResultByBoolen(CLOTHES_SERVICE.findClothe(enterParameters(scanner)));
                    break;
                case UserMenu.LOOK_CLOTHE:
                    showClothes(CLOTHES_SERVICE.lookClothe());
                    break;
            }
        }
    }

    private static Clothes enterParameters(Scanner scanner){
        System.out.println("Введите размер одежды: ");
        Integer clotheSize = scanner.nextInt();
        System.out.println("Введите тип одежды: юбка, штаны, или кофта ");
        String clotheType = scanner.next();
        System.out.println("Введите цену одежды: ");
        Integer clothePrice = scanner.nextInt();
        return new Clothes(clotheType, clotheSize, clothePrice);
    }

    private static int showMenu(Scanner scanner){
        Integer result = null;
        while (result == null || result > 4 || result < 1) {
            System.out.println("Меню: \r\n " +
                    "1. Добавить одежду \r\n 2. Удалить одежду \r\n " +
                    "3. Просмотреть всю одежду \r\n 4. Найти одежду");
            String inputString = scanner.next();
            boolean inputStinrgIsNumber = NumberUtils.isNumber(inputString);
            if (inputStinrgIsNumber) {
                result = Integer.valueOf(inputString);
            }
        }
        return result;
    }

    private static void showClothes(List<Clothes> clothes){

        for(Clothes clothesItem : clothes) {
            System.out.println(clothesItem);
        }
        System.out.println("Работа выполнена!");
    }

    private static void showResultByBoolen(boolean result){
        System.out.println(result);
        System.out.println("Работа выполнена");
    }
}


