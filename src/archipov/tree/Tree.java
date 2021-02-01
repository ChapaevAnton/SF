package archipov.tree;

import archipov.stack.SimpleQueue;
import archipov.stack.SimpleStack;

public class Tree {
    public static void main(String[] args) {
        tree root =
                new tree(20,
                        new tree(7,
                                new tree(4, null, new tree(6)), new tree(9)),
                        new tree(35,
                                new tree(31, new tree(28), null),
                                new tree(40, new tree(38),new tree(52))));

        System.out.println("Сумма дерева : " + tree.sumDeep(root));
    }

    static class tree{
        int value;
        tree left;
        tree right;

        public tree(int value, tree left, tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public tree(int value) {
            this.value = value;
        }

        public  int sum(){
            int summ = value;
            if(left != null){
                summ += left.sum();
            }
            if(right != null){
                summ += right.sum();
            }
            return summ;
        }
            /// Итеративный обход дерева в глубину..
        public static int sumDeep(tree root){
            SimpleStack<tree> stack = new SimpleStack<>();
            stack.push(root);

            int sum = 0;

            while(!stack.isEmpty()){
                tree node = stack.pop();

                System.out.println(node.value);

                sum += node.value;

                if(node.right != null){
                    stack.push(node.right);
                }

                if(node.left != null){
                    stack.push(node.left);
                }
            }
            return sum;
        }
            // Итеративный обход дерева в ширину
        public static int sumDeep1(tree root){
            SimpleQueue<tree> queue = new SimpleQueue<>();
            queue.add(root);

            int sum = 0;

            while(!queue.isEmpty()){
                tree node = queue.remove();

                System.out.println(node.value);

                sum += node.value;

                if(node.right != null){
                    queue.add(node.right);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
            }
            return sum;
        }
    }
}
