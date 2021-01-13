import java.util.Arrays;

import javax.lang.model.element.Element;

import jdk.tools.jlink.resources.plugins;

public class BinarySearchTester {
    public static void main(String[] args) {
        int[] x = new int[]{1,3,5,7,7,7,7,8,8,9,9};

        int key = 10;
        int result = Arrays.binarySearch(x,key);
        System.out.println(result);
    }

  
}