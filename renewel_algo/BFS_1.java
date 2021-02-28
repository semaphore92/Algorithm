import java.util.LinkedList;
import java.util.Queue;

public class BFS_1 {
    class TreeNode {

        // 값
        public int val;

        // 왼쪽
        TreeNode left;

        // 오른쪽
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Node Setting
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(13);

        System.out.println(solutiondfs(root));
        System.out.println(solutionbfs(root));
    }

    // 넓이 우선 탐색
    public static int solutionbfs(TreeNode root) {
        if(root == null) return 0;
        int count = 0;

        // Queue 생성 (링크드 리스트)
        Queue<TreeNode> queue = new LinkedList<>();

        // root Setting
        queue.offer(root);

        // Queue Empty가 아닐때까지
        while(!queue.isEmpty()) {
            int size = queue.size();

            // Queue Size만큼 돈다
            for(int i = 0; i<size; i++) {

                // Queue에서 node를 꺼냄
                TreeNode node = queue.poll();

                // Node의 왼쪽 값을 queue에 Setting
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}