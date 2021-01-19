package pl.put.poznan.informer.logic;

/**
 * Implementacja klasy Lokacja
 * @version 1.0.31
 * @author Delta
 */
public abstract class Lokacja {

    /**
     * Klasa abstrakcyjna w ktorej deklarowane sa funkcje uzywane pozniej przez klasy dziedziczace
     */
    public Lokacja(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;
    }

    private int id;
    private String nazwa;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa (String nazwa) {
        this.nazwa = nazwa;
    }

    public abstract double getArea();
    public abstract double getCube();

    public abstract double getLight();
    public abstract double getLightPower();

    public abstract double getHeating();
    public abstract double getHeatingPower();

    public abstract double getRent();
    public abstract double getRentPerArea();
    public abstract double getWater();
}
