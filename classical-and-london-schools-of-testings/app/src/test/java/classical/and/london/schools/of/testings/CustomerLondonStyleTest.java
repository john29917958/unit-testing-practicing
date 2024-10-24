package classical.and.london.schools.of.testings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomerLondonStyleTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testPurchaseShouldSucceedWhenInventoryIsEnough() {
        Store store = Mockito.mock(Store.class);
        Mockito.when(store.hasEnoughInventory(Products.Shampoo, 5)).thenReturn(true);
        boolean isPurchased = customer.purchase(store, Products.Shampoo, 5);
        assertTrue(isPurchased);
        Mockito.verify(store, Mockito.times(1)).hasEnoughInventory(Products.Shampoo, 5);
    }

    @Test
    public void testPurchaseShouldFailWhenInventoryIsNotEnough() {
        Store store = Mockito.mock(Store.class);
        Mockito.when(store.hasEnoughInventory(Products.Shampoo, 5)).thenReturn(false);
        boolean isPurchased = customer.purchase(store, Products.Shampoo, 5);
        assertFalse(isPurchased);
        Mockito.verify(store, Mockito.times(0)).removeInventory(Products.Shampoo, 5);
    }

    @AfterEach
    public void tearDown() {
        customer = null;
    }
}
