package Task2;

import java.io.*;
import java.nio.file.Files;

public class Task2 {
    public static void main(String[] args) {
        createImg();
    }

    public static void createImg() {
        File file = new File(System.getProperty("user.dir") + File.separator, "1.PNG");
        System.out.println(file.getAbsolutePath());
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            File fileOut = new File(System.getProperty("user.dir") + File.separator, "2.PNG");
            fileOut.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(fileOut);
            outputStream.write(buffer);
            outputStream.close();

            System.out.println("Файл создан");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
