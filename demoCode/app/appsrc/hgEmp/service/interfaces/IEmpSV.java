/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpSV.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:23:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpSV.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:23:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.service.interfaces;


import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;

/**
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpSV.java
 * @Description: 员工的服务类
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 下午6:23:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
public interface IEmpSV {
	
	/**
	 * 
	 * @Function: IEmpSV.java
	 * @Description: 添加/删除/更新 员工的方法
	 *
	 * @param:empValue
	 * methodStr：判断是否是添加
	 * @return：返回1 成功，0失败
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @throws Exception 
	 * @date: 2018年10月25日 下午6:26:34 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public int saveEmp(IBOEmpValue empValue, String methodStr) throws Exception;
	
	/**
	 * 
	 * @Function: IEmpSV.java
	 * @Description: 根据id 和name 查询员工集合
	 *
	 * @param:参数描述
	 * @return：返回员工集合 
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @throws Exception 
	 * @date: 2018年10月25日 下午6:38:25 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public IBOEmpValue[] queryEmps(String empId, String empName, int begin, int end) throws Exception;

	/**
	 * 
	 * @Function: IEmpSV.java
	 * @Description: 根据id name delState查询符合条件的员工数目
	 *
	 * @param:empId
	 * empName
	 * @return：员工数目
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @throws Exception 
	 * @date: 2018年10月25日 下午6:45:57 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public int queryEmpsCount(String empId, String empName) throws Exception;
	
	/**
	 * 
	 * @Function: IEmpSV.java
	 * @Description: 根据id 查询单个员工信息
	 *
	 * @param:参数描述
	 * @return：返回员工信息
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 下午6:56:04 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public IBOEmpValue queryEmpById(String empId, String delState) throws Exception;
	
}
