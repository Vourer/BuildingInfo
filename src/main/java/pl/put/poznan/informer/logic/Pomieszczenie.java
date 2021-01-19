package pl.put.poznan.informer.logic;

/**
 * Implementacja klasy Pomieszczenie
 * @version 1.0.31
 * @author Delta
 */
public class Pomieszczenie extends Lokacja{
    private double area;
    private double cube;
    private double heating;
    private double light;
    private double rent;
    private double water;

    public Pomieszczenie(int id, String nazwa) {
        super(id, nazwa);
    }
    public void setArea(double area){
        this.area = area;
    }
    public void setCube(double cube){
        this.cube = cube;
    }
    public void setLight(double light){
        this.light = light;
    }
    public void setHeating(double heating){
        this.heating = heating;
    }
    public void setRent(double rent){
        this.rent = rent;
    }
    public void setWater(double water){
        this.water = water;
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
    @Override
    public double getHeating() {
        return heating/cube;
    }

    @Override
    public double getHeatingPower() {
        return heating;
    }

    @Override
    public double getRent() {
        return rent;
    }

    @Override
    public double getRentPerArea() { return rent/area; }

    @Override
    public double getWater() {
        return water;
    }
}
