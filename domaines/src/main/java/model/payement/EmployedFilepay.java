package model.payement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Employed;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployedFilepay {

    private String id;
    private Employed employed;
    private Double totalSalary;
    private LocalDate date= LocalDate.now();

}

