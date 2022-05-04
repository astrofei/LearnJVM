package Delegates

// map属性
// 注意点
// 1. 委托属性名字必须与map中key的值相同
// 2. 委托属性类型必须与map中value的类型相同
class MapPropertiesDemo(val map : Map<String, Any?>) {
    val name: String by map
    val age : Int by map
}

fun main() {
    val user = MapPropertiesDemo(mapOf(
        "nae" to "John Doe",
        "age" to 12
    ))

    println(user.name)
    println(user.age)
}