package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacja klasy Poziom
 * Implementuje funkcje klasy Lokacja w analogiczny sposob co klasa Budynek
 * @version 1.0.31
 * @author Delta
 */
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

    /**
     * Funkcja zwracajaca sume pol powierzchni pomieszczen wchodzacych w sklad poziomu
     */
    public double getArea(){
        double sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getArea();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca objetosc poziomu
     */
    public double getCube(){
        double sum = 0;

        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getCube();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca stosunek mocy oswietlenia na poziomie budynku w stosunku do jego powierzchni
     */
    @Override
    public double getLight() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            arr+=  pomieszczenia.get(i).getArea();
            pow += pomieszczenia.get(i).getLightPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca sume mocy oswietlenia wszystkich pomimeszczen na danym poziomie
     */
    @Override
    public double getLightPower() {
        double sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getLightPower();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca stosunek zuzycia energii na ogrzewanie w przeliczeniu na jednostke objetosci poziomu budynku
     */
    @Override
    public double getHeating() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            arr+=  pomieszczenia.get(i).getCube();
            pow += pomieszczenia.get(i).getHeatingPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca sume zuzycia energii na ogrzewanie danego poziomu budynku
     */
    @Override
    public double getHeatingPower() {
        double sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getHeatingPower();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca liste pomieszczen przekraczajacych okreslony poziom zuzycia energii cieplnej w obrebie poziomu
     */
    public List<Integer> getValidRooms(double coefficient){
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < pomieszczenia.size(); i++){
            if (pomieszczenia.get(i).getHeating()>coefficient){
                lista.add(pomieszczenia.get(i).getId());
            }
        }
        return lista;
    }
}
