package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import pojo.PageBean;
import service.BrandService;
import service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private final BrandService brandService = new BrandServiceImpl();

    /**
     * 查询所有
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service查询
        List<Brand> brands = brandService.selectAll();
        //转为JSON
        String jsonString = JSON.toJSONString(brands);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    /**
     * 添加数据
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收品牌数据,读取请求的消息体数据
        BufferedReader br = req.getReader();
        String params = br.readLine();//JSON字符串
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用service添加
        brandService.add(brand);
        //响应成功标识
        resp.getWriter().write("success");
    }

    /**
     * 删除单个
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");

        //2. 调用service删除
        brandService.delete(Integer.parseInt(id));

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 修改单个
     */
    public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        System.out.println(params);
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2. 调用service添加
        brandService.updateById(brand);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     */
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据，[1,2,3,...]
        BufferedReader br = req.getReader();
        String params = br.readLine();//JSON字符串
        //转为int[]数组
        int[] ids = JSON.parseObject(params, int[].class);
        //调用service添加
        if(ids.length != 0){
            brandService.deleteByIds(ids);
        }
        //响应成功标识
        resp.getWriter().write("success");
    }

    /**
     * 分页查询
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收 当前页码 和 每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage,pageSize);

        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     */
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收 当前页码 和 每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();//JSON字符串

        //转为Brand
        Brand brand = JSON.parseObject(params, Brand.class);

        //调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
