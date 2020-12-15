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
    public abstract double getCube();
<<<<<<< HEAD
    public abstract double getLight();
    public abstract double getLightPower();


=======
>>>>>>> dd0972356fbe9e787c98a305a0a9792f2a504499
}
