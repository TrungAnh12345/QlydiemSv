package Service;

import Runsystem.Main;
import Unit.ScoreOfSubject;
import Unit.ScoreStudent;
import Unit.Student;
import Unit.Subject;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScoreStudentService {
    public static final String SCORESTUDENT_DATA_FILE = "scorestudent.dat";

    public void countScoreStudent(){
        if(Subject.isEmpty() || Student.isEmptyStudent()){
            System.out.println("Môn học và sinh viên hiện đang trống");
            return;
        }
        addScoreOfStudents();
        Main.fileUtil.writefileData(Main.scoreStudents, SCORESTUDENT_DATA_FILE);

    }
    public Student inputStudent(){
        Student student = null;
        System.out.println("Nhập id sinh viên cần tính điểm");

        boolean check2 = false;
        do {
            int idSt = 0;
            while (!check2) {
                try {
                    idSt = new Scanner(System.in).nextInt();
                    if (idSt > 0) {
                        break;
                    }
                    System.out.println("Số nhập vào phải dương");
                } catch (InputMismatchException e) {
                    System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                    new Scanner(System.in).next();
                }
            }

            for (int j = 0; j < Main.students.length; j++) {
                if (Main.students[j] != null && Main.students[j].getId() == idSt) {
                    student = Main.students[j];
                    break;
                }
            }
            if (student != null) {
                break;
            }
            System.out.println("Không tìm thấy sinh viên với id vừa nhập");
        } while (true);
//        while (!check2){
//            try{
//                idSt = new Scanner(System.in).nextInt();
//                if(idSt > 0){
//                    break;
//                }
//                System.out.println("Mã id phải dương");
//
//                for(int j = 0 ; j < Main.students.length; j++){
//                        if(Main.students[j] != null && Main.students[j].getId() == idSt){
//                            student = Main.students[j];
//                            break;
//                        }
//                    }
//                if(student != null){
//                    break;
//                }
//                    System.out.println("Không tìm thấy sinh viên với id vừa nhập, nhan phim de nhap lai");
//            }catch (InputMismatchException e){
//                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
//                new Scanner(System.in).next();
//            }
//        }


        return student;
     }


     public ScoreOfSubject [] addSubjectToScore(){
         System.out.println("Nhập số môn cần tính điểm");
         int numberSubject = 0;
         boolean check2  = false;
         boolean check1  = false;
         boolean check3 = false;
         while (!check2){
             try{
                 numberSubject = new Scanner(System.in).nextInt();
                 if(numberSubject > 0){
                     break;
                 }
                 System.out.println("Số nhập vào phải dương");
             }catch (InputMismatchException e){
                 System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                 new Scanner(System.in).next();
             }

         }
         ScoreOfSubject [] scoreOfSubjects = new ScoreOfSubject[numberSubject];
         for(int i = 0; i < numberSubject; i++) {
             System.out.println("Nhập id cho môn thứ " + (i + 1) + " mà bạn muốn tính điểm");
             Subject subject = null;
             do {
                 int idSubject = 0;
                 while (!check1) {
                     try {
                         idSubject = new Scanner(System.in).nextInt();
                         if (idSubject > 0) {
                             break;
                         }
                         System.out.println("Số nhập vào phải dương");
                     } catch (InputMismatchException e) {
                         System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                         new Scanner(System.in).next();
                     }
                 }

                 for (int j = 0; j < Main.subjects.length; j++) {
                     if (Main.subjects[j] != null && Main.subjects[j].getId() == idSubject) {
                         subject = Main.subjects[i];
                         break;
                     }
                 }
                 if (subject != null) {
                     break;
                 }
                 System.out.println("Không tìm thấy môn vừa nhập");
             } while (true);

//                for (int k = 0; k < Main.scoreStudents.length; k++){
//                    if(Main.scoreStudents[i] != null && subject == Main.scoreStudents[i].getScoreOfSubjects()[i].getSubject()){
//
//                    }
//
//                }

                 System.out.println("Nhập điểm cho môn học");
                 float score = 0;
                 boolean checkScore = false;
                 while (!checkScore) {
                     try {
                         score = new Scanner(System.in).nextFloat();
                         if (score >= 0 && score <= 10) {
                             break;
                         }
                         System.out.println("Số nhập vào phải dương và không lớn hơn 10");
                     } catch (InputMismatchException e) {
                         System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                         new Scanner(System.in).next();
                     }
                 }
                 ScoreOfSubject scoreOfSubject = new ScoreOfSubject(subject, score);
                 for(int k = 0; k < scoreOfSubjects.length; k++){
                     if(scoreOfSubjects[k] == null){
                         scoreOfSubjects[k] = scoreOfSubject;
                         break;
                     }
                 }
            }
         return scoreOfSubjects;
     }
     public void addScoreOfStudents(){
        boolean check = false;

         System.out.println("Nhập vào số sinh viên muốn tính điểm");
         boolean check1 = false;
         int numberStudent = 0;
         while (!check1) {
             try {
                 numberStudent = new Scanner(System.in).nextInt();
                 if (numberStudent > 0) {
                     break;
                 }
                 System.out.println("Số nhập vào phải dương");
             } catch (InputMismatchException e) {
                 System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                 new Scanner(System.in).next();
             }
         }
        for (int i = 0;i < numberStudent;i++){
            Student student = inputStudent();
//            for(int j = 0; j < Main.scoreStudents.length; j++){
//
//                if(Main.scoreStudents[i] != null && Main.scoreStudents[i].getStudent().getId() == student.getId() && Main.scoreStudents[i].getScoreOfSubjects()== ){
//                    check = true;
//                    break;
//                }
//            }
//            if(check){
//                System.out.println("Sinh viên vừa nhập đã tồn tại trong hệ thống tính điểm");
//                continue;
//            }

            // kiểm tra trước khi lưu vào bảng điểm để ko bị trùng tên sinh viên và trùng tên môn học
            // Main
            ScoreOfSubject [] scoreOfSubjects = addSubjectToScore();
            ScoreStudent scoreStudent = new ScoreStudent(student, scoreOfSubjects);
//            for(int k = 0; k < Main.scoreStudents.length; k++){
//                if(Main.scoreStudents[i] != null &&scoreStudent.getStudent() == Main.scoreStudents[i].getStudent() && scoreStudent.getScoreOfSubjects()[i].getSubject() == Main.scoreStudents[i].getScoreOfSubjects()[i].getSubject()){
//                    System.out.println("Đã bị trùng sinh viên và môn học");
//                    check = true;
//                }
//            }
//            if(!check){
//                break;
//            }
//            for(int k = 0; k < Main.scoreStudents.length; k++){
//
//                if(Main.scoreStudents[k] != null  && scoreStudent.getStudent() != Main.scoreStudents[k].getStudent() || scoreStudent.getScoreOfSubjects()[k].getSubject() != Main.scoreStudents[k].getScoreOfSubjects()[k].getSubject()){
//                    check = true;
//                    break;
//                }
//            }
//            if (check){
//                System.out.println("bị trùng tên sinh viên và môn học");
//                continue;
//            }
            saveScoreStudent(scoreStudent);
        }
    }

    public void saveScoreStudent(ScoreStudent scoreStudent){
        for(int i = 0; i < Main.scoreStudents.length; i++){
            if(Main.scoreStudents[i] == null){
               Main.scoreStudents[i] = scoreStudent;
               return;
            }
        }
    }
    public void showScoreStudent(){
        for(int i = 0; i < Main.scoreStudents.length; i++){
            if(Main.scoreStudents[i] == null){
                continue;
            }
            System.out.println(Main.scoreStudents[i]);
        }
    }

    public void sortByNameStudent(){
        for(int i = 0; i < Main.scoreStudents.length - 1; i++){
            if(Main.scoreStudents[i] == null){
                continue;
            }
            for(int j = i + 1; j < Main.scoreStudents.length; j++){
                if(Main.scoreStudents[j] == null){
                    continue;
                }
                if(Main.scoreStudents[i].getStudent().compareTo(Main.scoreStudents[j].getStudent()) > 0){
                    ScoreStudent scoreStudent = Main.scoreStudents[i];
                    Main.scoreStudents[i] = Main.scoreStudents[j];
                    Main.scoreStudents[j] = scoreStudent;

                }
            }
        }
        showScoreStudent();
    }

    public void sortBySubjectName(){
        for (int i = 0; i < Main.scoreStudents.length; i++){
            if(Main.scoreStudents[i] == null){
                continue;
            }

            for(int j = i + 1; j < Main.scoreStudents.length; j++){
                if(Main.scoreStudents[j] == null){
                    continue;
                }
                if(Main.scoreStudents[i].getScoreOfSubjects() != null && Main.scoreStudents[i] != null && Main.scoreStudents[i].getScoreOfSubjects() != null && Main.scoreStudents[i].getScoreOfSubjects()[i].getSubject().compareTo(Main.scoreStudents[j].getScoreOfSubjects()[i].getSubject()) > 0){
                    ScoreStudent scoreStudent = Main.scoreStudents[i];
                    Main.scoreStudents[i] = Main.scoreStudents[j];
                    Main.scoreStudents[j] = scoreStudent;
                }
            }

        }
        showScoreStudent();
    }

    public void totalScoreStudent(){
        for (int i = 0; i < Main.scoreStudents.length; i++){
            if (Main.scoreStudents[i] != null && Main.scoreStudents[i].getScoreOfSubjects() != null && Main.scoreStudents[i].getStudent() != null) {
                System.out.println("Điểm của sinh viên " + Main.scoreStudents[i].getStudent().getId() + "là: " + Main.scoreStudents[i].totalScore());
            }
        }
    }




}
