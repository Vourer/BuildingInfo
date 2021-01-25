package pl.put.poznan.informer.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.informer.logic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Implementacja klasy BuildingInfoController
 * @version 2.0.0
 * @author Delta
 */
@RestController
//@RequestMapping("/a/{text}")
public class BuildingInfoController {

    /**
     * Deklaracja i stworzenie nowej instancji bazy danych
     */
    DB db = new DB();
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    public BuildingInfoController(){
        Budynek b1 = new Budynek(1, "Kamienica");
        Poziom p11 = new Poziom(11, "Parter");
        db.add(b1);
        db.add(p11);
        b1.addPoziom(p11);
        for (int i = 1; i<5; i++){
            Pomieszczenie po = new Pomieszczenie(i+110, "Pokoj");
            po.setArea(20+5*i);
            po.setCube((20+5*i)*3.5);
            po.setHeating(300+(5/i)*50);
            po.setLight(1200+0.5*i*1000);
            po.setRent(20+5*i*40);
            po.setWater(200+(5/i)*60);
            db.add(po);
            p11.addPomieszczenie(po);
        }

        Poziom p12 = new Poziom(12, "Pietro 1");
        db.add(p12);
        b1.addPoziom(p12);
        for (int i = 1; i<6; i++){
            Pomieszczenie po = new Pomieszczenie(i+120, "Pokoj");
            po.setArea(20+5*i);
            po.setCube((20+5*i)*3.5);
            po.setHeating(300+(5/i)*50);
            po.setLight(1200+0.5*i*1000);
            po.setRent(20+5*i*40);
            po.setWater(200+(5/i)*60);
            db.add(po);
            p12.addPomieszczenie(po);
        }

        Poziom p13 = new Poziom(13, "Strych");
        db.add(p13);
        b1.addPoziom(p13);
        for (int i = 1; i<3; i++){
            Pomieszczenie po = new Pomieszczenie(i+130, "Pokoj");
            po.setArea(50+5*i);
            po.setCube((50+5*i)*3);
            po.setHeating(300+(5/i)*50);
            po.setLight(1200+0.5*i*1000);
            po.setRent(20+5*i*40);
            po.setWater(200+(5/i)*60);
            db.add(po);
            p13.addPomieszczenie(po);
        }

        Budynek b2 = new Budynek(2, "Dom jednorodzinny");
        Poziom p21 = new Poziom(21, "Parter");
        db.add(b2);
        db.add(p21);
        b2.addPoziom(p21);
        for (int i = 1; i<5; i++){
            Pomieszczenie po = new Pomieszczenie(i+210, "Pokoj");
            po.setArea(20+5*i);
            po.setCube((20+5*i)*3.5);
            po.setHeating(300+(5/i)*50);
            po.setLight(1200+0.5*i*1000);
            po.setRent(20+5*i*40);
            po.setWater(200+(5/i)*60);
            db.add(po);
            p21.addPomieszczenie(po);
        }

        Poziom p22 = new Poziom(22, "Pietro 1");
        db.add(p22);
        b2.addPoziom(p22);
        for (int i = 1; i<3; i++){
            Pomieszczenie po = new Pomieszczenie(i+220, "Pokoj");
            po.setArea(50+5*i);
            po.setCube((50+5*i)*3);
            po.setHeating(300+(5/i)*50);
            po.setLight(1200+0.5*i*1000);
            po.setRent(20+5*i*40);
            po.setWater(200+(5/i)*60);
            db.add(po);
            p22.addPomieszczenie(po);
        }
    }

    /**
     * Funkcja zwracajaca typ i powierzchnie obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_area/{id}")
    public String get_area(@PathVariable int id) {
        logger.debug("Get_area, id:" + id);
        System.out.println(id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("area", l.getArea());
            logger.debug(jo.toString());
            return jo.toString();

        }

        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca typ i objetosc obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_volume/{id}")
    public String get_cube(@PathVariable int id) {
        logger.debug("Get_cube, id:" + id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("Volume", l.getCube());
            logger.debug(jo.toString());
            return jo.toString();

        }
        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca typ i moc oswietlenia obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_light_power/{id}")
    public String get_light_power(@PathVariable int id) {
        logger.debug("Get_light_power, id:" + id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("Light power per square meter", l.getLight());
            logger.debug(jo.toString());
            return jo.toString();
        }
        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca typ i zuzycie energii na ogrzewanie obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_heating_power/{id}")
    public String get_heating_power(@PathVariable int id) {
        logger.debug("Get_heating_power, id:" + id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("Heating power per cube meter", l.getHeating());
            logger.debug(jo.toString());
            return jo.toString();
        }
        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca liste obiektow przekraczajacych okreslony poziom zuzycia energii cieplnej
     * Implemenuje metode POST z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.POST, value = "/valid_rooms")
    @ResponseBody
    public String valid_rooms(@RequestBody final Request request) {
        logger.debug("valid_rooms, id:" + request.getId());
        int id = request.getId();
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            if (l.getClass() != Budynek.class){
                return "Id is not a building id";
            }
            JSONObject jo = new JSONObject();
            List<Integer> lista = new ArrayList<Integer>();
            lista = ((Budynek) l).getValidRooms(request.getCoef());
            for (int i = 0; i < lista.size(); i++){
                jo.put("room_id_" + i, lista.get(i));
            }
            logger.debug(jo.toString());
            return jo.toString();
        }
        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca typ i czynsz obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_rent/{id}")
    public String get_rent(@PathVariable int id) {
        logger.debug("Get_rent, id:" + id);
        System.out.println(id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("rent", l.getRent());
            logger.debug(jo.toString());
            return jo.toString();
        }

        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca typ i czynsz w przeliczeniu na jednostke powierzchni obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_rpa/{id}")
    public String get_rpa(@PathVariable int id) {
        logger.debug("Get_rpa, id:" + id);
        System.out.println(id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("rpa", l.getRentPerArea());
            logger.debug(jo.toString());
            return jo.toString();
        }

        logger.debug("Id_not_found");
        return "Id_not_found";
    }

    /**
     * Funkcja zwracajaca typ i zuzycie wody dla obiektu o podanym id
     * Implemenuje metode GET z frameworku Spring
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_water/{id}")
    public String get_water(@PathVariable int id) {
        logger.debug("Get_water, id:" + id);
        System.out.println(id);
        if (Objects.nonNull(db.getObjectById(id))){
            Lokacja l = db.getObjectById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("water", l.getWater());
            logger.debug(jo.toString());
            return jo.toString();
        }

        logger.debug("Id_not_found");
        return "Id_not_found";
    }
}







