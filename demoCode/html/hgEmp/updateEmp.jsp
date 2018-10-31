<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="UTF-8"%>
<%@ page import="com.ai.appframe2.common.ServiceManager"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.client.OrgmodelClient"%>
<html>
<head>
<title>更新员工</title>
</head>
<body onload="init()">

<ai:contractframe title = "员工信息" id = "updateEmp" contenttype = "table" 
	width = "100%" allowcontract = "false" frameclosed = "false">
	<ai:dbform formid="updateEmpForm"
			   setname="com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp"
			   initial="false" editable = "true"
               conditionname="condition"
			   datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			   implservice_name="com.asiainfo.sh.so.sf.hgEmp.service.interfaces.IEmpSV"
			   implservice_querymethod="queryEmpById(String empId,String delState)">
		<table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">	
  			<tr>
                <td class = "td_font">工号<font size="2px" color="red">*</font></td>
                <td><ai:dbformfield formid = "updateEmpForm" fieldname = "emp_id" width = "200" height = "30" editable = "false" visible = "true" /></td>
                <td class = "td_font">姓名<font size="2px" color="red">*</font></td>
                <td><ai:dbformfield formid = "updateEmpForm" fieldname = "emp_name" width = "200" height = "30" editable = "true" visible = "true" /></td>
	 	    </tr>
	 	    <tr>
                <td class = "td_font">地址</td>
                <td><ai:dbformfield formid = "updateEmpForm" fieldname = "emp_addr" width = "200" height = "30" editable = "true" visible = "true" /></td>
                <td class = "td_font">联系方式<font size="2px" color="red">*</font></td>
                <td><ai:dbformfield formid = "updateEmpForm" fieldname = "emp_phone" width = "200" height = "30" editable = "true" visible = "true" /></td>
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
		</table>
	</ai:dbform>
</ai:contractframe>

	
	<div class="area_button">
	  	<ai:button text="保存" id="updateBtn" onclick="updateEmp()"/>
	  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  	<ai:button  text="关闭" id="backBtn" onclick="closeWindow()"/>
	</div>

</body>
<script type="text/javascript">

	//获取到员工id并且准备回显
	var empId = <%=request.getParameter("empId")%>;
 	if(empId != null){
 		empId = g_StringTrim(empId);
	} 
	 	
 	/**
 	 * 初始化编辑界面
 	 */
 	function init(){
// 	    alert(empId);
 		//根据主界面传来的empId判断，不为空表示修改学生信息，并回显该学生信息
 		if(empId != null){
 			var updateEmpForm = g_FormRowSetManager.get("updateEmpForm");
 			// 刷新回显
 			updateEmpForm.refresh("&empId="+empId+"&delState=1");
 		}
 	}

 	// 更新员工信息
	function updateEmp(){
		//校验
		if(g_FormRowSetManager.get("updateEmpForm").validate("emp_name",true,true) == false){
			//设置当前焦点在某个字段上
			g_FormRowSetManager.get("updateEmpForm").setFocus("emp_name");
			return;
		}
		if(g_FormRowSetManager.get("updateEmpForm").validate("emp_addr",true,true) == false){
			g_FormRowSetManager.get("updateEmpForm").setFocus("emp_addr");
			return;
		}
		if(g_FormRowSetManager.get("updateEmpForm").validate("emp_phone",true,true) == false){
			g_FormRowSetManager.get("updateEmpForm").setFocus("emp_phone");
			return;
		}else if(!g_IsMobileNumber(g_FormRowSetManager.get("updateEmpForm").getValue("emp_phone"))){
			alert("手机号码格式不正确");
			return; 
		}  
		
		var empName = g_FormRowSetManager.get("updateEmpForm").getValue("emp_name");
		var empAddr = g_FormRowSetManager.get("updateEmpForm").getValue("emp_addr");
		var empPhone = g_FormRowSetManager.get("updateEmpForm").getValue("emp_phone");
		
		var empGender = g_getListBox("sex").getValue();
		// 拼接参数
		var param = "&empId="+empId+"&empName="+empName+"&empAddr="+empAddr+"&empPhone="+empPhone+"&empGender="+empGender;
		alert(param);
		// 拼接URL
		var url = _gModuleName + "/business/com.asiainfo.sh.so.sf.hgEmp.service.web.EmpAction?action=updateEmp"+param;
		
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

</script>

</html>