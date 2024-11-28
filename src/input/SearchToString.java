package input;

import algorithms.BinarySearchAlgo;
import filllists.FillingFromConsole;
import models.Animal;
import models.Barrel;
import models.Human;

import java.util.List;

public class SearchToString {

    public void foundAnimalToString(List<Animal> animals){
        System.out.println("Бинарный поиск: ");
        Animal animal = new FillingFromConsole().createAnimal();
        int index = BinarySearchAlgo.findByKey(animals, animal);
        if(index == -1){
            System.out.println("Нет такого элемента.");
        } else {
            System.out.println("Индекс найденного элемента: " + index);
            animal.toString();
        }
    }
    public void foundBarrelToString(List<Barrel> barrels){
        System.out.println("Бинарный поиск: ");
        Barrel barrel = new FillingFromConsole().createBarrel();
        int index = BinarySearchAlgo.findByKey(barrels, barrel);
        if(index == -1){
            System.out.println("Нет такого элемента.");
        } else {
            System.out.println("Индекс найденного элемента: " + index);
            barrel.toString();
        }
    }
    public void foundHumanToString(List<Human> people){
        System.out.println("Бинарный поиск: ");
        Human human = new FillingFromConsole().createHuman();
        int index = BinarySearchAlgo.findByKey(people, human);
        if(index == -1){
            System.out.println("Нет такого элемента.");
        } else {
            System.out.println("Индекс найденного элемента: " + index);
            human.toString();
        }
    }
}
