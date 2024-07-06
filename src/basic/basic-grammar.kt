package basic

// Int 参数， 返回值 Int
fun sum(a: Int, b: Int): Int{
    return a + b
}
// 表达式作为函数体，返回类型自动推断
fun add(a: Int, b: Int) = a + b

// public 方法必须明确返回类型
public fun add01(a: Int, b: Int): Int = a + b
// 无返回值的函数类似 Java 中的 void()
fun sumPrintln(a: Int, b: Int): Unit {
    println(a + b)
}

// 如果返回是 Unit 类型，则可以省略（也适用于 public 方法）
public fun printSum(a: Int, b: Int) {
    print(a + b)
}

// 可变参数 vararg 表示
fun vars(vararg args: Int) {
    for (v in args) {
        println("vararg: " + v)
    }
}

// 定义常量与变量
/**
 * 可变变量定义： var 关键字
 * var <标识符>： <类型> = <初始化值>
 *
 * 不可变变量定义： val 关键字，只能赋值一次变量（类似java 中的 final）
 *
 * 常量与变量都可以没有初始化值，但在引用前必须初始化
 * 编译器支持自定类型判断，即声明时可以不指定类型，由编译器判断
 */
fun declareParams() {
    var a: Int;
    a = 1;
    var variableParam = 1;
//  可变变量在第一次声明时已经确定类型，后续改变类型赋值会报错
//    variableParam = "helle world";
    variableParam = 13;
    println(variableParam)
    val finalParam = "hello world"
}

// 注释
// 单行注释
/*
   多行
 */
/**
 * 快
 */


// 字符串模板
/**
 * $ 表示一个变量名或一个变量值
 * $varName 表示变量值
 * ${varName.fun()} 表示变量的方法返回值
 */
fun strModel() {
    var a = " kotlin";

    println("say hello to $a: ${strFun(a)}")
}

fun strFun(str: String): String {
    return "hello" + str;
}

// NULL 检查机制
/**
 * kotlin 的空安全设计对于生命可为空的参数，在使用时要进行空判断处理，有两种处理方式
 * 字段后加 !! 像 Java 一样抛出空异常，另一种字段后加 ？ 可以不做处理返回值为 null
 * 或配合 ？ 做空判断处理
 */
fun nullCheck(){
    // 类型后面加 ？ 表示可为空
    var age: String? = null
    // 不做处理返回 null
    val toInt = age?.toInt()
    println("为空不做处理返回 null : " + toInt)
    // age 为空返回 -1
    var i = age?.toInt() ?: -1
    println("为空返回 -1: " + i)
    // 抛出空异常
    val ages = age!!.toInt();
    println("为空抛出空异常" + ages)
}

/**
 * 当一个引用有可能为 null 值时，对应的类型生命必须明确地标记为 null
 */
fun parseInt(str: String): String? {
    return null
}
// 类型检测及自动类型转换
/**
 * 我们可以使用 is 运算符检测一个表达式是否耨类型的一个实例类似 Java 中的 instanced 关键字
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj 会被系统自动转为 String 类型
        return obj.length
    }
    // 在这里还有一种写法，与 Java 中的 instances 不同，是以哦那个 !is
    if (obj !is String) {
        // xxx
    }
    return null
}
fun getStringLength01(obj: Any): Int? {
    if (obj !is String)
        return null
    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
    return obj.length
}
fun getStringLength02(obj: Any): Int? {
    // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
    if (obj is String && obj.length > 0)
        return obj.length
    return null
}

// 区间
/**
 * 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 或 ！in 形成
 * 区间是为任何比较类型定义的，但对于整型原生类型，它有一个优化的实现。
 */
fun range(){
    // 输出 1234
    for (i in 1..4) print(i)

    println("+++++++++++++")
    // 什么都不输出
    for (i in 4..1) println(i)

    println("+++++++++++++")
    var i = 8
    // 等同于 1<= i && i <= 10
    if (i in 1..10){
        println(i)
    }

    println("+++++++++++++")
    // 使用 step 指定步长
    // 输出 13
    for (i in 1..4 step 2) print(i)

    println("+++++++++++++")
    // 输出 42
    for (i in 4 downTo 1 step 2) print(i)

    println("+++++++++++++")
    // 使用 until 函数排除结束元素
    // 输出 1-9
    for (i in 1 until 10) print(i)
}



fun main() {
    range()
//    println("Hello World!")
//    println("add: " + add(1, 2))
//    println("public add01： " + add01(2, 2))
//    println("sumPrintln： " + add01(2, 2))
//    vars(1, 2, 3, 4, 5, 6)

    // 匿名函数 lambda
//    var sumLambda: (Int, Int) -> Int = { x, y -> x + y }
//    println("sumLambda: " + sumLambda(12, 2))

//    strModel()

//    nullCheck()
//    getStringLength(12)
}