SpringSSM整合开发：
    SSM：Spring SpringMVC MyBatis
    也叫作SSI【Spring SpringMVC IBatis】

Spring：业务层；管理service、dao、工具类对象的
SpringMVC：视图层；负责接收请求，显示处理结果
MyBatis：持久层；访问数据库的
  用户发起请求---SpringMVC接收---Spring中的service对象---MyBatis处理数据

容器：
    1、第一个容器：Spring容器，管理service、dao、工具类对象的
    2、第二个容器：Spring容器，管理Controller对象的
    开发者要做的就是将对象交给合适的容器创建、管理。

SpringMVC容器与Spring容器是有关联的：SpringMVC容器是Spring容器的子容器，类似于java的继承。
    在子容器中的Controller可以访问父容器中的Service对象。


----------------------------------------------------------------------------------------


具体项目实现步骤：
    1、创建数据库表文件
    2、新建maven--javaWeb项目
    3、加入依赖：
        SpringMVC、Spring、MyBatis、jackson、mySql驱动、druid数据库连接池、jsp、servlet依赖
    4、修改web.xml
        1）注册DispatcherServlet
            目的：创建SpringMVC容器对象->装载Controller类对象，一个Servelt，用来接收用户请求
        2）注册Spring的监听器：ContextLoaderListener
            目的：在web运行期间，只创建一次Spring容器对象
        3）注册【字符集过滤器】：CharacterEncodingFilter
            目的：解决请求参数乱码的问题
    5、创建包：
        controller service dao 实体类包
    6、写SpringMVC Spring MyBatis的配置文件
    7、写代码：dao接口与配对的mapper文件；service接口及其实现类；controller类；实体类
    8、写用户交互页面
















