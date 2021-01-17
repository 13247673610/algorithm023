/**
 * ���Ӷȷ�����
 * ʱ�临�Ӷ� O(N)O(N) �� ���� NN Ϊ�������ڵ������������£���Ҫ�ݹ�����������нڵ㡣
 * �ռ临�Ӷ� O(N)O(N) �� �������£��ݹ���ȴﵽ NN ��ϵͳʹ�� O(N)O(N) ��С�Ķ���ռ䡣
 */
public class LowestCommonAncestor{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
