import model.PayRequest;
import processor.PaymentProcessor;

public class EmployedServicesImpl implements  EmployedFilePayService{

    PaymentProcessor paymentProcessor;
    public EmployedServicesImpl(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public boolean payBanking(PayRequest request) {
        return paymentProcessor.processPayment(
                request.getBankAccountNumber()
                ,request.getCardExpirationDate()
                ,request.getSalary());
    }
}
