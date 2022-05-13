package com.ling.kotlin.p2

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 03.继承
 */
fun main() {
    println("1.继承")
    test01()

    println("2.类型转换")
    test02()

    println("3.Any超类")
    test03()
}

/**
 * 1.继承
 */
private fun test01() {
    val luxuryProduct = LuxuryProduct()
    println(luxuryProduct.description())
    println(luxuryProduct.load())
}

private open class Product(val name: String) {

    fun description() = "Product: $name"

    open fun load() = "Nothing..."
}

private class LuxuryProduct : Product("Luxury") {

    override fun load(): String {
        return super.load() + " open"
    }

    fun special() = "LuxuryProduct special function"
}

/**
 * 2.类型转换
 */
private fun test02() {
    val product: Product = LuxuryProduct()
    println(product is LuxuryProduct)
    println(product is Product)

    (product as LuxuryProduct).special()

    if (product is LuxuryProduct) {
        product.special()
    }
}

/**
 * 3.Any超类
 */
private fun test03() {
    val value: Any = 100
    println(value)
}
