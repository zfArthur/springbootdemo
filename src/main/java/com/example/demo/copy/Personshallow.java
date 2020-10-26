package com.example.demo.copy;

import lombok.Data;

/**
 * @Author zhangfu
 * @Date 2020-10-13 18:32
 */
@Data
public class Personshallow implements Cloneable {
//    // 姓名
//    private String name;
//    // 年龄
//    private int age;
//    // 邮件
//    private String email;
//
//    // 将原来的 string desc 变成了 PersonDesc 对象，这样 personDesc 就是引用类型
//    private PersonDesc personDesc;
//
//    public void setDesc(String desc) {
//        this.personDesc.setDesc(desc);
//    }
//    public Personshallow(String name, int age, String email, String desc) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.personDesc = new PersonDesc();
//        this.personDesc.setDesc(desc);
//    }
//    /*
//     * 重写 clone 方法，需要将权限改成 public ，直接调用父类的 clone 方法就好了
//     */
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}

// 新增 PersonDesc
@Data
class PersonDesc {
    // 描述
    private String desc;


}
