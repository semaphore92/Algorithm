import java.util.ArrayList;
import java.util.Scanner;
 
/*
 * @ TITLE DFS(Depth First Search)
 * @ COMMENT
 *     인접리스트를 이용한 DFS 구현
 */
// 그래프(인접리스트) 클래스
class DfsGraph {
    private int nV;    // 정점의 개수
    private ArrayList<ArrayList<Integer>> dfsGraph;    // 그래프
    private boolean[] visitArr;    // 정점 방문 여부 확인 배열
 
    // 그래프 초기화 생성자
    public DfsGraph(int nV) {
        this.nV = nV;    // 정점 개수 초기화
        
        // ArrayList
        this.dfsGraph = new ArrayList<ArrayList<Integer>>(); // 그래프 생성
        
        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // ArrayList의 index는 0 부터 시작이므로 
        // ArrayIndexOutOfBoundsException 방지를 위해 
        // 정점을 담는 인접리스트의 size는 1을 더하여 초기화해줌
        // 즉, 입력받은 정점의 개수에 +1을 해줌
 
        // ex) initSize = 3
        // graph[0]
        // graph[1] -> 2 -> 3
        // graph[2] -> 1 -> 3 -> 4
        // graph[3] -> 1 -> 2 -> 4 -> 5
        for(int i=0; i<this.nV+1; i++) {
            this.dfsGraph.add(new ArrayList<Integer>());
        }
        
        // 정점 방문 여부 확인 배열 초기화
        // 그래프와 마찬가지로 정점의 개수에 +1하여 초기화
        this.visitArr = new boolean[this.nV+1];
    }
 
    // 그래프 return
    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.dfsGraph;
    }
 
    // 그래프의 특정 노드 return
    public ArrayList<Integer> getNode(int i) {
        return this.dfsGraph.get(i);
    }
 
    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        this.dfsGraph.get(x).add(y);
        this.dfsGraph.get(y).add(x);
    }
 
    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        this.dfsGraph.get(x).add(y);
    }
    
    // 그래프 출력 (인접리스트)
    public void printGraphToAdjList() {
        for(int i=1; i<this.dfsGraph.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");
            
            for(int j=0; j<this.dfsGraph.get(i).size(); j++) {
                System.out.print(" -> " + this.dfsGraph.get(i).get(j));
            }
            System.out.println();
        }
    }
    
    // 정점 방문 여부 확인 배열 초기화
    public void clearVisitArr() {
        for(int i=0; i<this.visitArr.length; i++) {
            this.visitArr[i] = false;
        }
    }
    
    // 그래프 탐색 (재귀호출)
    public void dfs(int vIdx) {
        // dfs()에 파라미터로 넘어온 vIdx는 방문한 것이므로
        // 방문배열의 해당 index값을 true로 바꿔주고 값을 출력함.
        this.visitArr[vIdx] = true;
        System.out.print(vIdx + " "); 
        
        // 인접리스트로 구현된 그래프에서
        // 해당 index에 맞는 리스트를 가져와서 반복
        for(int i : this.dfsGraph.get(vIdx)) {
            
            // 해당 정점(i)이 정점 방문 여부 확인 배열에서
            // 방문하지 않은 상태(false)인 경우
            if(this.visitArr[i] == false) {
                dfs(i);    // dfs() 재귀호출
            }
        }
    }
 
}
    
public class DFSAdjList {
    public static void main(String[] args) {
        // int v = 0;    // 정점 (수동입력에 사용되는 변수)
        // int e = 0;    // 간선 (수동입력에 사용되는 변수)
        int nV = 0;    // 정점의 개수
        int nE = 0;    // 간선의 개수
        
        Scanner sc = new Scanner(System.in);
        nV = sc.nextInt();    // 정점
        nE = sc.nextInt();    // 간선
        
        // 입력받은 정점의 개수로 그래프 초기화
        DfsGraph dfsGraph = new DfsGraph(nV);
        
        // 그래프에 정점과 간선 입력
        // 입력받은 간선의 개수만큼 반복
        // ex) 정점 8, 간선 10
        dfsGraph.put(1, 2);
        dfsGraph.put(1, 3);
        dfsGraph.put(2, 4);
        dfsGraph.put(2, 5);
        dfsGraph.put(3, 6);
        dfsGraph.put(3, 7);
        dfsGraph.put(4, 8);
        dfsGraph.put(5, 8);
        dfsGraph.put(6, 8);
        dfsGraph.put(7, 8);
        
        // 정점과 간선 수동 입력
        /*for(int i=0; i<nE; i++) {
            v = sc.nextInt();
            e = sc.nextInt();
            dfsGraph.put(v, e);
        }*/
        
        sc.close();
        
        // 입력한 정점과 간선으로 구성된 인접리스트 출력
        dfsGraph.printGraphToAdjList();
        
        // 정점 순서대로 그래프 탐색
        System.out.println();
        System.out.print("정점 1부터 탐색 : ");
        dfsGraph.dfs(1);
        
        System.out.println();
        System.out.print("정점 2부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(2);
        
        System.out.println();
        System.out.print("정점 3부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(3);
        
        System.out.println();
        System.out.print("정점 4부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(4);
        
        System.out.println();
        System.out.print("정점 5부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(5);
        
        System.out.println();
        System.out.print("정점 6부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(6);
        
        System.out.println();
        System.out.print("정점 7부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(7);
        
        System.out.println();
        System.out.print("정점 8부터 탐색 : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(8);
    }
}
