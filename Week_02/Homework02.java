import java.util.*;

public class Homework02 {

    /**
     * 242 有效的字母异位词
     * https://leetcode-cn.com/problems/valid-anagram/
     */
    class ValidAnagram {

        public boolean isAnagram(String s, String t) {
            if ((null ==s || null == t) || s.length() != t.length()) {
                return false;
            }


            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a'] ++;
                counter[t.charAt(i) - 'a'] --;
            }

            for (int count : counter) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * 49. 字母异位词分组
     * https://leetcode-cn.com/problems/group-anagrams/
     */
    class GroupAnagrams {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (null == strs || strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> recordMap = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (!recordMap.containsKey(key)) {
                    recordMap.put(key, new ArrayList<String>());
                }
                recordMap.get(key).add(str);
            }
            return new ArrayList<>(recordMap.values());
        }
    }


    /**
     * 589. N叉树的前序遍历
     * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
     */
    class NAryTreePreorderTraversal{

        public List<Integer> preorder(Node root) {

            LinkedList<Integer> result = new LinkedList<>();

            if (null == root) {
                return result;
            }

            LinkedList<Node> stack = new LinkedList<Node>();
            stack.add(root);

            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                result.add(node.val);
                Collections.reverse(node.children);
                for (Node child : node.children) {
                    stack.add(child);
                }
            }
            return result;
        }
    }

    /**
     * 94. 二叉树的中序遍历
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     */
    class BinaryTreeInOrderTraversal {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        public void helper(TreeNode root, List<Integer> result) {
            if (root != null) {

                // 左
                if (root.left != null) {
                    helper(root.left, result);
                }

                //根
                result.add(root.val);

                // 右
                if (root.right != null) {
                    helper(root.right, result);
                }
            }
        }
    }







}
