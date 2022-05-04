package Delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringDelegate(private var s: String = "Hello") : ReadWriteProperty<Owner, String> {
    override operator fun getValue(thisRef: Owner, property: KProperty<*>): String {
        return s
    }

    override operator fun setValue(thisRef: Owner, property: KProperty<*>, value: String) {
        s = value
    }
}

// 在委托属性的同时进行一些额外的逻辑判断,相当于通过provideDelegate进行了一次判断
class SmartDelegator {
    operator fun provideDelegate(
        thisRef: Owner,
        prop: KProperty<*>
    ): ReadWriteProperty<Owner, String> {
        return if (prop.name.contains("log")) {
            StringDelegate("log")
        } else {
            StringDelegate("normal")
        }
    }
}

class Owner {
    var normalText: String by SmartDelegator()
    var logText: String by SmartDelegator()
}

fun main() {
    val owner = Owner()
    println(owner.normalText)
    println(owner.logText)
}