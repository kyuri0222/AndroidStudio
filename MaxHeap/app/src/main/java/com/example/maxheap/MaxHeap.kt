package com.example.maxheap

class MaxHeap {
    private var heap = IntArray(n)
    private var num = 0

    fun push(x: Int) {
        heap[++num] = x
        var idx = num
        while (idx > 1 && heap[idx / 2] < heap[idx]) {
            if (idx == 1 || heap[idx / 2] > heap[idx]) break

            val tmp = heap[idx / 2]
            heap[idx / 2] = heap[idx]
            heap[idx] = tmp
            idx /= 2
        }
    }

    fun pop(): Int {
        val pop = heap[1]
        heap[1] = heap[num--]
        var idx = 1
        var next: Int
        while (true) {
            next = idx * 2
            if (next < num && heap[next] < heap[next + 1]) next++
            if (next > num || heap[next] < heap[idx]) break

            val tmp = heap[idx]
            heap[idx] = heap[next]
            heap[next] = tmp
            idx = next
        }
        return pop
    }

    fun heapsort(){

    }

    fun get_sorted_array(){

    }
}

var n = 1000
private var src = intArrayOf(2,9,6,4,7,3,8,1,5)
// private var src = IntArray(1000) { Random().nextInt() }.asList()

fun main(args: Array<String>) {
    val maxHeap = MaxHeap()
    for (i in src.indices) maxHeap.push(src[i])
    for (i in src.indices) {
        print(maxHeap.pop().toString() + " ")
    }
    val sorted_array = maxHeap.get_sorted_array()
}