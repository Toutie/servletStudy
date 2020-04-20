package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;


@WebServlet("/HelloDoGet")
public class ServletDoGetStudy extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init method is started");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应内容类型
        resp.setContentType("text/html;charset=utf-8");
//        //设置响应编码类型
//        resp.setCharacterEncoding("utf-8");
        //拿到输出流
        PrintWriter out = resp.getWriter();

        String title = "使用GET方法读取表单数据 ！";
        if(req.getParameter("name") != null){
            String name = new String(req.getParameter("name"));
            System.out.println(req.getParameter("name"));
            String docType = "<DOCTYPE html>\n";
            out.println(docType +
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.doGet(req,resp);
    }
}
