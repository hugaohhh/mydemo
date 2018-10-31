/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpDao.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午4:50:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpDao.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午4:50:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.dao.interfaces;

import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;

/**
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpDao.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午4:50:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 */
public interface IEmpDao {
	
	/**
	 * 
	 * @Function: IEmpDao.java
	 * @Description: 根据条件返回查询的IBOEmpValue 集合
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 上午11:05:52 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public IBOEmpValue[] queryEmployees(String empId, String empName,
										String delState, int begin, int end) throws Exception;
	
	/**
	 * 
	 * @Function: IEmpDao.java
	 * @Description: 根据给定条件返回查询的数目
	 *
	 * empId:员工id
	 * empName：员工姓名
	 * delState：员工状态
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @throws Exception 
	 * @date: 2018年10月25日 上午10:28:51 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public int queryEmpCount(String empId, String empName, String delState) throws Exception;
	
	/**
	 * 
	 * @Function: IEmpDao.java
	 * @Description: 保存员工方法
	 *
	 * @param:传入一个 IBOEmpValue
	 * @return：成功返回1 失败返回0
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 上午10:08:16 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public int saveEmp(IBOEmpValue empValue) throws Exception;
	

	/**
	 * 
	 * @Function: IEmpDao.java
	 * @Description: 得到一个员工id
	 *
	 * @param:参数描述
	 * @return：返回一个序列id
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: hugao
	 * @date: 2018年10月25日 上午10:25:20 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年10月25日     hugao           v1.0.0               修改原因
	 */
	public long getEmpId() throws Exception;
	

}
