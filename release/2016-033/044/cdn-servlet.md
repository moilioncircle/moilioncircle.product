分2期，一个servlet简介，cdn的写法
spring mvc 的3个xml，2个context

context 关系
Figure 22.2. Typical context hierarchy in Spring Web MVC
http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html

cdn, interceptor, filter,
jetty
2.3, 2.4 filter 不过滤内部forward
2.5 
servlet 2.4和3.0 区别
http://www.ibm.com/developerworks/cn/java/j-lo-servlet30/index.html

jetty embed
http://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty

ContextLoaderListener和DispatcherServlet
时序图

web.xml listener，filter加载顺序
ServletContext(context-param) -> listener -> filter -> servlet

http://docs.oracle.com/cd/B14099_19/web.1012/b14017/filters.htm

顺序
http://download.oracle.com/otndocs/jcp/servlet-2.4-fr-spec-oth-JSpec/
page 78
SRV.9.12Web Application Deployment

3.0 spec
8.2.2 p88
Ordering of web.xml and web-fragment.xml

8.2.3
Assembling the descriptor from web.xml, web-
fragment.xml and annotations



http://www.cnblogs.com/RunForLove/p/5688731.html


servelet 2.5
servelet 3.0

jetty 编码形式启动的好处


========
UrlBasedViewResolver
