package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacja klasy DB
 * @version 1.0.27
 * @author Delta
 */
public class DB {
    private List<Lokacja> obiekty =  new ArrayList<Lokacja>();

    public void add(Lokacja l){
        this.obiekty.add(l);
    }

    /**
     * @return obiekt o wskazanym id, jeżeli istnieje
     */
    public Lokacja getObjectById(int id){
        for (int i = 0; i < obiekty.size(); i++) {
            if(obiekty.get(i).getId() == id){
                return obiekty.get(i);
            }
        }
        return null;
    }
}
