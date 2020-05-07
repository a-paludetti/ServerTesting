package HTTPWebServer;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Httpserver {

    public void httpServer() throws InterruptedException, LifecycleException {
        String webLocation = "src/main/java/HTTPWebServer/";
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.parseInt(webPort));

        StandardContext context = (StandardContext) tomcat.
                addWebapp("/", new File(webLocation).getAbsolutePath());

        File additionWebClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources,
                "/WEB-INF/classes", additionWebClasses.getAbsolutePath(),
                "/"));

        context.setResources(resources);
        tomcat.start();
        tomcat.getServer().wait();
    }
}
