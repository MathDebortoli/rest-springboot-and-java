package br.com.mathdebortoli.controllers;


import br.com.mathdebortoli.controllers.exception.UnSupportedMathOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/soma/{numeroUm}/{numeroDois}")
    public Double soma (@PathVariable String numeroUm, @PathVariable String numeroDois) throws UnSupportedMathOperation{

        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)){
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return convertToDouble(numeroUm) + convertToDouble(numeroDois);
    }

    private Double convertToDouble(String numero )  throws UnSupportedMathOperation{
        if(numero == null || numero.isEmpty()){
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }
        String strNumber = numero.replace(',', '.');

        return Double.parseDouble(strNumber);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()){
            return false;
        }

        String number = strNumber.replace(',', '.');
        return number.matches("^-?\\d+(\\.\\d+)?$");
    }
}
