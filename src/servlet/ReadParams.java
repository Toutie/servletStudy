package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();

        String title = "读取所有表单数据";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        writer.println(docType +
                "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n"+
                "</tr>\n");

        //通过getParameterNames()来获得所有可用的表单参数。返回一个枚举
        //其中包含未指定顺序的参数名 可用标准方式循环枚举 使用hasMoreElements()方法确定何时停止 使用nextElement方法来
        //获取每个参数
        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()){
            String paramName = (String) parameterNames.nextElement();
            writer.print("<tr><td>"+paramName+"</td>\n");
            String[] parameterValues = req.getParameterValues(paramName);
            System.out.println("name : "+paramName);
            //读取单个值得数据
            if (parameterValues.length == 1){
                String paramValue = parameterValues[0];
                if (paramValue.length() == 0)
                    writer.println("<td><i>没有值</i></td>");
                else
                    writer.println("<td>" + paramValue + "</td>");
                System.out.println(paramValue);
            }else {
                //读取多个值得数据
                writer.println("<td><ul>");
                for (int i = 0 ; i < parameterValues.length; i++ ){
                    writer.println("<li>"+ parameterValues[i]);
                    System.out.println(parameterValues[i]);
                }
                writer.println("</ul></td>");
            }
            writer.print("</tr>");
        }
        writer.println("\n</table>\n</body></html>");
    }
}
