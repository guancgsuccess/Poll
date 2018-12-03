/**
 * 选择问卷
 */
$("#selectQuestions").change(function(){
    window.location="/Poll/teacher/index?status="+$(this).val();
});
