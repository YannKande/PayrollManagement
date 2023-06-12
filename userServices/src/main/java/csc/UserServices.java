package csc;

import model.user.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    String login(LoginRequest request);
}
