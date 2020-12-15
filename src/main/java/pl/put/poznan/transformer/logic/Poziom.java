package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

public class Poziom extends Lokacja{
    private List<Pomieszczenie> pomieszczenia =  new ArrayList<Pomieszczenie>();
    public Poziom(int id, String nazwa){
        super(id, nazwa);
    }

    public List<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }

    public void addPomieszczenie(Pomieszczenie p){
        this.pomieszczenia.add(p);

    }
    public double getArea(){
        float sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getArea();
        }
        return sum;
    }
    public double getCube(){
        float sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getCube();
        }
        return sum;
    }

    @Override
    public double getLight() {
        float arr = 0;
        float pow = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            arr+=  pomieszczenia.get(i).getArea();
            pow += pomieszczenia.get(i).getLightPower();
        }
        return pow/arr;
    }

    @Override
    public double getLightPower() {
        float sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getLightPower();
        }
        return sum;
    }

}
