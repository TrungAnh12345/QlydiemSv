package Runsystem;

import File.DataUtil;
import File.FileData;
import Service.ScoreStudentService;
import Service.StudentManipulation;
import Service.SubjectService;
import Unit.ScoreStudent;
import Unit.Student;
import Unit.Subject;
import constant.SubjectType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Student [] students ;
    public static Subject [] subjects ;
    public static ScoreStudent [] scoreStudents ;

    public static FileData fileUtil = new FileData();
    public static void initlizeData(){
        Object subjectFromFile = fileUtil.readData(SubjectService.SUBJECT_DATAFILE);
        Main.subjects = DataUtil.isNullOrEmpty(subjectFromFile) ? new Subject[200] : (Subject[]) subjectFromFile;

        Object studentFromFile = fileUtil.readData(StudentManipulation.STUDENT_DATA_FILE) ;
        Main.students = DataUtil.isNullOrEmpty(studentFromFile) ? new Student[200] : (Student[]) studentFromFile;

        Object scoreFromFile = fileUtil.readData(ScoreStudentService.SCORESTUDENT_DATA_FILE);
        Main.scoreStudents = DataUtil.isNullOrEmpty(scoreFromFile)? new ScoreStudent[200] : (ScoreStudent[]) scoreFromFile;
    }

    public static void main(String[] args) {
        initlizeData();
        ScoreStudentService scoreStudentService = new ScoreStudentService();
        boolean isContinue = true;
        StudentManipulation studentManipulation = new StudentManipulation();
        SubjectService subjectService = new SubjectService();
        do {
            System.out.println("Nhập vào các chức năng bạn muốn thực hiện:");
            System.out.println("1: Nhập vào thông tin sinh viên");
            System.out.println("2: HIển thị ra màn hình thông tin sinh viên");
            System.out.println("3: Nhập vào thông tin môn học");
            System.out.println("4: Hiển thị ra thông tin môn học");
            System.out.println("5: Nhập điểm cho sinh viên và in ra danh sách");
            System.out.println("6: Sắp xếp theo họ tên sinh viên");
            System.out.println("7: Sắp xếp theo tên môn học");
            System.out.println("8: Tính điểm tổng kết chung cho sinh viên");
            System.out.println("10: Thoát");
            int choice = 0;
            boolean check2 = false;
            while (!check2) {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice > 0) {
                        break;
                    }
                    System.out.println("Số nhập vào phải dương");
                } catch (InputMismatchException e) {
                    System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                    new Scanner(System.in).next();
                }
            }
            switch (choice){
                //0985445471

                case 1:
                    studentManipulation.input();
                    System.out.println("Nhập thành công");
                    break;
                case 2:
                    studentManipulation.output();
                    break;
                case 3: subjectService.input();
                break;
                case 4: subjectService.output();
                break;
                case 5: scoreStudentService.countScoreStudent();
                scoreStudentService.showScoreStudent();
                break;
                case 6: scoreStudentService.sortByNameStudent();
                break;
                //0222222222
                case 7: scoreStudentService.sortBySubjectName();
                break;
                case 8:scoreStudentService.totalScoreStudent();
                break;
                case 9:
                    scoreStudentService.showScoreStudent();
                    break;
                case 10:
                    isContinue = false;
                    break;
            }
        }while (isContinue);
        System.out.println();

    }

}
