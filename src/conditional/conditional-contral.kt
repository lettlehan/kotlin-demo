package conditional

fun main() {
    whenMethod(3)
    var res = ifMethod(1)
    println(res)
}

// if
/**
 * 可以把 IF 表达式的结果赋值给一个变量
 */
fun ifMethod(a: Int): String{
    var res: String
    if (a % 2 == 0) {
        println("$a 是偶数")
        res = "偶数"
    }else{
        println("$a 是奇数")
        res = "奇数"
    }
    return res
}

// when
fun whenMethod(a: Int){
    when(a){
        1 -> println("a == 1")
        2 -> println("a == 2")
        in 3..10 -> println("属于 3- 10")
        else -> println(" 不属于 1-10")
    }
}