package com.cx.service.impl;

import com.cx.dao.IScoreDao;
import com.cx.entity.Score;
import com.cx.service.IScoreService;
import com.cx.service.ISqVoService;
import com.cx.service.ISuggestService;
import com.cx.util.MathUtil;
import com.cx.vo.ExportObjVo;
import com.cx.vo.ScoreVo;
import com.cx.vo.SqVo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
@Service
@Transactional
public class ScoreServiceImpl implements IScoreService{

    @Autowired
    private IScoreDao scoreDao;

    @Autowired
    private ISuggestService suggestService;

    @Autowired
    private ISqVoService sqVoService;

    @Override
    public void save(Score score) {
        scoreDao.save(score);
    }

    @Override
    public List<ScoreVo> findByOrder(String clazzName, int index) {
        List<String> ukeys = suggestService.distinctUniqueKey(clazzName);
        String curr_keys = ukeys.get(index);

        List<ScoreVo> vos = scoreDao.findByClazzName(clazzName);

        for(int i=0;i<vos.size();i++){
            if(!vos.get(i).getUkey().equals(curr_keys)){
               // System.out.println(i);
                vos.remove(i);
                i--;
            }
        }
        return vos;
    }

    @Override
    public void export(ExportObjVo vo, int countOrder,OutputStream out) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("满意度分数表");
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

        //----------保存评论---------
        HSSFSheet sheet2 = wb.createSheet("匿名评价表");

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

        HSSFCellStyle s3 = wb.createCellStyle();

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

        c3.setCellValue("驰星教育满意度测评 - 匿名评价");
        c3.setCellStyle(s3);
        rowHeader2.setHeightInPoints(30);

        HSSFRow row3 = sheet2.createRow(1);
        //标记:
        CellStyle s4 = wb.createCellStyle();
        s4.setFillForegroundColor((short) 11);
        s4.setFillPattern(CellStyle.SOLID_FOREGROUND);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        List<String> contents = vo.getContents();
        for(int i=0;i<contents.size();i++) {
            row3 = sheet2.createRow(i + 1);

            // 第四步，创建单元格，并设置值
            HSSFCell cell10 = row3.createCell(0);
            cell10.setCellValue(contents.get(i));
            cell10.setCellStyle(style2);
            row3.setHeightInPoints(50);//设置行高
        }

        //=====================导出每道题的得分================================
        HSSFSheet sheets = wb.createSheet("单项得分表");

        sheets.setColumnWidth(0,5076);//序号
        sheets.setColumnWidth(1,10766);//问题描述
        sheets.setColumnWidth(2,5076);//得分
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle styles = wb.createCellStyle();

        styles.setWrapText(true);//设置自动换行
        styles.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 创建一个居中格式
        styles.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中格式

        //生成一个字体
        HSSFFont fs=wb.createFont();
        //font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        fs.setFontHeightInPoints((short) 12);
        fs.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
        fs.setFontName("楷体");

        //把字体应用到当前的样式
        styles.setFont(fs);

        //設置邊框
        styles.setBorderTop(CellStyle.BORDER_THIN);
        styles.setBorderBottom(CellStyle.BORDER_THIN);
        styles.setBorderLeft(CellStyle.BORDER_DOTTED);
        styles.setBorderRight(CellStyle.BORDER_THIN);

        CellRangeAddress regions = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                2// last column
        );
        sheets.addMergedRegion(regions);

        HSSFCellStyle ss = wb.createCellStyle();

        HSSFRow rowHeaders = sheets.createRow(0);
        HSSFCell cs = rowHeaders.createCell(0);
        ss.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        ss.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        //生成一个字体
        HSSFFont fss=wb.createFont();
        //font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        fss.setFontHeightInPoints((short) 12);
        fss.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
        fss.setFontName("楷体");

        ss.setFont(fss);

        ss.setBorderTop(HSSFCellStyle.BORDER_THIN);
        ss.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        ss.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        ss.setBorderRight(HSSFCellStyle.BORDER_THIN);

        cs.setCellValue("驰星教育满意度测评 - 单项得分");
        cs.setCellStyle(ss);
        rowHeaders.setHeightInPoints(30);

        HSSFRow rows4 = sheets.createRow(1);
        //标记:
        CellStyle s4s = wb.createCellStyle();
        s4s.setFillForegroundColor((short) 11);
        s4s.setFillPattern(CellStyle.SOLID_FOREGROUND);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
       List<SqVo> svs = sqVoService.findAll(vo.getClazzName(),countOrder);
       for(int i=0;i<svs.size();i++) {
            rows4 = sheets.createRow(i + 1);

            // 第四步，创建单元格，并设置值
            HSSFCell cell10 = rows4.createCell(0);
            cell10.setCellValue(i+1);
            cell10.setCellStyle(styles);

            HSSFCell cell101 = rows4.createCell(1);
            cell101.setCellValue(svs.get(i).getQuestions().getContent());
            cell101.setCellStyle(styles);

            HSSFCell cell102 = rows4.createCell(2);
            cell102.setCellValue(MathUtil.formatDouble4(svs.get(i).getScoreVo().getScore()));
            cell102.setCellStyle(styles);

            rows4.setHeightInPoints(50);//设置行高
        }
        // 第六步，将文件存到指定位置
        try {
            wb.write(out);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
