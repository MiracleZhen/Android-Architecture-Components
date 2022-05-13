package com.ling.kotlin.p2

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 05.接口与抽象类
 */
fun main() {
    println("1.接口定义")
    test01()

    println("2.抽象类")
    test02()
}

/**
 * 1.接口定义
 */
private fun test01() {
    val car = Car()
    println(car.move())
}

private interface Movable {
    fun move(): String
}

private class Car : Movable {

    override fun move(): String {
        return "car move"
    }
}

/**
 * 2.抽象类
 */
private fun test02() {
    val aK47 = AK47(500)
    println(aK47.trigger())
}

private abstract class Gun(val range: Int) {
    abstract fun trigger(): String
}

private class AK47(_price: Int) : Gun(range = 100) {
    override fun trigger(): String {
        return "AK47 shooting..."
    }
}
