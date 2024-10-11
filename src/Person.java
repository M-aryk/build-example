import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) return OptionalInt.of(age);
        return OptionalInt.empty();
    }

    public String getAddress() {
        String result = "";
        if (hasAddress()) {
            result = address;
        }
        return result;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age += 1;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        childBuilder.setAge(0);
        childBuilder.setAddress(this.address);
        return childBuilder;

    }

    @Override
    public String toString() {
        return name + " " + surname + " (возраст: " + age + ", адрес: " + address + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}

