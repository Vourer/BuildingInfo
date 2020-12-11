package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

public class Poziom extends Lokacja{
    private List<Pomieszczenie> pomieszczenia =  new ArrayList<Pomieszczenie>();

    public List<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }
}
