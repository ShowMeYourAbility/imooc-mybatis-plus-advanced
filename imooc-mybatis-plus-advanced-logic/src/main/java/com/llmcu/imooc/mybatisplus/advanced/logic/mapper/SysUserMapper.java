package com.llmcu.imooc.mybatisplus.advanced.logic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.llmcu.imooc.mybatisplus.advanced.logic.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * Java层手写sql与wrapper结合
     */
    @Select("select * from sys_user ${ew.customSqlSegment}")
    List<SysUser> selectAll(@Param(Constants.WRAPPER) Wrapper<SysUser> wrapper);

    List<SysUser> selectAllById(@Param("id") Long id);

}
