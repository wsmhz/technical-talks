package com.wsmhz.questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By tangbj On 2019/7/16
 * Description: 第6题，Z 字形变换
 *  将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 *  比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *  L   C   I   R
 *  E T O E S I I G
 *  E   D   H   N
 *  之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"
 *
 *  输入: s = "LEETCODEISHIRING", numRows = 4
 *  输出: "LDREOEIIECIHNTSG"
 *  解释:
 *  L     D     R
 *  E   O E   I I
 *  E C   I H   N
 *  T     S     G
 */
public class ZChange {

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] chars = s.toCharArray();
        List<StringBuilder> rows = new ArrayList<>();
        boolean toDown = false;
        // 直接分成numRows行，进行z字行“拍扁”按行添加
        for (int i = 0; i < Math.min(chars.length, numRows); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        for (char c : chars) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1){
                toDown = !toDown;
            }
            curRow = curRow + (toDown ?  1 : -1);
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = convert("LEETCODEISHIRING", 4);
        System.out.println(result);
    }
}
