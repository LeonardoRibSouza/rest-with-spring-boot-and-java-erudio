package br.com.erudio.Controller;

import br.com.erudio.exeception.ResourceNotFoundException;
import br.com.erudio.util.ConversaoUtil;
import br.com.erudio.util.Verification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {


    Verification verification = new Verification();
    ConversaoUtil conversaoUtil = new ConversaoUtil();

    //localhost/math/sum/1/2
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid character, please re-enter");
        }
        return conversaoUtil.convertToDouble(numberOne) + conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/math/subtraction/1/2
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo) {
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid character, please re-enter");
        }
        return conversaoUtil.convertToDouble(numberOne) - conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/math/multiplication/1/2
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                                 @PathVariable("numberTwo") String numberTwo) {
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid character, please re-enter");
        }
        return conversaoUtil.convertToDouble(numberOne) * conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/math/division/3/3
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) {
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid character, please re-enter");
        }
        return conversaoUtil.convertToDouble(numberOne) / conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/math/average/3/3
    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo) {
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid character, please re-enter");
        }
        return (conversaoUtil.convertToDouble(numberOne) + conversaoUtil.convertToDouble(numberTwo)) / 2;
    }

    //localhost/math/squareroot/average/3/3
    @RequestMapping("/squareroot/{numberOne}")
    public Double squareRoot(@PathVariable("numberOne") String numberOne) {
        if (!verification.isNumeric(numberOne)) {
            throw new ResourceNotFoundException("Invalid character, please re-enter");
        }
        Double i = 1.0;
        while (true) {
            if (i * i == conversaoUtil.convertToDouble(numberOne)) return i;
            i++;
            if (i > conversaoUtil.convertToDouble(numberOne)) {
                return 0.0;
            }



        }
    }



}