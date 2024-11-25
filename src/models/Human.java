package models;

import java.io.Serializable;
import java.util.Objects;

public class Human implements Comparable<Human>, HasNumField<Human>, Serializable {
    private final String surname;
    private final Gender gender;
    private final int age;

    private Human(Builder builder) {
        this.surname = builder.surname;
        this.gender = builder.gender;
        this.age = builder.age;
    }

    @Override
    public int getNumField() {
        return this.getAge();
    }

    @Override
    public String getNumFieldName() {
        return "age";
    }

    public static class Builder{
        private String surname;
        private Gender gender;
        private int age;

        public Builder surname(String surname) {
            if (surname == null || surname.trim().isEmpty()) {
                throw new IllegalArgumentException("Surname cannot be null or empty.");
            }
            this.surname = surname;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Age must be between 0 and 120.");
            }
            this.age = age;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {

        int surnameComp = String.CASE_INSENSITIVE_ORDER.compare(this.surname, other.surname);
        if (surnameComp != 0) {
            return surnameComp;
        }
        int ageComp = Integer.compare(this.age, other.age);
        if (ageComp != 0) {
            return ageComp;
        }
        return Integer.compare(this.gender.ordinal(), other.gender.ordinal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, gender, age);
    }

    @Override
    public String toString() {
        return "Human {" +
                " surname " + surname +
                ", gender " + gender +
                ", age " + age +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        return age == other.age
                && surname.equalsIgnoreCase(other.surname)
                && gender.equals(other.gender);
    }
}
