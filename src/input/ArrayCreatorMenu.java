package input;
import algorithms.BinarySearchAlgo;
import algorithms.InsertionSortAlgo;
import algorithms.SortContext;
import models.Animal;
import models.Barrel;
import models.Gender;
import models.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArrayCreatorMenu {

    private Scanner scanner = new Scanner(System.in);
    private final int classType;

    public ArrayCreatorMenu(int classType) {
        this.classType = classType;
    }


    public void display() {
        int length;
        int choice = 99;
        do {
            System.out.print("\nВведите длину массива для: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Введите натуральное число.");
                continue;
            }
            length = scanner.nextInt();
            if (length <= 0) {
                System.out.println("Длина массива должна быть больше нуля.");
                continue;
            }
            System.out.println("Создание массива: ");
            System.out.println("1. Заполнение вручную");
            System.out.println("2. Заполнение случайными значениями");
            System.out.println("3. Загрузка из файла");
            System.out.println("0. Назад");
            System.out.print("Выберите способ создания массива: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод");
                continue;
            }
            SortContext sortContext = new SortContext(new InsertionSortAlgo());
            BinarySearchAlgo Bs = new BinarySearchAlgo();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    switch (classType){
                        case 1:
                            List<Animal> animals = createAnimalListManually(length);
                            System.out.println("Заданный массив: " + animals.toString());
                            System.out.print("Введите слово: ");
                            String str = scanner.nextLine();
                            //int index = BinarySearchAlgo.findByKey(animals, str);
                            try{
                                sortContext.sort(animals);
                            }catch(Exception e){
                                System.out.println("");
                            }
                            System.out.println("Отсортированный массив: " + animals.toString());
                            break;
                        case 2:
                            List<Barrel> barrels = createBarrelListManually(length);
                            System.out.println("Заданный массив: " + barrels.toString());
                            try{
                                sortContext.sort(barrels);
                            }catch(Exception e){
                                System.out.println("");
                            }
                            System.out.println("Отсортированный массив: " + barrels.toString());
                            break;
                        case 3:
                            List<Human> people = createHumanListManually(length);
                            System.out.println("Заданный массив: " + people.toString());
                            try{
                                sortContext.sort(people);
                            }catch(Exception e){
                                System.out.println("");
                            }
                            System.out.println("Отсортированный массив: " + people.toString());
                            break;
                    }

                    //сортировка
                    //поиск
                    break;
                case 2:
                    createArrayRandomly(length);
                    //сортировка
                    //поиск
                    break;
                case 3:
                    loadArrayFromFile(length);
                    //сортировка
                    //поиск
                    break;
                case 0:
                    System.out.println("Возвращение в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (choice != 0);
    }

    private List<Animal> createAnimalListManually(int length) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.print("Заполнение массива Animal" + (i + 1));
            System.out.print("Есть шерсть? (true/false): ");
            if (!scanner.hasNextBoolean()) {
                i--;
                System.out.println("Введите true или false.");
                continue;
            }
            boolean isHair = scanner.nextBoolean();
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



            animals.add(new Animal.Builder(kind)
                    .yearColor(eyeColor)
                    .isHair(isHair)
                    .build());
        }

        System.out.println("\nСписок животных заполнен успешно!");
        return animals;
    }

    private List<Barrel> createBarrelListManually(int length) {
        Scanner scanner = new Scanner(System.in);
        List<Barrel> barrels = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Заполнение массива Barrel" + (i + 1));
            System.out.print("Введите объем: ");
            if (!scanner.hasNextInt()) {
                i--;
                System.out.println("Введите натуральное число.");
                continue;
            }
            int volume = scanner.nextInt();
            if (volume <= 0){
                i--;
                System.out.print("Объем не может быть отрицательным: ");
                continue;
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
            barrels.add(new Barrel.Builder(volume)
                    .storedMaterial(storedMaterial)
                    .barrelMaterial(material)
                    .build());
        }

        System.out.println("\nСписок Barrel заполнен успешно!");
        return barrels;
    }

    private List<Human> createHumanListManually(int length) {
        Scanner scanner = new Scanner(System.in);
        List<Human> people = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Заполнение массива Human" + (i + 1));
            System.out.print("Введите возраст: ");
            if (!scanner.hasNextInt()) {
                i--;
                System.out.println("Введите натуральное число.");
                continue;
            }
            int age = scanner.nextInt();
            if (age < 0 || age > 120){
                i--;
                System.out.print("Возраст должен быть от 0 до 120: ");
                continue;
            }
            System.out.print("Введите пол (MAN/WOMAN): ");
            Gender gender = null;

            while (gender == null) {
                String genderStr = scanner.nextLine().trim().toUpperCase();
                if (genderStr.equals("MAN")) {
                    gender = Gender.MAN;
                } else if (genderStr.equals("WOMAN")) {
                    gender = Gender.WOMAN;
                } else {
                    System.out.print("Неверный ввод. Введите пол (MAN/WOMAN): ");
                }
            }

            System.out.print("Введите фамилию: ");
            String surname =  scanner.nextLine().trim();
            while (surname.isEmpty()) {
                System.out.print("Поле 'Фамилия' не может быть пустым. Введите снова: ");
                surname = scanner.nextLine().trim();
            }


            people.add(new Human.Builder(surname)
                    .gender(gender)
                    .age(age)
                    .build());
        }

        System.out.println("\nСписок животных заполнен успешно!");
        return people;
    }



    private void createArrayRandomly(int length) {
        System.out.println("Заполнение массива " + classType + " случайными значениями...");
    }

    private void loadArrayFromFile(int length) {
        System.out.println("Загрузка массива " + classType + " из файла...");
    }

}
