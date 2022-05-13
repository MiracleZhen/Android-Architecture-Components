package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/4/2
 *    @desc   : 02.变量、常量和类型
 */
fun main() {
    println("1.声明变量和内置数据类型")
    test01()
    println("2.只读变量")
    test02()
    println("3.类型推断")
    test03()
    println("4.编译时常量")
    test04()
    println("5.查看kotlin字节码")
    test05()
    println("6.kotlin的引用类型")
    test06()
}

/**
 * 2.1 声明变量和内置数据类型
 */
private fun test01() {
    // 声明变量
    var maxValue: Int = 0
    maxValue = 10
    println(maxValue)

    // 内置数据类型
    val str: String = "Hello"
    val char: Char = 'A'
    val bool: Boolean = true
    val long: Long = 100
    val int: Int = 100
    val short: Short = 100
    val byte: Byte = 100
    val double: Double = 1.0
    val float: Float = 1F
    val list: List<Int> = listOf(1, 3, 5)
    val set: Set<String> = setOf("Java", "Kotlin", "Scala", "Groovy")
    val map: Map<String, Int> = mapOf("small" to 5, "medium" to 7, "large" to 9)
    println(str + char + bool + long + int + short + byte +
            double + float + list + set + map)
}

/**
 * 2.2 只读变量
 */
private fun test02() {
    val name: String = "Jack"
    var age: Int = 10
    age += 1
    println(name + age)
}

/**
 * 2.3 类型推断
 */
private fun test03() {
    val name = "Jack"
    println(name)
}

/**
 * 2.4 编译时常量
 */
private const val MAX = 256
private fun test04() {
    println(MAX)
}

/**
 * 2.5 查看kotlin字节码
 */
private fun test05() {
    println("查看kotlin字节码")
}

/**
 * 2.6 kotlin的引用类型
 */
private fun test06() {
    println("kotlin只提供引用类型")
}
