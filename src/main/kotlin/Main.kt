import api.InventoryService
import api.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000/") // JSON 服务器的地址
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productService = retrofit.create(ProductService :: class.java)
    val productResponse = productService.getProducts().execute()

    if (productResponse.isSuccessful) {
        val products = productResponse.body()
        products?.forEach { product ->

            // 根据 SKU 查询对应的库存信息
            val inventoryService = retrofit.create(InventoryService::class.java)
            val inventoryResponse = inventoryService.getInventories().execute()

            if (inventoryResponse.isSuccessful) {
                val inventories = inventoryResponse.body()?.filter { it.SKU == product.SKU }
                val totalQuantity = inventories?.sumOf { it.quantity } ?: 0

                // 根据库存量计算价格
                val price = when {
                    product.type == "HIGH_DEMAND" && totalQuantity <= 30 -> product.price * 1.5
                    product.type == "HIGH_DEMAND" && totalQuantity <= 100 -> product.price * 1.2
                    else -> product.price
                }

                println("SKU: ${product.SKU}, Name: ${product.name}, Price: $price, Total Quantity: $totalQuantity, Image: ${product.image}")
            } else {
                println("Failed to fetch inventories: ${inventoryResponse.errorBody()}")
            }
        }
    } else {
        println("Failed to fetch products: ${productResponse.errorBody()}")
    }
}