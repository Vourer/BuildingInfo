package pl.put.poznan.transformer.logic;

public class Pomieszczenie extends Lokacja{
    private float area;
    private float cube;
    private float heating;
    private float light;

    public Pomieszczenie(int id, String nazwa) {
        super(id, nazwa);

    }
    public void setArea(float area){
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    public float getHeating() {
        return heating;
    }

    public float getLight() {
        return light;
    }
}