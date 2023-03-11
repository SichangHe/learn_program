package com.youknowwho.firstjava

class Counter(var count: Int) {
    fun increment(): Int {
        count++
        return count
    }
}
