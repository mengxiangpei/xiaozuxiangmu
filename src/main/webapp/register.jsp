<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="registerDialog" style="display:none;">
		<form id="registerForm" class="easyui-form">
            <div>
        <label for="sysuserLoginname">账户名称:</label>
        <input class="easyui-validatebox" type="text" name="sysuserLoginname" id="sysuserLoginname" onblur="checkLoginName(this.value)" data-options="required:true"  />
    </div>   
    <div>   
        <label for="sysuserPwd">账户密码:</label>
        <input class="easyui-validatebox" type="password" id="sysuserPwd" name="sysuserPwd"
        data-options="required:true,validType:'length[6,18]'"    />   
    </div>   
    <div>   
       <label for="sysuserPwd2">确认密码:</label>
       <input class="easyui-validatebox" type="password" id="sysuserPwd2" name="sysuserPwd2"
       data-options="required:true"  validType="equals['#sysuserPwd']"/>
   	 </div>   
    <div>
	    	<label>验证码:</label>
	    	<input  class="easyui-validatebox"  data-options="required:true" name="imgcode" type="text" id="imgcode" style="width:60px"/>
	    	<img src="<%=request.getContextPath()%>/imageCode" id="imgcoode">
	   		<input class="l-btn" value="看不清换一个" type="button" onclick="getImageCode(this)"/>
	   	</div>
	</form>
</div>

<script type="text/javascript">
function checkLoginName(value){
	var flag = null;
	$.ajax({
		url:sys.contextPath+'/checkSysUser.do',
		type:'post',
		//同步
		async:false,
		data:{'sysuserLoginname':value},
		success:function(data){
			//用户不存在返回true
			if (data.success) {
				flag = true;
			//	$.messager.alert('警告','用户名可用');
			}else{
				//用户存在返回false
				$.messager.alert('警告','用户已存在',"error");
				flag = false;
			}
		}
	})

	//自定义验证规则
	$.extend($.fn.validatebox.defaults.rules, {
	    loginNameChk: {
	        validator: function(value,param){
	            return flag;
	        },
	        message: '两次密码输入不一致'
	    }
	});
}
$(function(){
	//自定义验证规则----两次密码必须一致
	$.extend($.fn.validatebox.defaults.rules, {
	    equals: {
	        validator: function(value,param){
	            return value == $(param[0]).val();
	        },
	        message: '两次密码输入不一致'
	    }
	});

	//自定义验证规则----账户名称至少5位
	$.extend($.fn.validatebox.defaults.rules, {
	    minLength: {
	        validator: function(value, param){
	            return value.length >= param[0];
	        },
	        //return false时提示messager的信息
	        message: '账户名称至少5位'
	    }
	});

	//自定义验证规则----账户名称是否已经注册
	$.extend($.fn.validatebox.defaults.rules, {
	    loginNameCheck: {
	        validator: function(value, param){

	        	var flag = false;

	        	console.info(value);//info() log() error()
	        	$.ajax({
	        		url:sys.contextPath+'/checkSysUser.do',
	        		type:'post',
	        		//同步
	        		async:false,
	        		data:{'sysuserLoginname':value},
	        		success:function(data){
	        			//用户不存在返回true
	        			if (data.success) {
							flag = true
						}
	        		}
	        	})
	            return flag;
	        },
	        //return false时提示messager的信息
	        message: '账户名称已经注册，请更换'
	    }
	});
})


$(function(){
	$("#registerDialog").show().dialog({
		//模式化窗口
		modal:true,
		closable:false,
		iconCls:'',
		top:200,
		buttons:[{
			text:'登录',
			handler:function(){
				location.href(sys.contextPath+'/login.jsp')
			}
		},{
			text:'注册',
			iconCls:'',
			handler:function(){
				registerSysUser()
			}
		},{
			text:'重置',
			iconCls:'',
			handler:function(){
				$('form').form('reset');
			}
		}],
		onOpen : function() {
			$('form :input:first').focus();
			$('form :input').keyup(function(event) {
				if (event.keyCode == 13) {
					regFun();
				}
			});
		}
	});
});
//注册用户
function registerSysUser(){
	var flag=$('form').form('validate')
	if(flag){
		$.ajax({
			url:'<%=request.getContextPath()%>/registerSysUser.do',
			type:'post',
			data:$("#registerForm").serialize(),
			dataType:'json',
			success:function(data){
				if(data){
 				$.messager.alert('提示信息',data.msg,'info');
 				window.location.href="<%=request.getContextPath()%>/login.jsp";
				}
 			},
 			error:function(){
 				$.messager.alert('警告','ajax请求失败，请联系管理员确认人品！');
 			}
		});
	}
}

 var countdown=10;
	//随机生成验证码图片
	function getImageCode(val){
		if (countdown == 0) {
			var thisDate =  new Date();
			//区分当前请求和上一次请求
			document.getElementById("imgcoode").src="<%=request.getContextPath()%>/imageCode?sjNum="+thisDate.getTime();
			$(val).attr("disabled",false);    
	 		$(val).val("免费获取验证码"); 
	 		countdown = 10; 
		} else { 
	 		$(val).attr("disabled", true); 
	 		$(val).val('重新发送('+countdown+')'); 
	 		countdown--; 
	 		setTimeout(function() { 
	 			getImageCode(val) 
	 		},1000) 
		}  
	}
	 
</script>
</body>
</html>