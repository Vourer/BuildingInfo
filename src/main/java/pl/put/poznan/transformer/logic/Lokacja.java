package pl.put.poznan.transformer.logic;

public abstract class Lokacja {
    private String id;
    private String nazwa;

    public String getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setId(String id) {
        this.id = id;
    }
}
