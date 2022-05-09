package com.ling.kotlin.p1

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/9
 *    @desc   : 07.字符串
 */
fun main() {
    println("1.substring")
    test01()
    println("2.split")
    test02()
    println("3.replace")
    test03()
    println("4.字符串比较")
    test04()
    println("5.字符串遍历")
    test05()
}

/**
 * 1.substring
 */
private fun test01() {
    val name = "Jimmy's friend"
    val index = name.indexOf('\'')
    println(name.substring(0 until index))
}

/**
 * 2.split
 */
private fun test02() {
    val names = "Jack,Jacky,Jason"
    val nameArray = names.split(',')
    println(nameArray)
    val (origin: String, dest: String, proxy: String) = names.split(',')
    println("解构：$origin $dest $proxy")
}

/**
 * 3.replace
 */
private fun test03() {
    val china = "The people's Republic of China."
    val result = china.replace(Regex("[abc]")) {
        when (it.value) {
            "a" -> "1"
            "b" -> "2"
            "c" -> "3"
            else -> it.value
        }
    }
    println(result)
}

/**
 * 4.字符串比较
 */
private fun test04() {
    val str1 = "Jason"
    val str2 = "jason".replaceFirstChar {
        it.uppercase()
    }
    val str3 = "Jason"
    println("str1 = $str1, str2 = $str2, str3 = $str3")
    println("str1 == str2, result: ${str1 == str2}")
    println("str1 === str2, result: ${str1 === str2}")
    println("str1 === str3, result: ${str1 === str3}")
}

/**
 * 5.字符串遍历
 */
private fun test05() {
    "The people's Republic of China.".forEach {
        print("$it*")
    }
}
