package java1;

import java.util.Arrays;

/**
 * 使用enum关键字自定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 * @author shkstart
 * @create 2021-12-13 15:03
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString:
        System.out.println(summer.toString());

        //values():
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));

        //valueOf(String objName):返回枚举类中对象名是objName的对象.
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        System.out.println(winter);
        winter.show();

    }

}
    interface info{
    void show();
    }
    //使用enum关键字枚举类
    enum Season1 implements info{
        //1.提供当前枚举类的对象，多个对象之间用逗号“,”隔开，末尾对象";"结束
         SPRING("春天","春暖花开"){
            @Override
            public void show() {
                System.out.println("这是个春天");
            }
        },
         SUMMER("夏天","夏日炎炎"){
             @Override
             public void show() {
                 System.out.println("这是个夏天");
             }
         },
         AUTUMN("秋天","秋高气爽"){
             @Override
             public void show() {
                 System.out.println("这是个秋天");
             }
         },
         WINTER("冬天","冰天雪地"){
             @Override
             public void show() {
                 System.out.println("这是个冬天");
             }
         };


        //声明Season1对象的属性:private final修饰
        private final String sensonName;
        private final String sensonDesc;


        //1.私有化类的构造器,并给对象属性赋值

        private Season1(String sensonName,String sensonDesc){
            this.sensonName = sensonName;
            this.sensonDesc = sensonDesc;
        }


        //4.其他诉求：获取枚举类对象的属性


        public String getSensonName() {
            return sensonName;
        }

        public String getSensonDesc() {
            return sensonDesc;
        }
//        //5.其他诉求1:提供toString()
//
//        @Override
//        public String toString() {
//            return "Season{" +
//                    "sensonName='" + sensonName + '\'' +
//                    ", sensonDesc='" + sensonDesc + '\'' +
//                    '}';
//        }

//        @Override
//        public void show() {
//            System.out.println("这是一个季节");
//        }

    }

