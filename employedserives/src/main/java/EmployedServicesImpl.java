import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import mapper.MapperEmployed;
import model.Employed;
import model.PayRequest;
import processor.PaymentProcessor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployedServicesImpl implements  EmployedFilePayService{

    List<Employed> employed;

     MapperEmployed mock;
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

    @SneakyThrows
    @Override
    public List<Employed> employed() {

     employed=MapperEmployed.getCustomers();

      if(employed.size()>0)return null;

        return employed.stream()
                .collect(Collectors.toList());
    }
    @SneakyThrows
    @Override
    public List<Employed> getEmployedByEmail(String email) {

        employed=MapperEmployed.getCustomers();

        if(email.isBlank() && email.length()>8)return null;

        List<Employed> employedStream=employed.stream()
                .filter(a->a.getEmail().equals(email))
                .collect(Collectors.toList());

        return employedStream;
    }
}
