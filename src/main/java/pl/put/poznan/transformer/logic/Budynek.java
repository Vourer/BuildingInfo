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
        double sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {

            sum += poziomy.get(i).getArea();
        }
        return sum;

    }

    public double getCube(){
        double sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {

            sum += poziomy.get(i).getCube();
        }
        return sum;
    }

}
