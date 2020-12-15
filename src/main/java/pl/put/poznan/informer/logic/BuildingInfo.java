package pl.put.poznan.informer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BuildingInfo {

    private final String[] informs;

    public BuildingInfo(String[] informs){
        this.informs = informs;
    }

}
