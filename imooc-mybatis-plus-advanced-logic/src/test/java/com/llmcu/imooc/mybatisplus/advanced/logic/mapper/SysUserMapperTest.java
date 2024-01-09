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

    /**
     * delete语句实际执行的是update语句
     * 真实执行语句形如：UPDATE sys_user SET deleted=1 WHERE id=? AND deleted=0
     */
    @Test
    @Rollback
    public void delete() {
        int deleteById = sysUserMapper.deleteById(3L);
        Assertions.assertEquals(1,deleteById);
        int deletedLikeJ = sysUserMapper.delete(Wrappers.lambdaQuery(SysUser.class).likeRight(SysUser::getName, "J"));
        Assertions.assertEquals(2,deletedLikeJ);
    }

    /**
     * select在WHERE中会自动拼接deleted=0
     * 真实执行语句形如：SELECT id,name,age,email,deleted FROM sys_user WHERE deleted=0
     */
    @Test
    @Rollback
    public void selectList() {
        List<SysUser> sysUsers = sysUserMapper.selectList(Wrappers.lambdaQuery(SysUser.class));
        Assertions.assertTrue(sysUsers.size()>0);
    }

    /**
     * update 语句会自动拼接上deleted=0
     * 真实执行语句形如：UPDATE sys_user SET name=?, age=?, email=? WHERE id=? AND deleted=0
     */
    @Test
    @Rollback
    public void updateById() {
        SysUser sysUser = sysUserMapper.selectById(1L);
        sysUser.setName("ll");
        int updateById = sysUserMapper.updateById(sysUser);
        Assertions.assertEquals(1,updateById);
    }

    /**
     * 自定义SQL不会自动拼接上deleted=0
     * 真实执行语句形如：select * from sys_user WHERE (id = ?)
     */
    @Test
    @Rollback
    public void select() {
        List<SysUser> sysUsers = sysUserMapper.selectAll(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getId, 1L));
        Assertions.assertEquals(1,sysUsers.size());
    }

    /**
     * 手写SQL不会自动拼接上deleted=0
     * 真实执行语句形如：select ID,NAME,AGE, EMAIL,DELETED from sys_user where ID > ?
     */
    @Test
    @Rollback
    public void selectAllById() {
        List<SysUser> sysUsers = sysUserMapper.selectAllById(2L);
        Assertions.assertEquals(3,sysUsers.size());
    }


}