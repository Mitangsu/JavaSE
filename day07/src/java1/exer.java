package java1;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-12-16 11:05
 */
public class exer {
    /*
    1.请从键盘随机输入10个整数保存到List中，并按倒序、从大
      到小的顺序显示出来
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            int a =scanner.nextInt();

            list.add(a);
        }

        Collections.reverse(list);
        for(Object o1 : list){
            System.out.println(o1);
        }
        Collections.sort(list);
        Collections.reverse(list);

        Iterator i1 =list.iterator();
        while (i1.hasNext()){
            System.out.println(i1.next());
        }





    }

}
