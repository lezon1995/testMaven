package com.proto;

import java.util.Arrays;

/**
 * protobuf学习
 * @author -琴兽-
 *
 */
public class PB2Bytes {

    public static void main(String[] args) throws Exception {
        byte[] bytes = toBytes();
        toPlayer(bytes);

    }

    /**
     * 序列化
     */
    public static byte[] toBytes(){
        //获取一个PBPlayer的构造器
        StudentModule.ProtoBufStudent.Builder builder = StudentModule.ProtoBufStudent.newBuilder();
        //设置数据
        builder.setName("张三").setAge(20).setGrade(50.5f);
        //构造出对象
        StudentModule.ProtoBufStudent student = builder.build();
        //序列化成字节数组
        byte[] byteArray = student.toByteArray();

        System.out.println(Arrays.toString(byteArray));

        return byteArray;
    }

    /**
     * 反序列化
     * @param bs
     * @throws Exception
     */
    public static void toPlayer(byte[] bs) throws Exception{

        StudentModule.ProtoBufStudent student = StudentModule.ProtoBufStudent.parseFrom(bs);

        System.out.println("grade:" + student.getGrade());
        System.out.println("age:" + student.getAge());
        System.out.println("name:" + student.getName());
    }
}
