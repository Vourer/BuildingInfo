package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Lokacja> obiekty =  new ArrayList<Lokacja>();

    public void add(Lokacja l){
        this.obiekty.add(l);
    }

    public Lokacja get_object_by_id (int id){
        for (int i = 0; i < obiekty.size(); i++) {
            if(obiekty.get(i).getId() == id){
                return obiekty.get(i);
            }
        }
        return null;
    }
}
