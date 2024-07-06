package ext

fun main() {
    User().play()
}

fun User.play(){
    println("pay piano")
}

class User{
    fun say(){
        println("hello")
    }
}