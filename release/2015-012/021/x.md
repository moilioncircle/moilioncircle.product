
http://jasig.github.io/cas/4.1.x/integration/Delegate-Authentication.html

/home/trydofor/workspace/moilion-com/workspace/release/021
http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html

1.clone目标工程
https://github.com/leleuj/cas-pac4j-oauth-demo/tree/4.1.x
git clone -b 4.1.x https://github.com/leleuj/cas-pac4j-oauth-demo.git
mvn clean package

修改 java6到8
更新demo的maven配置

修改host

http://docs.spring.io/spring-webflow/docs/2.4.0.RELEASE/reference/html/defining-flows.html#defining-flows-introduction

https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419316505&token=&lang=zh_CN

链接到oauth，链接到rfc

eclipse 需要增加maven的dependency jstl ，jsp
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.0</version>
            <scope>provided</scope>
        </dependency>
消除jsp错误

http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html

微信appid和secret要隐藏

80端口权限 这时候需要注意target目录的权限
                    <httpConnector>
                        <port>80</port>
                    </httpConnector>

http://stackoverflow.com/questions/257616/sudo-changes-path-why
sudo env PATH=$PATH mvn --version


sso.anwee.com/cas/login

这里是java6，jetty9和java8 时，spring不能scanning
ASM4 升级asm5

jetty9 java8 spring

升级plugin到9.3.4就好了



