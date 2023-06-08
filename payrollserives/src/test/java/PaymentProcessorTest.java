import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import processor.PaymentProcessor;

import java.util.Calendar;

public class PaymentProcessorTest {

    PaymentProcessor paymentProcessor = new PaymentProcessor();
    @Test
    public void testProcessPayment_ValidCard_ValidExpirationDate_SuccessfulPayment() {
        // Arrange
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        String cardNumber = "1234567890123456";
        String expirationDate = "06/23";
        double amount = 100.0;

        // Act
        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, amount);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testProcessPayment_InvalidCard_InvalidExpirationDate_FailedPayment() {
        // Arrange

        String cardNumber = "1234";
        String expirationDate = "06/21";
        double amount = 100.0;

        // Act
        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, amount);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsValidCardNumber_ValidCardNumber_ReturnsTrue() {
        // Arrange

        String cardNumber = "1234567890123456";

        // Act
        boolean result = paymentProcessor.isValidCardNumber(cardNumber);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsValidCardNumber_InvalidCardNumber_ReturnsFalse() {
        // Arrange
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        String cardNumber = "1234";

        // Act
        boolean result = paymentProcessor.isValidCardNumber(cardNumber);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsValidExpirationDate_ValidExpirationDate_ReturnsTrue() {
        // Arrange
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        String expirationDate = "06/23";

        // Act
        boolean result = paymentProcessor.isValidExpirationDate(expirationDate);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsValidExpirationDate_InvalidExpirationDate_ReturnsFalse() {
        // Arrange
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        String expirationDate = "06/25";

        // Act
        boolean result = paymentProcessor.isValidExpirationDate(expirationDate);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsValidCVV_ValidCVV_ReturnsTrue() {
        // Arrange
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        String cvv = "123";

        // Act
        boolean result = paymentProcessor.isValidCVV(cvv);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsValidCVV_InvalidCVV_ReturnsFalse() {
        // Arrange
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        String cvv = "12";

        // Act
        boolean result = paymentProcessor.isValidCVV(cvv);

        // Assert
        Assertions.assertFalse(result);
    }
}
