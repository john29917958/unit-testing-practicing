package classical.and.london.schools.of.testings;

import java.util.Map;
import java.util.HashMap;

/**
 * A product store.
 */
public class StoreImpl implements Store {
    /**
     * The inventory of products.
     */
    private Map<Products, Integer> inventory;

    public StoreImpl() {
        this.inventory = new HashMap<Products, Integer>();
    }

    @Override
    public void addInventory(Products product, int amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount should be greater than or equals to 0.");
        }

        if (this.inventory.containsKey(product)) {
            int originalAmount = this.inventory.get(product);
            int newAmount = originalAmount + amount;
            this.inventory.put(product, newAmount);
        } else {
            this.inventory.put(product, amount);
        }
    }

    @Override
    public int getInventory(Products product) {
        int amount;
        if (this.inventory.containsKey(product)) {
            amount = this.inventory.get(product);
        } else {
            amount = 0;
        }
        return amount;
    }

    @Override
    public boolean hasEnoughInventory(Products product, int amount) {
        return this.inventory.containsKey(product) && this.inventory.get(product) > amount;
    }

    @Override
    public void removeInventory(Products product, int amount) {
        if (this.inventory.containsKey(product)) {
            int stock = this.inventory.get(product);
            if (stock >= amount) {
                int updatedStock = stock - amount;
                this.inventory.put(product, updatedStock);
            }
        }
    }
}
