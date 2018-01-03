package org.openhab.binding.magnetpoetry.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagnetpoetryUtil {

    public static List<String> readFile(String filepath) {
        List<String> content = new ArrayList<String>();
        File file = new File(filepath);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] linesplit = line.split(",");
                for (String str : linesplit) {
                    content.add(str);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return content;
    }

}
