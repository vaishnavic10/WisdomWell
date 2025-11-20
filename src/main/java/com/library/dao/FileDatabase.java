package com.library.dao;

import java.io.*;
import java.util.*;

public class FileDatabase {

    public static List<String> readData(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) data.add(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeData(String filePath, List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String s : data) bw.write(s + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
