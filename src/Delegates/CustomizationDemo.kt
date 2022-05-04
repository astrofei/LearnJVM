package Delegates

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// 方式一
class Example {
    var p: String by CustomizationDemoTwo()
}

// Customization Delegates
class CustomizationDemo() {
    // 1. var修饰的属性，必须要有getValue，setValue
    // 2. Any？意指代理对象所属的类，这里是Example或其父类
    // 3. property意指所代理的对象，这里是p
    // 4. 返回的String意指所代理对象的类型或其父类型，这里p的类型是String
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : String {
        return "$thisRef, thank you for delegating ${property.name} to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef")
    }
}

// 方式二
// 针对var变量
class CustomizationDemoTwo() : ReadWriteProperty<Example,String> {
    override fun getValue(thisRef: Example, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating ${property.name} to me!"
    }

    override fun setValue(thisRef: Example, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef")
    }
}

// 针对val变量
class CustomizationDemoThree() : ReadOnlyProperty<Example,String> {
    override fun getValue(thisRef: Example, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating ${property.name} to me!"
    }

}

fun main() {
    val example = Example()
    example.p = "zhifei"
    println(example.p)
}
