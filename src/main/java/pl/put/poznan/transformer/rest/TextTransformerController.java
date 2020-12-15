package pl.put.poznan.transformer.rest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;
import java.util.Objects;

@RestController
//@RequestMapping("/a/{text}")
public class TextTransformerController {

    /**
     * Zainicjonowanie Bazy Danych zawierająych informacje o dwóch budynkach
     * Pierwszy budynek (Kamienica) -> 3 piętra
     * Drugi budynek (Dom jednorodzinny) -> Dwa piętra
     */


    DB db = new DB();
    public TextTransformerController(){
<<<<<<< HEAD
        Budynek b = new Budynek(1, "budynek");
        Poziom p = new Poziom(2, "Poziom 1");
        db.add(b);
        db.add(p);
        b.addPoziom(p);

        for (int i = 1; i<5; i++){
            Pomieszczenie po = new Pomieszczenie(i+3, "Pokoj");
            po.setArea(5*i);
            po.setCube(10*i);
            po.setLight(222);
            po.setHeating(22);
            db.add(po);
            p.addPomieszczenie(po);

        }
        p = new Poziom(3, "Poziom 2");
        db.add(p);
        b.addPoziom(p);
        for (int i = 1; i<7; i++){
            Pomieszczenie po = new Pomieszczenie(10*i+2, "Pokoj");
            po.setArea(5*i+4);
            po.setCube(11*i+1);
            po.setHeating(90);
=======

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
>>>>>>> dd0972356fbe9e787c98a305a0a9792f2a504499
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
            db.add(po);
            p22.addPomieszczenie(po);
        }

    }

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    //@RequestMapping("/a/{text}")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/a/{text}")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/a/{text}")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }


       /* @RequestMapping(method = RequestMethod.POST, value = "/math")
        @ResponseBody
        public Result math(@RequestBody final Request request) {
            final Result result = new Result();
            result.setAddition(request.getLeft() + request.getRight());
            result.setSubtraction(request.getLeft() - request.getRight());
            result.setMultiplication(request.getLeft() * request.getRight());
            return result;
        }*/


    //@RequestMapping("/a/{text}")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_area/{id}")
    public String get_area(@PathVariable int id) {

        System.out.println(id);
        if (Objects.nonNull(db.get_object_by_id(id))){
            Lokacja l = db.get_object_by_id(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("area", l.getArea());
            return jo.toString();
        }
        return "Id_not_found";
    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_volume/{id}")
    public String get_cube(@PathVariable int id) {


<<<<<<< HEAD
=======
    //@RequestMapping("/a/{text}")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_cube/{id}")
    public String get_cube(@PathVariable int id) {

        System.out.println(id);
>>>>>>> dd0972356fbe9e787c98a305a0a9792f2a504499
        if (Objects.nonNull(db.get_object_by_id(id))){
            Lokacja l = db.get_object_by_id(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
<<<<<<< HEAD
            jo.put("Volume", l.getCube());
            return jo.toString();
        }
        return "Id_not_found";
=======
            jo.put("cube", l.getCube());
            return jo.toString();
        }
        return "error";
    }

>>>>>>> dd0972356fbe9e787c98a305a0a9792f2a504499
    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_light_power/{id}")
    public String get_light_power(@PathVariable int id) {


        if (Objects.nonNull(db.get_object_by_id(id))){
            Lokacja l = db.get_object_by_id(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("Light power per square meter", l.getLight());
            return jo.toString();
        }
        return "Id_not_found";
    }




}







