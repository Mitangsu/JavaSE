package exer1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-12-18 16:19
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File file1 = new File(file.getParent(),"haha.txt");
            boolean newFile = file1.createNewFile();
            if (newFile){
            System.out.println("创建成功");
        }
        file1.delete();
    }
}
