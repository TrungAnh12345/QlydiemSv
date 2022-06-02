package Unit;

import Runsystem.Main;

import java.util.Scanner;

public class Student extends Person {

    private static int AUTO_ID = 10000;
    private String className;

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "className='" + className + '\'' +
                ", id=" + id +
                '}';
    }

    private int id;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
        super();
        id = AUTO_ID++;
    }

    public Student(String fullName, String address, String phoneNumber, int AUTO_ID, String className) {
        super(fullName, address, phoneNumber);
        id = AUTO_ID++;
        this.AUTO_ID = AUTO_ID;
        this.className = className;
    }
    public void inputInfo(){
        super.inputInfo();
        System.out.println("Nhập tên lớp");
        this.className = new Scanner(System.in).nextLine();
    }
    public static boolean isEmptyStudent(){
        for(int i = 0; i < Main.students.length; i++){
            if(Main.students[i] != null)
            {
                return false;
            }
        }
        return true;
    }

    public int compareTo(Student student){
        if(this.id > student.getId()){
            return 1;
        }
        else if(this.id < student.getId()){
            return -1;
        }
        return 0;
    }

}
