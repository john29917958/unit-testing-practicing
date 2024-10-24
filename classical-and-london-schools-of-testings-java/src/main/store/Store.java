package main.store;

/**
 * A product store.
 */
public interface Store {
    /**
     * Add product inventory.
     * 
     * @param product The product to add.
     * @param amount  The amount to add.
     * @throws Exception Occurrs When amount is less than 0.
     */
    void addInventory(Products product, int amount) throws Exception;

    /**
     * Gets inventory of a specific product.
     * 
     * @param product The product to check.
     * @return Returns the product inventory.
     */
    int getInventory(Products product);

    boolean hasEnoughInventory(Products product, int amount);

    void removeInventory(Products product, int amount);
}
