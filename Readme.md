# spring MVC基本使用
# 1.run project
# 2.视图定位
## 查看IndexController类及springmvc-servlet.xml
- 在springmvc-servlet.xml中增加
```
   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/page/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
```
- 修改IndexControler
- 在WEB-INF文件夹下新建一个page文件夹，并把index.jsp移动至其中

# 3.注解方式
## 查看IndexController2类及springmvc-servlet.xml
- 在类前面加上@Controller 表示该类是一个控制器
- 在handleRequest前面加上@RequestMapping("/index)
  表示路径/index会映射到该方法上,注意：此时IndexController不在实现Controller接口
- 去掉springmvc-servilet.xml中的相关SimpleUrlHandlerMapping bean配置，因为已经使用 **注解方式** 
  增加```<context:component-scan base-package="controller" />``` 

# 4.接受表单数据
## 查看ProductController类及springmvc-servlet.xml
- 创建一个基于表单name值实体类，即实体类中的值必须与表单中输入框(input)中的name值一样
- 创建一个ProdcutController类，并在该类中准的一个add方法主备一个Product参数,用于接受注入。 
@RequestMapping(/addProduct)  
 public ModleAndView add(Product product) throws Exception{
    //等价于mav.addObject("Product",product);
    ModelAndView mav= new ModelAndView("showProduct"") 
    return mav}
- 在controller类中创建

# 5.客户端跳转
## 查看IndexController2类jump方法及springmvc-servlet.xml
- 首先映射到/jump到jump()方法，在jump()中编写如下代码  `ModelAndView mv = new ModelAndView("redirect/index"")`

# 6.Session
# 6.中文问题
# 7.上传文件
# 8.拦截器


