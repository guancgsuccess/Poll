package com.cx.poi;

import com.cx.entity.User;
import com.cx.vo.ExportObjVo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.io.FileOutputStream;

/**
 * Created by Administrator on 2018/7/30 0030.
 */
public class TestExcel extends AbstractTestNGSpringContextTests{

    @SuppressWarnings("all")
    public static void main(String[] args) {
        ExportObjVo vo = new ExportObjVo();
        vo.setClazzName("J01180709");
        vo.setTeacher("强老师");
        vo.setTotal1(93.0);
        vo.setMaster("任津辉");
        vo.setTotal2(80.0);
        vo.setMustCounts(45);
        vo.setOnlineCounts(30);

        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("学生表");
        sheet.setColumnWidth(0,3766);//编号列
        sheet.setColumnWidth(1,5700);//真实姓名
        sheet.setColumnWidth(2,3766);//性别
        sheet.setColumnWidth(3,8766);//联系方式
        sheet.setColumnWidth(4,10766);//remark
        sheet.setColumnWidth(5,10766);//remark
        sheet.setColumnWidth(6,10766);//remark
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = wb.createCellStyle();

        style.setWrapText(true);//设置自动换行
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中格式

        //生成一个字体
        HSSFFont font=wb.createFont();
        //font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
        font.setFontName("楷体");

        //把字体应用到当前的样式
        style.setFont(font);

        //設置邊框
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_DOTTED);
        style.setBorderRight(CellStyle.BORDER_THIN);

        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                6// last column
        );
        sheet.addMergedRegion(region);

        HSSFCellStyle s = wb.createCellStyle();

        //设置背景颜色
        //s.setFillForegroundColor((short) 11);
        //s.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFRow rowHeader = sheet.createRow(0);
        HSSFCell c = rowHeader.createCell(0);
        s.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        s.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        //生成一个字体
        HSSFFont f=wb.createFont();
        //font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        f.setFontHeightInPoints((short) 12);
        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
        f.setFontName("楷体");

        s.setFont(f);

        s.setBorderTop(HSSFCellStyle.BORDER_THIN);
        s.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        s.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        s.setBorderRight(HSSFCellStyle.BORDER_THIN);

       /* for(int i=0;i<6;i++){
            Cell cc = rowHeader.createCell(i);
            // if(i==2){
            cc.setCellStyle(s);
            //}
        }*/

        c.setCellValue("驰星教育满意度测评");
        c.setCellStyle(s);
        rowHeader.setHeightInPoints(30);

        HSSFRow row = sheet.createRow(1);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("班级编号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("实训师");
        cell.setCellStyle(style);
        cell = row.createCell( 2);
        cell.setCellValue("得分");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("班主任");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("得分");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("班级人数");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("实际参与人数");
        cell.setCellStyle(style);

        //标记:
        CellStyle s2 = wb.createCellStyle();
        s2.setFillForegroundColor((short) 11);
        s2.setFillPattern(CellStyle.SOLID_FOREGROUND);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            row = sheet.createRow(0 + 2);

            // 第四步，创建单元格，并设置值

            HSSFCell cell1 = row.createCell(0);
            cell1.setCellValue(vo.getClazzName());
            cell1.setCellStyle(style);

            HSSFCell cell2 = row.createCell(1);
            cell2.setCellValue(vo.getTeacher());
            cell2.setCellStyle(style);

            HSSFCell cell3 = row.createCell(2);
            cell3.setCellValue(String.valueOf(vo.getTotal1()));
            cell3.setCellStyle(style);

            HSSFCell cell4 = row.createCell(3);
            cell4.setCellValue(vo.getMaster());
            cell4.setCellStyle(style);

            HSSFCell cell5 = row.createCell(4);
            cell5.setCellValue(String.valueOf(vo.getTotal2()));
            cell5.setCellStyle(style);

            HSSFCell cell6 = row.createCell(5);
            cell6.setCellValue(String.valueOf(vo.getMustCounts()));
            cell6.setCellStyle(style);

            HSSFCell cell7 = row.createCell(6);
            cell7.setCellValue(String.valueOf(vo.getOnlineCounts()));
            cell7.setCellStyle(style);
            row.setHeightInPoints(30);//设置行高

             //=============评价表=====================

        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet2 = wb.createSheet("评价表");

            sheet2.setColumnWidth(0,50766);//remark
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            // 第四步，创建单元格，并设置值表头 设置表头居中
            CellStyle style2 = wb.createCellStyle();

            style2.setWrapText(true);//设置自动换行
            style2.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 创建一个居中格式
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中格式

            //生成一个字体
            HSSFFont font2=wb.createFont();
            //font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
            font2.setFontHeightInPoints((short) 12);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
            font2.setFontName("楷体");

            //把字体应用到当前的样式
            style2.setFont(font2);

            //設置邊框
            style2.setBorderTop(CellStyle.BORDER_THIN);
            style2.setBorderBottom(CellStyle.BORDER_THIN);
            style2.setBorderLeft(CellStyle.BORDER_DOTTED);
            style2.setBorderRight(CellStyle.BORDER_THIN);

          /*  CellRangeAddress region2 = new CellRangeAddress(0, // first row
                    0, // last row
                    0, // first column
                    0// last column
            );
            sheet2.addMergedRegion(region2);*/

            HSSFCellStyle s3 = wb.createCellStyle();

            //设置背景颜色
            //s.setFillForegroundColor((short) 11);
            //s.setFillPattern(CellStyle.SOLID_FOREGROUND);

            HSSFRow rowHeader2 = sheet2.createRow(0);
            HSSFCell c3 = rowHeader2.createCell(0);
            s3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            s3.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            //生成一个字体
            HSSFFont f2=wb.createFont();
            //font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
            f2.setFontHeightInPoints((short) 12);
            f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
            f2.setFontName("楷体");

            s3.setFont(f2);

            s3.setBorderTop(HSSFCellStyle.BORDER_THIN);
            s3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            s3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            s3.setBorderRight(HSSFCellStyle.BORDER_THIN);

       /* for(int i=0;i<6;i++){
            Cell cc = rowHeader.createCell(i);
            // if(i==2){
            cc.setCellStyle(s);
            //}
        }*/

            c3.setCellValue("驰星教育满意度测评 - 匿名评价");
            c3.setCellStyle(s3);
            rowHeader2.setHeightInPoints(30);

            HSSFRow row3 = sheet2.createRow(1);
        /*    HSSFCell c4 = row3.createCell(0);
            c4.setCellValue("班级编号");
            c4.setCellStyle(style2);
            c4 = row3.createCell(1);
            c4.setCellValue("实训师");
            c4.setCellStyle(style2);*/

            //标记:
            CellStyle s4 = wb.createCellStyle();
            s4.setFillForegroundColor((short) 11);
            s4.setFillPattern(CellStyle.SOLID_FOREGROUND);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            row3 = sheet2.createRow(0 + 1);

            // 第四步，创建单元格，并设置值
            HSSFCell cell10 = row3.createCell(0);
            cell10.setCellValue("sssssdfdddddddddddddddddddddddddmmmmmmmmmmmmmmmmmmmmmmmmmmm");
            cell10.setCellStyle(style2);

            row3.setHeightInPoints(50);//设置行高



            // 第六步，将文件存到指定位置
            try {
                FileOutputStream out = new FileOutputStream("E:/users.xls");
                wb.write(out);
                out.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }
}
