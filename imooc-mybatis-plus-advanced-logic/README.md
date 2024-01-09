# 逻辑删除使用方法
给属性加了@TableLogic注解即可
# 逻辑删除使用效果
select、update 语句会自动拼接上deleted=0;
delete 语句会变为update语句；
自定义sql不会自动拼接deleted=0;
手写sql不会自动拼接deleted=0;
# 额外
默认逻辑删除值和默认逻辑未删除值分别是：1，0
可通过全局配置变更，也可以在@TableLogic变更。


