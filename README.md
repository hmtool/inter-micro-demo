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
    + springboot2.2.2+
    + hmtool-ext-interchan 1.4.1+ 
    + elasticsearch 7.5+
    + kafka 2.4+
    + jdk1.8+
    + swagger2
    + nacos 1.1.3+
    + sentinel 1.6.3+
    + spring cloud Hoxton.RELEASE+
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
