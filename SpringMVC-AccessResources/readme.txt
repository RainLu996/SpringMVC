SpringMVC项目实现步骤：
    1、新建maven-web工程
    2、加入依赖：
        ->spring-webmvc依赖：会间接的将spring依赖都加入到项目当中
        ->jsp、servlet依赖
    3、重点：在web.xml中注册springMVC的核心对象【DispatcherServlet】
             1）DispatcherServlet叫做中央调度器；是一个servlet；它的父类继承了HttpServlet
             2）DispatcherServlet也叫作前端控制器（Front Controller）
             3）DispatcherServlet负责接收用户提交的请求，然后调用其它的控制器对象，并把请求的处理结果显示给用户
    4、创建一个发起请求的页面
    5、创建控制器类（也叫作：后端控制器 Back Controller）
       1）在类的上面加入@Controller注解，创建对象，并放入到springMVC容器当中
       2）在类中的方法上面加入@RequestMapping注解
    6、创建一个显示处理结果的jsp
    7、创建springMVC的配置文件（同spring的配置文件）
        1）声明组件扫描器，指定@Controller注解所在的包名
        2）声明视图解析器，帮助处理视图view


---------------------------------------------------------------------------------------------------
                            *****SpringMVC请求的处理流程*****
         1）发起some.do
         2）tomcat(web.xml--url-pattern知道 *.do的请求给DispatcherServlet)
         3）DispatcherServlet（根据springmvc.xml配置知道 some.do---doSome()）
         4）DispatcherServlet把some.do转发个MyController.doSome()方法
         5）框架执行doSome（）把得到ModelAndView进行处理， 转发到show.jsp


        上面的过程简化的方式
          some.do---DispatcherServlet---MyController