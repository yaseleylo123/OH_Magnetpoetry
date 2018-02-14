package org.openhab.binding.magnetpoetry.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;

import org.openhab.binding.magnetpoetry.MagnetpoetryBindingConstants;
import org.openhab.binding.magnetpoetry.elements.semantic.MpSemanticSimple;

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

    public static String getStatementByIdentifier(String identifier) {
        Properties prop = new Properties();
        String semantic = null;
        try {
            FileInputStream inputStream = new FileInputStream(
                    MagnetpoetryBindingConstants.SEMANTIC_STATEMENT_PROPERTIES);
            prop.load(inputStream);
            for (Entry<Object, Object> entry : prop.entrySet()) {
                if (entry.getKey().toString().equals(identifier)) {
                    semantic = entry.getValue().toString();
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return semantic;
    }

    public static HashMap<String, String> searchSemanticBySimpleSemantics(List<MpSemanticSimple> simpleSemantics) {
        Properties propInternal = new Properties();
        Properties propComprehensive = new Properties();
        HashMap<String, String> semanticIdentifierMap = new HashMap<String, String>();
        // TODO: map with identifier and needed simpleSemantics
        try {
            FileInputStream inputStreamInternal = new FileInputStream(
                    MagnetpoetryBindingConstants.SEMANTIC_INTERNAL_STATEMENT_PROPERTIES);
            FileInputStream inputStreamComprehensive = new FileInputStream(
                    MagnetpoetryBindingConstants.SEMANTIC_COMPREHENSIVE_STATEMENT_PROPERTIES);

            propInternal.load(inputStreamInternal);
            propComprehensive.load(inputStreamComprehensive);

            for (Entry<Object, Object> entry : propInternal.entrySet()) {
                String stmt = entry.getValue().toString();
            }

            for (Entry<Object, Object> entry : propComprehensive.entrySet()) {

            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return semanticIdentifierMap;
    }

}
