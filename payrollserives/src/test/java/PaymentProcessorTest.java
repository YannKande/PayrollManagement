import org.junit.Assert;
import org.junit.Test;
import processor.PaymentProcessor;

public class PaymentProcessorTest {

    @Test
    public void testValidPayment() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        String cardNumber = "1234567890123456";
        String expirationDate = "12/25";
        String cvv = "123";
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidCardNumber() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        String cardNumber = "123456"; // Invalid card number length
        String expirationDate = "12/25";
        String cvv = "123";
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);

        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidExpirationDate() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        String cardNumber = "1234567890123456";
        String expirationDate = "15/21"; // Invalid expiration date format
        String cvv = "123";
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);

        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidCVV() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        String cardNumber = "1234567890123456";
        String expirationDate = "12/25";
        String cvv = "12"; // Invalid CVV length
        double amount = 100.0;

        boolean result = paymentProcessor.processPayment(cardNumber, expirationDate, cvv, amount);

        Assert.assertFalse(result);
    }

    // Add more test cases as needed

}
