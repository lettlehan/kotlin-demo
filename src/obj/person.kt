package obj

fun main() {
    var test = Test()
    test.setTestInterface(object : TestInterface{
        override fun test(){
            println("对象表达式创建匿名内部类的实例")
        }
    })
//    var nunM = Outer().Inner().nunM()
//    println(nunM)
//    Outer().Inner().testOuter()

//    animal.pig().say()

//    Hi("haha")

//    var hello = Hello("jack", 12, "man")
//    println(hello.appendUserName(hello.userName))

//    var teacher = Teacher("jack", 30)

//    var demo = Demo()
//    println(demo.name)

//    var person = person()
//    person.firstName = "tom"
//    println("firstName: ${person.firstName}")
//    person.no = 9
//    println("no:${person.no}")
//    person.no = 20
//    println("no:${person.no}")


//    var age = student("tom").age
//    println(age)
}

// 匿名内部类
class Test{
    fun setTestInterface(testInterface: TestInterface){
        testInterface.test()
    }
}

interface TestInterface{
    fun test()
}



// 内部类
/**
 * 内部类使用 inner 关键字来表示。
 * 内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
 */
class Outer{
    private var num: Int = 1
    var v = "成员属性"

    /**
     * 嵌套内部类
     */
    inner class Inner{
        // 访问外部类成员
        fun nunM() = num

        fun testOuter(){
            var outer = this@Outer
            println("内部类可以引用外部类的成员，例如：" + outer.v)
        }

    }
}

// 嵌套类
class animal{
    var name: String = "animal"

    class pig{
        fun say(){
            println("heng heng")
        }
    }
}

// 抽象类
abstract class Base{
    abstract var param: String
    var name: String = "abstract"
    abstract fun method01()

    fun printHaHa(){
        println("haha")
    }
}

class Say(override var param: String) : Base() {
    override fun method01() {
        TODO("Not yet implemented")
        print("Say implement")
    }
// 'printHaHa' in 'Base' is final and cannot be overridden
//    override fun printHaHa(){
//        println("haha")
//    }

}


// 私有无参构造，只能通过有参构造创建对象
class Hi private constructor(){
    constructor(userName: String): this(){
        println("sec constructor execute")
    }
    init {
        println("Hi init")
    }
}

// 次构造函数
//类也可以有二级构造函数，需要加前缀 constructor:
// 如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。
// 在同一个类中代理另一个构造函数使用 this 关键字：
class Hello(var userName: String) {
    // 直接代理主构造函数
    constructor(userName: String, age: Int): this(userName){
        println("sub constructor execute userName: $userName, age: $age")
    }
    // 间接代理主构造函数
    constructor(userName: String, age: Int, gender: String):this(userName, age){
        println("sub constructor agency execute userName: $userName, age: $age, gender : $gender")
    }
    init {
        println("init execute username: $userName")
    }

    fun appendUserName(userName: String): String{
        return "hi " + userName
    }
}

// 主构造器
/**
 * 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
 * 注意：主构造器的参数可以在初始化代码段中使用，也可以在类主体n定义的属性初始化代码中使用。
 * 一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）：
 */
class Teacher (userName: String, var age: Int) {
    init {
        println("init execute userName : $userName, age: $age")
    }
}

/**
 * 如果构造器有注解，或者有可见度修饰符，这时constructor关键字是必须的，注解和修饰符要放在它之前。
 */


// 延迟初始化
class Demo {
    lateinit var name: String;
    init {
        name = "tom"
    }
}

/**
 * 以下实例定义了一个 Person 类，包含两个可变变量 lastName 和 no，lastName 修改了 getter 方法，no 修改了 setter 方法。
 * Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制,备用字段使用field关键字声明,field 关键词只能用于属性的访问器
 */
class Person {
    var firstName: String = "nice"
        get() = field.reversed()
        set

    var no: Int = 100
        get() = field   // 后端变量
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = 1
            }
        }

    var heint: Float = 13.46f
        private set
}

// 含有主构造器的类
/**
 * Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
 * 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
 */

class student(userName: String) {
    var age: Int = 18

}

class user constructor(userName: String) {

}

// 声明类
class person {

}