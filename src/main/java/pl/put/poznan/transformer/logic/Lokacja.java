package pl.put.poznan.transformer.logic;

public abstract class Lokacja {

    public Lokacja(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;

    }

    private int id;
    private String nazwa;

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNazwa (String nazwa) {
        this.nazwa = nazwa;
    }
    public abstract double getArea();
}
