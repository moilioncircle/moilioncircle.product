package com.moilion.circle.r044;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class R044Jetty {
    public static int JETTY_SERVER_PORT = 9999;

    public static void main(String[] args) {
        try {
            Server server = new Server(JETTY_SERVER_PORT);
            WebAppContext context = new WebAppContext();
            context.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
            context.setResourceBase("./src/main/webapp");
            context.setContextPath("/");
            context.setParentLoaderPriority(true);
            server.setHandler(context);
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}