package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\SEN-SEI\\Downloads\\fake_data.csv";
        String delimiter = ","; // Specify the delimiter used in your CSV file

        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(delimiter);
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the contents of the dataList
        for (String[] data : dataList) {
            for (String value : data) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
