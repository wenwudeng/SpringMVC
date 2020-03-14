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
- **注意：**  1.addProdcut.jsp提交的name和price值会自动注入到参数product中  
             2.参数product会默认被当作值加入到ModelAndView中，相当于`mav.addObject("product",product);

# 5.客户端跳转
## 查看IndexController2类jump方法及springmvc-servlet.xml
- 首先映射到/jump路径进入到jump()方法，在jump()中编写如下代码  `ModelAndView mv = new ModelAndView("redirect/index"")`

# 6.Session
## 查看IndexController2类check()方法方法及springmvc-servlet.xml
- 为check()方法提供参数*HttpSession session*,这样就可以在方法中使用Session了接下来的逻辑就是每次访问session中的count+1，跳转到*check.jsp*页面

# 6.中文问题
#3 查看web.xml中*filter*标签
- 在web.xml中配置filter过滤器:<br>```<filter> 
                                   <filter-name>CharacterEncodingFilter</filter-name> 
                                   <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class> 
                                   <init-param> 
                                       <param-name>encoding</param-name> 
                                       <param-value>utf-8</param-value> 
                                   </init-param> 
                               </filter> 
                               <filter-mapping> 
                                   <filter-name>CharacterEncodingFilter</filter-name> 
                                   <url-pattern>/*</url-pattern> 
                               </filter-mapping>    ```
# 7.上传文件
## 查看 UploadController类
- 配置wbx.xml运行加载静态资源
- 配置springmvc-servlet.xml
- 创建upload.jsp,其中form属性，method使用post方式提交，enctype="multipart/form-data"
  *input标签中accept="image/"**表示支持所有图片类型，不限制图像格式；也可以更改想要的类型accept="image/gif,image/jepg
- 创建基于表单的name值的实体类-uploadImageFile
- 创建UploadController控制器
- 创建showUploadFile.jsp

# 8.拦截器
## 查看IndexInterceptor类
- 创建一个拦截器类-IndexInterceptor
- 配置拦截器:在springmvc-servlet.xml中对index路径进行拦截
- 创建index1.jsp
- 创建IndexInterceptorController


