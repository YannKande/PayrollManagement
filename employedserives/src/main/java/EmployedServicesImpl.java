import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import mapper.MapperEmployed;
import model.Employed;
import model.PayRequest;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;
import processor.PaymentProcessor;

import java.util.List;
import java.util.Optional;

public class EmployedServicesImpl implements  EmployedFilePayService{


    private MapperEmployed mock;
    ObjectMapper mapper=new ObjectMapper();
    private final SalaryCalculator calculator;
   private final PaymentProcessor paymentProcessor;

    public EmployedServicesImpl(SalaryCalculator calculator, PaymentProcessor paymentProcessor,
                                MapperEmployed mock) {
        this.calculator = calculator;
        this.paymentProcessor = paymentProcessor;
        this.mock=mock;
    }


    @Override
    public Boolean payBanking(PayRequest request) {

        return  paymentProcessor.processPayment(
                request.getBankAccountNumber()
                ,request.getCardExpirationDate()
                ,request.getSalary());

    }

    @SneakyThrows
    @Override
    public String paymentEmployed(PayRequest request) {

        double  calculatorSalary=calculator.calculatorPaySalary(
                request.getSalary(),
                31, request.getDayWorks());
        return mapper.writeValueAsString(calculatorSalary);
    }

    @Override
    public List<Employed> employed() {
        return null;
    }

    @Override
    public Optional<Employed> getEmployedByEmail(String email) {

        if(email.isBlank() && email.length()>8)return null;

        return Optional.empty();
    }
}
