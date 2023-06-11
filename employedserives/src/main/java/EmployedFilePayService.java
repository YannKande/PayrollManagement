import model.Employed;
import model.PayRequest;

import java.util.List;


public interface EmployedFilePayService  {

    Boolean payBanking(PayRequest request);
    Double paymentEmployed(PayRequest request);
    List<Employed> employed();
    List<Employed> getEmployedByEmail(String email);


}
