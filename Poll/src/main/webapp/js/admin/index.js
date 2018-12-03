/**
 * Created by Administrator on 2018/7/25 0025.
 */
function start(){
    var qst = $("#selectQuestions").val();
    var cla = $("#selectClazz").val();
    if(qst==-1){
        alert("sorry,请先选择一套问卷!");
        return;
    }

    if(cla == -1) {
        alert("sorry,请先选择调查班级");
        return;
    }
    $.ajax({
        type:'post',
        data:'qst='+qst+"&cla="+cla,
        url:'/Poll/teacher/check',
        success:function(data){
            if(data=="0"){
                alert("调查进行中...")
            }
        }
    });
}
    $("#end").click(function(){
        $.ajax({
            type:'post',
            url:'/Poll/teacher/stopCheck',
            success:function(data){
                if(data=="0"){
                    alert("本次调查已经结束了!");
                }
            }
        });
    });