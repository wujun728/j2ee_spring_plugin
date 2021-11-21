### `jun_plugin` 项目  

### 项目说明
jun_plugin 整合Java企业级各种开发组件、开箱即用、不写重复代码，包含基础Java基础开发组件，Spring企业家开发组，SpringBoot开发组件、SpringCloud开发组件

### 功能清单

1. Java常用开发组件：**java_plugin**，Java常用开发组件，当前**包含47类各种**lib类库示例与文档。
2. Spring常用开发组件：**spring_plugin**，企业级开发常用组件，当前**集成61中类种**lib类库示例与文档。
3. SpringBoot常用开发组件：**springboot_plugin**，当前**集成106中**类种类库示例与文档。
4. Maven常用项目模板：**maven_template**，当前集成了**10种模板**，含单体、SSH、SSM、Boot、Cloud等。
5. SpringCloud常用开发组件：**springcloud_plugin**，含netflix、alibaba、dubbo等，主要为示例与文档。


#### 基础篇：企业级开发组件(开发组件、代码生成、前端组件) [jun_java_plugin]

> Java基础系开发组件-通用篇（jun_plugin） 常用开发组件，基础公共lib包的组件不依赖Spring的组件，主要供原生开发的项目集成：

【jun_activiti】[流程引擎，Activiti工作流，完成工作流常用操作](https://github.com/wujun728/jun_plugin/jun_activiti)  
【jun_ajax】[完成ajax操作，前端及后端的ajax](https://github.com/wujun728/jun_plugin)  
【jun_aliyun_sms】[短信工具,集成阿里云短信、腾讯云短信发送及验证码等功能](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_aliyun_sms)  
【jun_apache_commons】[ Common工具集,集成Apache通用工具集](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_apache_commons)  
【jun_api】[ API中心,API注册测试校验管控鉴权中心](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_api)  
【jun_cron】 [cron表达式的java的实现及调度](https://github.com/wujun728/jun_plugin)  
【jun_cache】[分布式缓存，缓存工具,集成Redis分布式缓存功能](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_cache)  
【jun_camel】[消息路由，ESB服务总线,EIP框架，处理不同系统之间的消息传输](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_camel)  
【jun_captcha】[ 验证码工具,GoogleKaptcha及各种验证码工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_captcha)  
【jun_crawler】[ 爬虫引擎,网络爬虫引擎，Xpath解析HTML](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_crawler)  
【jun_datasource_cluster】[原生集成各种JDBC DataSource数据源,分布式数据源,Druid、DBCP等数据源](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_datasource_cluster)  
【jun_dbutil】[原生集成Apache 的Dbutils完成单表及多表的增删改查，原生JDBC操作，简单封装](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_dbutil)  

and so on 

 

> Spring系企业级开发框架组件 Spring常用开发组件，万能粘合剂，企业级J2EE实际标准平台

【spring_activemq】[ Activemq消息队列,Spring集成activemq消息队列工具集demo](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_activemq)  
【spring_atomikos】[ 分布式事务atomikos,分布式事务atomikos](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_atomikos)  
【spring_camel由】[ 消息路由camel,消息路由camel](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_camel)  
【spring_cas】[ 单点登录cas,单点登录cas](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_cas)  
【spring_cors】[ Spring跨域调用,Spring跨域调用](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_cors)  
【spring_demo】[ Spring测试DEMO,Spring测试DEMO](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_demo)  
【spring_distributed_config】[ Spring分布式配置,Spring分布式配置](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_config)  
【spring_distributed_fastdfs】[ Spring分布式文件,Spring分布式文件](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_fastdfs)  
【spring_distributed_lock】[ Spring分布式锁,Spring分布式锁](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_lock)  
【spring_distributed_multidatasource】[ Spring分布式数据源,Spring分布式数据源](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_multidatasource)  
【spring_distributed_netty】[ Spring分布式Netty服务,Spring分布式Netty服务](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_netty)  
【spring_distributed_oss_qiniu】[ Spring分布式对象存储,Spring分布式对象存储](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_oss_qiniu)  
【spring_distributed_rpc】[ Spring分布式RPC框架,Spring分布式RPC框架](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_rpc)  
【spring_distributed_session】[ 分布式Session实现及配置持久化等,Spring分布式Session](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_session)  
【spring_distributed_transaction_tcc[ Spring分布式事务TCC,Spring分布式事务TCC](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_distributed_transaction_tcc)  
【spring_drools】[ Spring集成规则引擎,Spring集成规则引擎](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_drools)  
【spring_dubbo】[ Spring集成Dubbo框架,Spring集成Dubbo框架](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/spring_dubbo)  

and so on

> Maven常用项目模板，含maven单体分布式、SSH、SSM、Boot、Cloud等

【maven_javaproject】[Java单体项目模板,Java单体项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_javaproject\)  
【maven_spring4_multi_modules】[Spring4多模块项目模板,Spring4多模块项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_spring4_multi_modules\)  
【maven_spring5_multi_modules】[Spring5多模块项目模板,Spring5多模块项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_spring5_multi_modules\)  
【maven_spring5template】[Spring5微服务项目模板,Spring5微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_spring5template\)  
【maven_springboot】[SpringBoot微服务项目模板,SpringBoot微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_springboot_permission_example\)  


> SpringBoot系开发框架组件，基于SpringBoot微服务开发组件，新企业级REST服务

【springboot_actuator】[SpringBoot微服务项目模板,SpringBoot微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_springboot_permission_example\)  
【springboot_admin】[SpringBoot微服务项目模板,SpringBoot微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_springboot_permission_example\)  
【springboot_async】[SpringBoot微服务项目模板,SpringBoot微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_springboot_permission_example\)  


#### 工程截图(组件较多，随意择选了几个)

<table>
    <tr>
		<td><img src=""/>
		<td><img src=""/>
    </tr>
</table>



#### 开发环境
- **JDK 1.8 

- **Maven 3.5 

- **IDEA 2018.2 + or  STS 4.5 +** (*注意：安装lombok插件）
  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Abc

  
#### 笔者其他项目   
 [俊哥个人技术栈代码库(持续更新)](https://github.com/wujun728)  
TODO PLAN：  
Step1基础篇：  
	jun_java_plugin Java基础框架-Java开发组件、Spring开发组件、SpringBoot开发组件、SpringCloud开发组件、Maven项目模板  
	jun_ssh_parent SSH基础框架-SpringBoot+EasyUI+JSP  
	jun_ssm_springboot SSM基础框架-SpringBoot+MybatisPlus+Boostrap+Shiro+JWT  
	jun_code_generator 代码生成器-SpringBoot+Freemarker+API接口+EasyExcel  
	jun_frontend_ui    前端框架，Bootstrap、AdminLTE、Jquery、EasyUI、LayUI、LayAdmin、Vue、vue-element-admin  
	jun_linux    服务器部署、gitlab部署、Nginx部署、Redis部署、Docker部署、MySQL部署、等等  
 	---审视项目本身，给出待办调整清单，给出下步计划  
Step2微服务&大数据：  
	jun_api_service API接口服务框架，SpringBoot+Rest API  
	jun_springboot_vue 前后端分离框架，SpringBoot+Vue+JWT  
	jun_springcloud 微服务框架，SpringCloud Netflix、SpringCloud Alibaba、Dubbo框架、Quarkus极速框架  
	jun_bigdata 大数据框架，支持数据清理、数据推荐、大数据分析、大数据企业看板、大数据报表等  

Step3产品篇：  
	jun_product_center 产品中心，包含企业官网、企业办公自动化OA系统、企业资源管理ERP系统、项目管理系统、等等  
	jun_website   CMS网站系统，基于WordPress的网站系统、支持博客、企业官网、及各种网站模板  
	wujun728.github.io 个人博客  

Step4产品篇：  
	jun_app    移动APP开发平台、支持Uniapp开发独立APP、小程序、企业办公等  
	jun_weixin   微信开发平台、微信公众号、微信小程序、微信管理后台、微信API接口后台  
	jun_android Android移动开发框架，APP开发模板、后台管理系统、后台API接口平台  


​	1


### `jun_plugin` 项目  

### 项目说明
jun_plugin 整合Java企业级各种开发组件、开箱即用、不写重复代码，包含基础Java基础开发组件，Spring企业家开发组，SpringBoot开发组件、SpringCloud开发组件

### 功能清单

1. Java常用开发组件：**java_plugin**，Java常用开发组件，当前**包含47类各种**lib类库示例与文档。
2. Maven常用项目模板：**maven_template**，当前集成了**10种模板**，含单体、SSH、SSM、Boot、Cloud等。
3. SpringCloud常用开发组件：**springcloud_plugin**，含netflix、alibaba、dubbo等，主要为示例与文档。


#### 基础篇：企业级开发组件(开发组件、代码生成、前端组件) [jun_java_plugin]


> Java基础系开发组件-通用篇（jun_plugin） 常用开发组件，基础公共lib包的组件不依赖Spring的组件，主要供原生开发的项目集成：

【jun_activiti】[流程引擎，Activiti工作流，完成工作流常用操作](https://github.com/wujun728/jun_plugin/jun_activiti)  
【jun_ajax】[完成ajax操作，前端及后端的ajax](https://github.com/wujun728/jun_plugin)  
【jun_aliyun_sms】[短信工具,集成阿里云短信、腾讯云短信发送及验证码等功能](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_aliyun_sms)  
【jun_apache_commons】[ Common工具集,集成Apache通用工具集](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_apache_commons)  
【jun_api】[ API中心,API注册测试校验管控鉴权中心](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_api)  
【jun_cron】 [cron表达式的java的实现及调度](https://github.com/wujun728/jun_plugin)  
【jun_cache】[分布式缓存，缓存工具,集成Redis分布式缓存功能](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_cache)  
【jun_camel】[消息路由，ESB服务总线,EIP框架，处理不同系统之间的消息传输](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_camel)  
【jun_captcha】[ 验证码工具,GoogleKaptcha及各种验证码工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_captcha)  
【jun_crawler】[ 爬虫引擎,网络爬虫引擎，Xpath解析HTML](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_crawler)  
【jun_datasource_cluster】[原生集成各种JDBC DataSource数据源,分布式数据源,Druid、DBCP等数据源](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_datasource_cluster)  
【jun_dbutil】[原生集成Apache 的Dbutils完成单表及多表的增删改查，原生JDBC操作，简单封装](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_dbutil)  
【jun_demo】[ DEMO测试,DEMO测试工具集](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_demo)  
【jun_designpattern】[23种涉及模式的Java实现](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_designpattern)  
【jun_drools】[ 规则引擎,规则引擎的各种demo及工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_drools)  
【jun_dubbo】[ Dubbo,阿里巴巴Dubbo RPC demo及工具集](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_dubbo)  
【jun_executor】[原生的并发多线程demo操作](https://github.com/wujun728/jun_plugin)  
【jun_email】[原生邮件发送、纯文本、HTML邮件、带附件的邮件](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_email)  
【jun_excel】[ Excel工具集,Excel导入导出工具集](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_excel)  
【jun_fileupload】[原生的文件上传及下载操作的实现基于common fileupload，OSS上传下载](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_fileupload)  
【jun_freemarker】[原生集成freemarker模板引擎，数据+模板=输出，可输出代码生成器](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_freemarker)  
【jun_guava】[ GoogleGuava,谷歌工具集，集合工具，缓存工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_guava)  
【jun_guice】[ GoogleGuice,谷歌依赖注入框架(配合Servlet3.0+Dbutil)](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_guice)  
【jun_gzip】[ Gzip压缩,Gzip压缩及解压缩](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_gzip)  
【jun_hibernate】[原生集成hibernate及使用,Hibernate,JPA框架，持久化框架](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_hibernate)  
【jun_httpclient】[原生集成httpclient，发送http请求、下载文件等，配合Postman发起各种HTTP请求](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_httpclient)  
【jun_image】[原生图片操作包、包括图片上传、下载、展示、转码、压缩转Base64、缩略图等](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_image)  
【jun_jdk】[JDK原生demo代码，了解的越多才会了解的越深](https://github.com/wujun728/jun_plugin)  
【jun_jdbc】[原生JDBC操作，简单封装，需要的可以看下](https://github.com/wujun728/jun_plugin)  
【jun_j2cache】[ 缓存j2cache,缓存工具，OSCHACHE使用的缓存工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_j2cache)  
【jun_jar2maven】[ Jar转Maven,Jar转Maven工具集，老web项目转maven项目](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_jar2maven)  
【jun_jbpm】[ 流程引擎JBPM,流程引擎JBPM，老牌流程引擎](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_jbpm)  
【jun_jdk】[ JDK核心,JDK核心工具，常用Demo等](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_jdk)  
【jun_jsoup】[HTM标记语言解析包，完成HTML解析、主要爬虫使用，解析HTML渲染数据](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_jsoup)  
【jun_lucene】[老牌搜索引擎、可以看下,搜索框架,搜索框架，全文检索工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_lucene)  
【jun_leetcode】[算法刷题大全](https://github.com/wujun728/jun_plugin)  
【jun_mybatisplus】[ MybatisPlus,MybatisPlus数据持久化映射框架](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_mybatisplus)  
【jun_pay】[ 支付工具,支付工具，集成微信及阿里支付](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_pay)  
【jun_pdf】[ PDF工具,PDF工具，生成PDF及PDF文件](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_pdf)  
【jun_poi】[原生POI完成Excel文件的导入、解析、导出及持久化等](https://github.com/wujun728/jun_plugin)  
【jun_qrcode】[二维码生成器,二维码生成工具，WEB二维码服务](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_qrcode)  
【jun_quartz】[job任务调度,任务调度框架，分布式任务调度](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_quartz)  
【jun_redis】[ Redis缓存,Redis缓存，分布式缓存，分布式锁](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_redis)  
【jun_rpc】[原生RPC调用、客户端及服务端](https://github.com/wujun728/jun_plugin)  
【jun_restlet】[REST工具，轻量级REST框架,不依赖Servlet的REST的工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_restlet)  
【jun_serializable】[ 序列化,序列化与反序列化工具集](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_serializable_json_protobuf_kyro_hessian)  
【jun_shiro】[ 认证与鉴权,认证与鉴权，URL过滤，用户任务，角色功能鉴权](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_shiro)  
【jun_sso】[原生SSO的实现单点登录,SSO单点登录工具，提供单点登录服务](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_sso)  
【jun_servlet】[原生Servlet、WEB开发的基础](https://github.com/wujun728/jun_plugin)  
【jun_templatespider】[ 模板爬虫,模板爬虫工具，直接下载url到html文件](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_templatespider)  
【jun_test】[JUNIT框架及TestNG框架](https://github.com/wujun728/jun_plugin)  
【jun_util】[开发工具util，常用开发工具集、非常重要！！！](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_util)  
【jun_webmagic】[ 爬虫引擎Webmagic,爬虫引擎Webmagic，爬取整个网站](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_webmagic)  
【jun_webservice】[原生的webservice调用、基于apache cxf实现服务调用及发布,CXF，Axis等](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_webservice)  
【jun_webservlet】[原生Servlet 3.0的实现,Servlet3.0新特性demo，原生注解Servlet](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_webservlet)  
【jun_websocket】[原生的WebSocket的实现长链接,Websocket长链接demo，消息推送及异步工具](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_websocket)  
【jun_xml】[原生的XML解析及生产XML、提供SAX、DOM、DOM4J解析生成XML](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/jun_xml)  


> Maven常用项目模板，含maven单体分布式、SSH、SSM、SpringBoot、SpringCloud等

【maven_javaproject】[Java单体项目模板,Java单体项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_javaproject\)  
【maven_spring4_multi_modules】[Spring4多模块项目模板,Spring4多模块项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_spring4_multi_modules\)  
【maven_spring5_multi_modules】[Spring5多模块项目模板,Spring5多模块项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_spring5_multi_modules\)  
【maven_spring5template】[Spring5微服务项目模板,Spring5微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_spring5template\)  
【maven_springboot】[SpringBoot微服务项目模板,SpringBoot微服务项目模板](https://github.com/wujun728/jun_java_plugin/tree/master/spring_plugin/maven_springboot_permission_example\)  

【maven_account_parent】[Java单体项目模板,Java单体项目模板]
【maven_project_template】[Java单体项目模板,Java单体项目模板]

【maven_springboot_jpa_jsp】[Java单体项目模板,Java单体项目模板]
【maven_springboot_mybatis】[Java单体项目模板,Java单体项目模板]
【maven_springboot_permission_example】[Java单体项目模板,Java单体项目模板]
【maven_springboot_template】[Java单体项目模板,Java单体项目模板]

 



#### 开发环境
- **JDK 1.8 
- **Maven 3.5 
- **IDEA 2018.2 + or  STS 4.5 +** (*注意：安装lombok插件）


​	
#### TODO PLAN：

Step1基础篇：  
	jun_java_plugin Java基础框架-Java开发组件、Spring开发组件、SpringBoot开发组件、SpringCloud开发组件、Maven项目模板  
	jun_ssh_parent SSH基础框架-SpringBoot+EasyUI+JSP  
	jun_ssm_springboot SSM基础框架-SpringBoot+MybatisPlus+Boostrap+Shiro+JWT  
	jun_code_generator 代码生成器-SpringBoot+Freemarker+API接口+EasyExcel  
	jun_frontend_ui    前端框架，Bootstrap、AdminLTE、Jquery、EasyUI、LayUI、LayAdmin、Vue、vue-element-admin  
	jun_linux    服务器部署、gitlab部署、Nginx部署、Redis部署、Docker部署、MySQL部署、等等  
 	---审视项目本身，给出待办调整清单，给出下步计划  
Step2微服务&产品中心篇：  
	jun_api_service API接口服务框架，SpringBoot+Rest API  
	jun_springboot_vue 前后端分离框架，SpringBoot+Vue+JWT  
	jun_springcloud 微服务框架，SpringCloud Netflix、SpringCloud Alibaba、Dubbo框架、Quarkus极速框架 
	jun_product_center 产品中心，包含企业官网、企业办公自动化OA系统、企业资源管理ERP系统、项目管理系统、等等  
	jun_website   CMS网站系统，基于WordPress的网站系统、支持博客、企业官网、及各种网站模板  
	wujun728.github.io 个人博客  

Step3 移动产品篇&大数据：  
	jun_bigdata 大数据框架，支持数据清理、数据推荐、大数据分析、大数据企业看板、大数据报表等  
	jun_app    移动APP开发平台、支持Uniapp开发独立APP、小程序、企业办公等  
	jun_weixin   微信开发平台、微信公众号、微信小程序、微信管理后台、微信API接口后台  
	jun_android Android移动开发框架，APP开发模板、后台管理系统、后台API接口平台  
	
-———————————————————————————————————————————————————————————————————————————————————————————————————————— 【TODO】待处理-TODO PLAN[jun_2021]


2011/08~2013/6
中航油税务管理系统、众环海华OA、众环海华ERP系统，担任项目开发
开发工程师
2013/07~2016/11
武汉农商ECIF，武汉农商CRM，长沙银行新报表平台，浦发银行PIMS系统，上海银行数据标准管理系统，前后担任开发、PL，PM等角色，负责需求分析、开发及业务实现，项目管理等工作
开发PL
2016/12~2018/02
担任华为HTM项目PM、SE，负责项目需求跟踪、分析、项目进度管理、人员管理、风险质量管理、输出IT方案及具体代码实现等工作
PM、SE
2018/03~至今
担任华为DTP项目SE、PM，负责项目整体需求分析、业务交付、整体人员能力提升、聚焦团队建设工作及版本交付等
PM、SE

 

产品清单：上传服务器发布

> > jun_code_generator 代码生成器
> > 为ssh项目写个代码生成器
> > mvn_template 开发模板，调整，新增项目模板；
> > 新增SSH、SSM、SpringBoot、SpringCloud、Android、APP   
> > 模板,新增+jun_ssh+ssm+springboot+mybatis+JPA

1、精简代码生成器
2、拆分成多个模块
3、切换freemarker
4、使用公共的数据源
5、维护多套模板-ssh

> > jun_plugin  
> > jun_java_plugin 常用开发组件，调整，新增并优化项目组件
> > https://github.com/whirlys/Elastic-In-Practice/tree/master/guava
> > fileServer-master\
> > fileServer-master (1)\
> > haima-front-dist-master\
> > jun_spring Spring开发组件，调整，新增Spring系常用plugin
> > jun_springboot SpringBoot开发组件，调整，SpringBoot系组件

> > jun_ssh_parent
> > Jun_ssh_eaayui
> > Jun_ssh_springboot
> > jun_ssm_parent
> > 整理ssm项目，写模板，模板还没梳理完
> > 美化ssh项目
> > https://github.com/doujinxian/renren-security
> > jun_springboot
> > jun_frontend_ui
> > jun_springcloud
> > SpringCloud开发组件，调整，SpringCloud系组件
> > Vue+uniapp+Nodejs+WordPress+PHP+Android+Bigdata 。
> > https://github.com/wujun728/vue-login-java
> > https://blog.csdn.net/xiaojinlai123/article/details/90694372
> > https://blog.csdn.net/sxdtzhaoxinguo/article/details/77965226
> > jun_linux
> > Linux开发组件，调整
> > jun_website
> > https://github.com/zhangdaiscott/luban-h5
> > https://github.com/zhangdaiscott/h5huodong
> > jun_bigdata

吴俊:
jun_website
https://github.com/zhangdaiscott/luban-h5
https://github.com/zhangdaiscott/h5huodong
jun_bigdata
jun_product_center
常用项目模板及常用项目，调整，常用项目的集合，私有的
财务系统
OA办公系统
https://github.com/hjp1011/uniapp-oa
http://www.yiiframe.com/
后端源码：官网下载
https://github.com/misstt123/oasys
https://github.com/yunchaoyun/active4j-oa
https://github.com/yunchaoyun/active4j-jsp        
HR服务系统
CRM客户关系
行政服务系统
问答系统
知识学习系统
jun_weixin
微信开发，调整
weixin_api
weixin_boot
weixin_manager
jun_android
jun_app
APP开发，调整
jun_uniapp
https://github.com/chenbool/uniapp-douyin
jun_app_cms

待办：
https://github.com/lerry903/spring-boot-api-project-seed
https://github.com/jackying/H-ui.admin
https://github.com/xiaoshaDestiny/spring-cloud-2020

https://github.com/stylefeng/Guns
https://github.com/jsnjfz/WebStack-Guns
https://github.com/1477551037/exam
https://github.com/itd2008/My-Blog
https://github.com/qiaokun-sh/spring-token

https://github.com/wujun728/inspinia_admin_java_ssm

https://github.com/xwjie/ElementVueSpringbootCodeTemplate
https://github.com/RudeCrab/rude-java
https://github.com/Wjhsmart/Front-end-UI
https://github.com/zongjl/JavaWeb
https://github.com/zongjl/Jeebase
https://github.com/xzt1995/nideshop-springboot

fsLayui
VIEWUI-FOR-EASYUI 迁移到UI
spring-boot-starter-motan
java
layoutit
Personnel-Management-System
fiction_house
inspinia_admin_java_ssm
springboot-mui
Jobs-search
xxyms————————————————————————————————————————————————————————————————————————————————————————————————————————
​      

TODO PLAN：

1、清空readme，新增readme图片，新增胶片方案模板供截图
2、调整package，调整author，调整每个工程大小，调整每个项目jar包
3、调整每个项目运行
4、mvn_template 开发模板，调整，新增项目模板；新增


jun_code_generator
0、默认生成模板调整，默认下载zip包调整
1、代码生成器jun_code_generator 默认提供Spring、Hibernate、MyBatis、Spring JDBC模板
2、代码生成器，将easyexcel的demo合并到code_generator
3、代码生成器的模板跟maven_template再整一下
4、代码生成器新模板
	Ssm+easyUI
	SSM+jwt+layui
	boot+Bootstrap
	boot+jwt+vue
5、单表生成
6、关联表生成
7、整理ssm项目
8、整理boot项目
9、SSH、SSM、SpringBoot、SpringCloud、Android、APP模板,
10、新增+jun_ssh+ssm+springboot+mybatis+JPA
jun_springboot_vue
1、ruoyi-vue-pro    ---迁移到
jun_product_center 产品中心，常用项目模板及常用项目工程，调整，常用项目的集合，私有的
0、整chinasoft的login.html跟index.html的page，适配Nginx跟ssm_jwt；
1、整理cs的login页面
2、整理cs的index页面
3、整理layui的静态前端页面并归档
4、整理adminlte及hplus
5、整理easyui的前端页面并归档
6、整理代码生成器
先根据邮件去掉非必须的项目
综合配置login及index的页面的归档


wujun728.github.io
jun_springcloud
jun_linux    Linux开发组件
Nginx优化，nginx优化单台机器抗10万并发
https://www.jianshu.com/p/5149a7a700b9
jun_weixin   微信开发
jun_android Android开发
jun_app    APP开发，Vue+uniapp+Nodejs++Android
jun_temp    临时仓库，干掉
jun_website    网站开发,以WordPress+网站模板为主
jun_bigdata   大数据开发



https://blog.csdn.net/yf275908654/article/details/50171607

 

Ssh_parent
aicode\      干掉
authority\ jsp hplus boot jpa
biu\   迁移到vue里面
mis\ 干掉
ShiroJwt\ 迁移到vue里面

不要的东西删掉，重新拟定计划跟技术选型及产品
1、新增产品规划，产品及技术选型
2、先技术规划，技术规划
3、新增管理规划，功能点补充及二次开发规划
4、功能地图及产品中心规划
5、整理胶片的模板发挥架构的优势


###TODO待办清单
NOTE20210311
jun_2021\
jun_framework\
jun_ssm\
jun_test\
jun_test11\
About
代码生成器jun_code_generator 默认提供Spring、Hibernate、MyBatis、Spring JDBC模板，也可以根据FreeMarker语法编写自定义模板生成代码。


https://www.bejson.com/
Nginx优化
https://www.jianshu.com/p/5149a7a700b9
Netty
https://blog.csdn.net/yuanzhenwei521/article/details/79194275

jun_boot
jun_plugin
jun_weixin
jun_ssm
jun_cloud
jun_app
jun_website 
fsLayui 
VIEWUI-FOR-EASYUI 
spring-boot-starter-motan 
java
layoutit
Personnel-Management-System
fiction_house
inspinia_admin_java_ssm
springboot-mui
Jobs-search
xxyms
jun_temp1\
jun_temp2\
TODO PLAN：




Vue+uniapp+Nodejs+WordPress+PHP+Android+Bigdata


https://blog.csdn.net/xiaojinlai123/article/details/90694372
https://blog.csdn.net/sxdtzhaoxinguo/article/details/77965226




https://hub.fastgit.org/moshowgame/SpringBootCodeGenerator
https://hub.fastgit.org/SpringCloud/spring-cloud-codegen
http://hub.fastgit.org/thinkgem/jeesite_autocode

Readme.md template

plugin
https://hub.fastgit.org/RudeCrab/rude-java/tree/master/project-practice


干掉，放到plugin里面
https://hub.fastgit.org/wujun728/jun_frontend_ui

boot

https://hub.fastgit.org/wujun728/jun_springboot 
合并到jun_ssm,并重命名

https://hub.fastgit.org/wangyushuai/inspinia_admin_java_ssm

前端模板-合并到front里面
https://hub.fastgit.org/wenfengSAT/wenfengSAT-UI
迁移到CRM里面
https://hub.fastgit.org/wenfengSAT/SpringbootCRM
迁移到plugin里面
https://hub.fastgit.org/wenfengSAT/wenfengSAT-SpringBoot
迁移到uniapp里面
https://hub.fastgit.org/fanchaoo/netease-cloud-music-community
待处理：
迁移到cloud里面
fsLayui
VIEWUI-FOR-EASYUI
spring-boot-starter-motan
总体待办：
吴俊-补充TODO待办清单
Jun_code-generator
临时分支


Jun_code_generator
doc\ 
	simple-fast-generator\   合并到code_mplus
	
jun_code_generator\
	hub.fastgit.org/alibaba/easyexcel
	集成easyexcel读取文件的功能noModelRead
jun_code_mybatis\
jun_code_mybatisplus\  




### 附录：个人作品索引目录（持续更新）

#### 基础篇:职业化，从做好OA系统开始
1. [Spring boot整合Mybatis实现增删改查（支持多数据源）](https://gitee.com/shenzhanwang/SSM)![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")
2. [Struts2,Hibernate,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/S2SH)
3. [Spring,SpringMVC和Hibernate的整合实现增删改查](https://gitee.com/shenzhanwang/SSH)
4. [Spring平台整合activiti工作流引擎实现OA开发](https://gitee.com/shenzhanwang/Spring-activiti)![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")
5. [Spring发布与调用REST风格的WebService](https://gitee.com/shenzhanwang/Spring-REST)
6. [Spring整合Apache Shiro框架，实现用户管理和权限控制](https://gitee.com/shenzhanwang/Spring-shiro)
7. [使用Spring security做权限控制](https://gitee.com/shenzhanwang/spring-security-demo)
8. [Spring整合Jasig CAS框架实现单点登录](https://gitee.com/shenzhanwang/Spring-cas-sso)
#### 中级篇：中间件的各种姿势
9. [Spring连接mongoDB数据库实现增删改查](https://gitee.com/shenzhanwang/Spring-mongoDB)
10. [Spring连接Redis实现缓存](https://gitee.com/shenzhanwang/Spring-redis)
11. [Spring连接图存数据库Neo4j实现增删改查](https://gitee.com/shenzhanwang/Spring-neo4j)
12. [Spring平台整合消息队列ActiveMQ实现发布订阅、生产者消费者模型（JMS）](https://gitee.com/shenzhanwang/Spring-activeMQ)
13. [Spring整合消息队列RabbitMQ实现四种消息模式（AMQP）](https://gitee.com/shenzhanwang/Spring-rabbitMQ)
14. Spring框架的session模块实现集中式session管理 [购买](http://t.cn/Ai80zekN)
15. [Spring整合websocket实现即时通讯](https://gitee.com/shenzhanwang/Spring-websocket)![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")
16. 使用Spring boot整合mybatis,rabbitmq,redis,mongodb实现增删改查 [购买](http://t.cn/Ai8Yh8Oy)
17. [Spring MVC整合FastDFS客户端实现文件上传](https://gitee.com/shenzhanwang/Spring-fastdfs)
18. 23种设计模式，源码、注释、使用场景 [购买](http://t.cn/Ai8Y7tEF)
19. [使用ETL工具Kettle的实例](https://gitee.com/shenzhanwang/Kettle-demo)
20. Git指南和分支管理策略 [购买](http://t.cn/Ai8Y7948)
21. 使用数据仓库进行OLAP数据分析（Mysql+Kettle+Zeppelin） ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")[购买](http://t.cn/Ai8Y7dVD)
#### 高级篇：架构之美
22. [zookeeper原理、架构、使用场景和可视化](https://gitee.com/shenzhanwang/zookeeper-practice)
23. Spring boot整合Apache dubbo v2.7.5实现分布式服务治理（SOA架构） ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题") [购买](https://dwz.lc/beP9N33)
>  包含组件Spring boot v2.2.2+Dubbo v2.7.5+Nacos v1.1.1
<a href="https://images.gitee.com/uploads/images/2020/0114/084731_fd0b7a82_1110335.gif" target="_blank">效果图</a>
24. 使用Spring Cloud Alibaba v2.1.0实现微服务架构（MSA架构）![输入图片说明](https://img.shields.io/badge/-%E6%8B%9B%E7%89%8C-yellow.svg)   [购买](https://dwz.lc/IdmrHzd)
>  包含组件Nacos+Feign+Gateway+Ribbon+Sentinel+Zipkin
<a href="https://images.gitee.com/uploads/images/2020/0106/201827_ac61db63_1110335.gif" target="_blank">效果图</a>
25. 使用jenkins+centos+git+maven搭建持续集成环境自动化部署分布式服务 [购买](http://t.cn/Ai8YZbaX)
26. 使用docker+compose+jenkins+gitlab+spring cloud实现微服务的编排、持续集成和动态扩容 [购买](http://t.cn/Ai8YZCYK)
27. 使用FastDFS搭建分布式文件系统（高可用、负载均衡）[购买](http://t.cn/Ai8YZePu)
28. 搭建高可用nginx集群和Tomcat负载均衡 [购买](http://t.cn/Ai8Ywlr8)
29. 搭建可扩展的ActiveMQ高可用集群 [购买](http://t.cn/Ai8YAbA8)
30. 实现Mysql数据库的主从复制、读写分离、分表分库、负载均衡和高可用 [购买](http://t.cn/Ai8YAOAK)
31. 搭建高可用redis集群实现分布式缓存 [购买](http://t.cn/Ai8Y2NQy)
32. [Spring boot整合Elastic search实现全文检索](https://gitee.com/shenzhanwang/Spring-elastic_search) ![输入图片说明](https://img.shields.io/badge/-%E6%8B%9B%E7%89%8C-yellow.svg "在这里输入图片标题")
#### 特别篇：分布式事务和并发控制
33. 基于可靠消息最终一致性实现分布式事务（activeMQ）[购买](http://t.cn/Ai8YLPBL)
34. Spring boot dubbo整合seata实现分布式事务![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题") [购买](https://dwz.lc/csO0rp2)
> 包含组件nacos v1.1.0 + seata v0.7.1 +spring boot dubbo v2.7.5
<a href="https://images.gitee.com/uploads/images/2020/0119/112233_62a33a77_1110335.gif" target="_blank">效果图</a>
35. Spring cloud alibaba v2.1.0整合seata实现分布式事务 ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")[购买](https://dwz.lc/0T8KCTC)
> 包含组件nacos v1.1.0 + seata v0.7.1 +spring cloud alibaba v2.1.0
<a href="https://images.gitee.com/uploads/images/2020/0119/134408_ee14a016_1110335.gif" target="_blank">效果图</a>
36. 决战高并发：数据库锁机制和事务隔离级别的实现![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题") [购买](http://t.cn/Ai8YyAQE)
37. 决战高并发：使用redis实现分布式锁  ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")[购买](http://t.cn/Ai8Y4bER)
38. 决战高并发：使用zookeeper实现分布式锁 [购买](http://t.cn/Ai8Y4Cuq)
39. 决战高并发：Java多线程编程实例 [购买](http://t.cn/Ai8Y4s0r)
40. 决战高并发：使用netty实现高性能NIO通信 [购买](http://t.cn/Ai8Ybq3e)
### 快捷入口
<a href="http://t.cn/Ai8YycFz" target="_blank">我的网店</a>

<a href="https://www.jianguofaka.com/details/B1143645" target="_blank">全套大礼包2020年版</a>





1、jun_api_service
初始化API_Service
https://hub.fastgit.org/lihengming/spring-boot-api-project-seed
干掉jun_api-plugin

2、jun_cache   ---干掉
新增springcache
https://hub.fastgit.org/iamsixer/spring-cache-demo
https://hub.fastgit.org/zheng-zy/spring-boot-redis-guava-caffeine-cache

3、camel 干掉，没啥用

4、jun_crawler 调整，跑起来，净化

5、jun_datasource_cluster rename 到 DataSource
新增 https://hub.fastgit.org/ran-jit/tomcat-cluster-redis-session-manager

6、分解jun_dbutils
https://hub.fastgit.org/objcoding/jdbc-utils

7、jun_demo rename到 jun_test

8、设计模式，合并到一起，分三种合并，中文转英文

9、jun_note 新增
https://hub.fastgit.org/GourdErwa/review-notes

10、新增jun_webservlet_guice_dbutil
https://www.cnblogs.com/huzi007/p/5802022.html
https://www.cnblogs.com/huzi007/p/5796372.html

11、drools https://hub.fastgit.org/maxxbwsDemo

12、email 调整，清理
https://hub.fastgit.org/biezhi/oh-my-email/blob/master/pom.xml
https://hub.fastgit.org/isliqian/NiceEmail

13、excel 集成 easyexcel
https://hub.fastgit.org/HowieYuan/easyexcel-encapsulation
新增jun_poi demo

14、jun_fileupload
https://hub.fastgit.org/wemakebug/FileUpload.Java
Spring fileupload
https://hub.fastgit.org/jdmr/fileUpload

15、freemarker boot https://hub.fastgit.org/JavaCodeMood/freemarker

16、guava
https://hub.fastgit.org/tiantiangao/guava-study
https://hub.fastgit.org/tfnico/guava-examples

17、guice
https://hub.fastgit.org/timlien/servlet-guice
https://hub.fastgit.org/greengerong/guice-demo
https://hub.fastgit.org/lg625740749/GuiceDemo

18、hibernate
https://hub.fastgit.org/hibernate/hibernate-demos

19、httpclient
https://hub.fastgit.org/Arronlong/httpclientutil
https://hub.fastgit.org/JourWon/httpclientutil

20、image
https://hub.fastgit.org/xuehuayous/ImageUpload
https://hub.fastgit.org/jmitchener/spring-images
https://hub.fastgit.org/woobong/spring-boot-jpa-summernote-image-upload-example
https://hub.fastgit.org/mrmodise/java-spring-file-upload

21、jbpm4
https://hub.fastgit.org/xxg3053/jbpm-study
https://hub.fastgit.org/American/workflow/tree/master/workflow

22.jdk 清理，调整

23、lucenne
https://hub.fastgit.org/abel533/SearchEngine
https://hub.fastgit.org/doushini/lucene
https://hub.fastgit.org/pumadong/cl-search
Springboot+ElasticSearch
https://hub.fastgit.org/Motianshi/all-search

24、pay
https://hub.fastgit.org/kongzhidea/pay
https://hub.fastgit.org/iyangyuan/pay-spring-boot

Spring-cloud

 


41、 webmagic
https://hub.fastgit.org/scsfwgy/WebMagic_CSDN_Demo
https://hub.fastgit.org/EzioL/neteasemusic

42、api_service
合并都api里面，其他的2个干掉

Spring
43、 jwt rename一下
新增springboot jwt
https://hub.fastgit.org/dolyw/VueStudy/tree/master/VueStudy08-JWT
https://hub.fastgit.org/dolyw/ShiroJwt.git

44、spring activemq
清理代码，优化test及readme
https://hub.fastgit.org/888xin/activeMQ

45、camel 调整为zip里面的spring
46、cas 干掉
新增oauth

47、cors 调整为filter过滤器

48、config 迁移到cloud里面

49、fastdfs

50、dubbo
https://hub.fastgit.org/GenshenWang/DubboDemo

51、quartz
https://hub.fastgit.org/ameizi/spring-quartz-cluster-sample

52、新增xxl-job
https://hub.fastgit.org/xuxueli/xxl-job

53、email
https://hub.fastgit.org/fangjieDevp/spring-email-master

54、Excel 干掉

55、hibernate
https://hub.fastgit.org/zhonglinlin1305/Spring
https://hub.fastgit.org/zhonglinlin1305/spring-projects/

0、Boot&cloud
https://hub.fastgit.org/zhonglinlin1305/spring-boot-sample/
https://hub.fastgit.org/zhonglinlin1305/spring-cloud-microservice
https://hub.fastgit.org/SpringForAll/springcloud-thoth

56、kafka
https://hub.fastgit.org/smallnest/spring-kafka-demo

57、lucenne
https://hub.fastgit.org/FuZhucheng/SSM

 

00、boot starter
https://hub.fastgit.org/battcn/extend-spring-boot

00、util
https://hub.fastgit.org/864381832/xJavaFxTool-spring

00、ppt
https://hub.fastgit.org/aalansehaiyang/technology-talk




1、plugin 代码全部梳理一遍，package/pom/test/readme
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
2、ssh 代码合并到一个，调整功能
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
3、ssm 代码合并到一个，调整功能
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
4、代码生成器、代码一套，功能一套，合并ry_gen
https://www.jianshu.com/p/31e532392a74
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
5、ui 整理ui
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
6、apiservice 代码一套，功能一套，同步ssm
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
https://hub.fastgit.org/callicoder/spring-webflux-reactive-rest-api-demo
https://blog.csdn.net/qq_35067322/article/details/106935320
https://hub.fastgit.org/dolyw/ShiroJwt
7、linux 部署文档，部署包、docker部署
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
部署环境


Step2
main
https://hub.fastgit.org/Heeexy/SpringBoot-Shiro-Vue
jun_springboot_jwt_layui\   合并到ssm框架
jun_springboot_jwt_shiro_api\   空的
jun_springboot_vue\   干掉
jun_springboot_vue_pro\ 合并到上面里面


Step4
1、uniapp
https://hub.fastgit.org/zsptsf/uniapp.git
https://hub.fastgit.org/c1013529993/springboot-uniapp-21cake



Step1
Jdbc_template
https://gitee.com/jervain_y/repository

https://hub.fastgit.org/horsecms/layuiCMS

Step2
1、vue-element-admin
https://hub.fastgit.org/panjiachen/vue-element-admin-site
https://panjiachen.github.io/vue-element-admin-site/zh/guide/
2、cloud
https://www.8kee.com/article/17347.html
https://hub.fastgit.org/JourWon/springcloud-learning
https://hub.fastgit.org/wenren0819/Spring-Cloud-2020
https://blog.csdn.net/ThinkWon/article/details/103726655

2、api_service
https://hub.fastgit.org/koocyton/reactor-guice
https://hub.fastgit.org/jwpttcg66/NettyGameServer
3、bigdata
爬虫
https://hub.fastgit.org/brianway/webporter
ETL
https://hub.fastgit.org/zhaxiaodong9860/kettle-scheduler
数仓
https://hub.fastgit.org/fenglei110/DataWarehouse
https://hub.fastgit.org/jd-bigdata/rtf-lake
https://hub.fastgit.org/xzt1995/Data-Warehouse
新增用户画像、用户行为
https://hub.fastgit.org/monsonlee/BigData
https://hub.fastgit.org/whirlys/BigData-In-Practice
https://hub.fastgit.org/597365581/bigdata_tools
https://blog.csdn.net/u013967628/article/details/83656560




1、plugin 代码全部梳理一遍，package/pom/test/readme
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
2、ssh 代码合并到一个，调整功能
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
3、ssm 代码合并到一个，调整功能
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
4、代码生成器、代码一套，功能一套，合并ry_gen
https://www.jianshu.com/p/31e532392a74
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
5、ui 整理ui
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
6、apiservice 代码一套，功能一套，同步ssm
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
https://hub.fastgit.org/callicoder/spring-webflux-reactive-rest-api-demo
https://blog.csdn.net/qq_35067322/article/details/106935320
https://hub.fastgit.org/dolyw/ShiroJwt
7、linux 部署文档，部署包、docker部署
1、清理没用代码、工程pom、工程package、工程test、readme、截图、胶片
部署环境


Step2
main
https://hub.fastgit.org/Heeexy/SpringBoot-Shiro-Vue
jun_springboot_jwt_layui\   合并到ssm框架
jun_springboot_jwt_shiro_api\   空的
jun_springboot_vue\   干掉
jun_springboot_vue_pro\ 合并到上面里面


Step4
1、uniapp
https://hub.fastgit.org/zsptsf/uniapp.git
https://hub.fastgit.org/c1013529993/springboot-uniapp-21cake


Step1
Jdbc_template
https://gitee.com/jervain_y/repository

https://hub.fastgit.org/horsecms/layuiCMS

Step2
1、vue-element-admin
https://hub.fastgit.org/panjiachen/vue-element-admin-site
https://panjiachen.github.io/vue-element-admin-site/zh/guide/
2、cloud
https://www.8kee.com/article/17347.html
https://hub.fastgit.org/JourWon/springcloud-learning
https://hub.fastgit.org/wenren0819/Spring-Cloud-2020
https://blog.csdn.net/ThinkWon/article/details/103726655

2、api_service
https://hub.fastgit.org/koocyton/reactor-guice
https://hub.fastgit.org/jwpttcg66/NettyGameServer
3、bigdata
爬虫
https://hub.fastgit.org/brianway/webporter
ETL
https://hub.fastgit.org/zhaxiaodong9860/kettle-scheduler
数仓
https://hub.fastgit.org/fenglei110/DataWarehouse
https://hub.fastgit.org/jd-bigdata/rtf-lake
https://hub.fastgit.org/xzt1995/Data-Warehouse
新增用户画像、用户行为
https://hub.fastgit.org/monsonlee/BigData
https://hub.fastgit.org/whirlys/BigData-In-Practice
https://hub.fastgit.org/597365581/bigdata_tools
https://blog.csdn.net/u013967628/article/details/83656560

Eureka
https://www.cnblogs.com/rickiyang/p/11802413.html
Rebbon
https://blog.csdn.net/forezp/article/details/74820899
Ribbon的负载均衡，主要通过LoadBalancerClient来实现的，而LoadBalancerClient具体交给了ILoadBalancer来处理，ILoadBalancer通过配置IRule、IPing等信息，并向EurekaClient获取注册列表的信息，并默认10秒一次向EurekaClient发送“ping”,进而检查是否更新服务列表，最后，得到注册列表后，ILoadBalancer根据IRule的策略进行负载均衡。在RestTemplate 被@LoadBalance注解后，能过用负载均衡，主要是维护了一个被@LoadBalance注解的RestTemplate列表，并给列表中的RestTemplate添加拦截器，进而交给负载均衡器去处理。

架构
https://blog.csdn.net/shenhuxi10000/article/details/105058723

https://hub.fastgit.org/wujun728/learningSummary

Springboot security
https://blog.csdn.net/yuanlaijike/article/details/80249235



mxtheme02



https://hub.fastgit.org/hemin1003
jun_temp     临时仓库
https://hub.fastgit.org/c1013529993/springboot-uniapp-21cake


JWT+VUE
https://hub.fastgit.org/cailichao/easyweb-jwt
https://hub.fastgit.org/whvcse/JwtPermission

Elasticsearch

来自 <https://www.cnblogs.com/sunsky303/p/9438737.html>

 

https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/zh-cn/index.html

***************************************************************************************************
***************************************************************************************************
***************************************************************************************************
***************************************************************************************************
***************************************************************************************************


Springboot_fileupload
https://hub.fastgit.org/gaoyuyue/MyUploader-Backend

springcloud_plugin
Superboot    --- 迁移到jun_cloud_center
Jun_dubbo ---迁移到jun_microservice
Spring

https://hub.fastgit.org/liuge1988/kitty-generator
https://hub.fastgit.org/zhoutaoo/SpringCloud




Api_service
1、API_BOOT代码生成器合并到code_generator里面
2、api里面的layui抽出来，合并到
https://hub.fastgit.org/Radom7/springboot-layui
jun_layuiadmin
3、新增apijson
https://hub.fastgit.org/APIJSON/APIJSON-Demo
https://vincentcheng.github.io/apijson-doc/

Api_service
1、API_BOOT代码生成器合并到code_generator里面
2、api里面的layui抽出来，合并到
https://hub.fastgit.org/Radom7/springboot-layui
jun_layuiadmin
3、新增apijson
https://hub.fastgit.org/APIJSON/APIJSON-Demo
https://vincentcheng.github.io/apijson-doc/



https://hub.fastgit.org/scaladte

https://hub.fastgit.org/malizhigithub/CRM


https://blog.csdn.net/qq_22211217/article/details/83759513
https://www.cnblogs.com/softidea/p/10271266.html
Mysql 递归查询

代码生成-springbootcodegenerator模板为主，逻辑为辅+新增数据查询转元数据+文件生成的方式
https://blog.csdn.net/houxinlin_csdn/article/details/108683593
https://blog.csdn.net/znwnymys/article/details/80739722
https://hub.fastgit.org/houbb/low-code
https://www.cnblogs.com/lbangel/p/3487796.html
https://blog.csdn.net/linhao_obj/article/details/88921170
Jdbc metabase


WordPress 多站点
企业官网
中软门户网站





 





   

