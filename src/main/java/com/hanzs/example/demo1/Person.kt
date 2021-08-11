package com.hanzs.example.demo1

class Person(val age: Int, val name: String) {
    override fun equals(other: Any?): Boolean {
        val other = (other as? Person) ?: return false
        return other.age == age && other.name == name
    }

    override fun hashCode(): Int {
        //通过age和name来比较相等性，把这俩定义成不可变的
        return 1 + 7 * age + 13 * name.hashCode()
    }
}

fun main() {
    val persons = HashSet<Person>()

//    (0..5).forEach {
//        persons += Person(20, "Hzs")
//    }
//    println(persons.size)

    /* val person = Person(20,"hanzs")
     persons+=person
     println(persons.size)
     person.age++
     persons-=person
     println(persons.size)*/
    //改变了age后没法把原来的对象从hashset里移除的

    val person = Person(20, "hanzs")
    persons += person
    println(persons.size)
    val person2 = Person(person.age + 1, person.name)
    persons -= person
    println(persons.size)


}