<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2017/6/27
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/include.jsp" %>
<html>
<head>
    <title>Title</title>

</head>
<body>


<!-- easyui渲染方式二  datagrid() -->
<table id="userDataGrid"></table>
<!--弹框新增-->
<div id="addUsers"></div>
<!-- datagrid 工具条 -->
<div id="tb" class="easyui-panel">
    <a href="javascript:addUser()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">新增</a>
</div>

<%--<!-- 查看角色 dialog -->--%>
<%--<div id="showRoleDialog">--%>
<%--<fieldset>--%>
<%--<legend>角色授权</legend>--%>
<%--<ul id="roleTree"></ul>--%>
<%--</fieldset>--%>
<%--</div>--%>
<script type="text/javascript">

    //新增
    function addUser(){
        $('#addUsers').dialog({
            title: '新增产品',
            width: 750,
            height: 550,
            closed: false,
            cache: false,
            href: '<%=request.getContextPath()%>/sys/addUser.do',
            modal: true,
            onClose:function(){
                //清空addProDIV的内容防止记住上次表单中添写的内容
                $('#addUsers').html('');
            },
            buttons:[{
                text:'保存',
                handler:function(){
                    //发送ajax请求做添加产品到数据库
                    $.ajax({
                        url:'<%=request.getContextPath()%>/sys/seaveUserInfo.do',
                        type:'POST',
                        data:$("#userID").serialize(),
                        dataType:'json',
                        success:function(data){
                            //提示添加产品成功/失败
                            if (data.success) {
                                alert('消息',data.msg,'info');
                            }
                            //添加成功 1.dataGrid刷新
                            $("#userID").datagrid('reload');
                            //dialog关闭
                            $('#addUsers').dialog('close');
                        },
                        error:function(){
                            $.messager.alert('消息','ajax请求失败！','warning');
                        }
                    })
                }
            },{
                text:'关闭',
                handler:function(){
                    //dialog关闭
                    $('#addUsers').dialog('close');
                }
            }]
        });
    }


    <!--页面加载时 查询userlist集合 -->
    $(function(){
        $("#userDataGrid").datagrid({
            url:'<%=request.getContextPath()%>/sys/selectUserList.do',
            method:'post',
            pagination:true,
            rownumbers:true,
            pageNumber:1,
            pageSize:2,
            pageList:[2,4,6,8],
            striped : true,
            singleSelect : true,
            idField : 'id',
            loadMsg:'候着。。。',
            toolbar: '#tb',
            columns:[
                [
                    {field:'userId',title:'ID',width:120},
                    {field:'userName',title:'账户名',width:120},
                    {field:'userPwd',title:'真实名',width:120},
                    {field:'userTel',title:'创建时间',width:120},
                    {field:'userTime',title:'修改时间',width:120}
                ]
            ]
        });
    });


</script>
</body>
</html>
