package Unit;

import Runsystem.Main;
import constant.SubjectType;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable {
    private static int AUTO_ID = 100;
    SubjectType subjectType;
    private int id;
    private String nameSubject;

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    private int dvht;

    public Subject() {
        id = AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getDvht() {
        return dvht;
    }

    public void setDvht(int dvht) {
        this.dvht = dvht;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectType=" + subjectType +
                ", id=" + id +
                ", nameSubject='" + nameSubject + '\'' +
                ", dvht=" + dvht +
                '}';
    }

    public void inputInfo(){

        System.out.println("Nhập tên môn học");
        this.nameSubject = new Scanner(System.in).nextLine();
        System.out.println("Nhập đơn vị học trình");

        boolean check2 = false;
        while (!check2){
            try{
                this.dvht = new Scanner(System.in).nextInt();
                if(this.dvht > 0){
                    break;
                }
                System.out.println("Số nhập vào phải dương");
            }catch (InputMismatchException e){
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }
        System.out.println(this.dvht);
        boolean check = false;
        System.out.println("Nhập loại môn");
        System.out.println("1: Đại cương");
        System.out.println("2: cơ sở ngành");
        System.out.println("3: Chuyên ngành");

        while (!check){
            try{
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    this.subjectType = SubjectType.DAI_CUONG;
                    break;
                }
                else if(choice == 2){
                    this.subjectType = SubjectType.CO_SƠ_NGANH;
                    break;
                }
                else if(choice == 3){
                    this.subjectType = SubjectType.CHUYEN_NGANH;
                    break;
                }
                System.out.println("Số nhập vào phải khớp 1 trong 3 điều kiện trên");
            }catch (Exception e){
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }

    }
    public static boolean isEmpty(){
        for(int i = 0; i < Main.subjects.length; i++){
            if(Main.subjects[i] != null){
                return false;
            }
        }
        return true;
    }

    public int compareTo(Subject subject){
        if(this.id < subject.getId()){
            return 1;
        }
        else if(this.id > subject.getId()){
            return -1;
        }
        return 0;
    }
}
