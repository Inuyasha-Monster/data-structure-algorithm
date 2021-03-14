package yuxing;

/**
 * @author djl
 * @create 2021/3/14 17:05
 */
public class DuPerson extends Person {

    // 会java 会c#
    private String skill;

    public DuPerson(int age, String name, String skill) {
        super(age, name);
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "DuPerson{" +
                "skill='" + skill + '\'' +
                "} " + super.toString();
    }
}
