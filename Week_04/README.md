学习笔记

搜索遍历：

需要保证：
每个节点都要访问一次；
每个节点仅仅要访问一次；（避免做过多的访问）
对于节点的访问顺序不同，分为：
深度优先：DFS (Depth first search)
广度有限：BFS (Breadth first search)

除了深度优先、广度优先，还有按照优先级搜索；

深度优先：
二叉树
def dfs(node):
	#递归终止条件，当前节点已经被访问过了
	if node in visited:
		return
	visited.add(node)
	dfs(node.left)
	dfs(node.right)

Java模板：
//Java    
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> allResults = new ArrayList<>();
	if(root==null){
		return allResults;        
	}        
	travel(root,0,allResults);        
	return allResults;    
}    
private void travel(TreeNode root,int level,List<List<Integer>> results){
	if(results.size()==level){
		results.add(new ArrayList<>());        
	}        
	results.get(level).add(root.val);        
	if(root.left!=null){            
		travel(root.left,level+1,results);        
	}        
	if(root.right!=null){            
		travel(root.right,level+1,results);        
	}    
}

N叉树：
visited = set()

def dfs(node,visited):
	visited.add(node)
	...
	# 直接下探到子树
	for next_node in node.children():
		# 校验子节点是否被访问过，也可以放到函数开始的位置
		if not next_node in visited:
			dfs(next_node,visited)

def dfs(node,visited):
	# 递归终止条件，判断当前节点是否已经被访问过
	if node in visited:
		return
	visited.add(node)
	...
	# 直接下探到子树
	for next_node in node.children():
		# 校验子节点是否被访问过，也可以放到函数开始的位置
		if not next_node in visited:
			dfs(next_node,visited)
Java模板：
Set<TreeNode> nodes = new HashSet<>();
public void dfs(TreeNode node,Set<TreeNode> nodes){
	if(nodes.contains(node)) return ;
	nodes.add(node);
	....
	for(TreeNode child : node.children){
		if(!nodes.contains(node)) dfs(child,nodes);
	}
}			

递归先左子树走到底，然后在回来看看当前节点是否有右子树
1.处理当前层
2.下转到下一层

以上是递归写法；

非递归写法：

def dfs(self,tree):
	if tree.root is None:
		return []
	visited,stack = [], [tree.root]
	
	while stack:
		node = stack.pop();
		visited.add(node);
		
		process(node)
		nodes = generate_related_nodes(node)
		stack.push(nodes)
		.....
非递归写法就是手动维护一个栈；

要点：牢记代码模板


广度优先搜索:
广度优先搜索就不再是用递归或者栈了，而是队列；
由上往下，逐层搜索；
水波纹；

Java代码模板：
//Java
public class TreeNode {
	int val;    
	TreeNode left;    
	TreeNode right;    
	TreeNode(int x) {        
		val = x;    
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {    
		List<List<Integer>> allResults = new ArrayList<>();    
		if (root == null) {        
			return allResults;
		}
		//使用队列来维护节点顺序，利用队列的先进先出特性
		Queue<TreeNode> nodes = new LinkedList<>();    
		nodes.add(root);    
		while (!nodes.isEmpty()) {        
			int size = nodes.size();        
			List<Integer> results = new ArrayList<>();        
			for (int i = 0; i < size; i++) {            
				TreeNode node = nodes.poll();
				results.add(node.val);            
				if (node.left != null) {                
					nodes.add(node.left);            
				}           
				if (node.right != null) {                
					nodes.add(node.right);            
				}        
			}        
			allResults.add(results);    
		}    
		return allResults;
}

本质上就是每个节点遍历一遍，按照每个节点访问顺序的不同分为：
深度优先：递归、辅助栈模拟递归
广度优先：队列



贪心算法：

贪心算法是一种，在每一步选择中，都采取在当前状态下最好或最优的选择，从而
希望导致结果是全局最好或最优的算法；
当前最优就能保证最终最优？

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退；
动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能；

贪心：当下做局部最优判断；
回溯：能够回退；
动态规划：最优判断+回退，动态规划依赖以前的计算结果；

贪心算法可以解决一些最优问题，如：求图中的最小生成树、求哈夫曼编码等；
然而对于工程和生活中的问题，贪心算法一般不能得到我们所要求的答案；

一旦一个问题可以通过贪心算法来解决，那么贪心法一般是解决这个问题的最好办法；
由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题；


何种情况下用到贪心算法？

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的的最优解；
这种子问题最优解称为最优子结构；

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退；
动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能；

贪心法难就难在怎么证明它可以用贪心法解决；

1.你能证明贪心是可以得到全局最优解的；
2.有些时候贪心的角度，可能是从后往前贪，也可能从前往后贪；
也可能从某个局部开始贪心；


二分查找：
化繁为简；
二分查找最关键的三个前提条件：
强记一下三点
1.目标函数单调性（单调递增或者递减）
2.存在上下界
3.能够通过索引访问
二分查找只能在有序里面查找，否则不能用二分查找；
因为无序只能从头到尾遍历；

正因为它存在有序性，可以通过判断它的某些特征排除掉，
前半部分或者后半部分；

另外还得有上下界，如果没有边界，那么没法往中间扩；

可以索引访问，所以如果是单链表，即使是有序性的，用二分查找起来也不容易；
可以通过跳表来进行构建多级索引来优化；

二分查找代码模板：
public int binarySearch(int[] array, int target){
	int left = 0, right = array.length - 1, mid;
	while(left <= right){
		//防止越界
		mid = (right - left) / 2 + left;
		if(array[mid] == target){
			return mid;
		}else if(array[mid] > target){
			right = mid - 1;
		}else{
			left = mid + 1;
		}
	}
	return -1;
}


在面试中碰到二分查找求解的题目时；
最好能跟面试官说明一下为什么这题可以使用二分查找；

比如：x 的平方根
y = x^2 , (x > 0) : 抛物线，在y轴的右侧单调递增，上下界

牛顿迭代法：
















