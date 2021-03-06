package com.clover.springdemo;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.http.HttpServlet;

public class LaunchTomcat {
    public static void main(String[] args) throws Exception {
        initServer();
    }

    public static void initServer() throws Exception {
        String webappDirLocation = "src/main/webapp";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        String contextPath = "";

        StandardContext ctx = (StandardContext) tomcat.addWebapp(contextPath, new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//
//        URL[] urls = ((URLClassLoader) cl).getURLs();
//
//        for(URL url: urls){
//            System.out.println(url.getFile());
//        }

//        HttpServlet servlet = new TestDBServlet();
//        String servletName = "TestDB";
//        String urlPattern = "/testDB";
//
//        tomcat.addServlet(contextPath, servletName, servlet);
//        ctx.addServletMappingDecoded(urlPattern, servletName);

        tomcat.start();
        tomcat.getServer().await();
    }
}

