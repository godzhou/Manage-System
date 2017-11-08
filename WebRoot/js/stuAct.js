/**
 * Created by pengxiang on 11/08 0008.
 */
$.ajax({
    dataType:"json",    //数据类型为json格式
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    type:"GET",
    url:"/ajaxTest/TestServlet",
    statusCode: {404: function() {
        alert('page not found'); }
    },
    success:function(data,textStatus){
        $("#sp").html("<table border='1'><tr><td>序号</td><td>姓名</td><td>年龄</td></tr>"+
            "<tr><td>"+data.people[0].id+"</td><td>"+data.people[0].name+"</td><td>"+data.people[0].age+"</td>"+
            "<tr><td>"+data.people[1].id+"</td><td>"+data.people[1].name+"</td><td>"+data.people[1].age+"</td></tr></table>");
    }
});