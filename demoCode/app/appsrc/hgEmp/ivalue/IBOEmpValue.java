package com.asiainfo.sh.so.sf.hgEmp.ivalue;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOEmpValue extends DataStructInterface {

  public final static  String S_DelState = "DEL_STATE";
  public final static  String S_EmpName = "EMP_NAME";
  public final static  String S_EmpId = "EMP_ID";
  public final static  String S_EmpPhone = "EMP_PHONE";
  public final static  String S_EmpAddr = "EMP_ADDR";
  public final static  String S_DeptId = "dept_id";
  public final static  String S_EmpGender = "EMP_GENDER";


  public long getDelState();

  public String getEmpName();

  public long getEmpId();

  public String getEmpPhone();

  public String getEmpAddr();

  public String getDeptId();

  public String getEmpGender();


  public  void setDelState(long value);

  public  void setEmpName(String value);

  public  void setEmpId(long value);

  public  void setEmpPhone(String value);

  public  void setEmpAddr(String value);

  public  void setDeptId(String value);

  public  void setEmpGender(String value);
}
