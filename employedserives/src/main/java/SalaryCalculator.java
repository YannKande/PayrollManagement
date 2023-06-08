public class SalaryCalculator {


    public  double CalculatorBaseSalary(int daysWork, double daySalary){
        return daysWork*daySalary;
    }
    public  double calculatorPaySalary(double basicSalary,int promiseDays , int presentDays) {
        return basicSalary / promiseDays * presentDays;
    }


}
