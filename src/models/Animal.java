package models;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Comparable<Animal>, Serializable {
    private final String kind;
    private final String eyeColor;
    private final boolean isHair;

    private Animal(Builder builder) {
        this.kind = builder.kind;
        this.eyeColor = builder.eyeColor;
        this.isHair = builder.isHair;
    }

    public static class Builder{
        private String kind;
        private String eyeColor;
        private boolean isHair;

        public Builder kind(String kind) {
            if (kind == null || kind.trim().isEmpty()) {
                throw new IllegalArgumentException("Kind cannot be null or empty.");
            }
            this.kind = kind;
            return this;
        }

        public Builder yearColor(String yearColor) {
            if (yearColor == null || yearColor.trim().isEmpty()) {
                throw new IllegalArgumentException("Color cannot be null or empty.");
            }
            this.eyeColor = yearColor;
            return this;
        }

        public Builder isHair(boolean isHair) {
            this.isHair = isHair;
            return this;
        }

        public Animal build(){
            return new Animal(this);
        }
    }

    public String getKind() {
        return kind;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isHair() {
        return isHair;
    }

    @Override
    public int compareTo(Animal other) {

        int kindComp = String.CASE_INSENSITIVE_ORDER.compare(this.kind, other.kind);
        if (kindComp != 0) {
            return kindComp;
        }
        int colorComp = String.CASE_INSENSITIVE_ORDER.compare(this.eyeColor, other.eyeColor);
        if (colorComp != 0) {
            return colorComp;
        }
        return (this.isHair && other.isHair)? 0: -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, eyeColor, isHair);
    }

    @Override
    public String toString() {
        return "Animal {" +
                " kind " + kind +
                ", eyeColor " + eyeColor +
                ", isHair " + isHair +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        return isHair == other.isHair
                && eyeColor.equalsIgnoreCase(other.eyeColor)
                && kind.equalsIgnoreCase(other.kind);
    }
}
