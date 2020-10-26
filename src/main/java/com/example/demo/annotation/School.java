package com.example.demo.annotation;

/**
 * @Author zhangfu
 * @Date 2020-10-26 13:59
 */
public class School {
    private Teacher teacher;
    private Student student;
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void setStudent(Student student){
        this.student = student;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public Student getStudent(){
        return student;
    }
    public String toString(){
        System.out.println(teacher);
        return teacher + "\n" + student;
    }
}
