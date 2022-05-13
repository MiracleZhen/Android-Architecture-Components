package com.ling.kotlin.p2

import kotlin.math.absoluteValue

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 2.初始化
 */
fun main() {
    println("1.主构造函数")
    val player0201 = Player0201("Jack", 20, true)
    println("name: ${player0201.name}, age: ${player0201.age}, isNormal: ${player0201.isNormal}")

    println("2.在主构造函数里定义属性")
    val player0202 = Player0202("Rose", 18, true)
    println("name: ${player0202.name}, age: ${player0202.age}, isNormal: ${player0202.isNormal}")

    println("3.次构造函数")
    val player02031 = Player0203("Jack", 20)
    println("name: ${player02031.name}, age: ${player02031.age}, isNormal: ${player02031.isNormal}")
    val player02032 = Player0203("Rose")
    println("name: ${player02032.name}, age: ${player02032.age}, isNormal: ${player02032.isNormal}")

    println("4.默认参数")
    val player0204 = Player0204(name = "Jack", isNormal = true)
    println("name: ${player0204.name}, age: ${player0204.age}, isNormal: ${player0204.isNormal}")

    println("5.初始化块")
    val player0205 = Player0205("Jack", 20, true)
    println(player0205)

    println("6.初始化顺序")
    println(Player0206("Rose"))

    println("7.延迟初始化 lateinit")
    val player0207 = Player0207()
    player0207.ready()
    player0207.battle()

    println("8.惰性初始化 by lazy")
    val player0208 = Player0208()
    println(player0208.config)
    println(player0208.config)

    println("9.初始化陷阱")
    test09()
}

/**
 * 1.主构造函数
 */
private class Player0201(_name: String, _age: Int, _isNormal: Boolean) {
    var name = _name
        get() = field.uppercase()
        set(value) {
            field = value.trim()
        }
    var age = _age
        get() = field.absoluteValue
        set(value) {
            field = value.absoluteValue
        }
    var isNormal = _isNormal
}

/**
 * 2.在主构造函数里定义属性
 */
private class Player0202(_name: String, var age: Int, var isNormal: Boolean) {
    var name = _name
        get() = field.uppercase()
        set(value) {
            field = value.trim()
        }
}

/**
 * 3.次构造函数
 */
private class Player0203(var name: String, var age: Int, var isNormal: Boolean) {

    constructor(name: String, age: Int) : this(name, age, true) {
        this.name = name.uppercase()
        this.age = age.absoluteValue
    }

    constructor(name: String) : this(name, 18, true) {
        this.name = name.uppercase()
    }
}

/**
 * 4.默认参数
 */
private class Player0204(var name: String, var age: Int = 18, var isNormal: Boolean)

/**
 * 5.初始化块
 */
private class Player0205(var name: String, var age: Int = 18, var isNormal: Boolean) {

    init {
        require(age > 0) { "age must be positive." }
        require(name.isNotBlank()) { "player must have a name." }
    }
}

/**
 * 6.初始化顺序
 */
private class Player0206(_name: String, _age: Int) {
    var name = _name
    var score = 0
    var subject: String

    init {
        println("initializing")
        subject = "math"
    }

    constructor(_name: String) : this(_name, 18) {
        score = 80
    }
}

/**
 * 7.延迟初始化 lateinit
 */
private class Player0207 {

    lateinit var equipment: String

    fun ready() {
        equipment = "sharp knife"
    }

    fun battle() {
        if (::equipment.isInitialized) {
            println(equipment)
        } else {
            println("lateinit property equipment has not been initialized")
        }
    }
}

/**
 * 8.惰性初始化 by lazy
 */
private class Player0208 {

    val config by lazy { loadConfig() }

    private fun loadConfig(): String {
        println("loading...")
        return "config info"
    }
}

/**
 * 9.初始化陷阱
 */
private fun test09() {
    println(Player020901())
    println(Player020902())
    println(Player020903("Jack"))
}

// 初始化陷阱一
private class Player020901 {

    init {
        // 初始化顺序
        //val bloodBonus = blood.times(4)
    }

    val blood = 100
}

// 初始化陷阱二
private class Player020902 {
    val name: String

    private fun firstLetter() = name[0]

    init {
        println(firstLetter())
        name = "Jack"
    }
}

// 初始化陷阱三
private class Player020903(_name: String) {
    val playerName = initPlayerName()
    val name: String = _name

    private fun initPlayerName() = name
}
