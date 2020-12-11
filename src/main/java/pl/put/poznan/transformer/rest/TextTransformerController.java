package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.Pomieszczenie;
import pl.put.poznan.transformer.logic.Request;
import pl.put.poznan.transformer.logic.Result;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;

@RestController
//@RequestMapping("/a/{text}")
public class TextTransformerController {

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
    public String get_area(@PathVariable String id) {
        final Pomieszczenie room = new Pomieszczenie();
        room.setId(id);
        // log the parameters
        return room.getId();
    }

    }







