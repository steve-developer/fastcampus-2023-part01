package ex06

fun main(){
    val dog = Dog("해피")

    println(dog.age)

    dog.age = 20

    println(dog.age)

    dog.eat()
    dog.bark()
}

interface Bark{
    fun bark()
}

interface Temp{
    fun hi()
}

abstract class Animal(
    private val name: String?="",
): Bark {
    // body
    fun eat(){
        println("$name 식사시작 합니다.")
    }
}

class Dog(
    private val name:String?=null,
) : Animal(name), Temp {

    var age: Int?=0

    override fun bark() {
        println("$name : 멍멍")
    }

    override fun hi() {
        println("hi")
    }

}