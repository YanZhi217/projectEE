package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//处理乱码
        request.setCharacterEncoding("UTF-8");
        //接收表单接收的数据，封装为Brand对象
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        //调用service完成添加
        brandService.Add(brand);
        //转发到查询所有Servlet
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);*/

        //获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将JSON字符串转换为Java对象
        Brand brand = JSON.parseObject(params,Brand.class);

        //调用service 添加
        brandService.Add(brand);

        //响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
