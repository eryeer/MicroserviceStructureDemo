package com.wxbc.mapper;

import com.wxbc.pojo.IVInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IVInfoDao {
    @Select("select * from IVActive where ivAddress =#{ivAddress}")
    IVInfo getIVWithIVAddress(@Param("ivAddress") String IVAddress);
}
