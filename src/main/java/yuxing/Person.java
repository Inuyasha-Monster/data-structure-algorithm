package yuxing;

import java.util.Objects;

/**
 * @author djl
 * @create 2021/3/14 15:30
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {

        int hash = Objects.hash(age, name);
        System.out.println("hash = " + hash);
        return hash;

//        int hashcode = age & this.name.hashCode(); // 我用年龄与name的散列码做一个与操作,与操作是什么?是真真为真
//
//        // hashcode 这个值越随机越好,可以做到分布的很均匀,为什么要分布均匀?设计到hashmap的空间利用率!
//        System.out.println("hashcode = " + hashcode);
//        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        // 如果它是Person
        if (obj instanceof Person) {
            Person person = (Person) obj;
            // 具有相同的age和name的时候才认为两个Person相等
            return person.age == this.age && person.name.equals(this.name);
        }

        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
