package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public float sum(float num1, float num2) {
        return num1 + num2;
    }

    @Override
    public float subtract(float num1, float num2) {
        return num1 - num2;
    }

    @Override
    public float multiply(float num1, float num2) {
        return num1 * num2;
    }

    @Override
    public float divide(float num1, float num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Второй аргумент 0. Деление на ноль невозможно");
        }
        return num1 / num2;
    }

}
