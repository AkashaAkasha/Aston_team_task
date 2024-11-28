package filllists;
import java.util.*;

import java.util.regex.*;
import models.*;

public class FillFromFile{
    java.io.FileReader reader;
    java.util.Scanner scanner;
    public List<Animal> readFromAnimal(){
        List<Animal> animalList = new ArrayList<>();
        Pattern p=Pattern.compile("([\\w]+) ([\\w]+) ([\\w]+)");
        
        try{
            reader=new java.io.FileReader("src/files/for_animal.txt");
            scanner=new java.util.Scanner(reader);
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            Matcher m=p.matcher(s);
            while(m.find()){
                animalList.add(new Animal
                        .Builder()
                        .kind(m.group(1))
                        .eyeColor(m.group(2))
                        .isHair(Boolean.valueOf(m.group(3)))
                        .build());
           
            }
        }
        reader.close();
        }catch(Exception e){

        }
        return animalList;
    }
    public List<Human> readFromHuman(){
        List<Human> humanList = new ArrayList<>();
        Pattern p=Pattern.compile("([\\d]+) ([\\w]+) ([\\w]+)");
        
        try{
            reader=new java.io.FileReader("src/files/for_human.txt");
            scanner=new java.util.Scanner(reader);
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            Matcher m=p.matcher(s);
            while(m.find()){
                
                humanList.add(new Human.Builder().
                age(Integer.parseInt(m.group(1))).
                gender(Gender.valueOf(m.group(3))).
                surname(m.group(2)).
                build());
           
            }
        }
        reader.close();
        }catch(Exception e){

        }
        return humanList;
    }
    public List<Barrel> readFromBarrel(){
        List<Barrel> barrelList = new ArrayList<>();
        Pattern p=Pattern.compile("([\\w]+) ([\\w]+) ([\\d]+)");
        
        try{
            reader=new java.io.FileReader("src/files/for_barrel.txt");
            scanner=new java.util.Scanner(reader);
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            Matcher m=p.matcher(s);
            while(m.find()){
                barrelList.add(new Barrel.Builder()
                        .storedMaterial(m.group(1))
                        .barrelMaterial(m.group(2))
                        .volume(Integer.parseInt(m.group(3)))
                        .build());
           
            }
        }
        reader.close();
        }catch(Exception e){

        }
        return barrelList;
    }
}