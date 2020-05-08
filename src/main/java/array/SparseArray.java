package array;

/**
 * @author kaixuan
 * @version 1.0
 * @date 27/4/2020 下午1:41
 * 二维数组转稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建原始二维数组
        int[][] twoArray = new int[11][11];
        twoArray[1][2] =1;
        twoArray[2][3] =2;
        twoArray[4][6]=2;
        System.out.println("原始的二维数组");
        for (int[] row : twoArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //=============================================
        //将二维数组转成稀疏数组
        //将二维数组进行遍历
        int sum=0;
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray.length; j++) {
                if (twoArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int [][] sparseArray=new int [sum+1][3];
        //给稀疏数组赋值
        sparseArray[0]= new int[]{twoArray.length, twoArray.length, sum};

        int count =1;
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray.length; j++) {
                if (twoArray[i][j] != 0) {
                  sparseArray[count][0]=i;
                  sparseArray[count][1]=j;
                  sparseArray[count][2]=twoArray[i][j];
                  count++;
                }
            }
        }


        System.out.println("===========================================================稀疏数组:");

        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }


        System.out.println("====================================================将稀疏数组转换成原始二维数组");

        int [][] twoArray1=new int [sparseArray[0][0]][sparseArray[0][1]];

        for (int a = 1; a < sparseArray.length; a++) {
            twoArray1[sparseArray[a][0]][sparseArray[a][1]]=sparseArray[a][2];
        }


        for (int[] ints : twoArray1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }




    }













}
