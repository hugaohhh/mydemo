/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: TestDemoEmp.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午5:07:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: TestDemoEmp.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午5:07:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.test;


import com.asiainfo.sh.so.sf.hgEmp.bo.BOEmpBean;
import com.asiainfo.sh.so.sf.hgEmp.dao.impl.IEmpDaoImpl;
import com.asiainfo.sh.so.sf.hgEmp.dao.interfaces.IEmpDao;
import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;
import com.asiainfo.sh.so.sf.hgEmp.service.interfaces.IEmpSV;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.service.ServiceFactory;
import org.junit.Test;

/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: TestDemoEmp.java
 * @Description: 单元测试类
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月24日 下午5:07:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月24日     hugao           v1.0.0               修改原因
 */
public class TestDemoEmp {
	
	@Test
	public void testEmpQuery(){
		
		IEmpSV empService = (IEmpSV) ServiceFactory.getService(IEmpSV.class);
		
		try {
			IBOEmpValue empById = empService.queryEmpById("1002", "1");
			
			System.out.println(empById);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testEmpSave(){
//		IEmpDao empDao = (IEmpDao) ServiceFactory.getService(IEmpDao.class);
		IEmpDao empDao = new IEmpDaoImpl();
		
		try {
			IBOEmpValue empValue = new BOEmpBean();
			
			empValue.setEmpId(1);
			empValue.setEmpName("ligang");
			empValue.setEmpGender("1");
			empValue.setEmpPhone("110");
			empValue.setEmpAddr("shanghai1001");
			empValue.setDeptId("1");
			
			empDao.saveEmp(empValue);
			
		} catch (AIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
