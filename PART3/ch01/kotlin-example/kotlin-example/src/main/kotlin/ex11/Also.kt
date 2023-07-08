package ex11

fun main(){
    // also / 또한

    val userDto = UserDto(
        name = "홍길동"
    )?.also { dto: UserDto ->
        println(dto)

        dto.name = "유관순"
    }

    println("result $userDto")

}