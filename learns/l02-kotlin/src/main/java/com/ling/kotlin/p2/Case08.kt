package com.ling.kotlin.p2

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 08.函数式编程
 */
fun main() {
    println("1.变换map")
    test01()

    println("2.变换flatMap")
    test02()

    println("3.过滤filter")
    test03()

    println("4.合并zip")
    test04()

    println("5.合并folder")
    test05()

    println("6.序列")
    test06()
}

/**
 * 1.变换map
 */
private fun test01() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals.map {
        "A baby $it"
    }.map {
        "$it, with the cutest little tail ever!"
    }
    println(animals)
    println(babies)

    println(animals.map { it.length })
}

private fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {
    val list = ArrayList<R>()
    for (item in this) {
        list.add(transform(item))
    }
    return list
}

/**
 * 2.变换flatMap
 */
private fun test02() {
    val flatMap = listOf(1, 2, 3).flatMap {
        listOf("$it")
    }
    println("flatMap: $flatMap")
}

private fun <T, R> Iterable<T>.flatMap(transform: (T) -> Iterable<R>): List<R> {
    val list = ArrayList<R>()
    for (item in this) {
        list.addAll(transform(item))
    }
    return list
}

/**
 * 3.过滤filter
 */
private fun test03() {
    val filter = listOf("Jack", "Rose", "Tom").filter {
        it.contains("J")
    }
    println("filter: $filter")

    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }.none { it == 0 }
    }
    println("primes: $primes")
}

private inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    val result = ArrayList<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

/**
 * 4.合并zip
 */
private fun test04() {
    val employees = listOf("Jack", "Rose", "Tom")
    val shirtSize = listOf("large", "x-large", "medium")
    val map = employees.zip(shirtSize).toMap()
    println(map["Jack"])
}

/**
 * 5.合并folder
 */
private fun test05() {
    val folderValue = listOf(1, 2, 3).fold(100) { accumulator, number ->
        println("Accumulated value: $accumulator, number: $number")
        accumulator + (number * 3)
    }
    println("Final value: $folderValue")
}

/**
 * 6.序列
 */
private fun test06() {
    fun Int.isPrime(): Boolean {
        for (item in (2 until this)) {
            if (this % item == 0) {
                return false
            }
        }
        return true
    }

    val result = (1..5000).toList().filter { it.isPrime() }.take(1000)
    println(result.size)

    val take = generateSequence(2) {
        it + 1
    }.filter {
        it.isPrime()
    }.take(1000)
    println(take.toList().size)
}
