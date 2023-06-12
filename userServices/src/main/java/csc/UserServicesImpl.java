package csc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import mapper.MapperUserList;
import model.user.LoginRequest;
import model.user.Users;

import java.util.List;
import java.util.stream.Collectors;

public class UserServicesImpl implements UserServices {

    ObjectMapper mapper;
    @SneakyThrows
    @Override
    public String login(LoginRequest request) {

        List<Users>user= MapperUserList.getUsers();

      List<?>log= user.stream()
                .filter(l->l.getLogin().equals(request.getLogin()) &&
                        l.getPassword().equals(request.getPassword()))
                .collect(Collectors.toList());

        if(log.size()>1) return new String(mapper.writeValueAsString(log));

        return new String(mapper.writeValueAsString("responseCode:404"+"msg:user not found "));
    }
}
