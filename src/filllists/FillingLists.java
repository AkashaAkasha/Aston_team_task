package filllists;

import models.Animal;
import models.Barrel;
import models.Gender;
import models.Human;

import java.util.ArrayList;
import java.util.List;

// Не стал доделывать до конца. Расставить индексы, как в indexModel
// в примере, который нашли в интернете

public class FillingLists {
    private final static int maxYear = 120;
    private final static int minYear = 0;
    // Можно заполнить так и парсить и делать что-то похожее на это:
    // String input = "MAN";
    // Gender gender = Gender.valueOf(input);
    private final static List<List<String>> humanSurnameList = List.of(
            List.of("Покровская","WOMAN"),
            List.of("Филиппова", "WOMAN"),
            List.of("Леонов","MAN"),
            List.of("Кочетков", "MAN"),
            List.of("Тарасова", "WOMAN"),
            List.of("Козлов", "MAN"),
            List.of("Соколова", "WOMAN"),
            List.of("Лаптева","WOMAN"),
            List.of("Усов","MAN"),
            List.of("Никонов","MAN")
    );

    // как добавить объем
    private final static int maxVolume = 100;
    private final static int minVolume = 5;
    private final static List<List<String>> barrelList = List.of(
            List.of("Water", "Plastic", "100"),
            List.of("Soda", "Glass", "50"),
            List.of("Coke", "Cardboard", "30"),
            List.of("Syrup", "Paper", "95"),
            List.of("Coconut milk", "Can", "40")
    );

    // как добавить булевую шерсть
    private final static List<List<String>> animalListFill = List.of(
            List.of("Fish", "Black", "false"),
            List.of("Bird", "Orange", "true"),
            List.of("Primates", "Brown", "true"),
            List.of("Reptiles", "Yellow", "false"),
            List.of("Amphibians", "Blue", "false")
    );
    // Можно попробовать использовать Boolean.parseBoolean()
//    private final static List<Boolean> animalList_isHair = List.of(true, false);

    public List fillAnimalList(int count) {
        List animalList;
        if (count > 0) {
            animalList = new ArrayList<Animal>(count);
            String kind, yearColor;
            boolean isHair = true;

            for (int i = 0; i < count; i++) {
                kind = String.valueOf(generateRandomInRangeIncludeEnd(0, animalList_Kind.size()));
                yearColor = String.valueOf(generateRandomInRangeNotIncludeEnd(0, animalList_EyeColor.size()));
                indexRootVegetable = generateRandomInRangeNotIncludeEnd(0, animalList_isHair.size());

                animalList.add(new Animal().Builder()
                        .type(TYPE_ROOT_VEGETABLE_LIST.get(indexRootVegetable))
                        .weight(weight)
                        .color(COLOR_LIST.get(indexColor))
                        .build());
            }
        } else {
            animalList = new ArrayList<Animal>(0);
        }
        return animalList;
    }

    public List fillHumanList(int count) {
        List humanList;
        if (count > 0) {
            humanList = new ArrayList<Human>(count);
            int age, indexSurname;
            Gender gender1 = Gender.WOMAN;
            Gender gender2 = Gender.WOMAN;
            // как инициализировать

            for (int i = 0; i < count; i++) {
                age = generateRandomInRangeIncludeEnd(minYear, maxYear);
                // и добавить его вот здесь
                gender = genderDiff ? gender1 : gender2;
                indexSurname = generateRandomInRangeNotIncludeEnd(0, humanSurnameList.size());
                humanSurnameList.add(new Human.Builder().
                        age(age).
                        gender(gender).
                        surname(humanSurnameList.get(indexSurname)).
                        build());
            }
        } else {
            humanList = new ArrayList<Human>(0);
        }
        return humanList;
    }

    public List fillBarrelList(int count) {
        List barrelList;
        if (count > 0) {
            barrelList = new ArrayList<Barrel>(count);
            String storedMaterial, barrelMaterial;
            int volume;
            int hash;

            for (int i = 0; i < count; i++) {
                ;
                storedMaterial = String.valueOf(generateRandomInRangeNotIncludeEnd(0, barrelList.size()));
                barrelMaterial = String.valueOf(generateRandomInRangeNotIncludeEnd(0, barrel_List_Material.size()));
                volume = generateRandomInRangeIncludeEnd(minVolume, maxVolume);
//                hash = hashCode()...
                barrelList.add(new Barrel.Builder()
                        .storedMaterial(storedMaterial)
                        .barrelMaterial(barrelMaterial)
                        .volume(volume)
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


}
