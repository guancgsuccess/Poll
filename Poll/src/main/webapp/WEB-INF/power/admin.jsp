<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2018/7/26 0026
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--管理员区域-->
<c:if test="${u.power==0}">
    <div class="container">
        <!--功能区域-->
        <div class="row">
            <div class="col-md-2">
                <form role="form">
                    <div class="form-group">
                        <select class="form-control" id="selectQuestions">
                            <option value="-1">===选择问卷===</option>
                            <c:forEach begin="1" var="v" end="${questionTotal}">
                                <option value="${v-1}" <c:if test="${status==v-1}">selected</c:if>>第${v}套问卷</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="col-md-2">
                <form role="form">
                    <div class="form-group">
                        <select class="form-control" id="selectClazz">
                            <option value="-1">===选择班级===</option>
                            <c:forEach items="${clazzList}" var="c">
                                <option value="${c.id}">${c.clazzName}-${c.teacher}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-default" onclick="start()" id="start">开始调查</button>
                <button type="button" class="btn btn-danger" id="end">结束调查</button>
            </div>
        </div>
    </div>

    <!--问题域-->
    <div class="container">
        <div class="table-responsive">
            <table class="table table-hover">
                <caption>问卷模板</caption>
                <thead>
                    <tr>
                        <th class="small" width="30px">编号</th>
                        <th class="small">调查内容</th>
                        <th colspan="4" class="small">选择</th>
                        <th class="small" width="55px">考察对象</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${questions}" var="qst" varStatus="vs">
                    <tr class="small">
                        <td>${vs.count}</td>
                        <td>${qst.content}</td>
                        <td>
                            <label class="checkbox-inline">
                                <input type="radio" id="inlineCheckbox1" value="option1">${qst.selection1}
                            </label>
                        </td>
                        <td>
                            <label class="checkbox-inline">
                                <input type="radio" id="inlineCheckbox2" value="option1">${qst.selection2}
                            </label>
                        </td>
                        <td>
                            <label class="checkbox-inline">
                                <input type="radio" id="inlineCheckbox3" value="option1">${qst.selection3}
                            </label>
                        </td>
                        <td>
                            <label class="checkbox-inline">
                                <input type="radio" id="inlineCheckbox4" value="option1">${qst.selection4}
                            </label>
                        </td>
                        <td>${qst.type==0?"实训师":"班主任"}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>