import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework03 {


    /**
     * 77.组合
     * https://leetcode-cn.com/problems/combinations/
     */
    class CombinationsSolution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();

            backTrack(1, n, k, result, new ArrayList<>());

            return result;
        }

        public void backTrack(int index, int n, int k, List<List<Integer>> result, List<Integer> cur) {

            //terminator
            if (index > n) {
                if (cur.size() == k) {
                    result.add(new ArrayList<>(cur));
                }
                return;
            }

            if (index < n && cur.size() > k) {
                return;
            }

            // not pick the number at this index
            backTrack(index+1, n, k, result, cur);

            //pick the number at this index
            cur.add(index);
            backTrack(index+1, n, k, result, cur);

            // reverse state
            cur.remove(cur.size() -1 );
        }

    }


    /**
     * 46 全排列
     * https://leetcode-cn.com/problems/permutations/submissions/
     */
    class PermutationsSolution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> output = new ArrayList<>();

            for (int num : nums) {
                output.add(num);
            }
            int length = nums.length;
            backtrace(length, output, result, 0);
            return result;
        }

        public void backtrace(int length, List<Integer> output, List<List<Integer>> result, int first ) {

            if (first == length) {
                result.add(new ArrayList<>(output));
            }

            for (int i = first; i < length; i++) {
                Collections.swap(output, first, i);
                backtrace(length, output, result, first + 1);
                Collections.swap(output, first, i);
            }
        }
    }

}
