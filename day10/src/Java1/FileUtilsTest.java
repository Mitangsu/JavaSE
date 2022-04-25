package Java1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-12-21 18:00
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile = new File("day10\\美味.jpg");
        File destsrcFile = new File("day10\\美味2.jpg");

        try {
            FileUtils.copyFile(srcFile,destsrcFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
