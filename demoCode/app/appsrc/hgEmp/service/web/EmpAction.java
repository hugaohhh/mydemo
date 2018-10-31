/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: EmpActioin.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:57:02 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: EmpActioin.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:57:02 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.service.web;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.omframe.common.service.interfaces.CenterConst;
import com.asiainfo.sh.so.sf.hgEmp.bo.BOEmpBean;
import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;
import com.asiainfo.sh.so.sf.hgEmp.service.interfaces.IEmpSV;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;

/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: EmpActioin.java
 * @Description: 员工的action 类
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:57:02 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
public class EmpAction extends BaseAction {
	
	// 打印日志
	public static final Log log = LogFactory.getLog(EmpAction.class);
	
	/**
	 * 
	 * @Function: EmpAction.java
	 * @Description: 更新员工
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 下午7:48:51 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public void updateEmp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CenterFactory.setCenterInfoByTypeAndValue(CenterConst.REGION_ID, "218");
		// 保存信息到jsp 页面
		CustomProperty customProperty = CustomProperty.getInstance(); 
		
		String resultValue = "1";
		
		IEmpSV empService = (IEmpSV) ServiceFactory.getService(IEmpSV.class);
		
		try {
			String empName = HttpUtil.getAsString(request, "empName");
			String empPhone = HttpUtil.getAsString(request, "empPhone");
			String empAddr = HttpUtil.getAsString(request, "empAddr");
			String empGender = HttpUtil.getAsString(request, "empGender");
			long empId = HttpUtil.getAsLong(request, "empId");
			
			// 先查询是否存在
			IBOEmpValue empValue = empService.queryEmpById(String.valueOf(empId), "1");
			if(empValue != null){
				empValue.setEmpName(empName);
				empValue.setEmpAddr(empAddr);
				empValue.setEmpGender(empGender);
				empValue.setEmpPhone(empPhone);
				empValue.setEmpId(empId);
				
				empService.saveEmp(empValue, "update");
				resultValue = "1";
				customProperty.set("resultMsg", "修改成功");
				
			}else{
				resultValue = "0";
				customProperty.set("resultMsg", "修改失败");
			}
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e);
			}
			resultValue = "0";
			customProperty.set("resultMsg", e.getMessage());
		}finally{
			customProperty.set("resultValue", resultValue);
			try {
				HttpUtil.showInfo(response, customProperty);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 
	 * @Function: EmpAction.java
	 * @Description: 保存员工
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 下午7:20:23 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public void saveEmp(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CenterFactory.setCenterInfoByTypeAndValue(CenterConst.REGION_ID, "218");
		// 保存信息到jsp 页面
		CustomProperty customProperty = CustomProperty.getInstance(); 
		
		String resultValue = "1";
		
		IEmpSV empService = (IEmpSV) ServiceFactory.getService(IEmpSV.class);
		
		try {
			String empName = HttpUtil.getAsString(request, "empName");
			String empPhone = HttpUtil.getAsString(request, "empPhone");
			String empAddr = HttpUtil.getAsString(request, "empAddr");
			String empGender = HttpUtil.getAsString(request, "empGender");
			
			IBOEmpValue empValue = new BOEmpBean();
			empValue.setEmpName(empName);
			empValue.setEmpAddr(empAddr);
			empValue.setEmpGender(empGender);
			empValue.setEmpPhone(empPhone);
            empValue.setDelState(1);

			empService.saveEmp(empValue, "addEmp");
			resultValue = "1";
			customProperty.set("resultMsg", "添加成功");
			
		} catch (AIException e) {
			// TODO Auto-generated catch block
			if(log.isErrorEnabled()){
				log.error(e.getMessage(),e);
			}
			resultValue = "0";
			customProperty.set("resultMsg", e.getMessage());
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error(e.getMessage(),e);
			}
			resultValue = "0";
			customProperty.set("resultMsg", e.getMessage());
		}finally{
			customProperty.set("resultValue", resultValue);
			// 功能：在前端页面显示信息，例如数据保存成功，数据校验通过等
			try {
				HttpUtil.showInfo(response, customProperty);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @Function: EmpAction.java
	 * @Description: 删除员工
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 下午7:38:01 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public void deleteEmp(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CenterFactory.setCenterInfoByTypeAndValue(CenterConst.REGION_ID, "218");
		CustomProperty customProperty = CustomProperty.getInstance();
		//设定删除信息标志位
		String resultValue = "1";
		IEmpSV empService = (IEmpSV) ServiceFactory.getService(IEmpSV.class);
		try {
			/**
			 * 2.获取页面传来的需要保存的数据，APPFrame会自动把这些数据转换为
			 * 	dataContainer 数组，对于简单的页面参数，
			 * 	也可以通过request.getParameter()获取。
			 *  因为有可能是批量删除
			 */
			DataContainerList[] dcList = HttpUtil.getDataContainerLists(request.getInputStream(), null);
			// 如果数组不为空，即请求参数不为空，才执行删除操作
			if(dcList != null && dcList.length > 0){
				
				int length = dcList[0].getAllDataContainerInterface().length;
				//遍历 dcList[0] 得到每一个 DataContainerInterface
				for(int i = 0; i < length; i++){
					DataContainerInterface dci = dcList[0].getAllDataContainerInterface()[i];
					String empId= dci.getAsString("EMP_ID");
					IBOEmpValue empById = empService.queryEmpById(empId, "1");
					// 当学生存在时才执行删除操作
					if(empById != null){
						empById.setDelState(0);
						empService.saveEmp(empById, "delEmp");
					}
				}
			}else{
				log.error("dataContainerLists数组为空");
			}
			
		}catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error(e);
				//设定标识位为删除失败
				resultValue = "0";
			}
		}finally{
			customProperty.set("resultValue", resultValue);
			try {
				HttpUtil.showInfo(response, customProperty);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try{
			}catch(Exception e){
				if(log.isErrorEnabled()){
					log.error(e);
				}
			}
		}
	}

}
