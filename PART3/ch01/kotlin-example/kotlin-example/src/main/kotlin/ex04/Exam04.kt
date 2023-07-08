package ex04

fun main(){
    // java Object == Any
    val map = mapOf<String,Any>(
        Pair("",""),
        "key" to "value"
    )

    val mutableMap = mutableMapOf<String, Any>(
        "key" to "value"
    )

    mutableMap["key"] = "value"
    val value = mutableMap["key"]

    val hashMap = hashMapOf<String, Any>()

    var triple = Triple<String, String, String>(
        first = "",
        second = "",
        third = ""
    )

}