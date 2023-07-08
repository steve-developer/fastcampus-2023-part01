package ex07

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(){

    val user = User()
    user.name = "홍길동"
    user.age = 10
    user.email = "gmail"
    
    val user2 = user.copy(name = "이순신") // named arguments

    val user3 = User(
        name = null,
        age = null,
        email = null
    )

    println(user)
    println(user2)
}
