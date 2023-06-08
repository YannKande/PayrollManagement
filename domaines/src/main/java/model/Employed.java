package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employed {
    String id;
    private String name;
    private String company;
    private long functionLevel;
    private double Salary;
    private String bankAccountNumber;

}
