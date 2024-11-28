package filllists;

import models.Animal;
import models.Barrel;
import models.Gender;
import models.Human;

import java.util.Scanner;

public class FillingFromConsole {
    public Human createHuman() {
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        boolean isValidInput = true;
        while (isValidInput) {
            System.out.print("Введите возраст от 0 до 120: ");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);  // Преобразование строки в число
                if (age > 0 && age < 120) {
                    isValidInput = false;
                } else {
                    System.out.println("Число вне допустимого диапазона. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }


        Gender gender = null;

        while (gender == null) {
            System.out.print("Введите пол (MAN/WOMAN): ");
            String genderStr = scanner.nextLine().trim().toUpperCase();
            if (genderStr.equals("MAN")) {
                gender = Gender.MAN;
            } else if (genderStr.equals("WOMAN")) {
                gender = Gender.WOMAN;
            } else {
                System.out.print("Неверный ввод.     ");
            }
        }

        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine().trim();
        while (surname.isEmpty()) {
            System.out.print("Поле 'Фамилия' не может быть пустым. Введите снова: ");
            surname = scanner.nextLine().trim();
        }


        return new Human.Builder()
                .surname(surname)
                .gender(gender)
                .age(age)
                .build();
    }

    public Animal createAnimal() {
        Scanner scanner = new Scanner(System.in);
        boolean isHair = false;
        boolean isValidInput = true;
        while (isValidInput) {
            System.out.print("У животного есть шерсть? Введите true или false: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                isHair = Boolean.parseBoolean(input);
                isValidInput = false;
            } else {
                System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
        System.out.print("Введите вид животного: ");
        String kind = scanner.nextLine().trim();
        while (kind.isEmpty()) {
            System.out.print("Вид животного не может быть пустым. Введите снова: ");
            kind = scanner.nextLine().trim();
        }

        System.out.print("Введите цвет глаз: ");
        String eyeColor = scanner.nextLine().trim();
        while (eyeColor.isEmpty()) {
            System.out.print("Цвет животного не может быть пустым. Введите снова: ");
            eyeColor = scanner.nextLine().trim();
        }

        return new Animal.Builder()
                .kind(kind)
                .eyeColor(eyeColor)
                .isHair(isHair)
                .build();
    }


    public Barrel createBarrel() {
        Scanner scanner = new Scanner(System.in);
        int volume = 0;
        boolean isValidInput = true;
        while (isValidInput) {
            System.out.print("Введите объем от 5 до 100: ");
            String input = scanner.nextLine();
            try {
                volume = Integer.parseInt(input);  // Преобразование строки в число
                if (volume >= 5 && volume <= 100) {
                    isValidInput = false;
                } else {
                    System.out.println("Число вне допустимого диапазона. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }

        System.out.print("Введите хранимый материал: ");
        String storedMaterial = scanner.nextLine().trim();
        while (storedMaterial.isEmpty()) {
            System.out.print("Хранимый материал не может быть пустым. Введите снова: ");
            storedMaterial = scanner.nextLine().trim();
        }
        System.out.print("Введите материал изготовления: ");
        String material = scanner.nextLine().trim();
        while (material.isEmpty()) {
            System.out.print("Материал не может быть пустым. Введите снова: ");
            material = scanner.nextLine().trim();
        }
        return new Barrel.Builder()
                .volume(volume)
                .storedMaterial(storedMaterial)
                .barrelMaterial(material)
                .build();
    }
}
