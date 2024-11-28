package filllists;

import models.Animal;
import models.Barrel;
import models.Gender;
import models.Human;

import java.util.ArrayList;
import java.util.List;


public class FillingLists {
    private final static int maxYear = 120;
    private final static int minYear = 0;
    private final static List<List<String>> humanSurnameList = List.of(
            List.of("Покровская", "WOMAN"),
            List.of("Филиппова", "WOMAN"),
            List.of("Леонов", "MAN"),
            List.of("Кочетков", "MAN"),
            List.of("Тарасова", "WOMAN"),
            List.of("Козлов", "MAN"),
            List.of("Соколова", "WOMAN"),
            List.of("Лаптева", "WOMAN"),
            List.of("Усов", "MAN"),
            List.of("Никонов", "MAN")
    );


    private final static List<List<String>> barrelListFill = List.of(
            List.of("Water", "Plastic", "100"),
            List.of("Soda", "Glass", "50"),
            List.of("Coke", "Cardboard", "30"),
            List.of("Syrup", "Paper", "95"),
            List.of("Coconut milk", "Can", "40")
    );

    private final static List<List<String>> animalListFill = List.of(
            List.of("Fish", "Black", "false"),
            List.of("Bird", "Orange", "true"),
            List.of("Primates", "Brown", "true"),
            List.of("Reptiles", "Yellow", "false"),
            List.of("Amphibians", "Blue", "false")
    );

    public List<Animal> fillAnimalList(int count) {
        List<Animal> animalList = new ArrayList<>();
        if (count > 0) {

            for (int i = 0; i < count; i++) {
                List<String> ls = animalListFill.get(generateRandomInRangeNotIncludeEnd(0, animalListFill.size()));

                String k = ls.get(0);
                String c = ls.get(1);
                boolean h = Boolean.valueOf(ls.get(2));

                animalList.add(new Animal
                        .Builder()
                        .kind(k)
                        .eyeColor(c)
                        .isHair(h)
                        .build());
            }
        } else {
            animalList = new ArrayList<Animal>(0);
        }
        return animalList;
    }

    public List<Human> fillHumanList(int count) {
        List<Human> humanList = new ArrayList<>();
        if (count > 0) {


            for (int i = 0; i < count; i++) {
                int age = generateRandomInRangeIncludeEnd(minYear, maxYear);

                List<String> ls = humanSurnameList.get(generateRandomInRangeNotIncludeEnd(0, humanSurnameList.size()));
                String n = ls.get(0);
                Gender g = Gender.valueOf(ls.get(1));
                humanList.add(new Human.Builder().
                        age(age).
                        gender(g).
                        surname(n).
                        build());
            }
        } else {
            humanList = new ArrayList<Human>(0);
        }
        return humanList;
    }

    public List<Barrel> fillBarrelList(int count) {
        List<Barrel> barrelList = new ArrayList<>();
        if (count > 0) {

            for (int i = 0; i < count; i++) {

                List<String> bl = barrelListFill.get(generateRandomInRangeNotIncludeEnd(0, barrelList.size()));
                String sm = bl.get(0);
                String bm = bl.get(1);
                int v = Integer.parseInt(bl.get(2));
                barrelList.add(new Barrel.Builder()
                        .storedMaterial(sm)
                        .barrelMaterial(bm)
                        .volume(v)
                        .build());
            }
        } else {
            barrelList = new ArrayList<Barrel>(0);
        }
        return barrelList;
    }

    private int generateRandomInRangeIncludeEnd(int start, int finish) {
        return (int) (Math.random() * (finish - start + 1) + start);
    }

    private int generateRandomInRangeNotIncludeEnd(int start, int finish) {
        return (int) (Math.random() * (finish - start) + start);
    }


}



