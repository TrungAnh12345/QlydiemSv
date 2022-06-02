package Service;

import Runsystem.Main;
import Actions.Manipulation;
import Unit.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManipulation implements Manipulation {

    @Override
    public void input() {
        System.out.println("NHập số sinh viên muốn nhập");
        int numberS = 0;
        boolean check2 = false;
        while (!check2){
            try{
                numberS = new Scanner(System.in).nextInt();
                if(numberS > 0){
                    break;
                }
                System.out.println("Số sinh viên phải dương");
            }catch (InputMismatchException e){
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }
        for (int i = 0; i < numberS; i++){
            Student student = new Student();
            System.out.println("Nhập thông tin sinh viên");
            student.inputInfo();
            add(student);
        }


    }
    public void add(Student student){
        for (int i = 0; i < Main.students.length; i++){
            if(Main.students[i] == null){
                Main.students[i] = student;
                return;
            }

        }
    }
    @Override
    public void output() {

        for(int i = 0;i < Main.students.length; i++){
            if(Main.students[i] ==  null){
                continue;
            }
            System.out.println(Main.students[i]);
        }
    }


}
