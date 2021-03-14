package yuxing;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author djl
 * @create 2021/3/14 17:33
 */
public class ReflectionTest {
    public static void main(String[] args) {
        // 我想直接读取Person类型的所有字段信息???

        // Person.class 意思是:拿到Person的类型

        // Person.class.getDeclaredFields() 获取Person的类型的定义的字段信息啊

        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType());
        }

        // 这个就是反射嘛

        System.out.println("------------------");

        Method[] methods = DuPerson.class.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            Parameter[] methodParameters = method.getParameters();
            System.out.println("methodName = " + methodName);
            System.out.println("methodParameters = " + methodParameters);
        }
    }
}
