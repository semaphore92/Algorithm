import java.util.*;
import java.io.*;


/*
조건1, 두 개의 선거구로 나눠야한다
조건2. 각 구격은 두 선거구 중 하나에 포함되어야한다.
조건3. 구역은 모두 연결되어 있어야 한다.

[데이터의 정보]

1. 구역의 개수
2. 구역의 인구
3.  첫 번째 정수는 그 구역과 인접한 구역의 수
    그 이후는 인접한 구역의 번호

Answer : 공평하게 선거구를 나누기 위해 선거구에 포함된 인구의 차이를 최소로한다.

문제풀이 접근

1. 두 선거구로 나누뇌 각 선거구끼리는 연결이 되어있어하며 
최종 인구수의 차이를 구한다.

2. 선거구를 나눌 수 있는 경우의수를 모두 구해서
인구의 최소차가 가장 적은 케이스를 구한다.
*/

class BackJoon_17471 {
    static int N, minValue = 99999999;
    static int arr[],connect[][],area[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 선거구 수 입력
        N = Integer.parseInt(br.readLine());

        // 선거구 인구 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 선거구 연결 정보 배열 생성
        connect = new int[N+1][N+1];

        // 인접 선거구 정보 세팅
        area = new int[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            // 근접한 선거구 개수 
            int iter = Integer.parseInt(st.nextToken());

            // 근접한 선거구 개수만큼 for문
            for(int j=1; j<=iter; j++) {
                // ex) 2번째 선거구 일경우
                int val = Integer.parseInt(st.nextToken());
                // 첫번째 선거구 옆 2번째에 1 세팅
                connect[i][val] = 1;
                // 두번째 선거구의 옆 첫번째에 1세팅
                connect[val][i] = 1;
            }
            /*
            6개 일때
            010000
            100000
            000000
            000000
            000000
            000000
            */
        }

        // 깊이 우선 탐색 1로 세팅
        dfs(1);
        if(minValue == 99999999)
            System.out.println(-1);
        else
            System.out.println(minValue);
        
    }

    // 깊이 우선 탐색
    private static void dfs(int count) {
        
        // 카운트가 선거구 + 1과 같으면
        if(count == N+1) {
            int area1 = 0, area2 = 0;
            for(int i=1; i<=N; i++) {

                if(area[i] == 1)
                    area1 += arr[i];
                else
                    area2 += arr[i];
            }
            visit = new boolean[N+1];
            
            int rs = 0;
            for(int i=1; i<=N; i++) {
                if(!visit[i]) {
                    checkArea(i, area[i]);
                    rs++;
                }
            }
            if(rs == 2) {
                if(minValue > Math.abs(area1 - area2))
                    minValue =  Math.abs(area1 - area2);
            }
            return;
        }

        // 선거구 배열에 1 세팅
        area[count] = 1;
        dfs(count+1);
        
        // 선거구 배열에 2세팅
        area[count] = 2;
        dfs(count+1);
    }
    private static void checkArea(int index, int num) {
        // TODO Auto-generated method stub
        visit[index] = true;
        for(int i=1; i<=N; i++) {
            if(connect[index][i] == 1 && !visit[i] && area[i]==num)
                checkArea(i, num);
        }
    }
}