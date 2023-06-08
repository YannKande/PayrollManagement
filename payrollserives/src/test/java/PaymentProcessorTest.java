import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import processor.PaymentProcessor;

public class PaymentProcessorTest {



PaymentProcessor paymentProcessor = new PaymentProcessor();

    @Test
    public void testValidPayment() {

        String cardNumber = "1234567890123456";
        String expirationDate = "12/25";
        String cvv = "123";
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidCardNumber() {

        String cardNumber = "123456"; // Invalid card number length
        String expirationDate = "12/25";
        String cvv = "123";
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);

        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidExpirationDate() {

        String cardNumber = "1234567890123456";
        String expirationDate = "15/21"; // Invalid expiration date format
        String cvv = "123";
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);

        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidCVV() {

        String cardNumber = "1234567890123456";
        String expirationDate = "12/25";
        String cvv = "12"; // Invalid CVV length
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);

        Assert.assertFalse(result);
    }

    // Add more test cases as needed

}
