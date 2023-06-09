import model.Employed;
import model.PayRequest;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;


public interface EmployedFilePayService  {

    Boolean payBanking(PayRequest request);

    String paymentEmployed(PayRequest request);
    List<Employed> employed();
    Optional<Employed> getEmployedByEmail(String email);
}
