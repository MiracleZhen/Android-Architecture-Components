// 使用@JvmName注解指定编译类的名字
@file:JvmName("Hero")

package com.ling.kotlin.p2

import java.io.IOException
import kotlin.jvm.Throws

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 09.Kotlin与Java互操作
 */
fun main() {
    println("1.互操作性与可空性")
    test01()

    println("2.类型映射")
    test02()

    println("3.属性访问")
    test03()
}

/**
 * 1.互操作性与可空性
 */
private fun test01() {
    val case10 = Case10()
    println(case10.utterGreeting())
    val level = case10.determineFriendshipLevel()
    println(level?.uppercase())
}

/**
 * 2.类型映射
 */
private fun test02() {
    println(1.javaClass)
    println("".javaClass)
    println(true.javaClass)
}

/**
 * 3.属性访问
 */
private fun test03() {
    val case10 = Case10()
    case10.name = "hello"
    println(case10.name)
}

/**
 * 4.@JvmName
 */
fun testJvmName() {
    println("@file:JvmName(\"Hero\")")
}

/**
 * 5.@JvmField
 */
class TestJvmField {

    @JvmField
    val spells = listOf("Magic Ms. L", "Lay on Hans")
}

/**
 * 6.@JvmOverloads
 */
@JvmOverloads
fun testJvmOverloads(leftHand: String = "berries", rightHand: String = "beef") {
    println("Mmmm... you hand over some delicious $leftHand and $rightHand")
}

/**
 * 7.@JvmStatic
 */
class SpellBook {
    companion object {
        @JvmField
        val MAX = 100
        @JvmStatic
        fun getSpellBook() = println("I am the Great Grimoire! $MAX")
    }
}

/**
 * 8.@Throws
 */
@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}

/**
 * 9.函数类型操作
 */
val translator = { utterance: String ->
    println(utterance.lowercase())
}

val upper = { name: String, age: Int ->
    println("name = $name, age = $age")
}
