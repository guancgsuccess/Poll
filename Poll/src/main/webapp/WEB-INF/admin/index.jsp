<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2018/7/25 0025
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>实训学员考评系统Poll-v1.0</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${path}/dist/css/bootstrap.min.css"/>
</head>
<body>
     <%@include file="../common/header.jsp"%>

    <!--管理员区域-->
     <%@include file="../power/admin.jsp"%>

     <!--班主任区域-->
     <!--管理员区域-->
     <c:if test="${u.power==1}">
         <div class="container">
             <!--功能区域-->
             <div class="row">
                 <div class="col-md-1">
                     <label class="text-success" style="padding: 5px">班级:</label>
                 </div>
                 <div class="col-md-2">
                     <form role="form">
                         <div class="form-group">
                             <select class="form-control" id="selectClazzs">
                                <option value="-1">===选择班级===</option>
                                <c:forEach items="${clazzList}" var="c">
                                    <option value="${c.clazzName}">${c.clazzName}</option>
                                </c:forEach>
                             </select>
                         </div>
                     </form>
                 </div>
                 <div class="col-md-1">
                     <label class="text-success" style="padding: 5px">次序:</label>
                 </div>
                 <div class="col-md-2">
                     <form role="form">
                         <div class="form-group">
                             <select class="form-control" id="selectCount">
                                <option value="-1">===选择测评次序===</option>
                             </select>
                         </div>
                     </form>
                 </div>
                <!--功能区域-->
                 <div class="col-md-4">
                     <button type="button" id="search" class="btn btn-default">
                         <span class="glyphicon glyphicon-search"></span>查询</button>
                     <button type="button" id="export" class="btn btn-success" disabled>
                         <span class="glyphicon glyphicon-save"></span>一键导出</button>
                 </div>
             </div>
         </div>

         <div class="container" style="margin-top: 30px" id="content"></div>

         <hr>

         <!--得分区域-->
         <div class="container">
             <div id="sc">

             </div>
         </div>
     </c:if>

    <!--导入尾部-->
    <%@ include file="../common/footer.jsp"%>
    <script type="text/javascript" src="${path}/dist/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/dist/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="${path}/js/admin/index.js"></script>
    <script type="text/javascript" src="${path}/js/power/admin.js"></script>

    <script>
        $(function(){
            $("#selectClazzs").change(function(){
                var v = $(this).val();
                $.ajax({
                    type:'post',
                    data:'clazzName='+v,
                    url:'${path}/teacher/uniquekey',
                    success:function(data){
                        if(data=="0"){
                            alert("对不起!该班级尚未测评");
                            $("#content").html("");
                            $("#sc").html("");
                            $("#selectCount").html('<option value="-1">===选择测评次序===</option>');
                        }else{
                            var c = parseInt(data);
                            $("#selectCount").empty();
                            for(var i=0;i<c;i++){
                                $("#selectCount").append("<option value='"+i+"'>"+(i+1)+"</option>");
                            }
                        }
                    }
                });
            })
        });

        //實訓師平均分
        var total1;
        //班主任
        var total2;

        //總人數
        var mustCounts;
        //實際參與測評人數
        var onlineCounts;


        $(function(){
            $("#search").click(function(){
                total1 = 0;
                total2=0;
                mustCounts=0;
                onlineCounts=0;

                //获取班级名称...
                var cname = $("#selectClazzs").val();

                //获取统计次序..
                var v = $("#selectCount").val();

                if(v==-1 || cname==-1){
                    alert("请先选择班级!");
                    return;
                }

                $.ajax({
                    type:'post',
                    data:'clazzName='+cname+"&countOrder="+v,
                    url:'${path}/teacher/query',
                    success:function(data){
                        //定义一个变量.用来保存总分
                       var total = 0;

                        //项目经理总分
                       var countTotal = 0;

                        //班主任
                       var mt = 0;
                       var cmt = 0;

                        var str = "";
                        for(var i=0;i<data.length;i++){
                            if(data[i].questions.type==0){
                                total+=data[i].scoreVo.score;
                                countTotal+=5;
                            }else{
                                mt+=data[i].scoreVo.score;
                                cmt+=5;
                            }

                            str+="<div class='row'>"
                            str+="<div class='col-md-3'>";
                            str+="<span class='text-info'>";
                            str+=data[i].questions.content;
                            str+="</span>";
                            str+="</div>"
                            str+="<div class='col-md-7'>"
                               // str+=data[i].clazzName+":"+":"+data[i].ukey+":"+data[i].questions_id+":"+data[i].score;
                                if(data[i].scoreVo.score==5) {
                                    str += '<div class="progress" style="height:14px">';
                                    str += '<div id="' + i + '" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" style="width: ' + (data[i].scoreVo.score / 5 * 100) + '%" aria-valuemin="0" aria-valuemax="100"></div>';
                                    str +='</div>'
                                }else if(data[i].scoreVo.score>=4){
                                    str += '<div class="progress" style="height:14px">';
                                    str += '<div id="' + i + '" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" style="width: ' + (data[i].scoreVo.score / 5 * 100) + '%" aria-valuemin="0" aria-valuemax="100"></div>';
                                    str +='</div>'
                                }else{
                                    str += '<div class="progress" style="height:14px">';
                                    str += '<div id="' + i + '" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" style="width: ' + (data[i].scoreVo.score / 5 * 100) + '%" aria-valuemin="0" aria-valuemax="100"></div>';
                                    str +='</div>';
                                }
                            str+="</div>";
                            str+="<div class='col-md-1'><span class='text-success'>"+data[i].scoreVo.score.toFixed(2)+"</span>";
                            str+="</div>";
                            str+="</div>";
                         }
                        $("#content").html(str);
                        $("#sc").html("<span class='text-danger' style='font-size: 16px' >项目经理:"+(total/countTotal*100).toFixed(2)+"分</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='text-warning' style='font-size: 16px' >班主任:"+(mt/cmt*100).toFixed(2)+"分</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='text-info' style='font-size: 16px' >总人数:"+data[0].num+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='text-primary' style='font-size: 16px' >实际参与测评人数:"+data[0].onlineCounts+"</span>");
                        total1 = (total/countTotal*100).toFixed(2);
                        total2 = (mt/cmt*100).toFixed(2);
                        mustCounts = data[0].num;
                        onlineCounts = data[0].onlineCounts;

                        //啟動導出excel
                        $("#export").attr("disabled",false);
                    }
                });
            });
        });

        //導出excel
        $(function(){
            $("#export").click(function(){
                //獲取第幾次評價
                var v = $("#selectCount").find("option:selected").val();
                //获取班级名称...
                var cname = $("#selectClazzs").val();
                $(this).attr("disabled",true);
                 window.location='${path}/teacher/export?clazzName='+cname+"&countOrder="+v+"&total1="+total1+"&total2="+total2+"&mustCounts="+mustCounts+"&onlineCounts="+onlineCounts;
            });
        });
    </script>
</body>
</html>
