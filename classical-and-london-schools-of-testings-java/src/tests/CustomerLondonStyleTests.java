package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;
import store.Customer;
import store.Products;
import store.Store;

public class CustomerLondonStyleTests extends TestCase {
    private Customer customer;

    @Before
    public void setUp() {
        this.customer = new Customer();
    }

    @Test
    public void testPurchaseShouldSucceedWhenInventoryIsEnough() {
        Store store = Mockito.mock(Store.class);
        Mockito.when(store.hasEnoughInventory(Products.Shampoo, 5)).thenReturn(true);
        boolean isPurchased = this.customer.purchase(store, Products.Shampoo, 5);
        assertTrue(isPurchased);
        Mockito.verify(store, Mockito.times(1)).hasEnoughInventory(Products.Shampoo, 5);
    }

    @Test
    public void testPurchaseShouldFailWhenInventoryIsNotEnough() {
        Store store = Mockito.mock(Store.class);
        Mockito.when(store.hasEnoughInventory(Products.Shampoo, 5)).thenReturn(false);
        boolean isPurchased = this.customer.purchase(store, Products.Shampoo, 5);
        assertFalse(isPurchased);
        Mockito.verify(store, Mockito.times(0)).removeInventory(Products.Shampoo, 5);
    }

    @After
    public void tearDown() {
        this.customer = null;
    }
}
