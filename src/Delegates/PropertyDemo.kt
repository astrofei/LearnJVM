package Delegates

import kotlin.properties.Delegates

//两个属性直接的委托,常用于软件版本之间的兼容
var count: Int = 0
var total: Int by ::count

// 标准委托
//懒加载委托
val data: String by lazy {
    request()
}
fun request(): String {
    println("do network request")
    return "net data"
}

// Observable properties
// 初始值 + 修改处理程序
// property : 代理的属性
// oldValue ： 旧值
// newValue ： 新值
// observable ： 返回Unit,对新值旧值做处理
// vetoable返回一个boolean值，返回false，赋值失败
var name : String by Delegates.observable("<no name>") {
    property, oldValue, newValue ->
    println("$oldValue -> $newValue")
}
var anotherName : String by Delegates.vetoable("<no name>") {
    property, oldValue, newValue ->
    oldValue.length < newValue.length
}

fun main() {
    // 懒加载委托
    // ----------
    println("----begin lazy load----")
    println(data)
    println(data)
    println("----end lazy load----")
    // ----------

    name = "first"
    name = "second"

    anotherName = "first"
    println(anotherName)
    anotherName = "second has large length"
    println(anotherName)
}