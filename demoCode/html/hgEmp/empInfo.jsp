<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8" %>
<%@ page import="com.ai.appframe2.common.ServiceManager" %>
<%@ include file="/webframe/common/commonhead.jsp" %>
<%@ page import="com.ai.secframe.client.OrgmodelClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>emp Test</title>

</head>
<body>
	<!-- 查询 -->
	<ai:contractframe title="查询条件" id="queryEmpById" contenttype = "table" 
	width = "100%" allowcontract = "false" frameclosed = "false">
   <%-- <ai:contractitem /> --%>
   
   <ai:dbform formid="empBaseInfo" setname="com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp" initial="false"
   conditionname="condition" parametersname="parameters"  editable="true">
   <table width="100%" align = "center" border = "0" id = "selectTable">
     <tr>
        <td class = "td_font">员工编号:</td>
        <td>
        	<ai:dbformfield formid="empBaseInfo" fieldname="emp_id" 
        	width="300" height="20" editable="true" visible="true" />
        </td>
        <td class = "td_font">员工姓名:</td>
        <td>
        	<ai:dbformfield formid="empBaseInfo" fieldname="emp_name" 
        	width="300" height="20" editable="true" visible="true" />
        </td>
        <td class = "td_button">
        	<ai:button text = "查询" id = "queryButton" onclick ="queryEmp();"/>
        </td>
     </tr>
     </table>
    </ai:dbform>
  </ai:contractframe>
  
  <!-- 以表格的形式显示员工信息  -->	
  <ai:contractframe id = "empInfoForm" contenttype = "table" title = "员工表" width = "100%" allowcontract = "false" frameclosed = "false" >
  <!-- 换行操作 -->
  	<ai:contractitem />	
	<ai:table  tableid="empInfoTable" 
		setname="com.asiainfo.sh.so.sf.hgEmp.bo.set.SETEmp"
		initial="false" multiselect = "true" editable = "false" 
		needrefresh = "true" ondbclick = ""
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sh.so.sf.hgEmp.service.interfaces.IEmpSV"
		implservice_querymethod="queryEmps(String empId, String empName, int $STARTROWINDEX,int $ENDROWINDEX)"
		implservice_countmethod="queryEmpsCount(String empId,String empName)"
		height="210" width="100%" pagesize="10">
		
		<ai:col fieldname="emp_id" width="20%" editable="false" title="员工编号" visible="true" />
		<ai:col fieldname="emp_name" width="20%" editable="false"  title="员工姓名" visible="true" />
		<ai:col fieldname="emp_addr" width="20%" editable="false"  title="员工地址" visible="true" />
		<ai:col fieldname="emp_gender" width="20%" editable="false"  title="员工性别" visible="true" />
		<ai:col fieldname="emp_phone" width="20%" editable="false"  title="员工电话" visible="true" />
		
	</ai:table>
	<!-- 增删改查 -->
        <div class = "area_button">
        <ai:button text = "增加" id = "addBut" onclick = "addEmp();" />
        <ai:button text = "删除" id = "delBut" onclick = "deleteEmp();" />
        <ai:button text = "修改" id = "editBut" onclick = "updateEmp();" />
        <a onclick="javascript:(this.href=g_TableRowSetManager.get('empInfoTable').toExcelUrl('员工信息'))" href="#">
        	<ai:button text="导出excel报表" id="daoBut" /></a>
        </div>
	</ai:contractframe>
	

</body>

<script type="text/javascript">

	// 删除员工
	function deleteEmp(){
		// 获取 empTable 
		var empTable = g_TableRowSetManager.get("empInfoTable");
		// toXmlStringOfSelects(colnames,isIncludeDisplayAttr):将选中数据行转化为Xml字符串
		var empXml = empTable.toXmlStringOfSelects();
		// 获取被选中的长度
		var delEmpLength = empTable.getSelectedRows().length;
		// 判断是否选中
		if(delEmpLength == 0){
			alert("请选择要删除的员工");
			return ;
		}
		if(!confirm("确定删除所选项吗？")) return;
		
		// 创建一个xml 字符串
		var xml = "<RootInfo>" + empXml + "</RootInfo>";
		// 拼接URL
		var delURL = _gModuleName + "/business/com.asiainfo.sh.so.sf.hgEmp.service.web.EmpAction?action=deleteEmp";
		alert(xml);
		// 将删除的url 和 xml 字符串传入  Action 方法中
		var result = PostInfo(delURL,xml);
		if(result.getValueByName("resultValue") == "1"){
			alert("删除成功");
		}else{
			alert("删除失败");
		}
		g_TableRowSetManager.get("empInfoTable").refresh("empId=0&empName="); 
		return ;
	}

	/**
	添加员工 
	*/
	function addEmp(){
		// 跳转到添加页面
		var saveURL = _gModuleName + "/sh/so/sf/hgEmp/addEmp.jsp";
		// 允许滚动，高 300 宽600
		// alert(saveURL);
		var features = "scroll:yes;resizable:no;status:no;dialogHeight:300px;dialogWidth:600px";
		window.showModalDialog(saveURL,"",features);
		g_TableRowSetManager.get("empInfoTable").refresh("empId=0&empName=");
	}
	
	/**
	 * 获取员工ID 和 员工姓名 查询员工
	 */
	function queryEmp() {
		try{
			var empId = g_FormRowSetManager.get("empBaseInfo").getValue("emp_id");
			var empName = g_FormRowSetManager.get("empBaseInfo").getValue("emp_name");
			alert(empId + "--->" + empName);
			if(empId != null){
				empId = g_StringTrim(empId);
			}else{
				empId = "";
			}
			
			if(empName != null){
				empName = g_StringTrim(empName);
			}else{
				empName = "";
			}
			//根据sid和sname刷新出数据，展示在页面
			params = "empId=" + empId + "&empName=" + empName;
			g_TableRowSetManager.get("empInfoTable").refresh(params);
		
		}catch(e){
			console.log(e);
		}
	}
	
	/**
	* 更新员工
	*/
	function updateEmp(){
		//获取勾选的列数，完成学生信息的修改功能
		var empTable = g_TableRowSetManager.get("empInfoTable");
		var selectedEmp = empTable.getSelectedRows().length;
		if(selectedEmp == 0){
			alert("您没有选择一项");
			return ;
		}else if(selectedEmp > 1){
			alert("只能选择一条");
			return ;
		}
		// 获取选中行行号数组
		var empRows = empTable.getSelectedRows();
		// 获取指定单元的数据值，参数为行号、列名
		var empId = empTable.getValue(empRows[0],"emp_id");

		var updateURL =  _gModuleName+ "/sh/so/sf/hgEmp/updateEmp.jsp?empId="+empId;
		var features = "scroll:yes;resizable:no;status:no;dialogHeight:200px;dialogWidth:600px";
		window.showModalDialog(updateURL, window, features);
		g_TableRowSetManager.get("empInfoTable").refresh("empId=0&empName=");
		return ;
	}
	
</script>
</html>