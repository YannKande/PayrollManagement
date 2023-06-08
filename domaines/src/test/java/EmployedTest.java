import model.Employed;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployedTest {

    @Test
    public void testGettersAndSetters() {

        Employed employed = new Employed();

        employed.setId("123");
        assertEquals("123", employed.getId());

        employed.setName("John Doe");
        assertEquals("John Doe", employed.getName());

        employed.setCompany("ACME Inc.");
        assertEquals("ACME Inc.", employed.getCompany());

        employed.setFunctionLevel(2);
        assertEquals(2, employed.getFunctionLevel());

        employed.setSalary(50000.0);
        assertEquals(50000.0, employed.getSalary(), 0.01);

        employed.setBankAccountNumber("123456789");
        assertEquals("123456789", employed.getBankAccountNumber());
    }



}
