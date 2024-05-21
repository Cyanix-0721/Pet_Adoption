package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.Blog;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 博客控制器
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    private ModelAndView modelAndView;


    /**
     * 查找所有博客
     *
     * @return 响应页面
     */
    @RequestMapping(value = "blog/findAll.action", method = RequestMethod.GET)
    public ModelAndView findAll() {
        List<Blog> blogList = blogService.findAll();
        modelAndView = new ModelAndView("/admin/blog/allAdmin");
        modelAndView.addObject("list", blogList);
        return modelAndView;
    }

    /**
     * 根据博客ID查找博客
     *
     * @param id 博客ID
     * @return 响应页面
     */
    @RequestMapping(value = "blog/findById.action", method = RequestMethod.GET)
    public ModelAndView findById(@RequestParam Integer id) {
        Blog blogList = blogService.findByBlogId(id);
        modelAndView = new ModelAndView("/admin/blog/findById");
        modelAndView.addObject("list", blogList);
        return modelAndView;
    }

    /**
     * 根据博客名称查找博客
     *
     * @param event 博客名称
     * @return 响应页面
     */
    @RequestMapping(value = "blog/findByName.action", method = RequestMethod.GET)
    public ModelAndView findByName(@RequestParam String event) {
        List<Blog> blogList = blogService.findByBlogName(event);
        modelAndView = new ModelAndView("/admin/blog/findByName");
        modelAndView.addObject("list", blogList);
        return modelAndView;
    }

    /**
     * 根据博客日期查找博客
     *
     * @param date 博客日期
     * @return 响应页面
     */
    @RequestMapping(value = "blog/findByDate.action", method = RequestMethod.GET)
    public ModelAndView findByDate(@RequestParam Date date) {
        List<Blog> blogList = blogService.findByBlogDate(date);
        modelAndView = new ModelAndView("/admin/blog/findByName");
        modelAndView.addObject("list", blogList);
        return modelAndView;
    }

    /**
     * 插入博客
     *
     * @param blog 博客信息
     * @return 响应页面
     */
    @RequestMapping(value = "blog/insert.action", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute Blog blog) {
        blog.setActionTime(new Date());
        if (blogService.insert(blog)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            // 插入成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "blog/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * 更新博客
     *
     * @param blog 博客信息
     * @return 响应页面
     */
    @RequestMapping(value = "blog/update.action", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Blog blog) {
        // 执行更新操作
        if (blogService.update(blog)) {
            // 更新成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            // 更新成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "blog/findAll.action");
        } else {
            // 更新失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
            return modelAndView;
        }
        return modelAndView;
    }

    /**
     * 删除博客信息
     *
     * @param id 管理员ID
     * @return 是否成功删除
     */
    @RequestMapping(value = "blog/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        // 执行删除操作
        if (blogService.delete(id)) {
            // 删除成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "删除成功");
            //删除成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "blog/findAll.action");
            return modelAndView;
        } else {
            // 删除失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "删除失败");
            return modelAndView;
        }
    }


    /**
     * 获取所有博客的JSON数据
     *
     * @return JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "blog/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        List<Blog> blogList = blogService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(4000, "", blogList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据ID获取博客的JSON数据
     *
     * @param id 博客ID
     * @return JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "blog/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        Blog blogList = blogService.findByBlogId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(4001, "", blogList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据名称获取博客的JSON数据
     *
     * @param event 博客名称
     * @return JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "blog/findByName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByNameJSON(@RequestParam String event) throws JsonProcessingException {
        List<Blog> blogList = blogService.findByBlogName(event);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(4002, "", blogList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据日期获取博客的JSON数据
     *
     * @param date 日期
     * @return JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "blog/findByDate.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByDateJSON(@RequestParam Date date) throws JsonProcessingException {
        List<Blog> blogList = blogService.findByBlogDate(date);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(4003, "", blogList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 插入博客的JSON数据
     *
     * @param blog 博客对象
     * @return JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "blog/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(Blog blog) throws JsonProcessingException {
        blog.setActionTime(new Date());
        boolean isOk = blogService.insert(blog);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(4004, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(4004, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    /**
     * 更新博客的JSON数据
     *
     * @param blog 博客对象
     * @return JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "blog/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody Blog blog) throws JsonProcessingException {
        System.out.println(blog);
        boolean isOk = blogService.update(blog);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(4005, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(4005, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }


    /**
     * 删除博客
     * HTTP POST 请求
     * 路径：blog/delete.json.action
     * 编码格式：application/json;charset=utf-8
     * 返回值：String
     *
     * @param id 博客ID
     * @return 删除结果的JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "blog/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        boolean isOk = blogService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(4006, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(4006, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 获取所有博客列表
     * HTTP GET 请求
     * 路径：blog/allPage.action
     * 编码格式：application/json;charset=utf-8
     * 返回值：String
     *
     * @param pageSize 每页博客数量
     * @param pageNum  当前页码
     * @return 查询结果的JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "blog/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> list = blogService.findAll();
        //生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(4007, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }


}