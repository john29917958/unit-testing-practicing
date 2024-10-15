using ClassicalAndLondonSchools;

namespace ClassicalAndLondonSchoolsTest;

[TestClass]
public class CustomerTests
{
    private Customer _customer;

    private Store _store;

    [TestInitialize]
    public void Initialize()
    {
        _customer = new Customer();
        _store = new Store();
    }

    [TestMethod]
    public void TestPurchaseShouldSucceedWhenInventoryIsEnough()
    {
        _store.AddInventory(Products.Shampoo, 10);
        bool isPurchased = _customer.Purchase(_store, Products.Shampoo, 5);
        Assert.IsTrue(isPurchased);
        Assert.AreEqual(5, _store.GetInventory(Products.Shampoo));
    }

    [TestMethod]
    public void TestPurchaseShouldFailWhenInventoryIsNotEnough()
    {
        _store.AddInventory(Products.Shampoo, 10);
        bool isPurchased = _customer.Purchase(_store, Products.Shampoo, 10);
        Assert.IsFalse(isPurchased);
        Assert.AreEqual(10, _store.GetInventory(Products.Shampoo));
    }

    [TestCleanup]
    public void Cleanup()
    {
        _customer = null;
        _store = null;
    }
}