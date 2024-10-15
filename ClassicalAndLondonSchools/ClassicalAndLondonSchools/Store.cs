namespace ClassicalAndLondonSchools;

/// <summary>
/// A product store.
/// </summary>
public class Store : IStore
{
    /// <summary>
    /// The inventory of products.
    /// </summary>
    private Dictionary<Products, int> _inventory;

    public Store()
    {
        _inventory = new Dictionary<Products, int>();
    }

    public void AddInventory(Products product, int amount)
    {
        if (amount < 0)
        {
            throw new ArgumentException("Amount should be greater than or equals to 0.");
        }

        if (_inventory.ContainsKey(product))
        {
            _inventory[product] = amount;
        }
        else
        {
            _inventory.Add(product, amount);
        }
    }

    /// <summary>
    /// Gets inventory of a specific product.
    /// </summary>
    /// <param name="product">
    /// The product to check.
    /// </param>
    /// <returns>
    /// Returns the product inventory.
    /// </returns>
    public int GetInventory(Products product)
    {
        if (_inventory.ContainsKey(product))
        {
            return _inventory[product];
        }
        else
        {
            return 0;
        }
    }

    public bool HasEnoughInventory(Products product, int amount)
    {
        bool isHasEnoughInventory = _inventory.ContainsKey(product) && _inventory[product] > amount;
        return isHasEnoughInventory;
    }

    public void RemoveInventory(Products product, int amount)
    {
        if (_inventory.ContainsKey(product) && _inventory[product] >= amount)
        {
            _inventory[product] -= amount;
        }
    }
}
