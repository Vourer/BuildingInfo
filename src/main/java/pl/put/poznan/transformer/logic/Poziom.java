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
}
