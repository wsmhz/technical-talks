package com.wsmhz.questions.leetcode;

import java.util.HashMap;

/**
 * Created By tangbj On 2019/7/22
 * Description: 36. 有效的数独
 *      判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 *      数字 1-9 在每一行只能出现一次。
 *      数字 1-9 在每一列只能出现一次。
 *      数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *      数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxs = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxs[i] = new HashMap<Integer, Integer>();
        }
        // i -> 行 j -> 列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    int val = (int)c;
                    rows[i].put(val, rows[i].getOrDefault(val, 0) + 1);
                    cols[j].put(val, cols[j].getOrDefault(val, 0) + 1);
                    int box = (i / 3) * 3 + j / 3; // 子数独索引
                    boxs[box].put(val, boxs[box].getOrDefault(val, 0) + 1);

                    if(rows[i].get(val) > 1 || cols[j].get(val) > 1 || boxs[box].get(val) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] data = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };
        char[][] data = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(data));
    }
}
