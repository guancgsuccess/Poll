package com.cx.controller;

import com.cx.entity.Questions;
import com.cx.entity.Score;
import com.cx.entity.Suggest;
import com.cx.service.IScoreService;
import com.cx.service.ISuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 控制层 - 学生
 */
@Controller
@RequestMapping("/student")
public class StudentAction {
    @Autowired
    private ISuggestService suggestService;

    @Autowired
    private IScoreService scoreService;

    @RequestMapping("/index")
    public String index(){
        return "student/index";
    }

    /**
     * 提交测试
     * @param total
     * @param suggest
     * @return
     */
    @RequestMapping("/submit")
    @ResponseBody
    public String submit(String teacher,String total, Suggest suggest, HttpServletRequest req){
        //获取远程ip,每个人只能提交一次
        String ip = req.getRemoteAddr();
        //从application作用域中获取ips集合
        Set<String> ips = (Set<String>) req.getServletContext().getAttribute("ips");
        if(ips.contains(ip)){
            return "1";
        }
        ips.add(ip);
        //重新放入到application作用域
        req.getServletContext().setAttribute("ips",ips);

        //保存建议...
        suggest.setCreateDate(new Date());
        suggest.setUniquekey((String) req.getServletContext().getAttribute("uniquekey"));

        if(suggest.getContent().trim().length()<50){
            return "2";
        }

        suggestService.save(suggest);

        String[] totals = total.split(":");

        //保存每道题的得分
        //获取所有的问题
        List<Questions> questionsList = (List<Questions>) req.getServletContext().getAttribute("questionsStart");
        for(int i=0;i<questionsList.size();i++){
            Score score = new Score();
            score.setClazzName(suggest.getClazzName());
            score.setUkey((String) req.getServletContext().getAttribute("uniquekey"));
            score.setQuestions(questionsList.get(i));
            score.setScore(Double.parseDouble(totals[i]));
            score.setCreateDate(new Date());
            score.setTeacher(teacher);
            scoreService.save(score);
        }
        return "0";
    }
}
