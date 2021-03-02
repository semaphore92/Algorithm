import java.util.Comparator;

public class BinTree<K, V> {

    // 루트
    private Node<K,V> root;    
    private Comparator<? super K> comparator = null;
 

    public BinTree(){
        root = null;
    }

    public BinTree(Comparator<? super K> c){
        this();
        comparator = c;
    }

    // key1 과 key2 를 비교하는 Method
    private int comp(K key1, K key2){
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1,key2);
    }

    public V search(K key){
        Node<K,V> p = root;

        while(true){
            if( p == null){
                return null;
            }

            int cond = comp(key,p.getKey());

            if(cond == 0){
                return p.getValue();
            }else if (cond < 0){
                p = p.left;
            }else{
                p = p.right;
            }
        }
    }

    private void addNode(Node<K,V> node, K key, V data){
        // 노드와 키값 을 비교
        int cond = comp(key, node.getKey());
        
        // 같으면 리턴
        if(cond == 0){
            return;
        //  key값이 더 작으면
        }else if (cond < 0){

            //레프트에 세팅
            if(node.left == null){
                node.left = new Node<K,V>(key, data, null, null);
            }else{
                addNode(node.left, key, data);
            }
        // key 값이 더 크면
        }else {
            if(node.right == null){
                node.right = new Node<K,V>(key, data, null, null);
            }else{
                addNode(node.right, key, data);
            }
        }
    }

    public void add(K key, V data){
        if(root == null){
            root = new Node<K,V>(key, data, null, null);
        }else{
            addNode(root, key, data);
        }
    }


    //노드 클래스 생성
    public class Node<K,V> {
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        // 생성자
        Node(K key, V data, Node<K,V> left , Node<K,V> right){
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        // 키 가져오기
        K getKey(){
            return key;
        }

        // 값 가져오기
        V getValue(){
            return data;
        }

        void print(){
            System.out.println(data);
        }

    }

   
}