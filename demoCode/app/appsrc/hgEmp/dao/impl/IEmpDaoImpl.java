/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpDaoImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午4:53:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpDaoImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午4:53:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.dao.impl;

import com.asiainfo.sh.so.sf.hgEmp.bo.BOEmpEngine;
import com.asiainfo.sh.so.sf.hgEmp.dao.interfaces.IEmpDao;
import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;
import com.asiainfo.sh.so.sf.hgEmp.utils.SQLUtils;

import java.util.HashMap;


/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: IEmpDaoImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午4:53:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 */
public class IEmpDaoImpl implements IEmpDao {

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
	@Override
	public int saveEmp(IBOEmpValue empValue) throws Exception {
		
		if(empValue != null){
			BOEmpEngine.save(empValue);
			return 1;
		}
		return 0;
	}

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
	@Override
	public long getEmpId() throws Exception {
		long empId = BOEmpEngine.getNewId().longValue();
		return empId;
	}

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
	@Override
	public int queryEmpCount(String empId, String empName, String delState) throws Exception {
		// 拼接字符串
		StringBuilder conStrString = new StringBuilder();
		//创建参数列表map
		HashMap<String, String> hashMap = new HashMap<String, String>();

        if(!("0".equals(empId)) && !("".equals(empId))){
            conStrString.append(SQLUtils.appendSQLStr(IBOEmpValue.S_EmpId, empId,
                    hashMap, false,false ));
            //  EMP_ID = :EMP_ID and ===> map
        }
		conStrString.append(SQLUtils.appendSQLStr(IBOEmpValue.S_EmpName, empName,
				hashMap, false,true ));
		//  EMP_ID = :EMP_ID and  EMP_NAME like :EMP_NAME and
		conStrString.append(SQLUtils.appendSQLStr(IBOEmpValue.S_DelState, delState, 
				hashMap, true,false ));
		//  EMP_ID = :EMP_ID and  EMP_NAME like :EMP_NAME and  DEL_STATE = :DEL_STATE
		int count = BOEmpEngine.getBeansCount(SQLUtils.regSQLStr(conStrString),hashMap);
		
		return count;
	}
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
	@Override
	public IBOEmpValue[] queryEmployees(String empId, String empName,
			String delState, int begin, int end) throws Exception {
		
		// 拼接字符串
		StringBuilder conStrString = new StringBuilder();
		//创建参数列表map
		HashMap<String,String> hashMap = new HashMap<String,String>();

		if(!("0".equals(empId)) && !("".equals(empId))){
			conStrString.append(SQLUtils.appendSQLStr(IBOEmpValue.S_EmpId, empId,
					hashMap, false,false ));
			//  EMP_ID = :EMP_ID and // map:{EMP_ID=1002}
		}
		conStrString.append(SQLUtils.appendSQLStr(IBOEmpValue.S_EmpName, empName,
				hashMap, false,true ));
		//EMP_ID = :EMP_ID and  EMP_NAME like :EMP_NAME and 
		//map : {EMP_NAME=liwei%, EMP_ID=1002}
		conStrString.append(SQLUtils.appendSQLStr(IBOEmpValue.S_DelState, delState, 
				hashMap, true,false ));
		// map : {EMP_NAME=liwei%, EMP_ID=1002, DEL_STATE=1}
		System.out.println(conStrString);
		// EMP_ID = :EMP_ID and  EMP_NAME like :EMP_NAME and  DEL_STATE = :DEL_STATE

		
		IBOEmpValue[] empValues = BOEmpEngine.getBeans(null, SQLUtils.regSQLStr(conStrString), 
				hashMap, begin, end, false);
		
		return empValues;
	}

}
