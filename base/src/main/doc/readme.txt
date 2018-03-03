https配置指南：
1.生成p12证书:
使用命令：keytool -genkey -alias wxbc.rhine -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12  -validity 3650 生成一个p12的证书,文件名是：keystore.p12。

//tomcat配置
2.将keystore.p12 放到tomcat安装的conf目录
3.修改conf/server.xml文件，去掉如下注释内容（大概87行）：
 <Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
               maxThreads="150" SSLEnabled="true"
               keystoreFile="conf/keystore.p12" keyAlias="wxbc.rhine" keystorePass="Changeme_123"
                clientAuth="false">

以上的keystorepass：是步骤1生成的密码；keyAlias是步骤1的-alias选项。



4.修改conf/web.xml，在最后增加如下内容，让所有的访问都走8443端口
<security-constraint>
        <web-resource-collection>
            <web-resource-name>SSL</web-resource-name>
                <url-pattern>/*</url-pattern>
            </web-resource-collection>
        <user-data-constraint>
             <transport-guarantee>CONFIDENTIAL</transport-guarantee>
        </user-data-constraint>
    </security-constraint>

5.使用https:127.0.0.1:8443/base/login访问


----mysql安装指导：

软件目录：172.16.1.250   目录：/pub/fengxinhe/mysql,参考mysql_intall_guide.txt文件

执行命令： /etc/init.d/mysql start  启动mysql

配置文件路径：/etc/mysql/mysql.cnf
登录mysql： mysql -u root -p 



执行install.sql脚本 初始化数据库，文件在/src/main/sql目录。




附录：
在springboot中如何配置https通道
2.将生成的文件keystore.p12放到src/main/resources目录。
3.修改application.properties文件，增加如下几行信息：
server.port=8443
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=Changeme_123    //---在步骤1，输入的密码。
server.ssl.keyStoreType=PKCS12
server.ssl.keyAlias=wxbc.rhine   //---命令里面的alias参数


