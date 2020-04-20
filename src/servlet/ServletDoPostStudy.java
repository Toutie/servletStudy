package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/helloDoPost")
public class ServletDoPostStudy extends HttpServlet {


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("我被调用了！");
//    }

    /**
     * 使用doPost
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");

        //拿到输出流
        PrintWriter writer = resp.getWriter();
        String name = new String(req.getParameter("name").getBytes("ISO8859-1"),"utf-8");
        String docType = "<!DOCTYPE html> \n";
        String title = "使用 doPost方法读取表单数据！";

        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + req.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
}
