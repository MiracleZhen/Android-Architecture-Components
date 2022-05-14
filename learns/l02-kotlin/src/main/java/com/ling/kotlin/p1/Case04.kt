package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/8
 *    @desc   : 04.函数
 */
fun main() {
    println("1.函数头")
    test01()
    println("2.函数参数")
    test02()
    println("3.Unit函数")
    test03()
    println("4.Nothing函数")
    test04()
    println("5.反引号中的函数名")
    test05()
}

/**
 * 4.1 函数头
 */
private fun test01() {
    println(doSomething(18, true))
    println(doSomething(20, false))
}

private fun doSomething(age: Int, flag: Boolean): String {
    return "age = $age, flag = $flag"
}

/**
 * 4.2 函数参数
 */
private fun test02() {
    fix("Jack")
    fix(age = 18, name = "Rose")
}

private fun fix(name: String, age: Int = 0) {
    println("name = $name, age = $age")
}

/**
 * 4.3 Unit函数
 */
private fun test03() {
    max()
}

private fun max(): Unit {
    println("Unit函数")
}

/**
 * 4.4 Nothing函数
 */
private fun test04() {
    nothing()
}

private fun nothing(i: Int = 1) {
    if (i > 1) {
        println(i)
    } else {
        TODO("argument($i) is too small.")
    }
}

/**
 * 4.5 反引号中的函数名
 */
private fun test05() {
    `is`()
}

private fun `is`() {
    println("反引号中的函数名")
}
