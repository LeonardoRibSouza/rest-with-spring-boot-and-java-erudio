package br.com.erudio.Controller;

import br.com.erudio.exeception.UnsupportedMathOperationExeception;
import br.com.erudio.util.ConversaoUtil;
import br.com.erudio.util.Verification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {


    Verification verification  = new Verification();
    ConversaoUtil conversaoUtil = new ConversaoUtil();

    //localhost/Math/sun/1/2
    @RequestMapping("/sun/{numberOne}/{numberTwo}")
    public Double sun(
            @PathVariable ("numberOne") String numberOne,
            @PathVariable ("numberTwo") String numberTwo
    ) throws Exception {
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) throw new UnsupportedMathOperationExeception("Invalid character, please re-enter");
        return conversaoUtil.convertToDouble(numberOne) + conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/Math/sub/1/2
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub (@PathVariable ("numberOne") String numberOne,
                       @PathVariable ("numberTwo") String numberTwo){
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) throw new UnsupportedMathOperationExeception("Invalid character, please re-enter");
        return conversaoUtil.convertToDouble(numberOne) - conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/Math/sub/1/2
    @RequestMapping("/mul/{numberOne}/{numberTwo}")
    public Double mul (@PathVariable("numberOne") String numberOne,
                       @PathVariable ("numberTwo") String numberTwo){
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) throw new UnsupportedMathOperationExeception("Invalid character, please");
        return conversaoUtil.convertToDouble(numberOne) * conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/Math/div/3/3
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div (@PathVariable("numberOne") String numberOne,
                       @PathVariable ("numberTwo") String numberTwo){
        if (!verification.isNumeric(numberOne) || !verification.isNumeric(numberTwo)) throw new UnsupportedMathOperationExeception("Invalid character, please");
        return conversaoUtil.convertToDouble(numberOne) / conversaoUtil.convertToDouble(numberTwo);
    }

    //localhost/math/med/3/3
    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public Double med (@PathVariable("numberOne")String numberOne,
                       @PathVariable ("numberTwo")String numberTwo){
        if (!verification.isNumeric(numberOne)|| !verification.isNumeric(numberTwo)) throw new UnsupportedMathOperationExeception("Invalid character, please");
        return (conversaoUtil.convertToDouble(numberOne) + conversaoUtil.convertToDouble(numberTwo))/2;
    }

    @RequestMapping("/raiz/{numberOne}")
    public Double raiz (@PathVariable("numberOne") String numberOne){
        if (!verification.isNumeric(numberOne)) throw new UnsupportedMathOperationExeception("Invalid character, please");
        Double i = 1.0;
        while (true){
            if (i * i == conversaoUtil.convertToDouble(numberOne)) return i;
            i++;
        }
    }



}