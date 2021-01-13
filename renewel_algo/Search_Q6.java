import java.util.Arrays;

import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class Search_Q6 {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,5,7,8,9,10};

        int key = 11;
        int result = SearchQ6(x, x.length, key);
        System.out.println(result);
    }

    static int SearchQ6(int[] a, int n, int key){
        int pl = 0;
        int pr = n-1;
        int result = -999;
        
        do{
            int pc = (pl+pr)/2;
        
            // 중간 값과 Key 일치 시,
            if(a[pc] == key){
                result = pc;
            }else if(a[pc] < key){
                pl = pc +1; 
            }else if(a[pc] > key){
                pr = pc -1;
            }
        }while(pl <= pr);
        
        // 검색 실패 삽입 idx 조회
        if(result == -1){
            for(int i = 0; i < n; i++){
                if(key < a[i]){
                    result = i*-1;
                    break;
                }
            }
        }

        return result;
    }
  
}