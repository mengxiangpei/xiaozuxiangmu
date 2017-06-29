<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp"%>

<html>
<head>
    <title>Title</title>
    <div id="tb" class="easyui-panel">
        <a href="javascript:addUser()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">新增</a>
    </div>
</head>
<body>
<div id="addUsers"></div>
<div id="userAddForm"></div>
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

</script>
</body>
</html>
