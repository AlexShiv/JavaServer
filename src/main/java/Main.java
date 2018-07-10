import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {
        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet(); // сервлет для обработки запросов

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorRequestServlet), "/mirror");

        Server server = new Server(8080); // основной класс Jetty сервера
        server.setHandler(context); // передача хендлера
        server.start();
        server.join();
    }
}
