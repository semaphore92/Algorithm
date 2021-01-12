import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class Search_Q4 {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,5,6,7,8,9,10};

        int key = 1;
        int result = SearchQ4(x, x.length, key);
        System.out.println(result);
    }

    static int SearchQ4(int[] a, int n, int key){
        int pl = 0;
        int pr = n-1;
        
        do{
            int pc = (pl+pr)/2;

            for(int x = pl; x <= pr; x++){
                if(x == pl){
                    System.out.print("< ");
                }else if(x == pc){
                    System.out.print("+ ");
                }else if(x == pr){
                    System.out.print(">");
                }else{
                    System.out.print("  ");
                }
            }    
            System.out.println();

            if(a[pc] == key){
                return pc;
            }else if(a[pc] < key){
                pl = pc +1; 
            }else if(a[pc] > key){
                pr = pc -1;
            }

            for(int x = 0; x < a.length; x++){
                System.out.print(a[x]+ " ");
            }
            System.out.println();

        }while(pl <= pr);
        
        return -1;
    }
}