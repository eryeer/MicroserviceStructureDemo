package com.wxbc.operlog.mapper;

import com.wxbc.operlog.bean.OperLogInfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by fengxinhe on 2017/8/22.
 */
public interface OperLogMapper {

    @Select("select * from tbl_operator_log where pubKeySigned=#{pubKeySigned}")
    OperLogInfo queryLog(String pubKeySigned);

    @Insert("insert into tbl_operator_log(logId,pubKeySigned,title,opertype,params,remoteAddr,requestUri,method,createDate,updateDate,details)" +
            " VALUES(#{logId},#{pubKeySigned},#{title},#{opertype},#{params},#{remoteAddr},#{requestUri},#{method},#{createDate},#{updateDate},#{details})")
    void insertLog(OperLogInfo log);

    @Update("update tbl_operator_log set opertype =#{opertype} , details =#{details}  where logId =#{logId}")
    void  updateLog(OperLogInfo log);

}
