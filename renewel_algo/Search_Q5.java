import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class Search_Q5 {
    public static void main(String[] args) {
        int[] x = new int[]{1,3,5,7,7,7,7,8,8,9,9};

        int key = 7;
        int result = SearchQ5(x, x.length, key);
        System.out.println(result);
    }

    static int SearchQ5(int[] a, int n, int key){
        int pl = 0;
        int pr = n-1;
        
        do{
            int pc = (pl+pr)/2;
        
            // 중간 값과 Key 일치 시,
            if(a[pc] == key){
                
                for(int z = pc; z >= pl; z--){
                    if(a[pc] != a[z]){
                        return z+1;
                    }
                }
            }else if(a[pc] < key){
                pl = pc +1; 
            }else if(a[pc] > key){
                pr = pc -1;
            }

        }while(pl <= pr);
        
        return -1;
    }
}