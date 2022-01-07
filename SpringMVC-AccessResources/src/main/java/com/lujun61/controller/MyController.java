package com.lujun61.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lujun61.paramBean.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/** Controller注解
 *      作用：用来创建控制器对象，对象就放在springMVC容器之中
 *      位置：在类的上面
 */
@Controller

/** RequestMapping注解：放在类的上面时
 *      value：所有请求地址的公共名称。叫做----->【模块名称】
 */
@RequestMapping(value = "/lujun61")
/**
 * @description 在自定义控制器类中定义方法，处理用户提交的请求
 * @author Jun Lu
 * @date 2022-01-02 18:59:30
 */
public class MyController {
    /** 准备使用doSome方法处理some.do请求
     *     RequestMapping注解：请求映射。作用是把一个请求地址和一个方法绑定在一起。
     *          使用RequestMapping注解修饰的【方法】叫做处理器方法或者控制器方法。
     *          使用RequestMapping注解修饰的【方法】是可以处理请求的，类似于servlet中的doGet、doPost方法
     *        属性：
     *              1、value：是一个String[]，表示请求的uri地址。
     *                 value的值必须是唯一的，不能重复。在使用时，推荐地址以“/”开头
     *              2、method：是一个枚举，表示请求的方式。不写此属性，表示可以接受任何方式的请求
     *                  --RequestMethod.GET：表示必须使用get方式发起请求
     *                  --RequestMethod.POST：表示必须使用post方式发起请求
     *        位置：
     *             1、在方法定义的上面（常用）
     *             2、在类定义的上面
     *        返回值：
     *             ModelAndView：表示本次请求的处理结果
     *                  Model：即数据。请求处理完成后，要显示给用户的数据
     *                  View：视图。显示给用户处理结果的文件
     */
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() {
        //处理some.do请求的控制器方法
        ModelAndView mv = new ModelAndView();

         /*添加数据：框架将数据放入到request作用域对象中*/
        //request.setAttribute(key, value);
        mv.addObject("msg", "这是使用SpringMVC做的第一个WEB应用！");
        mv.addObject("fun", "doSome方法执行了！");

         /*指定视图的完整路径*/
        //request.getRequestDispatcher("/result.jsp").forward(req, resp);
        //mv.setViewName("/result.jsp");

         /* 配置视图解析器后的写法：逻辑名称 */
        mv.setViewName("result");

        return mv;
    }

    /* POST请求方式 */
    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", "控制器方法2");
        mv.addObject("fun", "doOther方法执行了！");

        /* 配置视图解析器后的写法：逻辑名称 */
        mv.setViewName("result");

        return mv;
    }



/*----------------------------处理请求参数----------------------------------------------------------*/

    /**
     *   处理器方法可以包含以下四类参数，这些参数会在系统调用时由系统自动赋值，即程序员可在方法内直接使用。
     *       ➢ HttpServletRequest
     *       ➢ HttpServletResponse
     *       ➢ HttpSession
     *       ➢ 请求中所携带的请求参数
     */
    @RequestMapping(value = "/param.do")
    public ModelAndView toHandleParam(HttpServletRequest request,
                                      HttpServletResponse response,
                                      HttpSession session,
                                      String name, Integer age) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", "得到了请求参数：" +
                request.getParameter("name") + "，" + request.getParameter("age"));
        mv.addObject("fun", "toHandleParam方法执行了！");

        mv.addObject("myName", name);
        mv.addObject("myAge", age);

        /* 配置视图解析器后的写法：逻辑名称 */
        mv.setViewName("result");

        return mv;
    }


    @RequestMapping(value = "/differentParam.do")
   /**
    *     请求中所携带的请求参数处理方式：
    *        1、逐个接受（参数很少时，就用这个）：
    *           要求：处理器（控制器）方法的形参名和请求中参数名必须一致
    *           即：同名的请求参数赋值给同名的形参
    *
    *           but：参数名和处理器方法的形参名不一致的解决方案：
    *                使用@RequestParam注解！！！
    *                    注意：只能使用在逐个接受参数的解决方案中
    *                --->属性：
    *                        1、value：请求参数名
    *                        2、required：是一个boolean类型的，默认是true
    *                            true：表示请求中必须包含此参数
    *                            false：表示请求中不一定需要包含此参数
    *                    位置：
    *                        在处理器方法的形参定义的前面
    */
    public ModelAndView toHandleParam(
            @RequestParam(value = "diffName", required = true) String name,
            @RequestParam(value = "diffAge", required = true) Integer age) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("diffName", name);
        mv.addObject("diffAge", age);

        /* 配置视图解析器后的写法：逻辑名称 */
        mv.setViewName("chainParam");

        return mv;
    }


    /**
     * 请求中所携带的请求参数处理方式：
     *      2、使用java对象接收参数（参数很多时，就用这个）：
     *          前提：
     *              请求参数必须跟对象中的属性名一样！！！
     *          原理：
     *              框架会创建形参的java对象，并通过set方法给属性赋值。（类似于set注入）
     */
    @RequestMapping(value = "/objParam.do")
    public ModelAndView toHandleParam(People peo) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("objName", peo.getName());
        mv.addObject("objAge", peo.getAge());

        /* 配置视图解析器后的写法：逻辑名称 */
        mv.setViewName("objParam");

        return mv;
    }


