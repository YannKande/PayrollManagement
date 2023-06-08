import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import model.PayRequest;
import processor.PaymentProcessor;

public class EmployedServicesImpl implements  EmployedFilePayService{


    ObjectMapper mapper=new ObjectMapper();



    private final SalaryCalculator calculator;
   private final PaymentProcessor paymentProcessor;

    public EmployedServicesImpl(SalaryCalculator calculator, PaymentProcessor paymentProcessor) {
        this.calculator = calculator;
        this.paymentProcessor = paymentProcessor;
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
}
