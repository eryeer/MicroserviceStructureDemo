package com.wxbc.common;

import com.itextpdf.awt.AsianFontMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.codec.binary.Base64;

import java.io.*;

public class PDFUtil {

    public static String getPDF(String title, String contentWithArgs, String... args) throws Exception {
        String content = String.format(contentWithArgs, args);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 50, 50, 100, 100);
        PdfWriter.getInstance(document,  baos);
        document.open();
        // 设置基础字体样式
        BaseFont baseFont = BaseFont.createFont(AsianFontMapper.ChineseSimplifiedFont,
                AsianFontMapper.ChineseSimplifiedEncoding_H, BaseFont.NOT_EMBEDDED);
        //设置标题
        Font titleFont = new Font(baseFont, 20f, Font.BOLD, BaseColor.BLACK);
        Paragraph titleParagragh = new Paragraph(title, titleFont);
        titleParagragh.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titleParagragh);
        //设置正文
        Font contentFont = new Font(baseFont, 14f, Font.NORMAL, BaseColor.BLACK);
        Paragraph contentParagraph = new Paragraph(content,contentFont);
        contentParagraph.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(contentParagraph);
        document.close();

        byte[] fileContent = baos.toByteArray();
        //对文件内容进行base64编码
        byte[] encodeBase64 = Base64.encodeBase64(fileContent);
        return new String(encodeBase64, "UTF-8");

    }
}