import java.util.*;

public class DFS_BFS_EXERCISE {

    class Graph{
        Node[] nodes;

        Graph(int size){
            for(int i = 0; i < size; i ++){
                nodes[i] = new Node(i);
            }
        }

        class Node{
            int data;
            boolean marked;
            LinkedList<Node> adjacent;

            Node(int data){
                this.data = data;
                this.marked = false;
                this.adjacent = new LinkedList<Node>();
            }
        }

        void addEdge(int n1, int n2){
            Node n1Node = nodes[n1];
            Node n2Node = nodes[n2];

            if(!n1Node.adjacent.contains(n2Node)){
                n1Node.adjacent.add(n2Node);
            }
            if(!n2Node.adjacent.contains(n1Node)){
                n2Node.adjacent.add(n1Node);
            }
        }


        void dfs(){
            dfs(0);
        }

        void dfs(int idx){
            Node root = nodes[idx];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;

            while(!stack.isEmpty()){
                Node r = stack.pop();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        stack.push(n);
                    }
                }

            }

        }


    }


}