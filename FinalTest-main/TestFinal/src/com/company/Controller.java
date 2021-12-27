package com.company;

import java.util.Scanner;

public class Controller {

    public static User test = new User();
    public static Scanner sc = new Scanner(System.in);

    public static void instruction() {
        System.out.println("Hãy chọn hành động: ");
        System.out.println("\t 1 - Đăng nhập");
        System.out.println("\t 2 - Đăng ký");
    }
    public static void runApp() {
        instruction();
        int choice;
        while (true) {
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> logIn();
                case 2 -> register();
            }
        }
    }
    public static void logIn() {
        boolean checkID = false;
        boolean checkPass = false;
        String ID;
        String pass;
        int index = 0;

        while (!checkID) {
            System.out.println("Nhập ID:");
            ID = sc.nextLine();
            if (!test.checkValidUser(ID)) {

                index++;
                while (!checkPass) {
                    System.out.println("Nhập mật khẩu:");
                    pass = sc.nextLine();
                    if (test.getUserList().get(index - 1).getPass().equals(pass)) {
                        checkPass = true;
                        System.out.println("Chào mừng " + ID + ", bạn có thể thực hiện các công việc sau:");
                        logInSucessChoice(index-1);
                    } else {
                        System.out.println("Mật khẩu sai");
                        System.out.println("\t 1 - Nhập lại mật khẩu.");
                        System.out.println("\t 2 - Quên mật khẩu.");
                        int choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                break;
                            case 2:
                                System.out.println("Nhập email để tìm kiếm");
                                String recoverEmail = sc.nextLine();
                                for (User i : test.getUserList()) {
                                    if (i.getEmail().equals(recoverEmail)) {
                                        System.out.println("Nhập mật khẩu mới:");
                                        i.setPass(sc.nextLine());
                                        System.out.println("Đăng nhập lại.");
                                        logIn();
                                    } else {
                                        System.out.println("Không tồn tại email này.");
                                        System.out.println("Kết thúc!");
                                        runApp();
                                    }
                                }
                                break;
                        }
                    }

                }
                checkID = true;
                runApp();
            }
        }

    }

    public static void register() {

        boolean checkID = false;
        boolean checkPass = false;
        boolean checkEmail = false;
        String ID = null;
        String pass = null;
        String email = null;

        while (!checkID) {
            System.out.println("Nhập username đăng ký: ");
            ID = sc.nextLine();
            if (test.checkValidUser(ID)) {
                checkID = true;
            } else {
                System.out.println("ID đã tồn tại!");
            }
        }

        while (!checkPass) {
            System.out.println("Nhập mật khẩu đăng ký: ");
            pass = sc.nextLine();
            if (CheckPass.isPassValid(pass)) {
                checkPass = true;
            } else {
                System.out.println("Mật khẩu sai định dạng");
                System.out.println("(Mật khẩu phải có 7-15 ký tự, ít nhất 1 ký tự đặc biệt (@,!,$,..) và ít nhất một chữ cái viết hoa.");
            }
        }

        while (!checkEmail) {
            System.out.println("Nhập email đăng ký: ");
            email = sc.nextLine();
            if (CheckEmail.isEmailValid(email)) {
                checkEmail = true;
            } else {
                System.out.println("Email sai định dạng");
            }
        }

        test.addUser(new User(ID, email, pass));
//        System.out.println(test.getUserList());
        runApp();
    }


    public static void logInSucessChoice(int index) {
        boolean quit = false;
        int choice;
        System.out.println("\t 1 - Thay đổi username.");
        System.out.println("\t 2 - Thay đổi email.");
        System.out.println("\t 3 - Thay đổi mật khẩu.");
        System.out.println("\t 4 - Đăng xuất.");
        System.out.println("\t 0 - Thoát chương trình.");
        while (!quit) {
            System.out.println("Chọn tác vụ: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhập ID mới: ");
                    String newID = sc.nextLine();
                    if (test.checkValidUser(newID)) {
                        test.getUserList().get(index).setUsername(newID);
                    } else {
                        System.out.println("ID đã tồn tại.");
                    }
                }
                case 2 -> {
                    System.out.println("Nhập email mới: ");
                    String newEmail = sc.nextLine();
                    if (CheckEmail.isEmailValid(newEmail)) {
                        test.getUserList().get(index).setEmail(newEmail);
                        System.out.println("Thay đổi email thành công");
                    } else {
                        System.out.println("Email sai định dạng.");
                    }
                }
                case 3 -> {
                    System.out.println("Nhập mật khẩu mới: ");
                    String newPass = sc.nextLine();
                    if (CheckPass.isPassValid(newPass)) {
                        test.getUserList().get(index).setPass(newPass);
                    } else {
                        System.out.println("Mật khẩu sai định dạng.");
                    }
                }
                case 4 -> runApp();
                case 0 -> {
                    quit = true;
                    System.out.println("Xin chào tạm biệt!");
                }
            }
        }
    }


}
