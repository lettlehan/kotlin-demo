package extend

fun main() {
//    C().f()
//    Monkey().eat()
//    var sec = Sec(20)
}

// 重写
/**
 * 你可以用一个var属性重写一个val属性，但是反过来不行。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法
 *
 * 你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
 */
interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
    override var count: Int = 0
}

// 如果有多个相同的方法（继承或者实现自其他类，如A、B类），则必须要重写该方法，使用super范型去选择性地调用父类的实现。
open class A {
    open fun f () { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } //接口的成员变量默认是 open 的
    fun b() { print("b") }
}

class C() : A() , B{
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

// 重写
/**
 * 在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
 * 如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词：
 */
class Monkey: Animal(){
    override fun eat() {
        println("吃香蕉")
    }
}

open class Animal{
    open fun eat(){
        println("吃所有东西")
    }
}

// 构造函数
/**
 * 子类有主构造函数
 * 如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
 * 如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，
 * 或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
 */
class Teacher: Person {

    // 使用 super 关键字初始化基类
    constructor(name: String, age: Int) : super(name, age) {

    }

    // 使用 this 关键字通过代理实现基类
    constructor(name: String, age: Int, className: String): this(name, age){

    }

}
// 如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
class Student(name : String, age : Int, var no : String, var score : Int) : Person(name, age) {

}

open class Person(var name : String, var age : Int){// 基类

}

// 继承示例
/**
 * Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类：
 * 如果一个类要被继承，可以使用 open 关键字进行修饰。
 */
class Sec(age: Int): Base(age){

}

// open 关键字标识此类可以被继承
open class Base(age: Int) {

}

