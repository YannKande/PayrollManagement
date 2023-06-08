import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class SalaryCalculatorTest {

    SalaryCalculator calculator= new SalaryCalculator();
    @Test
    public void testCalculatorBaseSalary() {

        double baseSalary = calculator.CalculatorBaseSalary(22, 100.0);
        assertEquals(2200.0, baseSalary, 0.01); // Expected base salary is 2200.0
    }
    @Test
    public void testCalculatorPaySalary() {
        double paySalary = calculator.calculatorPaySalary(2000.0, 30, 22);
        assertEquals(1466.67, paySalary, 0.01); // Expected pay salary is 1466.67
    }
}
