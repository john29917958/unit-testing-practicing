package store;

public class Customer {
    /**
     * Purchase specific amount of a product from the store.
     * 
     * @param store   The store containing products.
     * @param product The product to purchase.
     * @param amount  The amount to purchase.
     * @return Returns true if successfully purchased the product from the store;
     *         Returns false otherwise.
     */
    public boolean purchase(Store store, Products product, int amount) {
        boolean isPurchased = false;
        if (store.hasEnoughInventory(product, amount)) {
            store.removeInventory(product, amount);
            isPurchased = true;
        }
        return isPurchased;
    }
}
