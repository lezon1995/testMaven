package work;

import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*

 */
public class FileDe {

    public static void main(String[] args) throws Exception {

        try (BufferedReader fileReader = new BufferedReader(new FileReader("E:\\github\\testMaven\\mavenTest\\src\\main\\java\\work\\2.txt"))) {
            String srcDir = "E:\\github\\unity\\ET";
            String desDir = "E:\\github\\unity\\indie\\indie_game_dev\\Server\\Model\\";
            String line = fileReader.readLine();
            while (line != null) {
                String[] split = line.split(" Link");
                String str = "Include=";
                String srcFile = split[0].substring(split[0].indexOf(str) + str.length());

//                System.out.println(srcFile);
                String desFile = split[1].substring(1, split[1].length() - 3);
//                System.out.println(desFile);
                String sourceFile = srcDir + srcFile;
//                System.out.println(sourceFile);
//        File file = new File(sourceFile);
//        System.out.println(file.getAbsolutePath());
                FileCopyUtils.copy(new File(sourceFile), new File(desDir + desFile));
                System.out.println("复制成功 --" + sourceFile);
                line = fileReader.readLine();
            }

        }

    }
}
