import model.PayRequest;


public interface EmployedFilePayService  {

    Boolean payBanking(PayRequest request);

    String paymentEmployed(PayRequest request);

}
