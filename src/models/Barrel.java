package models;

import java.io.Serializable;
import java.util.Objects;

public class Barrel implements Comparable<Barrel>, HasNumField<Barrel>, Serializable {
    private final int volume;
    private final String storedMaterial;
    private final String barrelMaterial;

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.barrelMaterial = builder.barrelMaterial;
    }

    @Override
    public int getNumField() {
        return this.getVolume();
    }

    @Override
    public String getNumFieldName() {
        return "volume";
    }

    public static class Builder{
        private int volume;
        private String storedMaterial;
        private String barrelMaterial;

        public Builder volume(int volume) {
            if (volume < 5 || volume > 100) {
                throw new IllegalArgumentException("Volume must be between 5 and 100.");
            }
            this.volume = volume;
            return this;
        }

        public Builder storedMaterial(String storedMaterial) {
            if (storedMaterial == null || storedMaterial.trim().isEmpty()) {
                throw new IllegalArgumentException("Stored Material cannot be null or empty.");
            }
            this.storedMaterial = storedMaterial;
            return this;
        }

        public Builder barrelMaterial(String barrelMaterial) {
            if (barrelMaterial == null || barrelMaterial.trim().isEmpty()) {
                throw new IllegalArgumentException("Barrel Material cannot be null or empty.");
            }
            this.barrelMaterial = barrelMaterial;
            return this;
        }

        public Barrel build(){
            return new Barrel(this);
        }
    }

    public int getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public String getBarrelMaterial() {
        return barrelMaterial;
    }

    @Override
    public int compareTo(Barrel other) {

        int volumeComp = Integer.compare(this.volume, other.volume);
        if (volumeComp != 0) {
            return volumeComp;
        }
        int storedComp = String.CASE_INSENSITIVE_ORDER.compare(this.storedMaterial, other.storedMaterial);
        if (storedComp != 0) {
            return storedComp;
        }
        return String.CASE_INSENSITIVE_ORDER.compare(this.barrelMaterial, other.barrelMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, storedMaterial, barrelMaterial);
    }


    @Override
    public String toString() {
        return "Barrel {" +
                " volume " + volume +
                ", storedMaterial " + storedMaterial +
                ", barrelMaterial " + barrelMaterial +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Barrel other = (Barrel) obj;
        return volume == other.volume
                && storedMaterial.equalsIgnoreCase(other.storedMaterial)
                && barrelMaterial.equalsIgnoreCase(other.barrelMaterial);
    }
}
