package Unit;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person{
    private String fullName;
    private String address;
    private String phoneNumber;
    public Person() {
    }

    public Person(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public void inputInfo(){
        System.out.println("Nhập họ tên");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại");
        boolean check = false;
        Scanner sc = new Scanner(System.in);

//
//        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
//        Matcher matcher = pattern.matcher(this.phoneNumber);

        do {
                this.phoneNumber = sc.nextLine();
                if(isValidPhoneNo(this.phoneNumber)){
                    System.out.println("Số điện thoại hợp lệ");
                }
                else{
                    System.out.println("Số điện thoại ko hợp lệ, vui lòng nhập đúng định dạng");
                }
        }while (!isValidPhoneNo(this.phoneNumber));
    }
    public static boolean isValidPhoneNo(String str){
        Pattern ptn = Pattern.compile("(0-9)?[0-9][0-9]{9}");
        Matcher matcher = ptn.matcher(str);
        return (matcher.find()&&matcher.group().equals(str));

    }
}
