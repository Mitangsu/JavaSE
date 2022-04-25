import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 * @author shkstart
 * @create 2021-12-12 17:33
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        //偏移量
        Date date = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date);//Fri Oct 08 00:00:00 CST 3920

    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
        说明：
            1.LocalDateTime相较于LocalDate、LocalTime，使用的频率要高
     */
    @Test
    public void test1() {
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime loclalTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(loclalTime);
        System.out.println(localDateTime);

        //of()：设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime of = LocalDateTime.of(2020, 10, 6, 17, 57, 23);
        System.out.println(of);

        //getXxx():获取相关属性
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());


        //更改：体现不可变性
        //withXxx():设置相关属性
        //当前天改成22天，原来定义不变:下面同理
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);


        LocalDateTime localDateTime1 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //添加plus
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //减去minus
        LocalDateTime localDateTime3 = localDateTime.minusHours(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

    }

    /*
    Instant的使用
    类似于 java.util.Date类


     */
    @Test
    public void test2() {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-12-12T10:44:46.608Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(6));
        System.out.println(offsetDateTime);//2021-12-12T18:44:21.520+08:00


        //toEpochMilli():获取对应的毫秒数：距离1970年1月1日0时0分0秒(UTC)开始的毫秒数 --->Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli():通过给定的毫秒数,获取Instant实例 -->Date(Long millis)
        Instant instant1 = Instant.ofEpochMilli(1639306098516L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
    */
//    方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    //格式化



//    方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)

//    重点：方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)


}
