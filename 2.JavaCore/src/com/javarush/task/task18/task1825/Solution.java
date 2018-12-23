package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        TreeSet<FilePart> fileParts = new TreeSet<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String filePart = "";
            while ((filePart = reader.readLine()) != null && !filePart.equals("end")) {
                fileParts.add(new FilePart(filePart));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        if (fileParts.isEmpty()) return;
        String firstFilePart = fileParts.first().getPartName();
        try(FileOutputStream fos = new FileOutputStream(firstFilePart.substring(0, firstFilePart.lastIndexOf(".part")))) {
            Iterator<FilePart> iterator = fileParts.iterator();
            byte[] buff = new byte[64 * 1024];
            while (iterator.hasNext()) {
                try(FileInputStream fis = new FileInputStream(iterator.next().getPartName())) {
                    while (fis.available() > 0) {
                        int readCount = fis.read(buff);
                        fos.write(buff, 0, readCount);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class FilePart implements Comparable<FilePart>{
        private String partName;
        public FilePart(String name) {
            this.partName = name;
        }

        public String getPartName() {
            return partName;
        }

        @Override
        public int compareTo(FilePart filePart) {
            int indexOfPart = filePart.getPartName().lastIndexOf(".part");
            int thisIndexOfPart = this.getPartName().lastIndexOf(".part");
            if (indexOfPart < 0 || thisIndexOfPart < 0) return this.getPartName().compareTo(filePart.getPartName());

            String mainFileName =  filePart.getPartName().substring(0, indexOfPart);
            String thisMainFileName =  this.getPartName().substring(0, indexOfPart);
            String partNumber = filePart.getPartName().substring(indexOfPart + 5);
            String thisPartNumber = this.getPartName().substring(thisIndexOfPart + 5);

            if (thisMainFileName.compareTo(mainFileName) != 0) {
                return thisMainFileName.compareTo(mainFileName);
            } else {
                try {
                    return Integer.parseInt(thisPartNumber) - Integer.parseInt(partNumber);
                } catch (NumberFormatException e) {
                    return this.getPartName().compareTo(filePart.getPartName());
                }
            }
        }
    }
}
