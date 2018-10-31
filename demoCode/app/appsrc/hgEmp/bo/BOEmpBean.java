package com.asiainfo.sh.so.sf.hgEmp.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.sh.so.sf.hgEmp.ivalue.IBOEmpValue;


public class BOEmpBean extends DataContainer implements DataContainerInterface,IBOEmpValue {

  private static String  m_boName = "com.asiainfo.sh.so.sf.hgEmp.bo.BOEmp";



  public final static  String S_DelState = "DEL_STATE";
  public final static  String S_EmpName = "EMP_NAME";
  public final static  String S_EmpId = "EMP_ID";
  public final static  String S_EmpPhone = "EMP_PHONE";
  public final static  String S_EmpAddr = "EMP_ADDR";
  public final static  String S_DeptId = "dept_id";
  public final static  String S_EmpGender = "EMP_GENDER";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOEmpBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //��������������������ҵ���������
   throw new AIException("Cannot reset ObjectType");
 }


  public void initDelState(long value){
     this.initProperty(S_DelState,new Long(value));
  }
  public  void setDelState(long value){
     this.set(S_DelState,new Long(value));
  }
  public  void setDelStateNull(){
     this.set(S_DelState,null);
  }

  public long getDelState(){
        return DataType.getAsLong(this.get(S_DelState));
  
  }
  public long getDelStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DelState));
      }

  public void initEmpName(String value){
     this.initProperty(S_EmpName,value);
  }
  public  void setEmpName(String value){
     this.set(S_EmpName,value);
  }
  public  void setEmpNameNull(){
     this.set(S_EmpName,null);
  }

  public String getEmpName(){
       return DataType.getAsString(this.get(S_EmpName));
  
  }
  public String getEmpNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EmpName));
      }

  public void initEmpId(long value){
     this.initProperty(S_EmpId,new Long(value));
  }
  public  void setEmpId(long value){
     this.set(S_EmpId,new Long(value));
  }
  public  void setEmpIdNull(){
     this.set(S_EmpId,null);
  }

  public long getEmpId(){
        return DataType.getAsLong(this.get(S_EmpId));
  
  }
  public long getEmpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EmpId));
      }

  public void initEmpPhone(String value){
     this.initProperty(S_EmpPhone,value);
  }
  public  void setEmpPhone(String value){
     this.set(S_EmpPhone,value);
  }
  public  void setEmpPhoneNull(){
     this.set(S_EmpPhone,null);
  }

  public String getEmpPhone(){
       return DataType.getAsString(this.get(S_EmpPhone));
  
  }
  public String getEmpPhoneInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EmpPhone));
      }

  public void initEmpAddr(String value){
     this.initProperty(S_EmpAddr,value);
  }
  public  void setEmpAddr(String value){
     this.set(S_EmpAddr,value);
  }
  public  void setEmpAddrNull(){
     this.set(S_EmpAddr,null);
  }

  public String getEmpAddr(){
       return DataType.getAsString(this.get(S_EmpAddr));
  
  }
  public String getEmpAddrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EmpAddr));
      }

  public void initDeptId(String value){
     this.initProperty(S_DeptId,value);
  }
  public  void setDeptId(String value){
     this.set(S_DeptId,value);
  }
  public  void setDeptIdNull(){
     this.set(S_DeptId,null);
  }

  public String getDeptId(){
       return DataType.getAsString(this.get(S_DeptId));
  
  }
  public String getDeptIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DeptId));
      }

  public void initEmpGender(String value){
     this.initProperty(S_EmpGender,value);
  }
  public  void setEmpGender(String value){
     this.set(S_EmpGender,value);
  }
  public  void setEmpGenderNull(){
     this.set(S_EmpGender,null);
  }

  public String getEmpGender(){
       return DataType.getAsString(this.get(S_EmpGender));
  
  }
  public String getEmpGenderInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EmpGender));
      }


 
 }

