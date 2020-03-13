# spring MVC基本使用
# 1.run project
# 2.视图定位
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
# 4.接受表单数据
# 5.客户端跳转
# 6.Session
# 6.中文问题
# 7.上传文件
# 8.拦截器