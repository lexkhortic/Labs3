package Task1;

import java.io.File;
import java.util.Arrays;

public class General {
    public static void main(String[] args) {
        showDir();
    }

    public static void showDir(){
        File file = new File("D:\\");
        System.out.println(Arrays.toString(file.list()));

        String[] array = file.list();
        for (String el: array) {
            File fileTemp = new File("D:\\" + File.separator + el);
            System.out.println(Arrays.toString(fileTemp.list()));
        }

    }
}
