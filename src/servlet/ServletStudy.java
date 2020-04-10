package servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**学习一下servlet
 * @author wang
 */
public class ServletStudy extends HttpServlet implements Servlet {
    /**
     * //要返回的信息
     */
    private String message;

    @Override
    public void init() throws ServletException {
        //在这里执行初始化
        message = "Hello world";
        System.out.println("init() is start!!!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应内容类型
        response.setContentType("text/html;charset=utf-8");

        //实际的逻辑
        PrintWriter writer = response.getWriter();
        writer.println("<h1>"+message+"</h1>");
        System.out.println("------------ my doGet method is started!!!!!!-----------");
        System.out.println("requestLocalName: "+ request.getLocalName()+"\nrequestUser: " + request.getRemoteUser()
        +"\n requestContextPath: "+ request.getContextPath());

        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("SessionId is : "+ id);

        System.out.println("responseContentType: "+ response.getContentType()+"\n"+response.getHeaderNames());
    }

    /**
     * 结束生命周期
     */
    @Override
    public void destroy(){
        System.out.println("my beautiful life is destroy！！");
        super.destroy();
    }

}
