package java2;

/**
 * @author shkstart
 * @create 2021-12-24 2:43
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){

    }

    @MyAnnotation(value = "abc")
    public Person(String name) {
        this.name = name;
    }

     Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;


    }

    public String display(String interests,int age)throws NullPointerException,ClassCastException{
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");

    }

    private static void show1(){
        System.out.println("我是个可爱的人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
