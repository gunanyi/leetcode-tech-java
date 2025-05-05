### 题目描述

https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

我们可以维护一个最小堆，大小为k，这样堆顶就是第k大元素，在添加时做一些处理，如果堆满了，并且当前元素小于堆顶元素，说明当前元素不可能时第k大，不处理，
如果大于，则当前元素放到堆顶，下沉。如果没满，当前元素放到堆尾，上浮。

```java
package n74.findKthLargest;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    static class Heap {
        int[] arr;
        int size;
        int cap;

        public Heap(int cap) {
            this.cap = cap;
            this.arr = new int[cap + 1];
        }

        public void insert(int val) {
            if (this.size == cap) {
                if (this.arr[1] > val) {
                    return;
                }

                this.arr[1] = val;
                this.shiftDown(1);
                return;
            }

            // 没有满
            this.arr[++size] = val;
            this.shiftUp(size);
        }

        public void swap(int i, int j) {
            int temp = this.arr[i];
            this.arr[i] = this.arr[j];
            this.arr[j] = temp;
        }

        // 上浮
        public void shiftUp(int k) {
            int pIndex = k / 2;
            while (pIndex >= 1 && this.arr[pIndex] > this.arr[k]) {
                swap(pIndex, k);
                k = pIndex;
                pIndex = k / 2;
            }
        }

        // 下沉
        public void shiftDown(int k) {
            while (2 * k <= this.size) {
                int swapIndex = 2 * k;
                if (swapIndex < this.size && this.arr[swapIndex] > this.arr[swapIndex + 1]) {
                    swapIndex++;
                }

                if (this.arr[k] <= this.arr[swapIndex]) {
                    break;
                }
                swap(k, swapIndex);
                k = swapIndex;
            }
        }
    }

    // findKthLargest 方法一：堆排序
    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(k);
        for (int num : nums) {
            heap.insert(num);
        }

        return heap.arr[1];
    }
}
```