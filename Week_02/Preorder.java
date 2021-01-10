public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if(root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; -- i) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}