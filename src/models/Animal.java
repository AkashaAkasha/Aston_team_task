package objects;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Comparable<Animal>, Serializable {
    private final String kind;
    private final String eyeColor;
    private final boolean isHair;

    public Animal(Builder builder) {
        this.kind = builder.kind;
        this.eyeColor = builder.yearColor;
        this.isHair = builder.isHair;
    }

    public static class Builder{
        private final String kind;
        private String yearColor = "brown";
        private boolean isHair = true;

        public Builder(String kind) {
            if (kind == null || kind.trim().isEmpty()) {
                throw new IllegalArgumentException("Kind cannot be null or empty.");
            }
            this.kind = kind;
        }

        public Builder yearColor(String yearColor) {
            if (yearColor == null || yearColor.trim().isEmpty()) {
                throw new IllegalArgumentException("Color cannot be null or empty.");
            }
            this.yearColor = yearColor;
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
        return Objects.hash(kind, color, isHair);
    }

    @Override
    public String toString() {
        return "Animal {" +
                " kind " + kind +
                ", yearColor " + eyeColor +
                ", isHair " + isHair +
                "}";
    }
}
