package mapper;

import model.Employed;
import model.EmployedDTO;
import model.PayRequest;
import model.payement.EmployedFilepay;

import java.time.LocalDate;

public class EmployedMapper {


    public  static EmployedDTO toEmployed(Employed employed){


        if (employed!=null)return EmployedDTO.builder()

                  .name(employed.getName())
                  .company(employed.getCompany())
                  .functionLevel(employed.getFunctionLevel())
                  .Salary(employed.getSalary())
                  .bankAccountNumber(employed.getBankAccountNumber())
                  .build();

        return null;
    }

    public  static Employed toDTO(EmployedDTO dto){

        Employed employed=new Employed();

        if ((dto!=null)){

            employed.setName(dto.getName());
            employed.setCompany(dto.getCompany());
            employed.setFunctionLevel(dto.getFunctionLevel());
            employed.setSalary(dto.getSalary());
            employed.setBankAccountNumber(dto.getBankAccountNumber());

            return employed;
        }

        return null;
    }


    public  static EmployedFilepay toPayFile(Employed employed, PayRequest payRequest){

        EmployedFilepay employedFilepay=new EmployedFilepay();

        if (employed!=null){

            employedFilepay.setEmployed(employed);
            employedFilepay.setTotalSalary(payRequest.getSalary());

            return employedFilepay;
        }

        return null;
    }



}
