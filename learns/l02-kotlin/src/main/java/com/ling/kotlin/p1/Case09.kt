package com.ling.kotlin.p1

import java.io.File

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/9
 *    @desc   : 09.标准库函数
 */
fun main() {
    println("1.apply")
    test01()
    println("2.let")
    test02()
    println("3.run")
    test03()
    println("4.with")
    test04()
    println("5.also")
    test05()
    println("6.takeIf")
    test06()
    println("7.takeUnless")
    test07()
}

/**
 * 1.apply
 */
private fun test01() {
    // 配置一个File实例
    val file1 = File("E://i have a dream_copy.txt")
    file1.setReadable(true)
    file1.setWritable(true)
    file1.setExecutable(false)
    // 使用apply
    val file2 = File("E://i have a dream_copy.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
        println("this: $this")
    }
    println("file1: $file1")
    println("file2: $file2")
}

/**
 * 2.let
 */
private fun test02() {
    // 求集合里第一个数的平方值
    val result1 = listOf(3, 2, 1).first().let {
        println("it: $it")
        it * it
    }
    println(result1)
    // 如果不用let函数，你需要把第一个数赋给一个变量
    val firstElement = listOf(3, 2, 1).first()
    val result2 = firstElement * firstElement
    println(result2)

    println(formatGreeting1("miracle"))
    println(formatGreeting1(null))
    println(formatGreeting2("jason"))
    println(formatGreeting2(null))
}

// 使用let
private fun formatGreeting1(guestName: String?): String {
    return guestName?.let {
        "Welcome, $it"
    } ?: "What's your name?"
}

// 不实用let
private fun formatGreeting2(guestName: String?): String {
    return if (guestName != null) {
        "Welcome, $guestName"
    } else {
        "What's your name?"
    }
}

/**
 * 3.run
 */
private fun test03() {
    // 查看某个文件是否包含某一个字符串
    val file = File("E://i have a dream_copy.txt")
    val result = file.run {
        // readText().contains("great")
        exists()
    }
    println(result)

    "The people's Republic of China."
        .run(::isLong)
        .run(::showMessage)
        .run(::println)
}

private fun isLong(name: String) = name.length >= 10

private fun showMessage(isLong: Boolean): String {
    return if (isLong) {
        "Name is too long"
    } else {
        "Please rename."
    }
}

/**
 * 4.with
 */
private fun test04() {
    val isTooLong = with("The people's Republic of China.") {
        length >= 10
    }
    println("too long $isTooLong")
}

/**
 * 5.also
 */
private fun test05() {
    // 没有初始化
    var fileContents: List<String>?
    File("E://i have a dream_copy.txt").also {
        println(it.name)
    }.also {
        // 初始化
        fileContents = if (it.exists()) it.readLines() else null
    }
    println(fileContents)
}

/**
 * 6.takeIf
 */
private fun test06() {
    val fileContents1 = File("E://i have a dream_copy.txt").takeIf {
        it.exists() && it.canRead() && it.canWrite()
    }?.readText()
    println(fileContents1)

    // 不用takeIf函数
    val file = File("E://i have a dream_copy.txt")
    val fileContents2 = if (file.exists() && file.canRead() && file.canWrite()) {
        file.readText()
    } else {
        null
    }
    println(fileContents2)
}

/**
 * 7.takeUnless
 */
private fun test07() {
    val fileContents = File("E://i have a dream_copy.txt").takeUnless {
        !it.exists() && !it.isHidden
    }?.readText()
    println(fileContents)
}
