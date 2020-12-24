package migong;

/**
 * @author djl
 * @create 2020/12/24 16:18
 */
public class MiGongApp {

    private static int counter;

    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7]; // 8行7列
        // 使用 1 标识墙壁
        // 二位数组周围一圈都是墙壁

        // 将上下设置为 墙壁
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 将左右设置为墙壁
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板
        map[3][1] = 1;  // 第4行的第2列 = 1
        map[3][2] = 1;  // 第4行的第3列 = 1

        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 开始走迷宫从 二行二列的位置开始走
        setWay3(map, 1, 1);

        // 走完迷宫打印新的地图
        System.out.println("小球走过并标识过的地图的情况:");
        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("行走步数:" + counter);
    }

    /**
     * 使用递归回溯来给小球找路
     * 约定如果小球能走到 map[6,5] 的位置则表示找到了通路
     * 当 map[i][j] 为 0 表示该点没有走过 , 为 1 表示墙壁 , 为 2 表示通路可以走 , 为 3 表示该点已经走过但是走不通
     * 制定走迷宫策略:下 -> 右 -> 上 -> 左 , 该点走不通再回溯
     *
     * @param map 表示地图
     * @param i   表示从地图的那个位置出发的[行]坐标
     * @param j   表示从地图的那个位置出发的[列]坐标
     */
    private static boolean setWay(int[][] map, int i, int j) {
        counter++;
        // 表示已经走到了通路
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                // 当前点还没走过则进入该点
                map[i][j] = 2;
                // 然后开始 下 -> 右 -> 上 -> 左 执行策略
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 如果都走不通说明该点是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {  // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

    /**
     * 修改找路的策略，改成 上->右->下->左
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    private static boolean setWay2(int[][] map, int i, int j) {
        counter++;
        if (map[6][5] == 2) { // 通路已经找到 ok
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 上->右->下->左
                map[i][j] = 2; // 假定该点是可以走通.
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { //向下
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }


    /**
     * 修改找路的策略，改成 上->下->左->右
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    private static boolean setWay3(int[][] map, int i, int j) {
        counter++;
        if (map[6][5] == 2) { // 通路已经找到 ok
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 上->右->下->左
                map[i][j] = 2; // 假定该点是可以走通.
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) { //向左
                    return true;
                } else if (setWay2(map, i, j + 1)) { // 向右走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }
}
