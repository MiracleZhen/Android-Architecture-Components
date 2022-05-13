package com.ling.kotlin.p2

import kotlin.math.absoluteValue

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 01.定义类
 */
fun main() {
    println("1.field")
    val player01 = Player0101()
    player01.name = "Rose"
    println("name = ${player01.name}, age = ${player01.age}")

    println("2.计算属性")
    val player02 = Player0102()
    println(player02.rolledValue)

    println("3.防范竟态条件")
    val player03 = Player0103()
    player03.saySomething()
}

/**
 * 1.field
 */
private class Player0101 {
    var name = "Jack"
        get() {
            return field.uppercase()
        }
        set(value) {
            field = value.trim()
        }
    var age = 18
        get() = field.absoluteValue
        private set(value) {
            field = value.absoluteValue
        }
}

/**
 * 2.计算属性
 */
private class Player0102 {
    val rolledValue
        get() = (1..6).shuffled().first()
}

/**
 * 3.防范竟态条件
 */
private class Player0103 {
    var words: String? = "hello"

    fun saySomething() {
        words?.also {
            println("Hello ${it.uppercase()}")
        }
    }
}
