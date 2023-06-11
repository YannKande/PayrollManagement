package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployedDTO {
    private String name;
    private String company;
    private long functionLevel;
    private double Salary;
    private String bankAccountNumber;

}
