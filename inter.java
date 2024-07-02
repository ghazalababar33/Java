/*interface Animal {
    void makeSound();
    default void eat() {
        System.out.println("Animal is eating.");
    }
    static void sleep() {
        System.out.println("Animal is sleeping.");
    }
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
*/
public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                this.day < compared.day) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}

interface PersonInterface {
    String getName();
    int getHeight();
    SimpleDate getBirthday();
    boolean olderThan(PersonInterface compared);
}

public class Person implements PersonInterface {
    private String name;
    private SimpleDate birthday;
    private int weight = 0;
    private int height = 0;

    public Person(String name, SimpleDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.birthday = new SimpleDate(day, month, year);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public SimpleDate getBirthday() {
        return this.birthday;
    }

    @Override
    public boolean olderThan(PersonInterface compared) {
        return this.birthday.before(compared.getBirthday());
    }

    @Override
    public String toString() {
        return this.name + ", born on " + this.birthday;
    }

    public static void main(String[] args) {
        SimpleDate date = new SimpleDate(1, 1, 780);
        Person muhammad = new Person("Muhammad ibn Musa al-Khwarizmi", date);
        Person pascal = new Person("Blaise Pascal", 19, 6, 1623);

        System.out.println(muhammad);
        System.out.println(pascal);

        if (muhammad.olderThan(pascal)) {
            System.out.println(muhammad.getName() + " is older than " + pascal.getName());
        } else {
            System.out.println(muhammad.getName() + " is not older than " + pascal.getName());
        }

        SimpleDate d1 = new SimpleDate(14, 2, 2011);
        SimpleDate d2 = new SimpleDate(21, 2, 2011);
        SimpleDate d3 = new SimpleDate(1, 3, 2011);
        SimpleDate d4 = new SimpleDate(31, 12, 2010);

        System.out.println(d1 + " is earlier than " + d2 + ": " + d1.before(d2));
        System.out.println(d2 + " is earlier than " + d1 + ": " + d2.before(d1));

        System.out.println(d2 + " is earlier than " + d3 + ": " + d2.before(d3));
        System.out.println(d3 + " is earlier than " + d2 + ": " + d3.before(d2));

        System.out.println(d4 + " is earlier than " + d1 + ": " + d4.before(d1));
        System.out.println(d1 + " is earlier than " + d4 + ": " + d1.before(d4));
    }
}
