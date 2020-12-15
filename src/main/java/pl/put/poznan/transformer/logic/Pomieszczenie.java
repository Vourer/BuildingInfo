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
    public void setCube(float cube){
        this.cube = cube;
    }
    public void setLight(float light){
        this.light = light;
    }
    public void setHeating(float heating){
        this.heating = heating;
    }

    public double getArea() {
        return area;
    }

    public double getCube() {
        return cube;
    }


    @Override
    public double getLight() {
        return light/area;
    }

    @Override
    public double getLightPower() {
        return light;
    }
}
