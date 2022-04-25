package exer1;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-12-12 12:05
 */
public class StringTest2 {
    /*
    3. 获取一个字符串在另一个字符串中出现的次数。
    比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数

     */

    /**
     * 获取subStr在mainStr中出现的次数
     *
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;

        if (mainLength >= subLength) {
            //方式一：
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //方式二：对方式一的改进
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }


            return count;
        } else {
            return 0;
        }
    }

    @Test
    public void test1() {
        String str = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(str, subStr);
        System.out.println(count);
    }
}
