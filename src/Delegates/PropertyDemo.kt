package Delegates

//标准委托,常用于软件版本之间的兼容
var count: Int = 0
var total: Int by ::count

//懒加载委托
val data: String by lazy {
    request()
}

fun request(): String {
    println("do network request")
    return "net data"
}

fun main() {
    // 懒加载委托
    println("----begin lazy load----")
    println(data)
    println(data)
    println("----end lazy load----")
}