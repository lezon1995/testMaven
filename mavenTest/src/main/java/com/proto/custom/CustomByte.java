package com.proto.custom;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class CustomByte {

    public static void main(String[] args) throws Exception {
        int id = 123456789;
        int age = 20;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(int2byte(id));
        System.out.println(Arrays.toString(int2byte(id)));
        outputStream.write(int2byte(age));
        System.out.println(Arrays.toString(int2byte(age)));
        byte[] bytes = outputStream.toByteArray();
        System.out.println(Arrays.toString(bytes));


        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        byte[] idByte = new byte[4];
        inputStream.read(idByte);
        System.out.println(Arrays.toString(idByte));
        System.out.println("id:"+byte2int(idByte));

        byte[] ageByte = new byte[4];
        inputStream.read(ageByte);
        System.out.println(Arrays.toString(ageByte));
        System.out.println("age:"+byte2int(ageByte));
    }

    static byte[] int2byte(int i) {
        byte[] b = new byte[4];
        b[0] = (byte) (i >> 3 * 8);
        b[1] = (byte) (i >> 2 * 8);
        b[2] = (byte) (i >> 1 * 8);
        b[3] = (byte) (i >> 0 * 8);
        return b;
    }

    static int byte2int(byte[] b) {
        int i = ((b[0] << 3 * 8) |
                (b[1] << 2 * 8) |
                (b[2] << 1 * 8) |
                (b[3] << 0 * 8)&255);
        return i;
    }
    public static int getUnsignedInt (int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
        return data&127;
    }
}
