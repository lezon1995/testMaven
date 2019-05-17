package cn;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

import java.io.*;

public class Traverse {
    static int fileNum = 0;
    static int dirNum = 0;

    public static void main(String[] args) throws Exception {
//        String dirName = "D:\\boc\\bankbrain-mini\\src";
        String dirName = "D:\\taifungbank\\bankbrain-mini\\src";
        traverseFolder2(dirName);
        System.out.println("文件一共" + fileNum);
        System.out.println("文件夹一共" + dirNum);
    }

    static void traverseFolder2(String path) throws Exception {
        String srcDir = "D:\\taifungbank\\";
        String targetDir = "E:\\taifungbank\\";
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        dirNum++;
                        String replace = file2.getAbsolutePath().replace(srcDir, targetDir);
                        File file1 = new File(replace);
                        if (!file1.exists()) {
                            file1.mkdirs();
                        }
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        //TODO 将文件中所有的java properties xml sql js的简体全部转为繁体
                        if (file2.getName().endsWith(".java") ||
                                file2.getName().endsWith(".properties") ||
                                file2.getName().endsWith(".xml") ||
                                file2.getName().endsWith(".sql") ||
                                file2.getName().endsWith(".js")) {
                            FileWriter fileWriter = new FileWriter(file2.getAbsolutePath().replace(srcDir, targetDir));
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                        FileReader fileReader = new FileReader(file2);
//                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                            String fileContent = readToString(file2);
                            String traditionalFileContent = ZhConverterUtil.convertToTraditional(fileContent);
                            bufferedWriter.write(traditionalFileContent);
                            bufferedWriter.flush();
                            System.out.println("文件:" + file2.getAbsolutePath() + "转换完成");
                            fileNum++;
                            bufferedWriter.close();
                        } else {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2.getAbsolutePath().replace(srcDir, targetDir)));
                            byte[] bytes = new byte[(int) file2.length()];
                            bufferedInputStream.read(bytes);
                            bufferedOutputStream.write(bytes);
                            bufferedOutputStream.flush();
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            System.out.println("文件:" + file2.getAbsolutePath() + "转换完成");
                            fileNum++;
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }


    public static String readToString(File file) {
        String encoding = "UTF-8";
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
}
