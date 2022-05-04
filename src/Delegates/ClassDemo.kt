package Delegates

interface DB {
    fun save()
}

class SqlDB() : DB {
    override fun save() {
        println("save to sql")
    }
}

class GreenDaoDB() : DB {
    override fun save() {
        println("save to GreenDao")
    }
}
//            1. 继承DB
//            2. 参数 通过 by 将接口实现委托给 db
//                ↓             ↓
class UniversalDB(db : DB) : DB by db

fun main() {
    // UniversalDB就是个壳
    UniversalDB(SqlDB()).save()
    UniversalDB(GreenDaoDB()).save()
}
