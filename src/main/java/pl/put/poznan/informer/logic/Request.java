package pl.put.poznan.informer.logic;

import java.io.Serializable;

/**
 * Implementacja klasy Request, sluzacej do wczytywania danych w formacie JSON
 * @version 1.0.7
 * @author Delta
 */
public class Request implements Serializable {
    // to jest wersja nr 1513207428686438208L;
    private double coef;
    private int id;

    public double getCoef() {
        return coef;
    }

    public int getId() {
        return id;
    }
}
