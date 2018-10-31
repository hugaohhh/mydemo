<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.common.ServiceManager"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.client.OrgmodelClient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加员工</title>
</head>
<body>

	<ai:contractframe title = "学生信息" id = "Search" contenttype = "table" 
	width = "600px" allowcontract = "false" frameclosed = "false">
	<ai:dbform formid = "saveEmpForm" 
	setname = "com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp" initial = "false" editable = "true">
	<table width = "100%" align = "center" border = "0" cellpadding = "1" cellspacing = "2" >
		<tr>
			<td class = "td_font">工号<font size="2px" color="red">*</font></td>
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_id" width = "200" height = "30" editable = "false" visible = "true" /></td>
			<td class = "td_font">姓名<font size="2px" color="red">*</font></td> 
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_name" width = "200" height = "30" editable = "true" visible = "true" /></td>
		</tr>
		<tr>
			
			<td class = "td_font">地址</td> 
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_addr" width = "200" height = "30" editable = "true" visible = "true" /></td>
			<td class = "td_font">联系方式<font size="2px" color="red">*</font></td>
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_phone" width = "200" height = "30" editable = "true" visible = "true" /></td>
		</tr>
		<tr>
			 <td class = "td_font">性别</td> 
			<%-- <td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_gender" 
			width = "200" height = "30" editable = "true" visible = "true" /></td> --%>
			<td><ai:listbox ds="com.asiainfo.sh.so.sf.hgEmp.bo.set.DSEmp"  showtype="list"
				multiselect="true" listsize="2"
				nulltext="请选择......" id="sex" width="100" nullid="-1"/>
			</td>
		</tr>
		
		<tr>
			<td class = "td_font">注：红色*为必填</td>
		</tr>
	</table>
	</ai:dbform>
	</ai:contractframe>
	
	<div class = "area_button">
		<ai:button text = "确定" id = "saveBtn" onclick = "saveEmp()" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<ai:button text = "重置" id = "resetBtn" onclick = "reSet()" />
	</div>
	

</body>
<script type="text/javascript">

	//initList();//页面初始化时执行
	
	function initList(){
		var listbox = createStaticListDataSource("com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp",null);
		listbox.fillListBox(null,null,document.all("org"));
		document.all("org").value=20;//设置默认为20
	}

	function saveEmp(){ 
		
		//校验
		if(g_FormRowSetManager.get("saveEmpForm").validate("emp_name",true,true) == false){
			//设置当前焦点在某个字段上
			g_FormRowSetManager.get("saveEmpForm").setFocus("emp_name");
			return;
		}
		if(g_FormRowSetManager.get("saveEmpForm").validate("emp_addr",true,true) == false){
			g_FormRowSetManager.get("saveEmpForm").setFocus("emp_addr");
			return;
		}
		if(g_FormRowSetManager.get("saveEmpForm").validate("emp_phone",true,true) == false){
			g_FormRowSetManager.get("saveEmpForm").setFocus("emp_phone");
			return;
		}else if(!g_IsMobileNumber(g_FormRowSetManager.get("saveEmpForm").getValue("emp_phone"))){
			alert("手机号码格式不正确");
			return; 
		} 
		 
		
		var empName = g_FormRowSetManager.get("saveEmpForm").getValue("emp_name");
		var empAddr = g_FormRowSetManager.get("saveEmpForm").getValue("emp_addr");
		var empPhone = g_FormRowSetManager.get("saveEmpForm").getValue("emp_phone");
		
		var empGender = g_getListBox("sex").getValue();
		
		// 拼接参数
		var param = "&empName="+empName+"&empAddr="+empAddr+"&empPhone="+empPhone+"&empGender="+empGender;
		alert(param);
		// 拼接URL
		var url = _gModuleName + "/business/com.asiainfo.sh.so.sf.hgEmp.service.web.EmpAction?action=saveEmp"+param;
		

		var result = PostInfo(url,"");
		var resultValue = result.getValueByName("resultValue");
		if(resultValue == "1"){
		    alert("添加成功");
			closeWindow();
		}else{
		    alert("添加失败");
		}

		
	}
	
	/**
	关闭窗口
	*/
	function closeWindow(){
		window.close();
	}
	
	/*
	重置按钮功能
	*/
	function reSet(){
		g_FormRowSetManager.get("saveEmpForm").clearValue("emp_name");
		g_FormRowSetManager.get("saveEmpForm").clearValue("emp_addr");
		g_FormRowSetManager.get("saveEmpForm").clearValue("emp_phone");
		//g_FormRowSetManager.get("saveEmpForm").clearValue("emp_gender");
	}

</script>
</html>