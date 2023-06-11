import mapper.MapperEmployedList;
import model.Employed;
import model.PayRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processor.PaymentProcessor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployedServicesImplTest {
    private SalaryCalculator salaryCalculatorMock;
    private PaymentProcessor paymentProcessorMock;
    private MapperEmployedList mapperEmployedListMock;
    private EmployedServicesImpl employedServices;

    PayRequest request;
    @BeforeEach
    public void setUp() {
        salaryCalculatorMock = mock(SalaryCalculator.class);
        paymentProcessorMock = mock(PaymentProcessor.class);
        mapperEmployedListMock = mock(MapperEmployedList.class);

        employedServices = new EmployedServicesImpl(
                salaryCalculatorMock,
                paymentProcessorMock,
                mapperEmployedListMock
        );

     request =  PayRequest.builder()
                .bankAccountNumber("123456789")
                .cardExpirationDate("01/25")
                .Salary( 1000.0)
                .build();

    }

    @Test
    public void testPayBanking() {
        PayRequest request =  PayRequest.builder()
                .bankAccountNumber("123456789")
                .cardExpirationDate("01/25")
                .Salary( 1000.0)
                .build();

        when(paymentProcessorMock.processPayment("123456789", "01/25", 1000.0)).thenReturn(true);

        boolean result = employedServices.payBanking(request);

        assertTrue(result);
        verify(paymentProcessorMock).processPayment("123456789", "01/25", 1000.0);
    }

    @Test
    public void testPaymentEmployed() throws Exception {

        when(salaryCalculatorMock.calculatorPaySalary(1000.0, 31, request.getDayWorks())).thenReturn(900.0);

        double result = employedServices.paymentEmployed(request);

        assertEquals("900.0", result);
        verify(salaryCalculatorMock).calculatorPaySalary(1000.0, 31, request.getDayWorks());
    }

    @Test
    public void testEmployed() throws Exception {
        List<Employed> mockEmployed = new ArrayList<>();
        when(mapperEmployedListMock.getCustomers()).thenReturn(mockEmployed);

        List<Employed> result = employedServices.employed();

        assertEquals(mockEmployed, result);
        verify(mapperEmployedListMock).getCustomers();
    }

    @Test
    public void testGetEmployedByEmail() throws Exception {
        String email = "yannickkandee@gmail.com";
        List<Employed> mockEmployed = new ArrayList<>();
        Employed ep=new Employed("01","yan hande",
                "yannickkandee@gmail.com","csc",
                11,400.0,"1209384736329");

        mockEmployed.add(ep);

       //when(any(String.class)).thenReturn("");

        List<Employed> result = employedServices.getEmployedByEmail(email);

        assertEquals(mockEmployed, result);
        verify(mapperEmployedListMock).getCustomers();
    }
}
