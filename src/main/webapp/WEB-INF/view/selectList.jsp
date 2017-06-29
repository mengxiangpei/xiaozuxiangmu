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
<!-- ID唯一！！！  -->

<!-- 条件查询表单 -->

<!-- easyui渲染方式二  datagrid() -->
<table id="userDataGrid"></table>

<!-- datagrid 工具条 -->
<div id="tb">
    <a href="javascript:showRoleInfo(1)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">查看角色</a>
    <a href="javascript:showRoleInfo(2)" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">修改角色</a>
</div>

<%--<!-- 查看角色 dialog -->--%>
<%--<div id="showRoleDialog">--%>
<%--<fieldset>--%>
<%--<legend>角色授权</legend>--%>
<%--<ul id="roleTree"></ul>--%>
<%--</fieldset>--%>
<%--</div>--%>
<script type="text/javascript">
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
            rownumbers : true,
            pagination : true,
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
                    {field:'userTime',title:'修改时间',width:120},
                ]
            ]
        });
    });


</script>
</body>
</html>
