<<<<<<< HEAD
# inter-micro-demo

#### 介绍
微服务体系的代码

#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
=======
<p align="center">
hmtool springcloud版demo
</p>
<p align="center">
-- 主页：<a href="http://mhuang.tech/hmtool-parent">http://mhuang.tech/hmtool-parent</a>  --
</p>
<p align="center">
    -- QQ群①:<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=6703688b236038908f6c89b732758d00104b336a3a97bb511048d6fdc674ca01"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="hmtool官方交流群①" title="hmtool官方交流群①"></a>
</p>
---------------------------------------------------------------------------------------------------------------------------------------------------------

## 简介
该项目是hmtool与springcloud集成的crud案例管理系统,使用阿里所开源的nacos进行配置、注册中心管理、sentinel限流
## 技术
- 前端
    + H+
    + bootstrap3+
    + jquery2+
- 后台
    + springboot2.1.8+
    + hmtool-ext-interchan 
    + elasticsearch 6+
    + kafka 2.11+
    + jdk1.8+
    + swagger2
    + nacos 1.1.3+
    + sentinel 1.6.3+
    + spring cloud Greenwich3
## 项目结构
- inter-micro-demo(parent)
    + inter-micro-protocol(协议包、存放DTO,QVO,RVO等)
    + inter-micro-sso(用户角色菜单管理)
    + inter-micro-logger(日志通用包)
    + inter-micro-gateway(gateway网关)
    + inter-micro-web(前端网页)
   
   
## 案例运行步骤
- 安装软件环境

        elasticsearch6+（日志），kibana6+（用于查看日志情况)，mysql5.7+（数据库），jdk1.8+,kafka2.1+(消息消费)
- 创建mysql数据库
        
        sql脚本存放在doc/数据库文件/inter-boot-demo.sql、先创建数据库、在选择数据库指定sql进行导入、
        若与demo不一致请自行配置相关ip、port、用户名、密码等
- 启动nacos和sentinel

        nacos和sentinel启动程序存放在doc/alibaba/下。将doc下的数据库目录下的nacos.sql在数据库中运行、
        若需要调整mysql的请调整nacos的配置、
        具体在doc/nacos/conf配置下、也可自行下载对应阿里巴巴提供的版本、conf/alibaba采用的是1.1.3版本的nacos和1.6.3版本的sentinel
- 启动gateway
        
        启动gatewayapplication
- 启动SSO
    
        启动ssoapplication
- 启动web
        
        启动webapplication
- 访问
        
        访问http://127.0.0.1:8088/直接点击登录即可
>>>>>>> 1.0.0
