import java.util.*;

public class Homework {

    /**
     * 两数之和 哈希表结局方法
     * https://leetcode-cn.com/problems/two-sum/
     */
    class  TwoSumSolution {

        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> recordMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int dif = target - nums[i];
                if (recordMap.containsKey(dif)) {
                    return new int[]{recordMap.get(dif), i};
                }
                recordMap.put(nums[i], i);
            }
            throw new IllegalArgumentException("No solution");
        }
    }

    /**
     * 加一
     * https://leetcode-cn.com/problems/plus-one/
     */
    class PlusOneSolution {

        public int[] plusOne(int[] digits) {

            for (int i = digits.length; i > 0; i--) {
                digits[i-1] = (digits[i-1] + 1) % 10;
                if (digits[i-1] != 0) {
                    return digits;
                }
            }

            int[] result = new int[digits.length + 1];
            result[0] = 1;

            return result;
        }
    }

    /**
     * 合并两个有序链表
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */
    class MergeTwoSortedLists {

        public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {

            ListNode temp = new ListNode(0);

            ListNode preNode = temp;

            while (null != l1 && null != l2) {
                if (l1.val <= l2.val) {
                    preNode.next = l1;
                    l1 = l1.next;
                } else {
                    preNode.next = l2;
                    l2 = l2.next;
                }
                preNode = preNode.next;
            }

            preNode.next = null != l1 ? l1 : l2;
            return temp.next;
        }

    }

    /**
     * 设计循环双端队列
     * https://leetcode-cn.com/problems/design-circular-deque/
     */
    class MyCircularDeque {

        private Stack<Integer> first = new Stack<>();
        private Stack<Integer> last = new Stack<>();
        private int capacity = 0;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            capacity = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            first.push(value);
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            last.push(value);
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            if (first.isEmpty()) {
                while (!last.isEmpty()) {
                    first.push(last.pop());
                }
            }

            first.pop();
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            if (last.isEmpty()) {
                while (!first.isEmpty()) {
                    last.push(first.pop());
                }
            }
            last.pop();
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }

            if (first.isEmpty()) {
                while (!last.isEmpty()) {
                    first.push(last.pop());
                }
            }

            return first.peek();
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            if (last.isEmpty()) {
                while (!first.isEmpty()) {
                    last.push(first.pop());
                }
            }
            return last.peek();
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return (first.size() + last.size()) == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return  (first.size() + last.size()) == capacity;
        }

    }


    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addLast("b");
        System.out.println(deque); //[a,b]

        deque.addFirst("c");
        System.out.println(deque); //[c,a,b]

        String first = deque.getFirst();
        System.out.println(first); //c
        System.out.println(deque); // [c,a,b]

        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
        System.out.println(deque); //[]
    }



}
