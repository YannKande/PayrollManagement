package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayRequest {
    private String idEmployed;
    private String name;
    private long functionLevel;
    private double Salary;
    private String bankAccountNumber;
    private String cardExpirationDate;
    int dayWorks;

}
