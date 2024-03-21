package api

import dataModel.Inventory
import dataModel.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}

interface InventoryService {
    @GET("inventories")
    fun getInventories(): Call<List<Inventory>>
}