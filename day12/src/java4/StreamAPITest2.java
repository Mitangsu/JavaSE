package java4;

import java3.Employee;
import java3.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 * @author shkstart
 * @create 2021-12-26 9:05
 */
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
//        allMatch(Predicate p) 检查是否匹配所有元素
//        练习：是否所有的员工过的年龄都大于18
            boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
            System.out.println(b);
//        anyMatch(Predicate p) 检查是否至少匹配一个元素
//        练习：是否存在员工的工资大于10000
            boolean b1 = employees.stream().anyMatch(s -> s.getSalary() > 10000);
            System.out.println(b1);

//        noneMatch(Predicate p) 检查是否没有匹配所有元素
//        练习：是否有姓雷的
            boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
            System.out.println(noneMatch);

//        findFirst() 返回第一个元素
            Optional<Employee> first = employees.stream().findFirst();
            System.out.println(first);

//        findAny() 返回当前流中的任意元素
            Optional<Employee> any = employees.parallelStream().findAny();
            System.out.println(any);

//        count() 返回流中元素总数
            long count = employees.stream().filter(e ->e.getSalary()>5000).count();
            System.out.println(count);

//        max(Comparator c) 返回流中最大值
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        System.out.println(doubleStream.max(Double::compare));

//        min(Comparator c) 返回流中最小值
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);


//        forEach(Consumer c)-内部迭代
        employees.stream().forEach(System.out::println);
        //使用集合的遍历操作
        employees.forEach(System.out::println);

    }
    //2-规约
    @Test
    public void test5(){
//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一 个值。返回 T
            List<Integer> lsit = Arrays.asList(1,3,4,6,7,78,86,5,1,45);
            Integer reduce = lsit.stream().reduce(0, Integer::sum);
            System.out.println(reduce);


//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一 个值。返回 Optional<T>
            List<Employee> employees = EmployeeData.getEmployees();
            Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
            Optional<Double> sumMoney = doubleStream.reduce((d1,d2) ->d1+d2);//(Double::sum)
            System.out.println(sumMoney);

    }
    //3-收集
    @Test
    public void test6(){
//        collect(Collector c) 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总 的方法
//          练习1：查询工资大于6000的员工,结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println();

        List<Employee> employeess = EmployeeData.getEmployees();
        Set<Employee> employeesss = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeesss.forEach(System.out::println);
    }
    }
