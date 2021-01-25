package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacja klasy Poziom
 * Implementuje funkcje klasy Lokacja w analogiczny sposob co klasa Budynek
 * @version 2.0.0
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
     * @return suma pol powierzchni pomieszczen na poziomie budynku
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
     * @return suma objetosci pomieszczen na poziomie budynku
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
     * @return stosunbek mocy oswietlenia do powierzchni poziomy
     */
    @Override
    public double getLight() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            arr += pomieszczenia.get(i).getArea();
            pow += pomieszczenia.get(i).getLightPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca sume mocy oswietlenia wszystkich pomimeszczen na danym poziomie
     * @return suma mocy oswietlenia pomieszczen na poziomie
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
     * @return stosunek zuzycia energii do objetosci poziomu budynku
     */
    @Override
    public double getHeating() {
        double arr = 0;
        double pow = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            arr += pomieszczenia.get(i).getCube();
            pow += pomieszczenia.get(i).getHeatingPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca sume zuzycia energii na ogrzewanie danego poziomu budynku
     * @return suma zuzycia energii na ogrzewanie
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
     * @param coefficient - poziom zuzycia energii, ktory musi byc przekroczony
     * @return lista pomieszczen
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

    /**
     * Funkcja zwracajaca sume czynszy pomieszczen danego poziomu budynku
     * @return czynsz
     */
    @Override
    public double getRent() {
        double sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getRent();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca stosunek sumy czynszy do sumy powierzchni wszystkich pomieszczen danego poziomu budynku
     * @return czynsz/suma powierzchni poziomu
     */
    @Override
    public double getRentPerArea() {
        double arr = 0;
        double ren = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            arr += pomieszczenia.get(i).getArea();
            ren += pomieszczenia.get(i).getRent();
        }
        return ren/arr;
    }

    /**
     * Funkcja zwracajaca sume zuzycia wody we wszystkich pomieszczeniach danego poziomu budynku
     * @return woda
     */
    @Override
    public double getWater() {
        double sum = 0;
        for (int i = 0; i < pomieszczenia.size(); i++) {
            sum +=  pomieszczenia.get(i).getWater();
        }
        return sum;
    }

}
