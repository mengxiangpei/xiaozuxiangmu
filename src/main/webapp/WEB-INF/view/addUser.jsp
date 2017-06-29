<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="userID" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="userName" class="easyui-validatebox"  data-options="required:true" />
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="text" name="userPwd" class="easyui-validatebox"  data-options="required:true" />            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td>
                <input type="text" name="userTel" class="easyui-validatebox"  data-options="required:true" />            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="userEmail" class="easyui-validatebox"  data-options="required:true" />            </td>
        </tr>
    </table>
</form>

</body>
</html>
