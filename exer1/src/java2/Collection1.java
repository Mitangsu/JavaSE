package java2;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author shkstart
 * @create 2022-01-14 16:29
 */
public class Collection1 {
    @Test
    public void test1() {
        Stream.iterate(0,t -> t+2).limit(5).forEach(System.out::println);

    }


    }

