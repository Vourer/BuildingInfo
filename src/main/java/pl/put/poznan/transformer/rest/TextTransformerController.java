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
    DB db = new DB();
    public TextTransformerController(){
        Budynek b = new Budynek(1, "budynek");
        Poziom p = new Poziom(2, "Poziom 1");
        db.add(b);
        db.add(p);
        b.addPoziom(p);
        for (int i = 1; i<5; i++){
            Pomieszczenie po = new Pomieszczenie(i+2, "Pokoj");
            po.setArea(5*i);
            po.setCube(5*i*i);
            db.add(po);
            p.addPomieszczenie(po);

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


        @RequestMapping(method = RequestMethod.POST, value = "/math")
        @ResponseBody
        public Result math(@RequestBody final Request request) {
            final Result result = new Result();
            result.setAddition(request.getLeft() + request.getRight());
            result.setSubtraction(request.getLeft() - request.getRight());
            result.setMultiplication(request.getLeft() * request.getRight());
            return result;
        }


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
        return "error";
    }

    //@RequestMapping("/a/{text}")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/get_cube/{id}")
    public String get_cube(@PathVariable int id) {

        System.out.println(id);
        if (Objects.nonNull(db.get_object_by_id(id))){
            Lokacja l = db.get_object_by_id(id);
            JSONObject jo = new JSONObject();
            jo.put("id", id);
            jo.put("type", l.getClass());
            jo.put("cube", l.getCube());
            return jo.toString();
        }
        return "error";
    }

    }







