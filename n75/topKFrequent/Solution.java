package n75.topKFrequent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{5, 3, 1, 1, 1, 3, 73, 1}, 2)));
    }

    static class Heap {
        int[] arr;
        int size;
        int cap;

        public Heap(int cap) {
            this.cap = cap;
            arr = new int[cap + 1];
        }

        public void insert(int val, Map<Integer, Integer> map) {
            if (this.size == cap) {
                if (map.get(this.arr[1]) >= map.get(val)) {
                    return;
                }

                this.arr[1] = val;
                shiftDown(1, map);
            } else {
                this.arr[++size] = val;
                shiftUp(this.size, map);
            }
        }

        public void shiftUp(int k, Map<Integer, Integer> map) {
            while (k > 1 && map.get(this.arr[k]) < map.get(this.arr[k / 2])) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        public void shiftDown(int k, Map<Integer, Integer> map) {
            while (k * 2 <= this.size) {
                int indexMin = k * 2;
                if ((indexMin + 1 <= this.size) && map.get(this.arr[indexMin]) > map.get(this.arr[indexMin + 1])) {
                    indexMin++;
                }

                if (map.get(this.arr[k]) <= map.get(this.arr[indexMin])) {
                    break;
                }

                swap(k, indexMin);
                k = indexMin;
            }
        }

        public void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Heap heap = new Heap(k);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            heap.insert(num, map);
        }

        return Arrays.copyOfRange(heap.arr, 1, heap.arr.length);
    }
}
