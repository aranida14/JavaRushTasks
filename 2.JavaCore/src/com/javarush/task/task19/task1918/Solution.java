package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader fileReader
                = new BufferedReader(new FileReader(reader.readLine()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                fileContent.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileContent.setLength(fileContent.length() - 1);
        Document html = Jsoup.parse(fileContent.toString(), "", Parser.xmlParser());
        String tag = args[0];
        Elements elements = html.select(tag);
        for (Element e : elements) {System.out.println(e.toString());}

        /*
        String tag = args[0];
        Pattern pattern = Pattern.compile("<" + tag + "(\\s.*?)?" + ">.*?</" + tag + ">", Pattern
                .CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(fileContent);
        while(matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(fileContent.substring(start, end));
        }
        */
    }
}
