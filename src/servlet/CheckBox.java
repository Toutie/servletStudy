package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@WebServlet("/CheckBox")
public class CheckBox extends HttpServlet implements Serializable {

    private static final long seriaversionUID = 1L;


    @Override
    public void init() throws ServletException {
        System.out.println("my checkBox is started");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //拿到输出流
        PrintWriter writer = resp.getWriter();
        String title = "读取复选框数据";
        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>菜鸟按教程标识：</b>: "
                + req.getParameter("runoob") + "\n" +
                "  <li><b>Google 标识：</b>: "
                + req.getParameter("google") + "\n" +
                "  <li><b>淘宝标识：</b>: "
                + req.getParameter("taobao") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
}
