package com.ling.kotlin.p1

import kotlin.math.roundToInt

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/9
 *    @desc   : 08.数字类型
 */
fun main() {
    println("1.安全转换函数")
    test01()
    println("2.Double转Int与类型格式化")
    test02()
}

/**
 * 1.安全转换函数
 */
private fun test01() {
    // 抛出异常
    // val number = "8.98".toInt()
    val number = "8.98".toIntOrNull()
    println("number = $number")
}

/**
 * 2.Double转Int与类型格式化
 */
private fun test02() {
    // 精度损失
    println(8.956756.toInt())
    // 四舍五入
    println(8.956756.roundToInt())

    // 格式化：保留两位小数
    println("%.2f".format(8.956756))
}
