/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: EmpSVImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:28:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: EmpSVImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:28:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.service.impl;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.omframe.common.service.interfaces.CenterConst;
import com.ai.omframe.util.InsServiceFactory;
import com.asiainfo.sh.so.sf.hgEmp.dao.impl.IEmpDaoImpl;
import com.asiainfo.sh.so.sf.hgEmp.dao.interfaces.IEmpDao;
import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;
import com.asiainfo.sh.so.sf.hgEmp.service.interfaces.IEmpSV;

/**
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: EmpSVImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:28:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
public class EmpSVImpl implements IEmpSV {

	@Override
	public int saveEmp(IBOEmpValue empValue, String methodStr) throws Exception {
//		IEmpDao empDao = (IEmpDao) ServiceFactory.getService(IEmpDao.class);
		IEmpDao empDao = new IEmpDaoImpl();
		if(methodStr != null && methodStr.length() >0) {
			if("addEmp".equals(methodStr)){
				// 如果是添加emp 就获取一个id

                long empId = InsServiceFactory.getInstanceSrvAttrDao().getNewId();
//                empId = empId / 100000;
                empValue.setEmpId(empId);
			}
			// 保存emp
			empDao.saveEmp(empValue);
			return 1;
		}
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see hugao.demo.emp.service.interfaces.IEmpSV#queryEmps(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public IBOEmpValue[] queryEmps(String empId, String empName, int begin,int end) throws Exception {
		System.out.println(empId+"==========>"+empName);
//		IEmpDao empDao = (IEmpDao) ServiceFactory.getService(IEmpDao.class);
		IEmpDao empDao = new IEmpDaoImpl();
		IBOEmpValue[] employees = empDao.queryEmployees(empId, empName, "1", begin, end);
		
		return employees;
	}

	@Override
	public int queryEmpsCount(String empId, String empName) throws Exception {
		//IEmpDao empDao = (IEmpDao) ServiceFactory.getService(IEmpDao.class);
		IEmpDao empDao = new IEmpDaoImpl();
		int empCount = empDao.queryEmpCount(empId, empName, "1");
		
		return empCount;
	}

	@Override
	public IBOEmpValue queryEmpById(String empId, String delState) throws Exception {
//		IEmpDao empDao = (IEmpDao) ServiceFactory.getService(IEmpDao.class);
		IEmpDao empDao = new IEmpDaoImpl();
		IBOEmpValue[] employees = empDao.queryEmployees(empId, "", delState, -1, -1);
		if(employees != null && employees.length > 0){
			// 查询出来就返回第一个
			return employees[0];
		}
		// 否则返回null
		return null;
	}

}
