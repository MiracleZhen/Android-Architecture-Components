package com.ling.kotlin.p2

import java.io.File

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 07.扩展
 */
fun main() {
    println("1.定义扩展函数")
    test01()

    println("2.泛型扩展函数")
    test02()

    println("3.定义扩展属性")
    test03()

    println("4.可空类扩展")
    test04()

    println("5.infix关键字")
    test05()

    println("6.定义扩展文件与重命名扩展")
    test06()

    println("7.apply函数详解")
    test07()
}

/**
 * 1.定义扩展函数
 */
private fun test01() {
    println("Jack".addExt())
    println("Rose".addExt(5))

    "Jack".easyPrint()
    100.easyPrint()
}

// 给字符串追加若干个感叹号
private fun String.addExt(count: Int = 1): String {
    return this + "!".repeat(count)
}

// 在超类上定义扩展函数，Any的所有子类都能使用函数了
private fun Any.easyPrint() {
    println("easy print: $this")
}

/**
 * 2.泛型扩展函数
 */
private fun test02() {
    "Jack".easyPrintln().addExt(10).easyPrintln()

    println("Rose".let { "length: ${it.length}" })
}

private fun <T> T.easyPrintln(): T {
    println(this)
    return this
}

private inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

/**
 * 3.定义扩展属性
 */
private fun test03() {
    "The people's Republic of China".numVowels.easyPrint()
}

private val String.numVowels
    get() = count { "abc".contains(it) }

/**
 * 4.可空类扩展
 */
private fun test04() {
    var nullableString: String? = null
    nullableString.printWithDefault("可空类扩展")
    nullableString = "Jack"
    nullableString.printWithDefault("可空类扩展")
}

private fun String?.printWithDefault(default: String) {
    println(this ?: default)
}

/**
 * 5.infix关键字
 */
private fun test05() {
    var nullableString: String? = null
    nullableString printWithDefault2 "default value"
    nullableString = "Rose"
    nullableString printWithDefault2 "default value"

    println("Rose" to 18)
}

private infix fun String?.printWithDefault2(default: String) {
    println(this ?: default)
}

/**
 * 6.定义扩展文件与重命名扩展
 */
private fun test06() {
    // import com.ling.kotlin.p2.randomTake
    val list = listOf("Jack", "Rose", "Tom")
    println(list.randomTake())

    // import com.ling.kotlin.p2.randomTake as randomizer
    // println(list.randomizer())
}

private fun <T> Iterable<T>.randomTake(): T {
    return this.shuffled().first()
}

/**
 * 7.apply函数详解
 */
private fun test07() {
    val apply = "Jack".apply {
        println(this)
        println(uppercase())
    }.apply {
        println(length)
    }
    println("apply: $apply")

    // 分解一下
    // 1.定义扩展函数
    fun File.ext() {
        setReadable(true)
        println("set readable true")
    }
    // 2.给block变量赋值
    val block = File::ext
    // 3.传入apply函数
    File("xxx").apply(block)

    File("xxx").apply {
        setReadable(true)
        println("set readable true")
    }
}

private inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}
