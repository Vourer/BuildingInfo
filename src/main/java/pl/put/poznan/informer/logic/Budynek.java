package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementacja klasy Budynek
 * @version 2.0.0
 * @author Delta
 */

public class Budynek extends Lokacja{
    private List<Poziom> poziomy =  new ArrayList<Poziom>();

    /**
     * Konstruktor klasy Budynek wywolujacy konstruktor abstrakcyjnej klasy nadrzednej Lokacja
     */
    public Budynek(int id, String nazwa) {
        super(id, nazwa);
    }

    public List<Poziom> getPoziomy() {
        return poziomy;
    }

    /**
     * Funkcja dodajaca obiekt klasy Poziom do listy poziomow obiektu Budynek
     */
    public void addPoziom(Poziom p) {
        this.poziomy.add(p);
    }

    /**
     * Funkcja zwracajaca sume pol powierzchni poziomow wchodzacych w sklad budynku
     * @return suma pol powierzchni pomieszczen budynku
     */
    public double getArea(){
        double sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            sum += poziomy.get(i).getArea();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca objetosc budynku
     * @return suma objetosci pomieszczen budynku
     */
    public double getCube(){
        double sum = 0;

        for (int i = 0; i < poziomy.size(); i++) {
            sum += poziomy.get(i).getCube();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca stosunek mocy oswietlenia w budynku do jego powierzchni
     * @return stosunbek mocy oswietlenia do powierzchni budynku
     */
    @Override
    public double getLight() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            arr += poziomy.get(i).getArea();
            pow += poziomy.get(i).getLightPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca zero
     * Implementacja wymagana przez wzglad na klase abstrakcyjna
     */
    @Override
    public double getLightPower() {
        return 0;
    }

    /**
     * Funkcja zwracajaca stosunek zuzycia energii na ogrzewanie w przeliczeniu na jednostke objetosci w budynku
     * @return stosunek zuzycia energii do objetosci budynku
     */
    @Override
    public double getHeating() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            arr += poziomy.get(i).getCube();
            pow += poziomy.get(i).getHeatingPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca zero
     * Implementacja wymagana przez wzglad na klase abstrakcyjna
     */
    @Override
    public double getHeatingPower() {
        return 0;
    }

    /**
     * Funkcja zwracajaca liste pomieszczen przekraczajacych okreslony poziom zuzycia energii cieplnej w obrebie budynku
     * @param coefficient - poziom zuzycia energii, ktory musi byc przekroczony
     * @return lista pomieszczen
     */
    public List<Integer> getValidRooms(double coefficient){
        List<Integer> lista = new ArrayList<Integer>();
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < poziomy.size(); i++){
            tmp = (poziomy.get(i)).getValidRooms(coefficient);
            for (int j = 0; j < tmp.size(); j++){
                lista.add(tmp.get(j));
            }
        }
        return lista;
    }

    /**
     * Funkcja zwracajaca sume czynszy na wszystkich poziomach danego poziomu budynku
     * @return czynsz
     */
    @Override
    public double getRent() {
        double sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            sum +=  poziomy.get(i).getRent();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca stosunek sumy czynszy do sumy powierzchni wszystkich poziomów w budynku
     * @return czynsz/suma powierzchni budynku
     */
    @Override
    public double getRentPerArea() {
        double arr = 0;
        double ren = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            arr += poziomy.get(i).getArea();
            ren += poziomy.get(i).getRent();
        }
        return ren/arr;
    }

    /**
     * Funkcja zwracajaca sume zuzycia wody na wszystkich poziomach danego budynku
     * @return woda
     */
    @Override
    public double getWater() {
        double sum = 0;
        for (int i = 0; i < poziomy.size(); i++) {
            sum +=  poziomy.get(i).getWater();
        }
        return sum;
    }
}
