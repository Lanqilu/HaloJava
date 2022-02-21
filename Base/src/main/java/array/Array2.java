package array;

/**
 * @Date : 2020/2/9  16:17
 * @Author: Halo
 * @File : Array2
 * @Version : v1.0
 * @Description: 二维数组的使用
 **/
public class Array2 {
    public static void main(String[] args) {

        //1.二维数组的声明和初始化
        int[] arr = new int[]{1, 2, 3};//一维数组
        //静态初始化
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        //动态初始化1
        String[][] arr2 = new String[3][2];
        //动态初始化2
        String[][] arr3 = new String[3][];
        //错误的情况
//		String[][] arr4 = new String[][4];
//		String[4][3] arr5 = new String[][];
//		int[][] arr6 = new int[4][3]{{1,2,3},{4,5},{6,7,8}};

        //也是正确的写法：
        int[][] arr4 = new int[][]{{1, 2, 3}, {4, 5, 9, 10}, {6, 7, 8}};
        int[][] arr5 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};

        //2.如何调用数组的指定位置的元素
        System.out.println(arr1[0][1]);//2
        System.out.println(arr2[1][1]);//null

        arr3[1] = new String[4];
        System.out.println(arr3[1][0]);

        //3.获取数组的长度
        System.out.println(arr4.length);//3
        System.out.println(arr4[0].length);//3
        System.out.println(arr4[1].length);//4

        //4.如何遍历二维数组
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
