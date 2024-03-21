package dataModel

data class Product(
    val id: Int,
    val SKU: String,
    val name: String,
    val price: Double,
    val type: String,
    val image: String
)

data class Inventory(
    val id: Int,
    val SKU: String,
    val zone: String,
    val quantity: Int
)