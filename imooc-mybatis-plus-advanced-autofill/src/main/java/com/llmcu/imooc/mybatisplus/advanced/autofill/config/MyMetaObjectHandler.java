package com.llmcu.imooc.mybatisplus.advanced.autofill.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 考虑1：是否有这个属性(是否有属性的setter方法)
        // 考虑2：这个属性值是不是null,有值不覆盖
        // 考虑3：填充值是不是null,提供的值为null也不填充

        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        // 或者
        this.strictInsertFill(metaObject, "createTime", () -> new Date(), Date.class); // 起始版本 3.3.3(推荐)
        // 或者
        this.fillStrategy(metaObject, "createTime", new Date()); // 也可以使用(3.3.0 该方法有bug)
        // 或者(1,3)
        this.setFieldValByName("createTime", new Date(), metaObject);

        this.strictInsertFill(metaObject, "creator", () -> "433", String.class); // 起始版本 3.3.3(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
        // 或者(有值不覆盖,如果提供的值为null也不填充)
        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class); // 起始版本 3.3.3(推荐)
        // 或者(1,2,3)
        this.fillStrategy(metaObject, "updateTime", new Date()); // 也可以使用(3.3.0 该方法有bug)
        // 或者(1,3)
        this.setFieldValByName("updateTime", new Date(), metaObject);

        this.strictUpdateFill(metaObject, "updater", () -> "433", String.class); // 起始版本 3.3.3(推荐)
    }
}