/*----------------------------处理请求参数----------------------------------------------------------*/
    /**
     * 返回值为ModelAndView：有数据和视图，对视图执行forward
     */
    /**
     * 处理器方法返回String---如果只需要表示【视图】名称，则返回值用String
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnStringView(People peo, HttpServletRequest request) {
        /* 可以自己手动将数据添加到request作用域 */
        request.setAttribute("name", peo.getName());
        request.setAttribute("age", peo.getAge());

        /* 配置视图解析器后的写法：逻辑名称 */
        //框架对视图进行forward转发工作
        return "returnString-view";
    }

    /**
     * 处理器方法返回void---不能表示数据，也不能表示视图；
     *      适用于在处理ajax时使用：ajax使用【响应对象】返回处理结果。
     *      返回的就是数据！与视图无关！
     */
    @RequestMapping(value = "/returnVoid.do")
    public void doReturnVoid(People peo, HttpServletResponse response) throws IOException {
        String json = "{}";
        //将对象数据转换为json格式数据
        ObjectMapper om = new ObjectMapper();
        json = om.writeValueAsString(peo);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }

    /**
     * 处理器方法返回Object---表示数据，不能表示视图；
     *      现在做ajax，主要使用json数据格式来传递数据。实现步骤为：
     *        1、加入处理json的工具库依赖（jackson）
     *        2、在springMVC配置文件中加入<mvc:annotation-driven/>注解驱动
     *              用来完成：【对象数据】到【json数据格式】的数据转换
     *        3、在处理器方法上面加入@ResponseBody注解
     *              用来完成：数据的响应工作；将json数据格式数据输出到【浏览器】
     *
     *
     * 实现原理：
     *      1、<mvc:annotation-driven/>注解驱动：
     *            加入了此注解，在springMVC容器中会自动创建【HttpMessageConverter】接口的实现类对象。
     *            包括MappingJackson2HttpMessageConverter【将数据转换为json格式】、StringHttpMessageConverter【将数据转换为text/plain格式】
     *
     *            在HttpMessageConverter中的，控制器用来将结果输出给浏览器时使用的：
     *               boolean canWrite(Class<?> var1, @Nullable MediaType var2);
     *                  检查处理器方法var1的返回值，能不能转换为var2所表示的【数据格式】。能就返回true；反之相反
     *               void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3);
     *                  把处理器方法的返回值对象，调用jackson中的ObjectMapper对象转为json字符串
     *       2、@ResponseBody注解：
     *          放在处理器方法的上面，底层通过【HttpServletResponse】输出数据至浏览器，响应ajax请求
     */
    @RequestMapping(value = "/returnObject.do")
    @ResponseBody
    /**
     * 框架对此返回值的处理流程：
     *     1、框架会调用【HttpMessageConverter】接口的每个实现类中的canWrite()方法，匹配一个能将盘【对象数据】转换为【所需要的数据类型】的实现类
     *     2、匹配完毕之后，框架会调用此类的write()方法，将数据进行转换
     *     3、待到转换完毕之后，框架会将转换完毕的数据输出给浏览器。    请求处理完成
     */
    public Object doReturnObject(People peo, HttpServletResponse response) throws IOException {
        return peo;
    }


    /**
     * 返回值是list集合，最终会转换为对应数据格式的数组形式。原理同上
     */
    @RequestMapping(value = "/returnJsonArray.do")
    @ResponseBody
    public ArrayList<People> doReturnObject(HttpServletResponse response) throws IOException {
        ArrayList<People> list = new ArrayList<>();
        People people = new People("id1", 1);
        list.add(people);

        people = new People("id2", 2);
        list.add(people);

        return list;
    }


    /**
     * 处理器方法返回的是String，这里的String是表示数据，不是视图！！！
     * 区分返回值是String时，是数据还是视图，就看有没有@ResponseBody注解；
     *      如果有@ResponseBody注解，就是表示【数据】；没有表示【视图】
     *
     *
     * 注意：
     *    Content-Type默认使用的是："text/plain;charset=ISO-8859-1"
     * 解决方案：给@RequestMapping增加一个属性【produces】；使用这个属性指定新的ContentType
     */
    @RequestMapping(value = "/returnStringData.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doReturnObject(){
        return "此时返回值是String，表示数据，而不是视图！！！";
    }


    /*----------------------------请求重定向和转发----------------------------------------------------------*/

    /**
     * 处理器方法返回ModelAndView，实现forward转发：
     *      语法：mv.setViewName("forward:视图文件完整路径");
     *      forward特点：不和视图解析器一同使用，就当项目中未配置视图解析器
     *                  可以访问WEB-INF文件夹中的文件，因为forward之后的请求是服务器
     *
     *      作用：可以访问配置视图之后，无法访问的资源文件
     */
    @RequestMapping(value = "/doForward.do", method = RequestMethod.GET)
    public ModelAndView doForward(String name, Integer age) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("name", name);
        mv.addObject("age", age);

        mv.setViewName("forward:/WEB-INF/view/doForward.jsp");
        /* 配置视图之后，这样无法访问文件： mv.setViewName("doForward");*/

        return mv;
    }

    /**
     * 处理器方法返回ModelAndView，实现重定向redirect：
     *      语法：mv.setViewName("redirect:视图文件完整路径");
     *      redirect特点：不和视图解析器一同使用，就当项目中未配置视图解析器
     *                  不可以访问WEB-INF文件夹中的文件，因为发起请求的都是浏览器！
     *
     *      框架对重定向的操作：
     *          1、框架会把Model中的简单数据类型转为String来使用，作为doRedirect.jsp中的get请求参数使用
     *          目的：在doRedirect.do与doRedirect.jsp两次的请求之间传递数据
     *
     *          2、在doRedirect.jsp页面可以使用参数集合对象 ${param} 来获取请求参数值
     *
     *              http://localhost:8080/myWeb/doRedirect.jsp?name=陆俊&age=18
     *              EL表达式简化版：${param.name}、${param.age}
     *              即：<%=request.getParameter("请求中的参数名")%>
     */
    @RequestMapping(value = "/doRedirect.do", method = RequestMethod.GET)
    public ModelAndView doRedirect(String name, Integer age) {
        ModelAndView mv = new ModelAndView();

        //这里的request域数据在对doRedirect.jsp发起请求时，不再共享。因为是【重定向转发】
        mv.addObject("name", name);
        mv.addObject("age", age);

        mv.setViewName("redirect:/doRedirect.jsp");
        /* 配置视图之后，这样无法访问文件： mv.setViewName("doRedirect");*/

        return mv;
    }
}














