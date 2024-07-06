package loop

fun main() {
    tagReturn()
//    tag()
//    ret()
//    whileMethod()
//    forMethod()
}

// 标签处返回
fun tagReturn(){
    // 直接函数返回
//    (0..4).forEach {
//        if (it == 2)return
//    }

    // 最后一行可以输出，结束 forEach
    (0..4).forEach {
        if (it == 2)return@forEach
    }

    // 用一个匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回
    (0..4).forEach(fun (value: Int){
        if (value == 2)return
    })

    println("tagReturn end")
}

// Break 和 Continue 标签
/**
 * 在 Kotlin 中任何表达式都可以用标签（label）来标记。
 * 标签就是用来跳出循环
 * 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。 要为一个表达式加标签，我们只要在其前加标签即可。
 */
fun tag(){

    var a = 3
    topA@ a= if(a > 3) a else if (a < 5) 4 else 5
    // topA@  标签无法使用到循环内部
    outerLoop@ for (j in 0..4) {
        innerLoop@ for (i in 0..4){
            if (j == 1 && i ==1) break@innerLoop
            if (j == 2 && i ==2) break@outerLoop
            println("j : $j, i : $i")
        }
    }

}



// 返回跳转
/**
 * Kotlin 有三种结构化跳转表达式：
 *  return。默认从最直接包围它的函数或者匿名函数返回。
 *  break。终止最直接包围它的循环。
 *  continue。继续下一次最直接包围它的循环。
 */
fun ret(){
    var arr = arrayOf(1,2,3);
    for (i in arr){
        if (i == 2) return
        println(i)
    }
}

// while 与 do...while
fun whileMethod(){
    var arr = arrayOf(1,2,3)

    var index: Int = 0
    do {
        println(arr[index])
        index++
    }while (index < arr.size)

    index = 0
    while (index < arr.size) {
        arr.reverse()
        println(arr[index])
        index++
    }

}

// for
/**
 * for 循环可以对任何提供迭代器（iterator）的对象进行遍历
 * for (item in collection) print(item)
 */

fun forMethod(){
    var arr = arrayOf(1,2,3);
    for (i in arr) println(i)

    for (i in arr.indices) println("the i is $i, value is ${arr[i]}")
}