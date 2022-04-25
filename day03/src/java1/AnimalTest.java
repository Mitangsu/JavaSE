package java1;

/**
 * @author shkstart
 * @create 2021-12-10 9:13
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal test = new Animal();
        test.yy(new Dog());
        test.yy(new Cat());
    }


}


class Animal {
    public void yy(Animal animal){
        animal.eat();
        animal.work();

    }



    public void eat() {
        System.out.println("吃饭");
    }

    public void work() {
        System.out.println("工作");
    }
}

class Dog extends Animal{
    public void eat() {
        System.out.println("吃骨头");
    }

    public void work() {
        System.out.println("汪~");
    }
}

class Cat extends Animal{
    public void eat() {
        System.out.println("吃鱼");
    }

    public void work() {
        System.out.println("喵~");
    }
}