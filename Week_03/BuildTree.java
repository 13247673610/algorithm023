public class BuildTree{
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeHelper(preorder,  inorder, (long)Integer.MAX_VALUE + 1);
	}
	int pre = 0;
	int in = 0;
	private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
		//����ĩβ���� null
		if(pre == preorder.length){
			return null;
		}
		//����ֹͣ�㷵�� null
		//��ǰֹͣ���Ѿ����ˣ�in ����
		if (inorder[in] == stop) {
			in++;
			return null;
		}
		int root_val = preorder[pre++];
		TreeNode root = new TreeNode(root_val);   
		//��������ֹͣ���ǵ�ǰ�ĸ��ڵ�
		root.left = buildTreeHelper(preorder,  inorder, root_val);
		//��������ֹͣ���ǵ�ǰ����ֹͣ��
		root.right = buildTreeHelper(preorder, inorder, stop);
		return root;
	}
}