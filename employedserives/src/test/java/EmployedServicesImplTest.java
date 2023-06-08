import model.PayRequest;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import processor.PaymentProcessor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployedServicesImplTest {
    private EmployedServicesImpl employedServices;
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    void setUp() {
        paymentProcessor = mock(PaymentProcessor.class);
        employedServices = new EmployedServicesImpl(paymentProcessor);
    }

    @Test
    void payBanking_ShouldProcessPaymentWithCorrectParameters() {
        // Arrange
        PayRequest payRequest = PayRequest.builder()
                .bankAccountNumber("123456789")
                .cardExpirationDate("12/25")
                .Salary(1000.0)
                .build();


        // Act
        employedServices.payBanking(payRequest);

        // Assert
        verify(paymentProcessor).processPayment("123456789", "12/25", 1000.0);
    }

    @Test
    void payBanking_ShouldReturnTrueWhenPaymentIsSuccessful() {
        // Given
        PayRequest payRequest = PayRequest.builder()
                .bankAccountNumber("123456789")
                .cardExpirationDate("12/25")
                .Salary(1000.0)
                .build();

        when(paymentProcessor.processPayment(anyString(), anyString(),
                anyDouble())).thenReturn(true);

        // Act
        boolean result = employedServices.payBanking(payRequest);

        // Assert
        assertTrue(result);
    }

    @Test
    void payBanking_ShouldReturnFalseWhenPaymentFails() {
        // Arrange
        PayRequest payRequest = PayRequest.builder()
                .bankAccountNumber("123456789")
                .cardExpirationDate("12/25")
                .Salary(1000.0)
                .build();

        when(paymentProcessor.processPayment(anyString(),
                anyString(), anyDouble())).thenReturn(false);

        // Act
        boolean result = employedServices.payBanking(payRequest);

        // Assert
        assertFalse(result);
    }
}

