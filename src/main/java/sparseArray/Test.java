package sparseArray;

/**
 * @author djl
 * @create 2020/12/5 15:46
 * 1.完成二维数组向稀疏数组的转换以及利用文件存储结果
 * 2.读取存储文件还原稀疏数组,然后恢复原始二维数组
 * 总结:综上完成初步的数据结构和算法的入门训练,完成二维数组的压缩和解压的功能
 */
public class Test {
    public static void main(String[] args) {
        // 构建原始的二维数组
        int[][] sourceArr = new int[11][11];
        // 设置第二行第三列 -> 1
        sourceArr[1][2] = 1;
        // 设置第三行第五列 -> 2
        sourceArr[2][4] = 2;
        // 设置第8行第8列 -> 3
        sourceArr[7][7] = 3;
        // 设置第4行第4列 -> 2
        sourceArr[3][3] = 2;

        // 打印原始数据
        for (int[] ints : sourceArr) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        int[][] spareArrayFromDoubleArray = getSpareArrayFromDoubleArray(sourceArr);

        System.out.println();
        // 打印稀疏数组
        for (int[] ints : spareArrayFromDoubleArray) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        System.out.println();

        int[][] sourceArrFromSpareArr = getSourceArrFromSpareArr(spareArrayFromDoubleArray);

        // 打印原始数据
        for (int[] ints : sourceArrFromSpareArr) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    public static int[][] getSourceArrFromSpareArr(int[][] spareArr) {
        // 首先根据稀疏数组的第一行数据还原原始数组大小
        int row = spareArr[0][0];
        int col = spareArr[0][1];
        int sum = spareArr[0][2];
        int[][] sourceArr = new int[row][col];

        // 根据稀疏数组还原二维数组 循环稀疏数组后续的行数据赋予原始数组
        for (int i = 1; i < sum + 1; i++) {
            int sourceRow = spareArr[i][0];
            int sourceCol = spareArr[i][1];
            int sourceData = spareArr[i][2];
            sourceArr[sourceRow][sourceCol] = sourceData;
        }

        return sourceArr;
    }

    public static int[][] getSpareArrayFromDoubleArray(int[][] sourceArray) {
        // 由于稀疏数组列数固定为3,则需要根据原始二维数组查询行数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (sourceArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 初始化稀疏数组 行数=有效数据个数+1
        int[][] spareArr = new int[sum + 1][3];
        // 初始化第一行数据
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;

        int row = 0;
        // 初始化稀疏数组后续的行数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                int data = sourceArray[i][j];
                if (data != 0) {
                    row++;
                    spareArr[row][0] = i; // 记录数据的原始行
                    spareArr[row][1] = j; // 记录数据的原始列
                    spareArr[row][2] = data; // 记录数据本身
                }
            }
        }

        // 返回结果
        return spareArr;
    }
}
