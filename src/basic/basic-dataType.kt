package basic

fun main() {
//    string()
//    array()
//    char('1')
//    bitOperation()
//    typeConversion()
    compareNum()
}

// 字符串
/**
 * 和 Java 一样，String 是不可变的。方括号 [] 语法可以很方便的获取字符串中的某个字符，
 * 也可以通过 for 循环来遍历：
 */
fun string(){
    var str = "hello world";
    println(str[0])
    println(str.substring(0,5))

    for (i in str) {
        print(i)
    }
}

// 数组
/**
 * 数组用类 Array 实现
 * 创建数组两种方式：
 *  arrayOf();
 *  工厂函数
 *
 *  注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。
 *
 */
fun array(){
    // arrayOf 创建 [1,2,3,4]
    var arr = arrayOf(1, 2, 3, 4)
    println(arr.get(0))

    // 工厂方法创建 [0,2,4]
    var  arr1 = Array(3, {i -> i * 2})
    println(arr1[2])

    var arrL = longArrayOf(1,2,3)
}

// 布尔
/**
 * 布尔用 Boolean 类型表示，它有两个值：true 和 false。
 * 若需要可空引用布尔会被装箱。
 *
 * || – 短路逻辑或
 * && – 短路逻辑与
 * ! - 逻辑非
 */

// 字符
/**
 * Kotlin 中的 Char 不能直接和数字操作。
 * Char 必须是单引号 ' 包含起来
 * 特殊字符可以使用反斜杠转义，如 ：\t、 \b、\n、\r、\'、\"、\\ 和 \$
 */
fun char(c: Char){
    println(c)
}

// 位操作
/**
 * 对于 Int 和 Long 类型，还有一系列位操作符可以使用
 * shl(bits) – 左移位 (Java’s <<)
 * shr(bits) – 右移位 (Java’s >>)
 * ushr(bits) – 无符号右移位 (Java’s >>>)
 * and(bits) – 与
 * or(bits) – 或
 * xor(bits) – 异或
 * inv() – 反向
 */
fun bitOperation() {
    var a: Int = 2
    var b: Int = 1

    println("$a 左移 $b 位：" + a.shl(b))
    println("$a 右移 $b 位：" +a.shr(b))
    println("$a 无符号右移 $b 位：" +a.ushr(b))
    println("$a 与 $b ：" +a.and(b))
    println("$a 或 $b ：" +a.or(b))
    println("$a 异或 $b ：" +a.xor(b))
    println("$a 反向 ：" +a.inv())
}

// 类型转换
/**
 * 由于不同的表示方式，较小类型不是较大类型的子类型，较小类型不能隐式转为较大类型。
 */
fun typeConversion() {
    var a: Byte = 1;
    // 下面代码会报错
//    var b: Int = a
    var b: Int = a.toInt()
    println(b)
    /**
     * 每种数据类型都有对应的方法转为其他类型
     * toByte(): Byte
     * toShort(): Short
     * toInt(): Int
     * toLong(): Long
     * toFloat(): Float
     * toDouble(): Double
     * toChar(): Char
     */

    // 如下情况也可以自动转化，前提是根据上下问环境推断出正确的数据类型且数学操作符会做相应重载
    var c = 1L + 3
    println(c)
}

// 比较两个数字
/**
 * Kotlin 中没有基础数据类型，只有分装的数字类型，你每定义的一个变量，其实 Kotlin
 * 帮你封装了一个对象，这样可以保证不会出现空指针。数字类型也一样，所以在比较两个数字的时候，
 * 就有比较数据大小和比较两个对象是否相同的区别了。
 * 在 Kotlin 中三个等号 === 表示比较对象地址，两个 == 两个值大小
 */
fun compareNum() {
    var a: Int = 999
    println(a === a) // true

    var boxedA: Int? = a
    var anotherBoxedA: Int? = a
    println(boxedA == anotherBoxedA) // true
    println(boxedA === anotherBoxedA) // false

    println("========== c ========")
    var c: Int = 999

    var boxedC: Int = c
    var anotherBoxedC: Int = c
    // 下面两个都是 true
    println(boxedC === anotherBoxedC) // true
    println(boxedC == anotherBoxedC) // true

    println("========= d =========")
    var d: Int? = 999

    var boxedD: Int? = d
    var anotherBoxedD: Int? = d
    // 下面两个都是 true
    println(boxedD === anotherBoxedD) // true
    println(boxedD == anotherBoxedD) // true

    /**
     * var c: Int = 999 这种方式 c 就是个数值，不涉及装箱问题，也就是不是个对象
     * var d: Int? = 999 这种方式 d 是一个 Int 类型对象，涉及装箱问题
     * 块 a  boxedA === anotherBoxedA 比较的是两个对象为 false
     * 块 c 所有变量都是数值 所以为 true
     * 块 d 所有变量都是同一个对象 所以为 true
     */

    println("=========== b =========")
    var b: Int = 120

    var boxedB: Int? = b
    var anotherBoxedB: Int? = b
    // 下面两个都是 true
    println(boxedB === anotherBoxedB) // true
    println(boxedB == anotherBoxedB) // true

    println("========= e ==========")
    var e: Int = 128

    var boxedE: Int? = e
    var anotherBoxedE: Int? = e
    println(boxedE === anotherBoxedE) // false
    println(boxedE == anotherBoxedE) // true

    /**
     * 块 b 和 e 不同原因，类似 java 装箱拆箱 IntegerCache
     */

}

/**
 * Kotlin 的基本数值类型包括
 * Byte 8、Short 16、Int 32、Long 64、Float 32、Double 64 等。
 * 不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型。
 */

fun declareData() {
    // 十进制
    var int = 123
    // 长整型
    var long = 12L
    // 16 进制
    var hexadecimal = 0x122;
    // 2 进制
    var binary = 0b1010101
    // 8 进制不支持

    // Double 默认写法： 123.9，123.7e10
    var double = 123.45
    // Float 使用 f 或者 F 后缀
    var float = 123.3f

    // 使用下划线使数字常量更易读
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L

}