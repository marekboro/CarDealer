import org.junit.Before;
import org.junit.Test;
import people.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;


    @Before
    public void before() {
        customer = new Customer("Jack", 5000.0, "To buy a Porche");
    }

    @Test
    public void hasName() {
        assertEquals("Jack", customer.getName());
    }

    @Test
    public void hasMoney() {
        assertEquals(5000.0, customer.getMoney(), 0.01);
    }

    @Test
    public void hasADream() {
        assertEquals("To buy a Porche", customer.getDreams());
    }

    @Test
    public void hasNoVehiclesOnCreation() {
        assertEquals(0, customer.getOwnedVehicles().size());
    }
}
