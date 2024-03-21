package unitTest

import api.InventoryService
import api.ProductService
import dataModel.Inventory
import dataModel.Product
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import retrofit2.Call
import retrofit2.Response

class ServiceTest {
    @Test
    fun `test ProductService`() {
        val productService = mockk<ProductService>()
        val products = listOf(Product(1, "ABC123", "Electronic Watch", 299.99, "NORMAL", "image1.jpg"))
        val call = mockk<Call<List<Product>>>()
        every { call.execute() } returns Response.success(products)
        every { productService.getProducts() } returns call

        val response = productService.getProducts().execute()
        val actualProducts = response.body()

        assertEquals(products, actualProducts)
    }

    @Test
    fun `test InventoryService`() {
        val inventoryService = mockk<InventoryService>()
        val inventories = listOf(Inventory(1, "ABC123", "CN_NORTH", 120))
        val call = mockk<Call<List<Inventory>>>()
        every { call.execute() } returns Response.success(inventories)
        every { inventoryService.getInventories() } returns call

        val response = inventoryService.getInventories().execute()
        val actualInventories = response.body()

        assertEquals(inventories, actualInventories)
    }

}