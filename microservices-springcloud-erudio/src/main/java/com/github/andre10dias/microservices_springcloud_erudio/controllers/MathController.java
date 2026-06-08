package com.github.andre10dias.microservices_springcloud_erudio.controllers;

import com.github.andre10dias.microservices_springcloud_erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.andre10dias.microservices_springcloud_erudio.request.converters.NumberConverter.convertToDouble;
import static com.github.andre10dias.microservices_springcloud_erudio.math.SimpleMath.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double addition(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return sub(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/mul/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return mul(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        Double numberTest = convertToDouble(numberOne);
        if (numberTest == 0) {
            throw new UnsupportedMathOperationException("Division by zero");
        }
        return div(numberTest, convertToDouble(numberTwo));
    }

    @RequestMapping("/ave/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return ave(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/sqr/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    ) {
        Double numberTest = convertToDouble(number);
        if (numberTest < 0) throw new UnsupportedMathOperationException("Square root of zero");
        return sqr(convertToDouble(number));
    }

}
