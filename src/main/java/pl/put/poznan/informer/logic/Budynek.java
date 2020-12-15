package pl.put.poznan.informer.logic;

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

    @Override
    public double getLight() {
        double arr = 0;
        double pow = 0;
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



    @Override
    public double getHeating() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            arr+=  poziomy.get(i).getCube();
            pow += poziomy.get(i).getHeatingPower();
        }
        return pow/arr;
    }

    @Override
    public double getHeatingPower() {
        return 0;
    }

    public List<Integer> get_valid_rooms(double coefficient){
        List<Integer> lista = new ArrayList<Integer>();
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < poziomy.size(); i++){
            tmp = (poziomy.get(i)).get_valid_rooms(coefficient);
            for (int j = 0; j < tmp.size(); j++){
                lista.add(tmp.get(j));
            }

        }
        return lista;
    }

}
