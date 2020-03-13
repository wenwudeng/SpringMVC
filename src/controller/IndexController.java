package controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 手动配置映射
 */
public class IndexController implements Controller {

/*控制类 IndexController实现接口Controller ，提供方法handleRequest处理请求
    SpringMVC通过 ModelAndView 对象把模型和视图结合在一起

    ModelAndView mav = new ModelAndView("index.jsp");
    mav.addObject("message", "Hello Spring MVC");

    表示视图是index.jsp
    模型数据是 message，内容是 “Hello Spring MVC”*/

  @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

}
