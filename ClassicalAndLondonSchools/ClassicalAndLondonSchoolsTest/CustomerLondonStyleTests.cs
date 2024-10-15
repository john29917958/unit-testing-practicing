using ClassicalAndLondonSchools;
using Moq;

namespace ClassicalAndLondonSchoolsTest
{
    [TestClass]
    public class CustomerLondonStyleTests
    {
        private Customer _customer;

        [TestInitialize]
        public void Initialize()
        {
            _customer = new Customer();
        }

        [TestMethod]
        public void TestPurchaseShouldSucceedWhenInventoryIsEnough()
        {
            Mock<IStore> storeMock = new Mock<IStore>();
            storeMock.Setup(s => s.HasEnoughInventory(Products.Shampoo, 5)).Returns(true);
            bool isPurchased = _customer.Purchase(storeMock.Object, Products.Shampoo, 5);
            Assert.IsTrue(isPurchased);
            storeMock.Verify(s => s.HasEnoughInventory(Products.Shampoo, 5), Times.Once);
        }

        [TestMethod]
        public void TestPUrchaseShouldFailWhenInventoryIsNotEnough()
        {
            Mock<IStore> storeMock = new Mock<IStore>();
            storeMock.Setup(s => s.HasEnoughInventory(Products.Shampoo, 5)).Returns(false);
            bool isPurchased = _customer.Purchase(storeMock.Object, Products.Shampoo, 5);
            Assert.IsFalse(isPurchased);
            storeMock.Verify(s => s.RemoveInventory(Products.Shampoo, 5), Times.Never);
        }

        [TestCleanup]
        public void Cleanup()
        {
            _customer = null;
        }
    }
}