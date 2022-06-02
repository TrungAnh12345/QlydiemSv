package Service;

import Actions.Manipulation;
import Runsystem.Main;
import Unit.Subject;
import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectService implements Manipulation {

    @Override
    public void input() {
        System.out.println("Nhập thông tinn môn học");
        System.out.println("Nhập số môn học muốn thêm");
        int number = 0;
        boolean check2 = false;
        while (!check2){
            try{
                number = new Scanner(System.in).nextInt();
                if(number > 0){
                    break;
                }
                System.out.println("Số môn học phải dương");
            }catch (InputMismatchException e){
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }
        for (int i = 0; i < number;i++){
            Subject subject = new Subject();
            subject.inputInfo();
            add(subject);
        }

    }
    public void add(Subject subject){
        for (int i = 0; i < Main.subjects.length; i++){
            if(Main.subjects[i] == null){
                Main.subjects[i] = subject;
                break;
            }

        }
    }

    @Override
    public void output() {

        for (int i = 0; i < Main.subjects.length; i++){
            if(Main.subjects[i] == null){
                continue;
            }
            System.out.println(Main.subjects[i]);
        }

    }


}
