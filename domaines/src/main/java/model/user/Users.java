package model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
      private String id;
      private  String username;
      private  String login;

      private String password;

      private String role;

}
