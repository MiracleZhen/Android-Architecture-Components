package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/8
 *    @desc   : 05.匿名函数｜lambda｜闭包
 */
fun main() {
    println("1.什么是匿名函数")
    test01()
    println("2.函数类型与隐式返回")
    test02()
    println("3.函数参数")
    test03()
    println("4.it关键字")
    test04()
    println("5.类型推断")
    test05()
    println("6.什么是lambda")
    test06()
    println("7.定义参数是函数的函数")
    test07()
    println("8.函数内联（inline）")
    test08()
    println("9.函数引用")
    test09()
    println("10.函数类型作为返回类型")
    test10()
}

/**
 * 5.1 什么是匿名函数
 */
private fun test01() {
    val count = "miracle".count()
    println("count = $count")

    val totalC = "miracle".count { letter ->
        letter == 'c'
    }
    println("total C = $totalC")
}

/**
 * 5.2 函数类型与隐式返回
 */
private fun test02() {
    val blessingFunction: () -> String = {
        val holiday = "National Day."
        "Happy $holiday"
    }
    println(blessingFunction())
}

/**
 * 5.3 函数参数
 */
private fun test03() {
    val blessingFunction: (String) -> String = { name ->
        val holiday = "New Year"
        "$name, Happy $holiday"
    }
    println(blessingFunction("Jack"))
}

/**
 * 5.4 it关键字
 */
private fun test04() {
    val blessingFunction: (String) -> String = {
        val holiday = "New Year"
        "$it, Happy $holiday"
    }
    println(blessingFunction("Rose"))
}

/**
 * 5.5 类型推断
 */
private fun test05() {
    // 1.不带参数
    val blessingFunction1: () -> String = {
        val holiday = "New Year"
        "Happy $holiday"
    }
    val blessingFunction2 = {
        val holiday = "New Year"
        "Happy $holiday"
    }
    println(blessingFunction1())
    println(blessingFunction2())

    // 2.带参数
    val blessingFunction3: (String, Int) -> String = { name, year ->
        val holiday = "New Year"
        "$name, Happy $holiday $year"
    }
    val blessingFunction4 = { name: String, year: Int ->
        val holiday = "New Year"
        "$name, Happy $holiday $year"
    }
    println(blessingFunction3("Jack", 2021))
    println(blessingFunction4("Rose", 2022))
}

/**
 * 5.6 什么是lambda
 */
private fun test06() {
    val function = { name: String, age: Int ->
        "Your name is $name, age is $age"
    }
    println(function("Jack", 18))
}

/**
 * 5.7 定义参数是函数的函数
 */
private fun test07() {
    // 获取促销文案
    val getDiscountWords = { goodsName: String, hour: Int ->
        val currentYear = 2022
        "${currentYear}年, 双11${goodsName}促销倒计时：$hour 小时"
    }
    // 展现
    showOnBoard(goodsName = "冰箱", getDiscountWords)

    // 简略写法
    showOnBoard(goodsName = "洗衣机") { goodsName: String, hour: Int ->
        val currentYear = 2022
        "${currentYear}年, 双11${goodsName}促销倒计时：$hour 小时"
    }
}

private fun showOnBoard(goodsName: String, showDiscount: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(showDiscount(goodsName, hour))
}

/**
 * 5.8 函数内联（inline）
 */
private fun test08() {
    login("Jack", "123456") { code, msg ->
        println("login result: code = $code, msg = $msg")
    }
    login("Rose", "111222") { code, msg ->
        println("login result: code = $code, msg = $msg")
    }
}

// 函数内联 关键字 inline
private inline fun login(username: String, password: String, callback: (code: Int, msg: String) -> Unit) {
    if (username == "Jack" && password == "123456") {
        callback(0, "login success")
    } else {
        callback(-1, "login failure")
    }
}

/**
 * 5.9 函数引用
 */
private fun test09() {
    login("Rose", "111222", ::callback)
}

private fun callback(code: Int, msg: String) {
    println("login result: code = $code, msg = $msg")
}

/**
 * 5.10 函数类型作为返回类型
 */
private fun test10() {
    val configDiscountWords = configDiscountWords()
    println(configDiscountWords("s"))
}

private fun configDiscountWords(): (String) -> String {
    val currentYear = 2022
    var hour = (1..24).shuffled().last()
    return { goodsName: String ->
        hour += 20
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
}
