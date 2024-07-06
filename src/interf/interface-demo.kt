package interf

fun main() {

}

// 接口属性
/**
 * 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
 */
class FieldImpl01 : Field{
    override var name: String = "haha"
}
class FieldImpl(override var name: String) : Field{

}
interface Field{
    var name: String
}

// 接口实现
class Child: MyInterface{
    override fun a() {
        TODO("Not yet implemented")
        println("Child implement")
    }

    // 可以选择实现
    override fun b() {
        super.b()
    }

}

// 接口
/**
 * Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
 */
interface MyInterface{
    fun a()
    fun b(){
        println("default implement")
    }
}