package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementDemo {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        pool:while (true) {
            System.out.println("----------------欢迎来到学生管理系统------------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入您的选择：");
            //键盘输入选择
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            //根据选择跳转选项
            switch (choose){
                case "1" : addStudent(list);break;
                case "2" : deleteStudent(list);break;
                case "3" : updateStudent(list);break;
                case "4" : queryStudent(list);break;
                case "5" : System.out.println("退出");break pool;//System.exit(0);
                default :
                    System.out.println("没有此选项，请重新输入！");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        //学生id
        System.out.println("请输入学生id：");
        String id = sc.next();
        //学生姓名
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        //学生年龄
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        //学生地址
        System.out.println("请输入学生地址：");
        String address = sc.next();
        Student stu = new Student(id,name,age,address);
        list.add(stu);
        System.out.println("学生信息添加成功!");
    }
    //删除学生
    public static void deleteStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id：");
        String id = sc.next();
        if(!isExistId(list,id)){
            System.out.println(id+"不存在！");
        }
        else{
            list.remove(getIndexId(list,id));
            System.out.println("删除成功！");
        }
    }
    //修改学生
    public static void updateStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        String id = sc.next();
        if(!isExistId(list,id)){
            System.out.println(id+"不存在！");
        }
        else{
            System.out.println("请输入新的学生姓名");
            list.get(getIndexId(list,id)).setName(sc.next());
            System.out.println("请输入新的学生年龄");
            list.get(getIndexId(list,id)).setAge(sc.nextInt());
            System.out.println("请输入新的学生地址");
            list.get(getIndexId(list,id)).setAddress(sc.next());
            System.out.println("修改成功！");
        }
    }
    //查询学生
    public static void queryStudent(ArrayList<Student> list){
        if (list.isEmpty()){
            System.out.println("当前无学生信息，请添加后再查询！");
        }
        else{
            System.out.println("id\t\t\t姓名\t\t\t\t年龄\t\t\t\t家庭住址");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getAge()+"\t"+list.get(i).getAddress());
            }
        }
    }
    public static Boolean isExistId(ArrayList<Student> list,String id){
        return getIndexId(list,id)>=0;
    }
    public static int getIndexId(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
