package com.example.javatokotlin

// 모바일컴퓨팅 (60185077 김규리) - maxheap 구현
object MaxHeap {
    var n = 1000
    var src = intArrayOf(2,9,6,4,7,3,8,1,5)

    @JvmStatic
    fun main(args: Array<String>) {
        val heap = Heap()
        for (i in src.indices) heap.push(src[i])
        for (i in src.indices) {
            print(heap.pop().toString() + " ")
        }
    }

    class Heap {
        var heap = IntArray(n)
        var num = 0

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
                //swap
                val tmp = heap[idx]
                heap[idx] = heap[next]
                heap[next] = tmp
                idx = next
            }
            return pop

        }
    }
}


