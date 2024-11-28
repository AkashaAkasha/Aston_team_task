package input;

import algorithms.BinarySearchAlgo;
import algorithms.InsertionSortAlgo;
import algorithms.SortContext;
import filllists.FillFromFile;
import filllists.FillingFromConsole;
import filllists.FillingLists;
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
            choice = scanner.nextInt();
            SortContext sortContext = new SortContext(new InsertionSortAlgo());
            BinarySearchAlgo Bs = new BinarySearchAlgo();

            switch (choice) {
                case 1:
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
                    switch (classType) {
                        case 1:
                            List<Animal> animals = new ArrayList<>();
                            for (int i = 0; i < length; i++) {
                                System.out.println("Заполнение Animal №" + (i + 1));
                                animals.add(new FillingFromConsole().createAnimal());
                            }
                            System.out.println("Заданный массив: " + animals.toString());
                            try {
                                sortContext.sort(animals);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + animals.toString());
                            new SearchToString().foundAnimalToString(animals);
                            break;
                        case 2:
                            List<Barrel> barrels = new ArrayList<>();
                            for (int i = 0; i < length; i++) {
                                System.out.println("Заполнение Barrel №" + (i + 1));
                                barrels.add(new FillingFromConsole().createBarrel());
                            }
                            System.out.println("Заданный массив: " + barrels.toString());
                            try {
                                sortContext.sort(barrels);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + barrels.toString());
                            new SearchToString().foundBarrelToString(barrels);
                            break;
                        case 3:
                            List<Human> people = new ArrayList<>();
                            for (int i = 0; i < length; i++) {
                                System.out.println("Заполнение Human №" + (i + 1));
                                people.add(new FillingFromConsole().createHuman());
                            }
                            System.out.println("Заданный массив: " + people.toString());
                            try {
                                sortContext.sort(people);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + people.toString());
                            new SearchToString().foundHumanToString(people);
                            break;
                    }
                    break;
                case 2:
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
                    switch (classType) {
                        case 1:
                            List<Animal> animals = new FillingLists().fillAnimalList(length);
                            System.out.println("Заданный массив: " + animals.toString());
                            try {
                                sortContext.sort(animals);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + animals.toString());
                            new SearchToString().foundAnimalToString(animals);
                            break;
                        case 2:
                            List<Barrel> barrels = new FillingLists().fillBarrelList(length);
                            System.out.println("Заданный массив: " + barrels.toString());
                            try {
                                sortContext.sort(barrels);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + barrels.toString());
                            new SearchToString().foundBarrelToString(barrels);
                            break;
                        case 3:
                            List<Human> people = new FillingLists().fillHumanList(length);
                            System.out.println("Заданный массив: " + people.toString());
                            try {
                                sortContext.sort(people);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + people.toString());
                            new SearchToString().foundHumanToString(people);
                            break;
                    }
                    break;
                case 3:
                    FillFromFile ff = new FillFromFile();
                    switch (classType) {
                        case 1:
                            List<Animal> animals = ff.readFromAnimal();
                            System.out.println("Заданный массив: " + animals.toString());
                            try {
                                sortContext.sort(animals);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + animals.toString());
                            new SearchToString().foundAnimalToString(animals);
                            break;
                        case 2:
                            List<Barrel> barrels = ff.readFromBarrel();
                            System.out.println("Заданный массив: " + barrels.toString());
                            try {
                                sortContext.sort(barrels);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + barrels.toString());
                            new SearchToString().foundBarrelToString(barrels);
                            break;
                        case 3:
                            List<Human> people = ff.readFromHuman();
                            System.out.println("Заданный массив: " + people.toString());
                            try {
                                sortContext.sort(people);
                            } catch (Exception e) {
                                System.out.println(" ");
                            }
                            System.out.println("Отсортированный массив: " + people.toString());
                            new SearchToString().foundHumanToString(people);
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Возвращение в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (choice != 0);
    }


}
