<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.common.ServiceManager"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.client.OrgmodelClient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���Ա��</title>
</head>
<body>

	<ai:contractframe title = "ѧ����Ϣ" id = "Search" contenttype = "table" 
	width = "600px" allowcontract = "false" frameclosed = "false">
	<ai:dbform formid = "saveEmpForm" 
	setname = "com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp" initial = "false" editable = "true">
	<table width = "100%" align = "center" border = "0" cellpadding = "1" cellspacing = "2" >
		<tr>
			<td class = "td_font">����<font size="2px" color="red">*</font></td>
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_id" width = "200" height = "30" editable = "false" visible = "true" /></td>
			<td class = "td_font">����<font size="2px" color="red">*</font></td> 
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_name" width = "200" height = "30" editable = "true" visible = "true" /></td>
		</tr>
		<tr>
			
			<td class = "td_font">��ַ</td> 
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_addr" width = "200" height = "30" editable = "true" visible = "true" /></td>
			<td class = "td_font">��ϵ��ʽ<font size="2px" color="red">*</font></td>
			<td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_phone" width = "200" height = "30" editable = "true" visible = "true" /></td>
		</tr>
		<tr>
			 <td class = "td_font">�Ա�</td> 
			<%-- <td><ai:dbformfield formid = "saveEmpForm" fieldname = "emp_gender" 
			width = "200" height = "30" editable = "true" visible = "true" /></td> --%>
			<td><ai:listbox ds="com.asiainfo.sh.so.sf.hgEmp.bo.set.DSEmp"  showtype="list"
				multiselect="true" listsize="2"
				nulltext="��ѡ��......" id="sex" width="100" nullid="-1"/>
			</td>
		</tr>
		
		<tr>
			<td class = "td_font">ע����ɫ*Ϊ����</td>
		</tr>
	</table>
	</ai:dbform>
	</ai:contractframe>
	
	<div class = "area_button">
		<ai:button text = "ȷ��" id = "saveBtn" onclick = "saveEmp()" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<ai:button text = "����" id = "resetBtn" onclick = "reSet()" />
	</div>
	

</body>
<script type="text/javascript">

	//initList();//ҳ���ʼ��ʱִ��
	
	function initList(){
		var listbox = createStaticListDataSource("com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp",null);
		listbox.fillListBox(null,null,document.all("org"));
		document.all("org").value=20;//����Ĭ��Ϊ20
	}

	function saveEmp(){ 
		
		//У��
		if(g_FormRowSetManager.get("saveEmpForm").validate("emp_name",true,true) == false){
			//���õ�ǰ������ĳ���ֶ���
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
			alert("�ֻ������ʽ����ȷ");
			return; 
		} 
		 
		
		var empName = g_FormRowSetManager.get("saveEmpForm").getValue("emp_name");
		var empAddr = g_FormRowSetManager.get("saveEmpForm").getValue("emp_addr");
		var empPhone = g_FormRowSetManager.get("saveEmpForm").getValue("emp_phone");
		
		var empGender = g_getListBox("sex").getValue();
		
		// ƴ�Ӳ���
		var param = "&empName="+empName+"&empAddr="+empAddr+"&empPhone="+empPhone+"&empGender="+empGender;
		alert(param);
		// ƴ��URL
		var url = _gModuleName + "/business/com.asiainfo.sh.so.sf.hgEmp.service.web.EmpAction?action=saveEmp"+param;
		

		var result = PostInfo(url,"");
		var resultValue = result.getValueByName("resultValue");
		if(resultValue == "1"){
		    alert("��ӳɹ�");
			closeWindow();
		}else{
		    alert("���ʧ��");
		}

		
	}
	
	/**
	�رմ���
	*/
	function closeWindow(){
		window.close();
	}
	
	/*
	���ð�ť����
	*/
	function reSet(){
		g_FormRowSetManager.get("saveEmpForm").clearValue("emp_name");
		g_FormRowSetManager.get("saveEmpForm").clearValue("emp_addr");
		g_FormRowSetManager.get("saveEmpForm").clearValue("emp_phone");
		//g_FormRowSetManager.get("saveEmpForm").clearValue("emp_gender");
	}

</script>
</html>