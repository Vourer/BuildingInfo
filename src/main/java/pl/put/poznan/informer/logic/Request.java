package pl.put.poznan.informer.logic;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 1513207428686438208L;
    private double coef;
    private int id;

    public double getCoef() {
        return coef;
    }

    public int getId() {
        return id;
    }
}
