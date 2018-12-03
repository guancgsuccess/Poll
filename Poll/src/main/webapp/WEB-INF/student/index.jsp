<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2018/7/25 0025
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>驰星教育满意度测评系统Poll-v1.0</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${path}/dist/css/bootstrap.min.css"/>
</head>
<body>
    <div class="container">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">驰星教育满意度测评系统 - 考核班级:${clazzStart.clazzName}</h3>
            </div>
            <div class="panel-body">
                <span class="text-danger">
                    亲爱的小伙伴们，你好!
                    感谢你抽出时间参与我们的调查，请根据自己的实际感受和看法如实填写。本次调查为不记名调查，答案无对错之分，旨在了解学员在驰星学习、生活期间的满意度以及不满意原因，以帮助我们及时发现问题、纠正偏差，同时也为大家营造一个更好的生活、学习环境，提高学习效率！
                </span>
            </div>
        </div>
    </div>

    <!--问卷内容-->
    <c:if test="${empty questionsStart}">
        <div class="container">
            <span class="text-danger">调查任务尚未开始!</span>
        </div>
    </c:if>
    <c:if test="${!empty questionsStart}">
        <!--问题域-->
        <div class="container">
            <div class="table-responsive">
                <table class="table table-hover">
                    <caption><strong>为亲爱的${clazzStart.teacher}评价</strong></caption>
                    <tbody>
                    <c:forEach items="${questionsStart}" var="qst" varStatus="vs">
                        <c:if test="${qst.type==0}">
                            <tr>
                                <td colspan="4"><span class="text-danger small">${vs.count}.${qst.content}</span></td>
                            </tr>
                            <tr class="mustSelect">
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="5" name="${vs.index}"><span class="small text-success">${qst.selection1}</span>
                                    </label>
                                </td>
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="4" name="${vs.index}"><span class="small">${qst.selection2}</span>
                                    </label>
                                </td>
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="3" name="${vs.index}"><span class="small text-primary">${qst.selection3}</span>
                                    </label>
                                </td>
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="0" name="${vs.index}"><span class="small text-muted">${qst.selection4}</span>
                                    </label>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive">
                <table class="table table-hover">
                    <caption><strong>为亲爱的${clazzStart.master}评价</strong></caption>
                    <tbody>
                    <c:forEach items="${questionsStart}" var="qst" varStatus="vs">
                        <c:if test="${qst.type==1}">
                            <tr>
                                <td colspan="4"><span class="text-danger small">评价${vs.index+1}.${qst.content}</span></td>
                            </tr>
                            <tr class="mustSelect">
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="5" name="${vs.index}"><span class="small text-success">${qst.selection1}</span>
                                    </label>
                                </td>
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="4" name="${vs.index}"><span class="small">${qst.selection2}</span>
                                    </label>
                                </td>
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="3" name="${vs.index}"><span class="small text-primary">${qst.selection3}</span>
                                    </label>
                                </td>
                                <td>
                                    <label class="checkbox-inline">
                                        <input type="radio" value="0" name="${vs.index}"><span class="small text-muted">${qst.selection4}</span>
                                    </label>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">留下你的宝贵建议</h3>
                </div>
                <div class="panel-body">
                    <textarea rows="5" id="leftCall" class="form-control" style="color: #ccc">必须留下你的建议(不少于50字),对我们的老师,对班级管理,对我们的服务</textarea>
                    <div align="right" style="color: red">还剩<span id="leftNum">100</span>字</div>
                </div>
            </div>
            <div align="right">
                <button type="button" class="btn btn-info" onclick="end()">提交</button>
            </div>
        </div>
    </c:if>
    <script type="text/javascript" src="${path}/dist/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/dist/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="${path}/js/student/index.js"></script>

    <script>

        /**
         * 需要控制每道题都要能够回答.
         *
         * */
        function end(){
            //判断是否每道题都回答到了.
            var trs = $(".mustSelect");
            //定义一个变量用来保存得分...
            var total = "";
            //统计尚未回答的题目
            var str = "";
            for(var i=0;i<trs.length;i++){
                //获取每行下标的单选框
                var rs = trs[i].getElementsByTagName("input");
                //定义一个变量,统计count
                var count = 0;
                for(var j=0;j<rs.length;j++){
                    if(rs[j].checked){
                        count++;
                        total+=rs[j].value+":";
                    }
                }
                if(count==0) {
                    str += (i + 1) + ":";
                }
            }
            if(str.length!=0){
                alert("尚未完成作答的题目:"+str.replace(/:/g," "));
                return;
            }

            //获取建议..
            var v = $("#leftCall").val();
            if(v.length<50){
                alert("需要你再啰嗦一点!不少于50字的建议!");
                return;
            }

            $.ajax({
                type:'post',
                data:'total='+total.substring(0,total.length-1)+"&content="+v+"&teacher=${clazzStart.teacher}"+"&clazzName=${clazzStart.clazzName}",
                url:'${path}/student/submit',
                success:function(data){
                   if(data=="1"){
                       alert("对不起!你已经评价过了!");
                   }else if(data=="2"){
                       alert("小样,继续填充50字!")
                    }else{
                       alert("感谢你的参与!");
                   }
                }
            });
        }

        /**控制留言字数不超过100**/
        $(function(){
            $("#leftCall").click(function(){
                $(this).val("");
                $(this).unbind("click");
            })

            $("#leftCall").keyup(function(){
                var len = $(this).val().length;
                $("#leftNum").text(100-len);
                if(100-parseInt(len)<0){
                    $(this).val($(this).val().substring(0,100));
                    $("#leftNum").text(0);
                }
            })
        })
    </script>
</body>
</html>
