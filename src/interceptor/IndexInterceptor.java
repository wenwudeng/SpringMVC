package interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class IndexInterceptor extends HandlerInterceptorAdapter {
    /**
     * 在业务处理器处理<请求之前>被调用
     *
     * 如果返回<false>
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链

     * 如果返回<true>
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("preHandle()，在访问Controller之前被调用");
        return true;
    }

    /**
     * 在业务处理器<处理请求执行完成后>,<生成视图之前>执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    public void  postHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle()，在访问Controller之后，访问视图之前被调用，这里可以注入一个时间modleAndView中，用于视图显示");
        modelAndView.addObject("data，拦截器生成时间", new Date());
    }

    /**
     * 在DispatcherServlet<完全处理完请求后>被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion()，在访问视图之后被调用");
    }

}
