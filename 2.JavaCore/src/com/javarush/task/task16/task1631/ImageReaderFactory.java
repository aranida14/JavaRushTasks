package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;
import com.javarush.task.task16.task1631.common.BmpReader;
import com.javarush.task.task16.task1631.common.JpgReader;
import com.javarush.task.task16.task1631.common.PngReader;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader reader = null;
        if (type == ImageTypes.JPG) {
            reader = new JpgReader();
        } else if (type == ImageTypes.PNG) {
            reader = new PngReader();
        } else if (type == ImageTypes.BMP) {
            reader = new BmpReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
