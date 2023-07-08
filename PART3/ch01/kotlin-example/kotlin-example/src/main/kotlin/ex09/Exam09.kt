package ex09

import java.lang.NullPointerException
import java.lang.RuntimeException

fun main(){


    val result = when(""){
        "" -> {
            ""
        }
        "MASTER","ADMIN" -> {
            "master"
        }
        "USER" -> {
            "user"
        }
        else -> {
            "default"
        }
    }

    var any : Any = "";
    var exception = RuntimeException()
    when(exception){
        is NullPointerException -> {

        }
        is RuntimeException -> {

        }
    }

    var number = 13


    when(val n = number % 2){
        0 -> {
            println(n)
        }
        else ->{
            println(n)
        }
    }

    val r = when{
        number % 2 == 0 ->{
            100
        }
        else -> {
            200
        }
    }
    println(r)

}