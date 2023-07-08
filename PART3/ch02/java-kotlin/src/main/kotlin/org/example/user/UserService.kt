package org.example.user

import org.example.model.UserDto
import java.time.LocalDateTime

class UserService {

    fun logic(userDto: UserDto? = null){

        val userDto = UserDto(
            null,
            10,
            "gmail.com",
            "010-1111-2222",
            LocalDateTime.now()
        )

        userDto.name?.let { println(it.length) }?: println("null".length)
    }

}

fun main(){
    UserService().logic()
}