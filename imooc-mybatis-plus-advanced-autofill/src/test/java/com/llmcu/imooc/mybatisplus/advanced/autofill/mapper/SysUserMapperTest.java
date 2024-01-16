package com.llmcu.imooc.mybatisplus.advanced.autofill.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.llmcu.imooc.mybatisplus.advanced.autofill.entity.SysUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    @Rollback
    public void delete() {
        SysUser sysUser = new SysUser().setName("sam").setAge(36).setEmail("dd");
        sysUserMapper.insert(sysUser);
        SysUser sysUser1 = sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, "sam"));
        System.out.println(sysUser1);
    }

}