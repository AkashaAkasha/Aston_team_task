package objects;

import java.io.Serializable;
import java.util.Objects;

public class Human implements Comparable<Human>, Serializable {
    private final String surname;
    private final Gender gender;
    private final int age;

    public Human(Builder builder) {
        this.surname = builder.surname;
        this.gender = builder.gender;
        this.age = builder.age;
    }

    public static class Builder{
        private final String surname;
        private Gender gender = Gender.MAN;
        private int age = 18;

        public Builder(String surname) {
            if (surname == null || surname.trim().isEmpty()) {
                throw new IllegalArgumentException("Surname cannot be null or empty.");
            }
            this.surname = surname;
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
        return this.gender.equals(other.gender);
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
}
