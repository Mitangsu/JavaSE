import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author shkstart
 * @create 2022-01-14 7:57
 */
public class DateTimeFormatter {
    @Test
    public void test1() {

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
    */
//    方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化: 日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = formatter.format(localDateTime);
        System.out.println(format);
        System.out.println(localDateTime);

        //解析: 字符串 -->日期
        TemporalAccessor parse = formatter.parse("2022-01-14T07:58:49.462");
        System.out.println(parse);


//    方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        java.time.format.DateTimeFormatter formatter1 = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format1 = formatter1.format(localDateTime);
        System.out.println(format1);


//    重点：方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        String format2 = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format2);

        TemporalAccessor parse1 = dateTimeFormatter.parse("2022-01-14 08:06:53");
        System.out.println(parse1);


    }

    @Test
    public void test2() {

        StringBuffer stringBuffer = new StringBuffer("ss");
        System.out.println(stringBuffer);
    }
}
