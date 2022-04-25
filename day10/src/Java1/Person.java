package Java1;

import java.io.Serializable;

/**
 * Person需要满足如下的要求，方可序列化
 * 1.需要实现接口 Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外,还必须保证内部
 *   所有属性也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 * 4. ObjectOutputStream和ObjectInputStream
 *    不能序列化static和transient修饰的成员变量
 *
 * @author shkstart
 * @create 2021-12-21 14:06
 */
public class Person implements Serializable{

    public static final long serialVersionUID = 4325254313L;

    private String name;
    private int age;
    private int id;
    private Account acct;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id, Account acct) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.acct = acct;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", acct=" + acct +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

class Account implements Serializable{

    public static  final  long serialVersionUID = 234252412L;

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
