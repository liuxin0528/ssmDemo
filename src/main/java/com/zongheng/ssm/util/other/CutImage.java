/*
 * Copyright 2018 by 青岛比特信息科技有限公司 .
 * All rights reserved.
 */
package com.zongheng.ssm.util.other;

import javafx.scene.effect.ImageInput;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 * 日期		:	2018/9/1<br>
 * 作者		:	liuxin<br>
 * 项目		:	ssmDemo<br>
 * 功能		:	<br>
 */
public class CutImage {

    public static void cutImage(String filePath, int x, int y, int w, int h) throws Exception{
        ImageInputStream iis = ImageIO.createImageInputStream(new FileInputStream(filePath));

        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader imageReader = it.next();

        imageReader.setInput(iis,true);

        ImageReadParam par = imageReader.getDefaultReadParam();
        par.setSourceRegion(new Rectangle(x,y,w,h));

        BufferedImage bi = imageReader.read(0, par);

        ImageIO.write(bi, "jpg", new File(filePath));
    }


    public static void main(String[] args) {
        String filePath = "E:\\test\\img\\TIM截图20180108081126.png";
        int x = 10;
        int y = 10;
        int w = 100;
        int h = 100;


        try {
            cutImage(filePath, x, y, w, h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
