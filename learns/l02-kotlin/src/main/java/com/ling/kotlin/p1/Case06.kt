package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/9
 *    @desc   : 06.null安全与异常
 */
fun main() {
    println("1.null安全")
    test01()
    println("2.异常")
    test02()
}

/**
 * 1.null安全
 */
private fun test01() {
    // 1.1 kotlin可空性
    var str1: String? = null
    str1 = "Jack"
    println("str1 = $str1")

    // 1.2 安全调用操作符
    val str2: String? = null
    val length = str2?.length
    println("str2 = $str2, length = $length")

    val result1 = readLine()?.let {
        if (it.isNotBlank()) {
            it.uppercase()
        } else {
            "butterfly"
        }
    }
    println(result1)

    // 1.3 使用非空断言操作符
    println("input uppercase: ${readLine()!!.uppercase()}")

    // 1.4 使用if判断null值情况
    val input = readLine()
    val result2 = if (input != null) {
        input.uppercase()
    } else {
        "butterfly"
    }
    println(result2)

    // 1.4 使用空合并操作符
    println(readLine() ?: "butterfly")
    println(readLine()?.let { "uppercase: $${it.uppercase()}" } ?: { "butterfly" })
}

/**
 * 2.异常
 */
private fun test02() {
    // 处理异常
    val number: Int? = null
    try {
        checkOperation(number)
        println(number!!.plus(1))
    } catch (e: Exception) {
        e.printStackTrace()
    }

    // 先决条件函数
    checkNotNull(number) { "Something is not good" }
}

// 抛出异常
private fun checkOperation(number: Int?) {
    number ?: throw UnskilledException()
}

// 自定义异常
class UnskilledException : IllegalArgumentException("操作不当")
