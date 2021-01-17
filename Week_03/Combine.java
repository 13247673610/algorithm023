import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        // Ϊ�˷�ֹ�ײ㶯̬�������ݣ���ʼ����ʱ������󳤶�
        Deque<Integer> path = new ArrayDeque<>(k);
        dfs(1, n, k, path, res);
        return res;
    }

    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // �����汾�ĵݹ���ֹ������if (begin == n + 1) {
        if (begin > n - k + 1) {
            return;
        }
        // ��ѡ��ǰ���ǵ��� begin��ֱ�ӵݹ鵽��һ��
        dfs(begin + 1, n, k, path, res);

        // ��ѡ��ǰ���ǵ��� begin���ݹ鵽��һ���ʱ�� k - 1������ k ��ʾ����Ҫѡ���ٸ���
        path.addLast(begin);
        dfs(begin + 1, n, k - 1, path, res);
        // ������ȱ����л�ͷ�Ĺ��̣������Ҫ����ѡ��
        path.removeLast();
    }
}
