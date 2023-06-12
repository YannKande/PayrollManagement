import model.Employed;
import model.PayRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployedFilePayService  {

    Boolean payBanking(PayRequest request);
    Double paymentEmployed(PayRequest request);
    List<Employed> employed();
    List<Employed> getEmployedByEmail(String email);


}
