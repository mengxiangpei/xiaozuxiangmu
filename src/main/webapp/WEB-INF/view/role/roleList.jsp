<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/06/28
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/include.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- datagrid-->
<table id="roleDataGrid"></table>

<!-- datagrid 工具条 -->
<div id="tb">
    <a href="javascript:resourceDialog('showResourceDialog')" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">查看权限</a>
</div>

<!-- 查询资源dialog -->
<div id="showResourceDialog" style="diaplay:none">
    <fieldset>
        <legend>查看角色授权</legend>
        <ul name="resourceTree"></ul>
    </fieldset>
</div>

<script type="text/javascript">
    $(function(){
        $("#roleDataGrid").datagrid({
            url:sys.contextPath+'/role/selectRoleList.do',
            method:'post',
            columns:[[
                {field:'id',width:150,title:'ID'},
                {field:'name',width:150,title:'角色名'},
                {field:'description',width:150,title:'角色描述'},
            ]],
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
            toolbar: '#tb',
        });
    })

    //权限 dialog
    function resourceDialog(dialogId){
        //获取被选中的行
        var trObj = $("#roleDataGrid").datagrid('getSelected');
        if (trObj) {
            if (dialogId == 'showResourceDialog') {
                $("#"+dialogId).dialog({
                    title: '查看资源',
                    width: 400,
                    height: 400,
                    closed: false,
                    cache: false,
                    onBeforeOpen:function(){
                        //初始化 资源tree插件
                        initTree(dialogId,trObj.id);
                    }
                })
            }
        }
    }

    //初始化 资源tree插件
    function initTree(dialogId,roleId){
        var  ul = $("#"+dialogId).find('ul');
        $(ul).tree({
            url:sys.contextPath+'/resource/getResourceTree.do',
            method:'post',
            checkbox:true,
            onLoadSuccess:function(node,data){
                $.ajax({
                    url:sys.contextPath+'/resource/getResourceByRoleId.do',
                    type:'POST',
                    data:{'id':roleId},
                    dataType:'json',
                    success:function(data){
                        for (var i = 0; i < data.length; i++) {
                            //根据节点id获取node节点
                            var node =$(ul).tree('find',data[i].sysresourceId);
                            //当node节点存在是，判断node节点是否是叶子节点/子节点 --- isLeaf方法
                            if (node) {
                                //isLeaf 返回boolean类型---判断node节点是否是叶子节点
                                var isLeaf = $(ul).tree('isLeaf',node.target)
                                if (isLeaf) {
                                    //选中该节点
                                    $(ul).tree('check',node.target);
                                }
                            }
                        }
                    }
                })
            }
        });
    }

</script>
</body>
</html>
