异常处理：
springmvc框架采用的是统一，全局的异常处理。
把controller中的所有异常处理都集中到一个地方。 采用的是aop的思想。把业务逻辑和异常处理代码分开。解耦合。

使用两个注解
1.@ExceptionHandler
2.@ControllerAdvice


是将异常处理方法专门定义在一个类中，作为全局的异常处理类。
需要使用注解@ControllerAdvice，字面理解就是“控制器增强”，是给控制器对象增强功能的。
使用@ControllerAdvice 修饰的类中可以使用@ExceptionHandler。
当使用@RequestMapping 注解修饰的方法抛出异常时，会执行@ControllerAdvice 修饰的类中的异常处理方法。
@ControllerAdvice 是使用@Component 注解修饰的，可以<context:component-scan>
扫描到@ControllerAdvice 所在的类路径(包名)，创建对象。
