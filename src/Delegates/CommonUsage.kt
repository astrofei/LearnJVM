package Delegates

/***
 * 代理常用用法
 */

// 非集合类属性可见性封装，这种方式是OK的
class CommonUsage {
    var data: String = ""
        private set

    private fun load() {
        // 网络请求
        data = "请求结果"
    }
}

// 集合类属性可见性封装
// 虽然data是val的，但外部还是可以往添加里添加数据
class CommonUsage1 {
    val data : MutableList<String> = mutableListOf()

    private fun load() {
        // 网络请求
        data.add("Hello")
    }
}
// 使用委托进行集合类属性可见性封装
class CommonUsage2 {
    // _data是private val的可变数组集合
    private val _data : MutableList<String> = mutableListOf()
    val data : List<String> by ::_data

    private fun load() {
        // 网络请求
        _data.add("Hello")
    }
}


fun main() {
    // ----------
    var commonUsage = CommonUsage()
    // 提示错误，原因：data的set方法是私有的
    //commonUsage.data = "another"
    // ----------

    // 本意是想封装data只能在CommonUsage1中添加数据，
    // 但外部获取实例后仍可以添加数据
    val commonUsage1 = CommonUsage1()
    commonUsage1.data.add("world")
    // ----------
    // 提示错误，原因：data是不可变集合，不能添加数据，必须调用load方法
    val commonUsage2 = CommonUsage2()
    //commonUsage2.data.add("world")

}