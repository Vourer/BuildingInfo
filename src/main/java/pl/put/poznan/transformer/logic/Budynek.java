package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;



public class Budynek extends Lokacja{
private List<Poziom> poziomy =  new ArrayList<Poziom>();

    public Budynek(int id, String nazwa) {
        super(id, nazwa);

    }

    public List<Poziom> getPoziomy() {
        return poziomy;
    }

    public void addPoziom( Poziom p) {
        this.poziomy.add(p);

    }

    public double getArea(){
        float sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {

            sum += poziomy.get(i).getArea();
        }
        return sum;

    }

    public double getCube(){
        float sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {

            sum += poziomy.get(i).getCube();
        }
        return sum;

    }

    @Override
    public double getLight() {
        float arr = 0;
        float pow = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            arr+=  poziomy.get(i).getArea();
            pow += poziomy.get(i).getLightPower();
        }
        return pow/arr;
    }

    @Override
    public double getLightPower() {
        return 0;
    }


}
