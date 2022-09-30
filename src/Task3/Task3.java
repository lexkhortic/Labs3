package Task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class Task3 {
    public static void main(String[] args) {
        String dirTemp = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "Task3"
                + File.separator + "Temp" + File.separator;
        File fileTemp = new File(dirTemp);
        String[] nameAllFiles = fileTemp.list();

        assert nameAllFiles != null;
        File file = new File(dirTemp, nameAllFiles[0]);
        try {
            completedAction(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void completedAction(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите вашу фамилию: ");
        StringBuilder surname = new StringBuilder(reader.readLine());
        File fileCopy = new File(System.getProperty("user.dir")+ File.separator + "src" + File.separator + "Task3"
                + File.separator + "User_photos" + File.separator, surname + ".PNG");

        int count = 1;
        while (fileCopy.exists()) {
            surname.append(count);
            fileCopy = new File(System.getProperty("user.dir")+ File.separator + "src" + File.separator + "Task3"
                    + File.separator + "User_photos" + File.separator, surname + ".PNG");
            count++;
        }

        Files.copy(file.toPath(), fileCopy.toPath());
        file.delete();
    }
}
