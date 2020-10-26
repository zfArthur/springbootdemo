package com.example.demo.copy;

import lombok.Data;

import java.io.*;

/**
 * @Author zhangfu
 * @Date 2020-10-13 19:13
 */
@Data
public class PersonSerializable implements Serializable {
    private static final long serialVersionUID = 369285298572941L;
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;

    private PersonDescSerializable personDesc;

    public PersonSerializable clone() {
        PersonSerializable person = null;
        try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            person = (PersonSerializable) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }


    public void setPersonDesc(String desc) {
        this.personDesc.setDesc(desc);
    }
}
