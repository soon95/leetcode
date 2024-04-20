import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Song
 * @date 4/20/24
 */
public class No199RightSideViewTest {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;

        No199RightSideViewTest test = new No199RightSideViewTest();

        List<Integer> res = test.rightSideView(node1);

        System.out.println(res);


    }


    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }


        List<TreeNode> nextLayerNodes = new ArrayList<>();
        nextLayerNodes.add(root);


        doEachLayer(nextLayerNodes, res);


        return res;
    }

    private void doEachLayer(List<TreeNode> nodes, List<Integer> res) {

        if (nodes.size() == 0) {
            return;
        }


        List<TreeNode> nextLayerNodes = new ArrayList<>();

        for (TreeNode node : nodes) {

            if (node == null) {
                continue;
            }

            if (node.left != null) {
                nextLayerNodes.add(node.left);
            }

            if (node.right != null) {
                nextLayerNodes.add(node.right);
            }
        }

        res.add(nodes.get(nodes.size() - 1).val);


        doEachLayer(nextLayerNodes, res);
    }


}
