namespace ClassicalAndLondonSchools;

public interface IStore
{
    public void AddInventory(Products product, int amount);

    /// <summary>
    /// Gets inventory of a specific product.
    /// </summary>
    /// <param name="product">
    /// The product to check.
    /// </param>
    /// <returns>
    /// Returns the product inventory.
    /// </returns>
    public int GetInventory(Products product);

    public bool HasEnoughInventory(Products product, int amount);

    public void RemoveInventory(Products product, int amount);
}
