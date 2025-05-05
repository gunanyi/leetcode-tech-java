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

    // findKthLargest2 方法二：快速排序 快速排序思路，k左边的元素大于于k，右边元素小于k k就是第k大元素
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return nums[l];
        }

        int pivotIndex = partition(nums, l, r); // 分区操作
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSort(nums, pivotIndex + 1, r, k);
        } else {
            return quickSort(nums, l, pivotIndex - 1, k);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left]; // 基准值
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, left, i); // 基准归位
        return (i);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
