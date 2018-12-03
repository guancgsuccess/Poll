package com.cx.controller;

import com.cx.entity.Clazz;
import com.cx.entity.Questions;
import com.cx.entity.User;
import com.cx.service.*;
import com.cx.service.impl.QuestionsServiceImpl;
import com.cx.vo.ExportObjVo;
import com.cx.vo.ScoreVo;
import com.cx.vo.SqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 控制层 - 教师
 */
@Controller
@RequestMapping("/teacher")
public class TeacherAction {

    @Autowired
    private IUserService userService;

    @Autowired
    private IClazzService clazzService;

    @Autowired
    private IQuestionsService questionsService;

    @Autowired
    private ISuggestService suggestService;

    @Autowired
    private IScoreService scoreService;

    @Autowired
    private ISqVoService sqVoService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public String index(){
        return "admin/login";
    }

    /**
     * 登录所有
     */
    @RequestMapping("/logincl")
    public String login(User user, Model model, HttpSession session){
        User u = userService.login(user.getUsername());
        //用户名不存在
        if(u==null){
            model.addAttribute("loginError","0");
            return "admin/login";
        }else{
            if(!u.getPassword().equals(user.getPassword())) {
                //密码错误
                model.addAttribute("loginError","1");
                return "admin/login";
            }else{
                //登录成功
                session.setAttribute("u",u);
                return "redirect:index";
            }
        }
    }

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(Model model,Integer status){
        //查询所有的班级信息
        List<Clazz> clazzList = clazzService.findAll();
        model.addAttribute("clazzList",clazzList);

        //查询所有的问题信息
        List<Questions> questions = questionsService.findAll(status==null?0:status);
        model.addAttribute("questions",questions);

        //查询问卷的总条目
        long questionTotal = questionsService.getTotals();
        model.addAttribute("questionTotal",questionTotal);

        if(null!=status){
            model.addAttribute("status",status);
        }

        return "admin/index";
    }

    /**
     *
     * @param qst 试卷id
     * @param cla 班级id
     * @return
     */
    @RequestMapping("/check")
    @ResponseBody
    public String check(Integer qst, Integer cla,HttpServletRequest req){
        //查询问卷
        List<Questions> questionsList = questionsService.findAll(qst);
        //查询班级
        Clazz clazz = clazzService.getById(cla);

        req.getServletContext().setAttribute("questionsStart",questionsList);
        req.getServletContext().setAttribute("clazzStart",clazz);

        //新建一个Set集合,用来存放存放过来的ip地址
        Set<String> ips = new HashSet<>();
        req.getServletContext().setAttribute("ips",ips);

        //存放唯一标识
        String uniquekey = UUID.randomUUID().toString();
        req.getServletContext().setAttribute("uniquekey", uniquekey);

        return "0";
    }

    @RequestMapping("/uniquekey")
    @ResponseBody
    public String uniquekey(String clazzName){
        long count = suggestService.countPoll(clazzName);
        return String.valueOf(count);
    }

    @RequestMapping("/query")
    @ResponseBody
    public List<SqVo> query(String clazzName, int countOrder){
        return sqVoService.findAll(clazzName,countOrder);
    }

    /**
     * 導出excel
     */
    @RequestMapping("/export")
    @ResponseBody
    public String export(ExportObjVo vo, int countOrder, HttpServletResponse resp) throws UnsupportedEncodingException {
        //ExportObjVo中封装teacher和master
        Clazz c = clazzService.getByClazzName(vo.getClazzName());
        vo.setTeacher(c.getTeacher());
        vo.setMaster(c.getMaster());

        //ExportObjVo中封装留言内容.
        List<ScoreVo> scoreVos = scoreService.findByOrder(vo.getClazzName(),countOrder);

        //获取unkeys
        String unkeys = scoreVos.get(0).getUkey();
        //获取评论
        List<String> contents = suggestService.getContentsByUkey(unkeys);
        vo.setContents(contents);

        try {
            //拼接文件名称
            String filename = vo.getClazzName()+"_苏州驰星第"+(countOrder+1)+"次满意度调查报告.xls";
            filename = new String(filename.getBytes(),"ISO-8859-1");

            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/x-download");
            resp.addHeader("Content-Disposition", "attachment;filename="+filename);

            OutputStream out = resp.getOutputStream();
            scoreService.export(vo,countOrder,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping("/stopCheck")
    @ResponseBody
    public String stopCheck(HttpServletRequest req){
        req.getServletContext().removeAttribute("ips");
        req.getServletContext().removeAttribute("uniquekey");
        req.getServletContext().removeAttribute("questionsStart");
        req.getServletContext().removeAttribute("clazzStart");
        return "0";
    }
}
