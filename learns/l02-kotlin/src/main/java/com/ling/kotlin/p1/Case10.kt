package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/9
 *    @desc   : 10.集合
 */
fun main() {
    println("1.数组")
    test01()
    println("2.List")
    test02()
    println("3.Set")
    test03()
    println("4.Map")
    test04()
}

/**
 * 1.数组
 */
private fun test01() {
    println(intArrayOf(1, 2, 3))
    println(arrayOf("Java", "Kotlin", "Scala", "Groovy"))
}

/**
 * 2.List
 */
private fun test02() {
    // 1.List创建与元素获取
    val list1 = listOf("Java", "Kotlin", "Scala", "Groovy")
    println(list1[0])
    println(list1.getOrElse(4) { "Unknown" })
    println(list1.getOrNull(4))
    println(list1.getOrNull(4) ?: "Unknown")

    // 2.可变List集合
    val list2 = mutableListOf("Java", "Kotlin", "Scala", "Groovy")
    list2.add("C++")
    list2.remove("Java")
    println(list2)

    println(listOf("Java", "Kotlin").toMutableList())
    println(mutableListOf("Java", "Kotlin").toList())

    // 3.mutator函数
    val list3 = mutableListOf("Java", "Kotlin", "Scala", "Groovy")
    list3 += "C#"
    println(list3)
    list3 -= "Scala"
    println(list3)

    list3.removeIf { it.contains("K") }
    println(list3)

    // 4.List集合遍历
    val list4 = listOf("Java", "Kotlin", "Scala", "Groovy")
    for (item in list4) {
        println(item)
    }
    list4.forEach {
        println(it)
    }
    list4.forEachIndexed { index, item ->
        println("$index, $item")
    }

    // 5.解构语法过滤元素
    val list5 = listOf("Java", "Kotlin", "Scala", "Groovy")
    val (origin, _, _, proxy) = list5
    println("origin = $origin, proxy = $proxy")
}

/**
 * 3.Set
 */
private fun test03() {
    // 1.Set创建与元素获取
    val set1 = setOf("Java", "Kotlin", "Scala", "Groovy")
    println(set1.elementAt(1))
    println(set1.elementAtOrElse(4) { "Unknown" })
    println(set1.elementAtOrNull(4))

    // 2.可变Set集合
    val set2 = mutableSetOf("Java", "Kotlin", "Scala")
    set2 += "Groovy"
    println(set2)

    // 3.集合转换与快捷函数
    val list = listOf("Java", "Kotlin", "Scala", "Groovy", "Java")
        .toSet()
        .toList()
    println(list)
    println(listOf("Java", "Kotlin", "Scala", "Groovy", "Java").distinct())
}

/**
 * 4.Map
 */
private fun test04() {
    // 1.Map创建
    val map1 = mapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)
    println(map1)
    println(mapOf(Pair("Jack", 20), Pair("Jason", 18)))

    // 2.读取Map的值
    val map2 = mapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)
    println(map2["Jack"])
    println(map2.getValue("Jack"))
    println(map2.getOrElse("Rose") { "unknown" })
    println(map2.getOrDefault("Rose", 0))

    // 3.遍历Map
    val map3 = mapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)
    map3.forEach {
        println("${it.key}, ${it.value}")
    }
    map3.forEach { (key, value) ->
        println("$key, $value")
    }

    // 4.可变Map
    val map4 = mutableMapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)
    map4 += "Jimmy" to 30
    map4["Jimmy"] = 31

    println(map4.getOrPut("Jimmy") { 18 })
    map4.getOrPut("Rose") { 18 }
    println(map4)
}
