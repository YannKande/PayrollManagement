package processor;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class PaymentProcessor {
    public boolean processPayment(String cardNumber, String expirationDate, double amount) {
        // Validate card information
        if (!isValidCardNumber(cardNumber) || !isValidExpirationDate(expirationDate) ) {
            System.out.println("Invalid card information");
            return false;
        }

        // Process payment
        if (isPaymentSuccessful(cardNumber, expirationDate,amount)) {
            System.out.println("Payment processed successfully");
            return true;
        } else {
            System.out.println("Payment failed");
            return false;
        }
    }

    public boolean isValidCardNumber(String cardNumber) {
        // Add card number validation logic here
        return cardNumber.length() == 16; // Example validation: Card number must be 16 digits long
    }

    public boolean isValidExpirationDate(String expirationDate) {
        // Add expiration date validation logic here
        if (!expirationDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }

        // Parse the expiration date into a Date object
        SimpleDateFormat format = new SimpleDateFormat("MM/yy");
        format.setLenient(false);
        Date parsedDate;
        try {
            parsedDate = format.parse(expirationDate);
        } catch (ParseException e) {
            return false;
        }

        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);

        // Get the provided date
        Calendar expirationDates = Calendar.getInstance();
        expirationDates.setTime(parsedDate);
        expirationDates.set(Calendar.HOUR_OF_DAY, 23);
        expirationDates.set(Calendar.MINUTE, 59);
        expirationDates.set(Calendar.SECOND, 59);
        expirationDates.set(Calendar.MILLISECOND, 999);

        // Compare the expiration date with the current date
        return expirationDates.getTime().before(currentDate.getTime());
        // Example validation: Expiration date must be in the format "MM/YY" and should be a future date
        // You may need to use a date library or parse the string to validate the date.
       // return expirationDate.matches("^(0[1-9]|1[0-2])/[0-9]{2}$");
    }

    public boolean isValidCVV(String cvv) {
        // Add CVV validation logic here
        return cvv.length() == 3; // Example validation: CVV must be 3 digits long
    }

    private boolean isPaymentSuccessful(String cardNumber, String expirationDate, double amount) {
        // Add payment processing logic here
        // This is a placeholder implementation that assumes all payments are successful
        return true;
    }
}
