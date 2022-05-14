package com.ling.kotlin.p2

import java.io.File

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 04.对象
 */
fun main() {
    println("1.object关键字")
    test01()

    println("2.嵌套类")
    Nest.Equipment("AK47").show()
    Nest().battle()

    println("3.数据类")
    val coordinate = Coordinate(10, 20)
    println(coordinate)
    println(coordinate.isInBounds)

    val s = Student("Jack")
    val copy = s.copy(name = "Rose")
    println(copy)

    val (exp, level) = PlayerScore(10, 20)
    println("experience: $exp, level: $level")
    val (x, y) = Coordinate(10, 20)
    println("x: $x, y: $y")

    val c1 = Coordinate2(5, 6)
    val c2 = Coordinate2(10, 20)
    println(c1 + c2)

    println("4.枚举类")
    println("东 -> ${Direction.EAST}, 西 -> ${Direction.WEST}, 南 -> ${Direction.SOUTH}, 北 -> ${Direction.NORTH}")

    println(Direction2.EAST.updateCoordinate(Coordinate(10, 20)))

    println(Driver(LicenseStatus.LEARNING).checkLicense())

    println("5.密封类")
    println(Driver2(LicenseStatus2.Qualified("00001")).checkLicense())
}

/**
 * 1.object关键字
 */
private fun test01() {
    // 对象声明
    ApplicationConfig.setSomething()
    println(ApplicationConfig)
    println(ApplicationConfig)

    // 对象表达式
    val player = object : Player() {
        override fun load(): String {
            return "anonymous class load.."
        }
    }
    println(player.load())

    // 伴生对象
    println(ConfigMap.load())
}

// 对象声明
private object ApplicationConfig {

    init {
        println("loading config...")
    }

    fun setSomething() {
        println("setSomething")
    }
}

// 对象表达式
private open class Player {
    open fun load() = "loading nothing."
}

// 伴生对象
private class ConfigMap {

    companion object {
        private const val PATH = "XXX"
        fun load() = File(PATH).exists()
    }
}

/**
 * 2.嵌套类
 */
private class Nest {

    class Equipment(var name: String) {
        fun show() = println("equipment: $name")
    }

    fun battle() {
        Equipment("sharp knife").show()
    }
}

/**
 * 3.数据类
 */
private data class Coordinate(var x: Int, var y: Int) {
    val isInBounds = x >= 0 && y >= 0
}

// copy
private data class Student(var name: String, val age: Int) {
    var score = 10
    private val hobby = "music"
    private val subject: String

    init {
        println("initializing student")
        subject = "math"
    }

    constructor(_name: String) : this(_name, 10) {
        score = 20
    }

    override fun toString(): String {
        return "Student(name='$name', age='$age', score='$score', hobby='$hobby', subject='$subject')"
    }
}

// 解构声明
private class PlayerScore(val experience: Int, val level: Int) {

    operator fun component1() = experience

    operator fun component2() = level
}

// 运算符重载
private data class Coordinate2(var x: Int, var y: Int) {

    val isInBounds = x >= 0 && y >= 0

    operator fun plus(other: Coordinate2) = Coordinate2(x + other.x, y + other.y)
}

/**
 * 4.枚举类
 */
private enum class Direction {
    EAST, WEST, SOUTH, NORTH;
}

private enum class Direction2(private val coordinate: Coordinate) {
    EAST(Coordinate(5, -1)),
    WEST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    NORTH(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
}

private enum class LicenseStatus {
    UNQUALIFIED,
    LEARNING,
    QUALIFIED
}

private class Driver(var status: LicenseStatus) {
    fun checkLicense(): String {
        return when (status) {
            LicenseStatus.UNQUALIFIED -> "没资格"
            LicenseStatus.LEARNING -> "在学"
            LicenseStatus.QUALIFIED -> "有资格"
        }
    }
}

/**
 * 5.密封类
 */
private sealed class LicenseStatus2 {
    object UnQualified : LicenseStatus2()
    object Learning : LicenseStatus2()
    class Qualified(val licenseId: String) : LicenseStatus2()
}

private class Driver2(var status: LicenseStatus2) {
    fun checkLicense(): String {
        return when (status) {
            is LicenseStatus2.UnQualified -> "没资格"
            is LicenseStatus2.Learning -> "在学"
            is LicenseStatus2.Qualified -> {
                "有资格，驾驶证编号：${(this.status as LicenseStatus2.Qualified).licenseId}"
            }
        }
    }
}
