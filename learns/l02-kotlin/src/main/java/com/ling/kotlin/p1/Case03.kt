package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/8
 *    @desc   : 03.条件语句
 */
fun main() {
    println("1.range表达式")
    test01()
    println("2.when表达式")
    test02()
    println("3.string模版")
    test03()
}

/**
 * 3.1 range表达式
 */
private fun test01() {
    val age = 18
    val result = if (age in 0..18) {
        "未成年"
    } else {
        "成年"
    }
    println(result)

    if (age !in 1..10) {
        println("不在1到10范围之内")
    }
}

/**
 * 3.2 when表达式
 */
private fun test02() {
    val level = when ("小学") {
        "学前班" -> "幼儿"
        "小学" -> "少儿"
        "中学" -> "青少年"
        else -> "成年"
    }
    println(level)
}

/**
 * 3.3 string模版
 */
private fun test03() {
    val origin = "Jack"
    val dest = "Rose"
    println("$origin love $dest")

    val flag = false
    println("Answer is: ${if (flag) "我可以" else "对不起"}")
}
