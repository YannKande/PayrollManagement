
import com.google.common.io.Resources;
import model.Employed;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MapperEmployedTest {
    @Test
    public void testGetCustomers() throws IOException {
        // Mock the InputStream with your test data
        InputStream inputStreamMock = mock(InputStream.class);
        when(inputStreamMock.read()).thenReturn((int) '[', (int) ']', -1);

        // Mock the Resources class to return the mocked InputStream
        Resources resourcesMock = mock(Resources.class);
        //when(resourcesMock.getResource("dummy/data.json")).thenReturn(inputStreamMock);

        // Call the method to be tested
       // List<Employed> result = MapperEmployed.getCustomers(resourcesMock);

        // Define the expected result
        List<Employed> expected = new ArrayList<>();
        // Add expected Employed objects to the list

        // Assert the result
    //    assertEquals(expected, result);
    }
}
