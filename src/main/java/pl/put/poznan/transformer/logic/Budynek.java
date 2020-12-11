package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;



public class Budynek extends Lokacja{
private List<Poziom> poziomy =  new ArrayList<Poziom>();

    public List<Poziom> getPoziomy() {
        return poziomy;
    }
}
