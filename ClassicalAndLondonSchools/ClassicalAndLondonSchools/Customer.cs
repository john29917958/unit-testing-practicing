namespace ClassicalAndLondonSchools;

public class Customer
{
    /// <summary>
    /// Purchase specific amount of a product from the store.
    /// </summary>
    /// <param name="store">
    /// The store containing products.
    /// </param>
    /// <param name="product">
    /// The product to purchase.
    /// </param>
    /// <param name="amount">
    /// The amount to purchase.
    /// </param>
    /// <returns>
    /// Returns true if successfully purchased the product from the store; Returns false otherwise.
    /// </returns>
    public bool Purchase(IStore store, Products product, int amount)
    {
        bool isPurchased = false;
        if (store.HasEnoughInventory(product, amount))
        {
            store.RemoveInventory(product, amount);
            isPurchased = true;
        }
        return isPurchased;
    }
}
