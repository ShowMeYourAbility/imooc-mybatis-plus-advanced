package com.llmcu.imooc.mybatisplus.advanced.logic.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.llmcu.imooc.mybatisplus.advanced.logic.entity.SysUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    @Rollback
    public void select() {
        int deleteById = sysUserMapper.deleteById(3L);
        Assertions.assertEquals(1,deleteById);
        int deletedLikeJ = sysUserMapper.delete(Wrappers.lambdaQuery(SysUser.class).likeRight(SysUser::getName, "J"));
        Assertions.assertEquals(2,deletedLikeJ);
    }
}