package ex11

fun main(){

    // apply , 생성자 패턴

    val userDto = UserDto().apply {
        name = "홍길동"

    }

    UserDto(
        name = null, age = null, email = null, registeredAt = null

    )

    println(userDto)

}
/*

fun UserDto.myUserDto(){
    println(this.name)
}*/
