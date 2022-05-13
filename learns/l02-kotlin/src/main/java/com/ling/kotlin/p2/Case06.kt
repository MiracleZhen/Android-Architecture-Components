package com.ling.kotlin.p2

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/13
 *    @desc   : 06.泛型
 */
fun main() {
    println("1.定义泛型类")
    test01()

    println("2.泛型函数")
    test02()

    println("3.多泛型函数")
    test03()

    println("4.泛型类型约束")
    test04()

    println("5.vararg关键字与get函数")
    test05()

    println("6.out(协变) | in(逆变) | invariant(不变)")
    test06()

    println("7.reified")
    test07()
}

/**
 * 1.定义泛型类
 */
private fun test01() {
    val box1: MagicBox<Boy> = MagicBox(Boy("Jack", 20))
    val box2: MagicBox<Dog> = MagicBox(Dog(20))
    println("box1: ${box1.subject}, box2: ${box2.subject}")
}

private class MagicBox<T>(item: T) {
    var subject: T = item
}

private class Boy(val name: String, val age: Int)
private class Dog(val weight: Int)

/**
 * 2.泛型函数
 */
private fun test02() {
    println(fetch("Jack"))
    println(fetch(20))
}

private fun <T> fetch(item: T): String {
    return item.toString()
}

/**
 * 3.多泛型函数
 */
private fun test03() {
    println(mr("Rose", 18))
    println(mr("Jack", 20))
}

private fun <T, R> mr(a: T, b: R): String {
    return "a: ${a.toString()}, b: ${b.toString()}"
}

/**
 * 4.泛型类型约束
 */
private fun test04() {
    val box1: MagicBox4<Int> = MagicBox4(10)
    box1.available = true
    println(box1.fetch())
    println(box1.fetch { (it + 1).toString() })
}

private class MagicBox4<T : Number>(item: T) {

    var available = false
    private var subject: T = item

    fun fetch(): T? {
        return subject.takeIf { available }
    }

    fun <R> fetch(function: (T) -> R): R? {
        return function(subject).takeIf { available }
    }
}

/**
 * 5.vararg关键字与get函数
 */
private fun test05() {
    val box = MagicBox5(10.88, 9.98)
    box.available = true
    println(box.fetch(1))
    println(box.fetch(1) { it + 0.01 })

    println(box[1])
}

// vararg关键字与[]操作符取值
private class MagicBox5<T : Number>(vararg item: T) {

    var available = false
    var subject: Array<out T> = item

    fun fetch(index: Int): T? {
        return subject[index].takeIf { available }
    }

    fun <R> fetch(index: Int, function: (T) -> R): R? {
        return function(subject[index]).takeIf { available }
    }

    operator fun get(index: Int): T? = subject[index].takeIf { available }
}

/**
 * 6.out(协变) | in(逆变) | invariant(不变)
 */
private fun test06() {
    val p: Production<String> = object : Production<String> {
        override fun product(): String {
            return "product phone"
        }
    }
    println(p.product())

    val c: Consumer<String> = object : Consumer<String> {
        override fun consume(item: String) {
            println("consume $item")
        }
    }
    c.consume("phone")

    val pc: ProductionConsumer<String> = object : ProductionConsumer<String> {
        override fun product(): String {
            return "product pc"
        }

        override fun consume(item: String) {
            println("consume $item")
        }
    }
    println(pc.product())
    pc.consume("pc")

    // 子类泛型对象可以赋值给父类泛型对象，用out
    val production1: Production<Food> = FoodStore()
    val production2: Production<FastFood> = FastFoodStore()
    val production3: Production<Burger> = BurgerStore()
    println(production1.product())
    println(production2.product())
    println(production3.product())
    // 父类泛型对象可以赋值给子类泛型对象，用in
    val consumer1: Consumer<Burger> = Everybody()
    val consumer2: Consumer<Burger> = ModernPeople()
    val consumer3: Consumer<Burger> = American()
    consumer1.consume(Burger())
    consumer2.consume(Burger())
    consumer3.consume(Burger())
}

// out(协变)
private interface Production<out T> {
    fun product(): T
}

// in(逆变)
private interface Consumer<in T> {
    fun consume(item: T)
}

// invariant(不变)
private interface ProductionConsumer<T> {
    fun product(): T
    fun consume(item: T)
}

/*
 * 为什么使用in&out?
 * -> 父类泛型对象可以赋值给子类泛型对象，用in。
 * -> 子类泛型对象可以赋值给父类泛型对象，用out。
 */
private open class Food()
private open class FastFood : Food()
private class Burger : FastFood()

// 生产者
private class FoodStore : Production<Food> {
    override fun product(): Food {
        return Food()
    }
}

private class FastFoodStore : Production<FastFood> {
    override fun product(): FastFood {
        return FastFood()
    }
}

private class BurgerStore : Production<Burger> {
    override fun product(): Burger {
        return Burger()
    }
}

// 消费者
private class Everybody : Consumer<Food> {
    override fun consume(item: Food) {
        println(item)
    }
}

private class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println(item)
    }
}

private class American : Consumer<Burger> {
    override fun consume(item: Burger) {
        println(item)
    }
}

/**
 * 7.reified
 */
private fun test07() {
    val box = MagicBox7()
    println(box.randomOrBackup { "unknown" })
    println(box.randomOrBackup { 0 })
}

private class MagicBox7 {
    inline fun <reified T> randomOrBackup(backup: () -> T): T {
        val list = listOf("Jack", "Rose")
        val random = list.shuffled().first()
        return if (random is T) {
            random
        } else {
            backup()
        }
    }
}
