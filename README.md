# 简介

- dds是一个轻量级的Spring Boot2.x快速开发平台，学习简单、轻量级、易扩展；使用最新技术。
- 本系统是在Bing-UPMS 系统（https://gitee.com/xiaobingby/bing-upms） 基础上升级为SpringBoot2.x

### **具有如下特点** 
- RBAC权限管理 控制到按钮级权限
- 友好的代码结构及注释，便于阅读及二次开发
- 使用轻量级FreeMarker模板引擎，代替JSP
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- Bootstrap Table进行数据展示,快速完成前端数据展示
- MP代码生成器模块,快速生成 entity、Mapper.xml、dao、service、controller 代码
- 引入云存储服务，已支持：腾讯云COS对象存储
- 通用CRUD操作,单表操作无需写任何SQL语句。把精力关注在多表操作，提高开发效率 （Mybatis-Plus）

### 数据库设计
![输入图片说明](https://gitee.com/uploads/images/2017/1104/004510_91f7d52d_734677.png "database.png")

### 技术选型

#### 后端技术:
技术 | 名称 | 官网
 ----|------|----
Spring Boot | Spring Boot | http://projects.spring.io/spring-boot/
Spring MVC | MVC框架 | https://spring.io/
Apache Shiro | 安全框架  | http://shiro.apache.org/
FreeMarker | 模板引擎 | http://freemarker.org/
MyBatis | ORM框架  | http://www.mybatis.org/mybatis-3/
Mybatis-Plus | Mybatis 的增强工具 | https://gitee.com/baomidou/mybatis-plus/
Druid | 数据库连接池  | http://druid.io/
MySql | 数据库 | https://www.mysql.com/
COS | 腾讯云对象存储| https://cloud.tencent.com/product/cos/
Maven | 项目构建管理  | http://maven.apache.org/
FastJson | JSON处理器 | https://github.com/alibaba/fastjson/
spring-boot-devtools | 热部署 | https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3/
JMail | 邮件操作组件 | 
Ehcache | Java的进程内缓存框架 | http://www.ehcache.org/
Redis | 缓存数据库 | https://redis.io/

#### 前端技术:
技术 | 名称 | 官网
----|------|----
jQuery | 函式库 | http://jquery.com/
Bootstrap | 前端框架 | http://getbootstrap.com/
Bootstrap-table | Bootstrap数据表格 | http://bootstrap-table.wenzhixin.net.cn/
treegrid | 表格树 | 无
Bootstrap File Input | 文件上传插件 | http://plugins.krajee.com/file-input/demo
zTree | 树插件 | http://www.treejs.cn/v3/
Font-awesome | 字体图标 | http://fontawesome.io/
H+ | 后台管理模板 | http://www.zi-han.net/theme/hplus/
wangEditor | 轻量级web富文本编辑器 | http://www.wangeditor.com

### 预览图片
- 登陆
![输入图片说明](https://gitee.com/uploads/images/2017/1104/004845_18a73aef_734677.png "01.png")
- 注册
![输入图片说明](https://gitee.com/uploads/images/2017/1104/004856_d525ec30_734677.png "02.png")
- 后台首页
![输入图片说明](https://gitee.com/uploads/images/2017/1104/004945_cc742cd1_734677.png "03.png")
- 用户管理(CRUD) (Demo 按钮权限)
![输入图片说明](https://gitee.com/uploads/images/2017/1105/154346_ba65799b_734677.png "用户管理(有权限用户).png")
![输入图片说明](https://gitee.com/uploads/images/2017/1105/154400_96b87c0a_734677.png "用户管理(无权限用户).png")
- 用户管理(无权限操作拦截)
![输入图片说明](https://gitee.com/uploads/images/2017/1105/154844_dc117f8c_734677.png "无权限操作.png")
- 角色管理(CRUD)
![输入图片说明](https://gitee.com/uploads/images/2017/1105/154418_8325175c_734677.png "角色管理.png")
- 权限管理(CRUD)
![输入图片说明](https://gitee.com/uploads/images/2017/1105/154438_b52688c6_734677.png "权限管理.png")
