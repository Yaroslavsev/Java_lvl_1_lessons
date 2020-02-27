package lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(fullName + " | " + position + " | " + email + " | " + telephone + " | " + salary + " | " + age);
    }

    public int getAge() {
        return age;
    }

}
