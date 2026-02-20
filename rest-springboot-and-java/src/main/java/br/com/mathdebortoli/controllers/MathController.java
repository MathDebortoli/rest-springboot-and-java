package br.com.mathdebortoli.controllers;


import br.com.mathdebortoli.controllers.exception.UnSupportedMathOperation;
import br.com.mathdebortoli.math.SimpleMath;
import br.com.mathdebortoli.tools.NumberValidator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matematica")
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping("/soma/{numeroUm}/{numeroDois}")
    public Double soma(@PathVariable String numeroUm, @PathVariable String numeroDois) throws UnSupportedMathOperation {

        if (!NumberValidator.isNumeric(numeroUm) || !NumberValidator.isNumeric(numeroDois)) {
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return math.soma(NumberValidator.convertToDouble(numeroUm), NumberValidator.convertToDouble(numeroDois));
    }

    @RequestMapping("/subtracao/{numeroUm}/{numeroDois}")
    public Double subtracao(@PathVariable String numeroUm, @PathVariable String numeroDois) throws UnSupportedMathOperation {

        if (!NumberValidator.isNumeric(numeroUm) || !NumberValidator.isNumeric(numeroDois)) {
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return math.subtracao(NumberValidator.convertToDouble(numeroUm), NumberValidator.convertToDouble(numeroDois));
    }

    @RequestMapping("/divisao/{numeroUm}/{numeroDois}")
    public Double divisao(@PathVariable String numeroUm, @PathVariable String numeroDois) throws UnSupportedMathOperation {

        if (!NumberValidator.isNumeric(numeroUm) || !NumberValidator.isNumeric(numeroDois)) {
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return math.divisao(NumberValidator.convertToDouble(numeroUm), NumberValidator.convertToDouble(numeroDois));
    }

    @RequestMapping("/multiplicacao/{numeroUm}/{numeroDois}")
    public Double multiplicacao(@PathVariable String numeroUm, @PathVariable String numeroDois) throws UnSupportedMathOperation {

        if (!NumberValidator.isNumeric(numeroUm) || !NumberValidator.isNumeric(numeroDois)) {
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return math.multiplicacao(NumberValidator.convertToDouble(numeroUm), NumberValidator.convertToDouble(numeroDois));
    }

    @RequestMapping("/media/{numeroUm}/{numeroDois}")
    public Double media(@PathVariable String numeroUm, @PathVariable String numeroDois) throws UnSupportedMathOperation {

        if (!NumberValidator.isNumeric(numeroUm) || !NumberValidator.isNumeric(numeroDois)) {
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return math.media(NumberValidator.convertToDouble(numeroUm), NumberValidator.convertToDouble(numeroDois));
    }

    @RequestMapping("/raizquadrada/{numero}")
    public Double raizquadrada(@PathVariable String numero) throws UnSupportedMathOperation {

        if (!NumberValidator.isNumeric(numero)) {
            throw new UnSupportedMathOperation("Por Favor Coloque Caracteres Válidos!");
        }

        return math.raizquadrada(NumberValidator.convertToDouble(numero));
    }

}
