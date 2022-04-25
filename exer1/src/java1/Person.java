package java1;

/**
 * @author shkstart
 * @create 2021-12-30 11:28
 */
public class Person {


    private String name;
    private int age;



    public void eat(){
        System.out.println("吃川菜");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
