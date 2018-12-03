package com.cx.dao;

import com.cx.entity.Clazz;
import com.cx.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestQuestionsDao extends AbstractTestNGSpringContextTests{

    @Autowired
    private IQuestionsDao questionsDao;

    /**
     * 测试试题模拟数据
     */
    @Test
    public void testSave(){
        //第一套试卷....
        //项目经理数据
        Questions questions1 = new Questions("项目经理是否有迟到、早退的现象？","一直很准时","偶尔不准时","很少能准时","从不准时",0,0);
        Questions questions2 = new Questions("项目经理是否每天布置课后任务？","每天都布置","偶尔不布置","偶尔布置","从不布置",0,0);
        Questions questions3 = new Questions("项目经理每天布置的课后任务是否讲解？","每天都很耐心的讲解","讲解，但是不耐心","有时候讲解，有时候不讲解","基本不讲解",0,0);
        Questions questions4 = new Questions("项目经理是否能够耐心、负责地解答你提出的问题？"," 很耐心"," 大多数时候耐心","缺乏耐心","态度恶劣",0,0);
        Questions questions5 = new Questions("项目经理是否时刻关注学员的知识掌握程度，实时调整教学进度并提供配套辅导，确保学员赶上学习进度","一直如此","多数做到","偶尔","从未",0,0);

        //班主任数据
        Questions questions6 = new Questions("班主任是否充分告知班级管理制度？","充分告知","告知","我好像不知道","从来没告知过",1,0);
        Questions questions7 = new Questions("班主任是否每天巡班？","是的，每天巡班多次","基本每次都来巡班","有时候来，有时候不来","好几天来一次",1,0);
        Questions questions8 = new Questions("班主任有主动关心你的学习生活情况吗？","经常","一般","偶尔","从不",1,0);
        Questions questions9 = new Questions("班主任能及时解决你的问题吗？","非常及时","及时解决","解决了但是拖拉","完全不管不问",1,0);
        Questions questions10 = new Questions("班主任是否组织大家做演讲？","是的，并会参加","是的，但班主任不参加","让我们自己组织","没有组织",1,0);

       /* questionsDao.save(questions1);
        questionsDao.save(questions2);
        questionsDao.save(questions3);
        questionsDao.save(questions4);
        questionsDao.save(questions5);

        questionsDao.save(questions6);
        questionsDao.save(questions7);
        questionsDao.save(questions8);
        questionsDao.save(questions9);
        questionsDao.save(questions10);*/

        //第二套试卷...
        //项目经理数据...
        Questions a1 = new Questions("项目经理是否有迟到、早退？","一直很准时","偶尔不准时","很少能准时","从不准时",0,1);
        Questions a2 = new Questions("课程体系上的知识点项目经理都讲到了吗？","都讲到了,而且讲得很细致","基本讲到了,但部分知识点讲得不够仔细"," 大部分讲到了","只讲到了一部分",0,1);
        Questions a3 = new Questions("项目经理是否时刻关注学员的知识掌握程度，确保学员赶上学习进度？","一直如此","多数做到","偶尔","从未",0,1);
        Questions a4 = new Questions("你对项目经理所教授的相关知识和技能掌握程度如何？","很好","好","一般","不好",0,1);
        Questions a5 = new Questions("课后任务抽查和讲解情况如何？","经常被抽查到作业，项目经理每天都认真讲解课后作业","偶尔被抽查到作业，项目经理每天都认真讲解作业","项目经理基本没抽查过作业，只是讲解作业共性问题","项目经理从不抽查作业，也不讲解课后任务",0,1);
        Questions a6 = new Questions("项目经理是否能够耐心、负责地解答你提出的问题？","很耐心","大多数时候耐心","缺乏耐心","态度恶劣",0,1);
        Questions a7 = new Questions("项目经理是否能给予实战项目立项充分的指导？","给了很多的指导","给了部分指导","很少没指导","没指导过",0,1);
        Questions a8 = new Questions("阶段考试后，项目经理有按照考试成绩给予正确的学习方法和建议吗？","项目经理根据考试情况进行了讲解，并给与我们正确的学习方法的知道","项目经理只给了分数，讲了一部分","只给了分数","并未讲解，也没有给分数",0,1);
        Questions a9 = new Questions("项目经理有指导阶段项目并录视频并上传至服务器吗？","项目经理给予了充分的项目指导，并指导我们录视频","项目经理督促我们录视频，问到会指导","只督促上传并未指导","从不过问",0,1);


        //班主任
        Questions a10 = new Questions("你感觉所在班级学习氛围如何？","非常好","好","一般","不好",1,1);
        Questions a11 = new Questions("班主任有按时巡班吗？","每天按时","大多数按时","时来时不来","没见过班主任来",1,1);
        Questions a12 = new Questions("班主任对违纪等行为有按照班级管理制度执行吗？","严厉的现场执行并宣导","执行","偶尔执行，看情况","执行的不公平",1,1);
        Questions a13 = new Questions("班主任能及时解决你的问题吗？","非常及时","及时解决","解决了但是拖拉","完全不管不问",1,1);
        Questions a14 = new Questions("班主任有主动关心你的学习生活情况吗？","经常","一般","偶尔","从不",1,1);

       /* questionsDao.save(a1);
        questionsDao.save(a2);
        questionsDao.save(a3);
        questionsDao.save(a4);
        questionsDao.save(a5);
        questionsDao.save(a6);
        questionsDao.save(a7);
        questionsDao.save(a8);
        questionsDao.save(a9);
        questionsDao.save(a10);
        questionsDao.save(a11);
        questionsDao.save(a12);
        questionsDao.save(a13);
        questionsDao.save(a14);*/


       //第三套问卷
        Questions s1 = new Questions("项目经理是否有迟到、早退？","一直很准时","偶尔不准时","很少能准时","从不准时",0,2);
        Questions s2 = new Questions("项目经理是否每天布置课后任务？","每天","经常","偶尔","从不",0,2);
        Questions s3 = new Questions("课后任务抽查和讲解情况如何？","经常被抽查到作业，项目经理每天都认真讲解课后作业","偶尔被抽查到作业，项目经理每天都认真讲解作业","项目经理基本没抽查过作业，只是讲解作业共性问题","项目经理从不抽查作业，也不讲解课后任务",0,2);
        Questions s4 = new Questions("项目经理是否能够耐心、负责地解答你提出的问题？","很耐心","大多数时候耐心","缺乏耐心","态度恶劣",0,2);
        Questions s5 = new Questions("项目经理对阶段项目（含服务端项目）的开发指导情况如何？","给予充分指导","只给予一般性指导","很少给予指导","从未给予指导",0,2);
        Questions s6 = new Questions("项目经理对最后的实战项目实施（含需求分析、设计等）指导的情况如何？","给予充分指导","只给予一般性指导","很少给予指导","从未给予指导",0,2);
        Questions s7 = new Questions("授课时，项目经理是否能够结合案例进行讲解相关知识点？","一直如此","多数做到","偶尔","从未",0,2);
        Questions s8 = new Questions("你对项目经理所教授的相关知识和技能掌握程度如何？","很好","好","一般","不好",0,2);
        Questions s9 = new Questions("你是否了解最后的实战项目的重要性？","非常清楚","清楚","大概清楚","不清楚",0,2);
        Questions s10 = new Questions("最后的实战项目相关的知识点是否已经开始准备？","准备很充分","已准备了部分","刚开始准备","没有准备",0,2);
        Questions s11 = new Questions("你认为最后的实战项目要求难吗？","很容易","不难","稍有难度","很难",0,2);

        Questions s12 = new Questions("你感觉所在班级学习氛围如何？","非常好","好","一般","不好",1,2);
        Questions s13 = new Questions("班主任有按时巡班吗？","每天按时","大多数按时","时来时不来","没见过班主任来",1,2);
        Questions s14 = new Questions("班主任对违纪等行为有按照班级管理制度执行吗？","严厉的现场执行并宣导","执行","偶尔执行，看情况","执行的不公平",1,2);
        Questions s15 = new Questions("班主任能及时解决你的问题吗？","非常及时","及时解决","解决了但是拖拉","完全不管不问",1,2);
        Questions s16 = new Questions("班主任有主动关心你的学习生活情况吗？","经常","一般","偶尔","从不",1,2);

      /*  questionsDao.save(s1);
        questionsDao.save(s2);
        questionsDao.save(s3);
        questionsDao.save(s4);
        questionsDao.save(s5);
        questionsDao.save(s6);
        questionsDao.save(s7);
        questionsDao.save(s8);
        questionsDao.save(s9);
        questionsDao.save(s10);
        questionsDao.save(s11);
        questionsDao.save(s12);
        questionsDao.save(s13);
        questionsDao.save(s14);
        questionsDao.save(s15);
        questionsDao.save(s16);*/

        //第四套
        Questions o1 = new Questions("项目经理是否有迟到、早退？","一直很准时","偶尔不准时","很少能准时","从不准时",0,3);
        Questions o2 = new Questions("项目经理每天在班上的项目辅导时间是多少？","全天","多于半天","半天","不足半天",0,3);
        Questions o3 = new Questions("项目经理是否能够耐心、负责地解答你提出的问题？","很耐心","大多数时候耐心","缺乏耐心","态度恶劣",0,3);
        Questions o4 = new Questions("项目经理是否及时关注各组项目的进度？","及时","一般","很少","没有",0,3);
        Questions o5 = new Questions("项目经理对项目开发过程的技术辅导如何？","主动指导","问到会指导","指导不力","从不指导",0,3);
        Questions o6 = new Questions("项目经理对项目开发过程的项目管理辅导如何？","主动指导","问到会指导","指导不力","从不指导",0,3);
        Questions o7 = new Questions("项目是否按照进度保质保量完成？","完成得很好","完成","差不多完成","未完成",0,3);
        Questions o8 = new Questions("个人负责模块是否按时保质保量完成？","完成得很好","完成","差不多完成","未完成",0,3);
        Questions o9 = new Questions("你是否了解项目的整体功能和实现？","非常了解","了解","一般","不了解",0,3);

        Questions o10 = new Questions("你觉得班主任和你熟吗？","非常熟悉","熟悉","不熟","连我是谁不知道",1,3);
        Questions o11 = new Questions("班主任有协助各项目组开展项目管理工作吗？","主动协助","会参与管理","协助不力","从不关注",1,3);
        Questions o12 = new Questions("班主任对个人在项目中责任模块胜任度管理得如何？","非常关注并监督协调管理","经常找组长、个人谈话","偶尔关注","从不关注",1,3);
        Questions o13 = new Questions("班主任能及时解决你的问题吗？","非常及时","及时解决","解决了但是拖拉","完全不管不问",1,3);
        Questions o14 = new Questions("你感觉你们班项目期的整体学习氛围如何？","非常好","还可以","会有迟到旷课现象","学习氛围一点不好",1,3);
        Questions o15 = new Questions("班主任是否及时告知了退宿注意事项，并做好相关的工作安排？","非常了解","了解","不是很清楚","不知道",1,3);

//        questionsDao.save(o1);
//        questionsDao.save(o2);
//        questionsDao.save(o3);
//        questionsDao.save(o4);
//        questionsDao.save(o5);
//        questionsDao.save(o6);
//        questionsDao.save(o7);
//        questionsDao.save(o8);
//        questionsDao.save(o9);
//        questionsDao.save(o10);
//        questionsDao.save(o11);
//        questionsDao.save(o12);
//        questionsDao.save(o13);
//        questionsDao.save(o14);
//        questionsDao.save(o15);

        //第五套
        Questions m1 = new Questions("项目经理是否每天布置课后任务？","每天","经常","偶尔","从不",0,4);
        Questions m2 = new Questions("课后任务抽查和讲解情况如何？","经常被抽查到作业，项目经理每天都认真讲解课后作业","偶尔被抽查到作业，项目经理每天都认真讲解作业","项目经理基本没抽查过作业，只是讲解作业共性问题","项目经理从不抽查作业，也不讲解课后任务",0,4);
        Questions m3 = new Questions("项目经理是否能够耐心、负责地解答你提出的问题？","很耐心","大多数时候耐心","缺乏耐心","态度恶劣",0,4);
        Questions m4 = new Questions("项目经理是否定期给予小组成员指导？","给了很多的指导","给了部分指导","很少没指导","没指导过",0,4);
        Questions m5 = new Questions("项目经理对最后的实战项目实施（含需求分析、设计等）指导的情况如何？","给予充分指导","只给予一般性指导","很少给予指导","从未给予指导",0,4);
        Questions m6 = new Questions("授课时，项目经理是否能够结合案例进行讲解相关知识点？","一直如此","多数做到","偶尔","从未",0,4);
        Questions m7 = new Questions("你对项目经理所教授的相关知识和技能掌握程度如何？","很好","好","一般","不好",0,4);
        Questions m8 = new Questions("你对下面哪个知识点掌握最弱？","没有","mybatis","servlet,jsp,ajax","spring",0,4);

        Questions m9 = new Questions("班主任经常关注你吗？","每天关注","经常关注","偶尔关注","从不关注",1,4);
        Questions m10 = new Questions("班主任会定期关注你们小组的情况吗？","每天关注","经常关注","偶尔关注","从不关注",1,4);
        Questions m11 = new Questions("班主任对违纪等行为有按照班级管理制度执行吗？","严厉的现场执行并宣导","执行","偶尔执行，看情况","执行的不公平",1,4);
        Questions m12 = new Questions("班主任能及时解决你的问题吗？","非常及时","及时解决","解决了但是拖拉","完全不管不问",1,4);
        Questions m13 = new Questions("班主任有主动关心你的学习生活情况吗？","经常","一般","偶尔","从不",1,4);

//        questionsDao.save(m1);
//        questionsDao.save(m2);
//        questionsDao.save(m3);
//        questionsDao.save(m4);
//        questionsDao.save(m5);
//        questionsDao.save(m6);
//        questionsDao.save(m7);
//        questionsDao.save(m8);
//        questionsDao.save(m9);
//        questionsDao.save(m10);
//        questionsDao.save(m11);
//        questionsDao.save(m12);
//        questionsDao.save(m13);

          //第六套
        Questions mm1 = new Questions("项目经理是否每天布置课后任务？","每天","经常","偶尔","从不",0,5);
        Questions mm2 = new Questions("课后任务抽查和讲解情况如何？","经常被抽查到作业，项目经理每天都认真讲解课后作业","偶尔被抽查到作业，项目经理每天都认真讲解作业","项目经理基本没抽查过作业，只是讲解作业共性问题","项目经理从不抽查作业，也不讲解课后任务",0,5);
        Questions mm3 = new Questions("项目经理是否能够耐心、负责地解答你提出的问题？","很耐心","大多数时候耐心","缺乏耐心","态度恶劣",0,5);
        Questions mm4 = new Questions("项目经理是否定期给予小组成员指导？","给了很多的指导","给了部分指导","很少没指导","没指导过",0,5);
        Questions mm5 = new Questions("项目经理对最后的实战项目实施（含需求分析、设计等）指导的情况如何？","给予充分指导","只给予一般性指导","很少给予指导","从未给予指导",0,5);
        Questions mm6 = new Questions("授课时，项目经理是否能够结合案例进行讲解相关知识点？","一直如此","多数做到","偶尔","从未",0,5);
        Questions mm7 = new Questions("你对项目经理所教授的相关知识和技能掌握程度如何？","很好","好","一般","不好",0,5);

        Questions mm8 = new Questions("班主任经常关注你吗？","每天关注","经常关注","偶尔关注","从不关注",1,5);
        Questions mm9 = new Questions("班主任会定期关注你们小组的情况吗？","每天关注","经常关注","偶尔关注","从不关注",1,5);
        Questions mm10 = new Questions("班主任对违纪等行为有按照班级管理制度执行吗？","严厉的现场执行并宣导","执行","偶尔执行，看情况","执行的不公平",1,5);
        Questions mm11 = new Questions("班主任能及时解决你的问题吗？","非常及时","及时解决","解决了但是拖拉","完全不管不问",1,5);
        Questions mm12 = new Questions("班主任有主动关心你的学习生活情况吗？","经常","一般","偶尔","从不",1,5);

        questionsDao.save(mm1);
        questionsDao.save(mm2);
        questionsDao.save(mm3);
        questionsDao.save(mm4);
        questionsDao.save(mm5);
        questionsDao.save(mm6);
        questionsDao.save(mm7);
        questionsDao.save(mm8);
        questionsDao.save(mm9);
        questionsDao.save(mm10);
        questionsDao.save(mm11);
        questionsDao.save(mm12);
    }

    @Test
    public void testFindAll(){
        System.out.println(questionsDao.findAll(0));
    }

    @Test
    public void getTotal(){
        System.out.println(questionsDao.getTotals());
    }
}
