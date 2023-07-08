package ex11

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(){
    // run , 지역 scope

    val userDto = UserDto("").run {
        name = "홍길동"
        "empty"
    }

    println("result $userDto")

    val x = 10

    val sum = run {
        val x = 2
        val y = 3
        x + y
    }

    println(sum)

    val now: LocalDateTime? = null

    val n = now?.let { it }?: LocalDateTime.now()

    val d = now?.let {
        val minusTime = it.minusDays(1)
        minusTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    }?: run {
        val now = LocalDateTime.now()
        val minusTime = now.minusDays(1)
        minusTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    }

    println("result $d")
}