package ex11

import java.time.LocalDateTime
import kotlin.streams.toList

fun main(){
    // let
    val now  = LocalDateTime.now()
    val localDateTime: LocalDateTime?=null

    val kst = localDateTime?.let { localDateTime ->
        println("let scope $localDateTime")
        "let scope"
    }?: LocalDateTime.now()

    println("result $kst")

    UserDto(name = "홍길동").let {
        logic(it)
    }

    val userDtoList = listOf(UserDto("홍길동"), UserDto("유관순"))

    val responseList = userDtoList.stream()
        .map { it ->
            UserResponse(
                userName = it.name
            )
        }.toList()

}

fun logic(userDto: UserDto?): UserResponse? {

    return userDto?.let { userDto ->
        println("dto $userDto")

        UserEntity(
            name = userDto.name
        )
    }?.let {
        println("entity $it")

        UserResponse(
            userName = it.name
        )
    }
}


data class UserDto(
    var name: String?=null,
    var age: Int?=null,
    var email: String?=null,
    var registeredAt: LocalDateTime?=null,
)

data class UserEntity(
    var name: String?=null,
)

data class UserResponse(
    var userName: String?=null,
)