package br.com.mathdebortoli.tools;

import br.com.mathdebortoli.controllers.exception.UnSupportedMathOperation;

public class NumberValidator {

    public static Double convertToDouble(String numero )  throws UnSupportedMathOperation {
        if(numero == null || numero.isEmpty()){
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }
        String strNumber = numero.replace(',', '.');

        return Double.parseDouble(strNumber);
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()){
            return false;
        }

        String number = strNumber.replace(',', '.');
        return number.matches("^-?\\d+(\\.\\d+)?$");
    }
}
