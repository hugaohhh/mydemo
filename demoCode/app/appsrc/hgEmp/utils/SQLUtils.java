/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: SQLUtils.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 上午10:32:49 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 *//**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: SQLUtils.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 上午10:32:49 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
package com.asiainfo.sh.so.sf.hgEmp.utils;

import java.util.HashMap;

import com.ai.appframe2.util.criteria.Criteria;

/**   
 * Copyright: Copyright (c) 2018 Asiainfo
 * 
 * @ClassName: SQLUtils.java
 * @Description: 拼接sql 的工具类
 *
 * @version: v1.0.0
 * @author: hugao
 * @date: 2018年10月25日 上午10:32:49 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2018年10月25日     hugao           v1.0.0               修改原因
 */
public class SQLUtils {
	
	/**
	 * 
	 * @Function: appendSQLStr
	 * @Description: 拼接and条件
	 *
	 * @param:colStrString表字段名
	 * @param:conStrString属性值
	 * @param:hashMap 属性值hashMap
	 * @param:theEndB 是否已经到了结尾
	 * @param:likeStrB 是否模糊查询
	 * @return：返回拼接好的sql语句
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018-10-24   hugao           v1.0.0                                         修改原因
	 */
	public static String appendSQLStr(String colStrString,String conStrString,
			HashMap hashMap,boolean isEnd,boolean isLike){
		// 当表字段名不为空
		if(colStrString != null && colStrString.length() > 0){
			// 拼接字符串
			String resultStr = " "+ colStrString;
			if(isLike){
				// 如果是模糊查询 加like 给map加一个key-value
				hashMap.put(colStrString,conStrString+"%");
				resultStr += " like :" + colStrString;
			}else{
				// 如果不是就直接= 
				hashMap.put(colStrString,conStrString);
				resultStr += " = :" + colStrString;
			}
			if(isEnd){
				// 如果到底了就直接返回
				return resultStr;
			}
			// 没有就加and
			return resultStr +" and ";
			
		}else{
			// 为空直接返回
			return "";
		}
	}
	
	/**
	 * 
	 * @Function: regSQLStr
	 * @Description: 该函数的功能描述
	 *
	 * @param sqlStringBuilder 需要处理的sql语句
	 * @return：处理好的sql语句
	 * @throws：无
	 *
	 */
	
	public static String regSQLStr(StringBuilder sqlStringBuilder){
	
		String resultStr = "";
		// 将其排序
		Criteria criteria = new Criteria();
		if(sqlStringBuilder != null && sqlStringBuilder.length() > 0){
			// 忽略大小写 如果 sqlStringBuilder 的倒数三个字符 = and
			if("AND".equalsIgnoreCase(sqlStringBuilder.substring(
					sqlStringBuilder.length() - 3,sqlStringBuilder.length()))){
				// 将返回and 前面的字符串
				resultStr = sqlStringBuilder.substring(0,sqlStringBuilder.length() - 3);
			}else{
				// 否则直接返回  sqlStringBuilder
				resultStr = sqlStringBuilder.toString();
			}
			resultStr = resultStr + criteria.addAscendingOrderByColumn("EMP_ID").toString();
		}
		return resultStr;
	}
	

}
