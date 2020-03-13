package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Product;
/*接受表单数据*/
@Controller
public class ProductController {

    @RequestMapping("/addProduct")
    public ModelAndView add(Product product) throws Exception{
        ModelAndView mav = new ModelAndView("showProduct");
        //Product等价于 mav.addObject("product",product);
        return mav;
    }
}
