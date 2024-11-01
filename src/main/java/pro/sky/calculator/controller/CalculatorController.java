package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam ("num1") float num1, @RequestParam ("num2") float num2) {
        float result = calculatorService.sum(num1, num2);
        return createRs(num1, num2, '+', result);
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam float num1, @RequestParam float num2) {
        float result = calculatorService.subtract(num1, num2);
        return createRs(num1, num2, '-', result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam (value = "num1") float num1, @RequestParam (value = "num2") float num2) {
        float result = calculatorService.multiply(num1, num2);
        return createRs(num1, num2, '*', result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam float num1, @RequestParam float num2) {
        float result = calculatorService.divide(num1, num2);
        return createRs(num1, num2, '/', result);
    }

    private String createRs(float num1, float num2, char action, float result) {
        return String.format("%.2f %c %.2f = %.2f", num1, action, num2, result);
    }


}
