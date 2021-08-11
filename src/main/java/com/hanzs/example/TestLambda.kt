package com.hanzs.example

/**
 * kotlin 学习 lambda表达式
 */

//普通函数
fun func() {
    println("Hello")
}

//匿名函数 赋值给一个变量 匿名函数的传递
//此函数调用则为 func()或者func
//这里的func是变量
val func = fun() {
    println("hello")
}

//匿名函数的类型
//类型为 ()->Unit 与普通函数一致的
val func2: () -> Unit = fun() {
    println("func2, hello")
}

//lambda
val lambda: () -> Unit = {
    println("Hello")
}

val f1: (Int) -> Unit = { p: Int ->
    println(p)
}
val f2: Function1<Int, Unit> = { p: Int ->
    println(p)
}

//f2可以简化
//表达式参数类型从表达式类型推断而来
val f22: Function1<Int, Unit> = { p ->
    println(p)
}

//可以进一步简化
val f222 = { p: Int -> println(p) }
//java的匿名函数是接口的语法糖 SAM Single Abstract Meethod
//lambda的匿名函数是函数的语法糖 函数是一等公民

//lambda的表达式最后一行为返回值
//(Int) -> String 类型
val f3 = { p: Int ->
    println(p)
    "Hello"
}

/**
 * lambda表达式的参数省略形式
 */
val f4: Function1<Int, Unit> = { p ->
    println(p)
}

//可以写成
//只有一个参数时，参数名可默认为it
//定义array的时候
val f41: Function1<Int, Unit> = {
    println(it)
}

val array = IntArray(5) {
    it + 1
}