package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.Admin;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.service.AdminService;
import com.pet_adoption.util.verifyCodeUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/*@RequestParam注解：
        用于处理请求参数，将请求中的参数值注入到注解对应的字段中。
        适用于GET和POST请求中的参数传输。
@ModelAttribute注解：
        用于将一个对象模型绑定到请求数据上，以便在控制器方法中使用。
        适用于需要从请求数据中创建或更新一个对象的情况。
@PathVariable注解：
        用于处理URL中的路径变量，将URL中的变量值注入到注解对应的字段中。
        适用于需要根据URL路径来确定处理逻辑的情况。
            例如，URL为 "/users/{id}"，其中 {id} 是路径变量，
            可以使用 @PathVariable 注解来注入这个变量的值：
            @GetMapping("/users/{id}")
            public String getUser(@PathVariable("id") Long userId)
            { // 根据userId获取用户信息并返回 }
            这个方法会将 URL 中的 {id} 变量的值注入到 userId 字段中
@SessionAttribute注解：
        用于指定一个属性应该保存在session中，以便在多个请求之间共享数据。
        适用于需要在多个请求之间共享数据的情况。
@CookieValue注解：
        用于处理Cookie中的值，将Cookie的值注入到注解对应的字段中。
        适用于需要从Cookie中获取数据的情况*/

/**
 * 管理员控制器
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    private ModelAndView modelAndView;

    /**
     * 管理员登录
     *
     * @param adminName 管理员姓名
     * @param adminPwd  管理员密码
     * @param request   请求
     * @param response  响应
     * @return 登录的管理员信息
     */
    @RequestMapping(value = "admin/login.action", method = RequestMethod.POST)
    @RequestScope//每次请求都会创建一个新的实例
    public ModelAndView login(@RequestParam String adminName,
                              @RequestParam String adminPwd,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        // 判断登录信息是否正确
        Admin admin = adminService.login(adminName, adminPwd);
        // 判断验证码是否正确
        if (!verifyCodeUtil.checkVerifyCode(request)) {
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "验证码错误");
        } else {
            if (adminName.trim().isEmpty() || adminPwd.trim().isEmpty()) {
                // 登录失败，用户名或密码为空
                modelAndView = new ModelAndView("fail");
                modelAndView.addObject("msg", "登录失败，用户名或密码为空");
            } else {
                if (admin != null) {
                    // 登录成功
                    modelAndView = new ModelAndView("success");
                    modelAndView.addObject("msg", "登录成功");
                    modelAndView.addObject("url", "/admin/user/user.jsp");

                    // 将登录信息保存到SESSION中
                    request.getSession().setAttribute("admin", admin);

                    // 将登录信息保存到COOKIE中
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null && cookies.length > 0) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("admin")) {
                                cookie.setValue(adminName);
                                break;
                            }
                        }
                        Cookie cookie = new Cookie("admin", adminName);
                        cookie.setMaxAge(3600); // 设置COOKIE的有效期为1小时
                        cookie.setPath("/"); // 设置COOKIE的作用路径为根路径
                        cookie.setSecure(true); // 设置是否通过安全连接传输COOKIE
                        response.addCookie(cookie);
                    }
                } else {
                    // 登录失败，用户名或密码错误
                    modelAndView = new ModelAndView("fail");
                    modelAndView.addObject("msg", "登录失败，用户名或密码错误");
                }
            }
        }
        return modelAndView;
    }


    /**
     * 管理员登出
     *
     * @param request  请求
     * @param response 响应
     * @return
     */
    @RequestMapping(value = "admin/logout.action", method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 删除SESSION中的登录信息
        request.getSession().removeAttribute("admin");

        // 删除COOKIE中的登录信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("admin")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        //跳转登录，成功原因不明
        return "redirect:/admin/login.jsp";
    }

    /**
     * 查找管理员信息
     *
     * @return 查询到的管理员列表
     */
    @RequestMapping(value = "admin/findAll.action", method = RequestMethod.GET)
    public ModelAndView findAll() {
        List<Admin> adminList = adminService.findAll();
        modelAndView = new ModelAndView("/admin/admin/allAdmin");
        modelAndView.addObject("list", adminList);
        return modelAndView;
    }

    /**
     * 根据管理员ID查找管理员信息
     *
     * @param id 管理员ID
     * @return 查询到的管理员列表
     */
    @RequestMapping(value = "admin/findById.action", method = RequestMethod.GET)
    public ModelAndView findById(@RequestParam Integer id) {
        Admin adminList = adminService.findByAdminId(id);
        modelAndView = new ModelAndView("/admin/admin/findById");
        modelAndView.addObject("list", adminList);
        return modelAndView;
    }

    /**
     * 根据管理员姓名查找管理员信息
     *
     * @param name 管理员用户名
     * @return 查询到的管理员列表
     */
    @RequestMapping(value = "admin/findByName.action", method = RequestMethod.GET)
    public ModelAndView findByName(@RequestParam String name) {
        List<Admin> adminList = adminService.findByAdminName(name);
        modelAndView = new ModelAndView("/admin/admin/findByName");
        modelAndView.addObject("list", adminList);
        return modelAndView;
    }


    /**
     * 插入管理员信息
     *
     * @param admin 待插入的管理员信息
     * @return 是否成功插入
     */
    @RequestMapping(value = "admin/insert.action", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute Admin admin) {
        if (adminService.insert(admin)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            // 插入成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "admin/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * 修改管理员信息
     *
     * @param admin 待修改的管理员信息
     * @return 是否成功修改
     */
    @RequestMapping(value = "admin/update.action", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Admin admin) {
        // 执行更新操作
        if (adminService.update(admin)) {
            // 更新成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            // 更新成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "admin/findAll.action");
        } else {
            // 更新失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
        }
        return modelAndView;
    }

    /**
     * 删除管理员信息
     *
     * @param id 管理员ID
     * @return 是否成功删除
     */
    @RequestMapping(value = "admin/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        // 执行删除操作
        if (adminService.delete(id)) {
            // 删除成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "删除成功");
            //删除成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "admin/findAll.action");
            return modelAndView;
        } else {
            // 删除失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "删除失败");
            return modelAndView;
        }
    }

    /**
     * 获取所有管理员信息（JSON格式）
     *
     * @return 所有管理员信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "admin/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        List<Admin> adminList = adminService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(1000, "", adminList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据管理员ID获取管理员信息（JSON格式）
     *
     * @param id 管理员ID
     * @return 管理员信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "admin/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        Admin adminList = adminService.findByAdminId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(1001, "", adminList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据管理员姓名获取管理员信息（JSON格式）
     *
     * @param name 管理员用户名
     * @return 管理员信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "admin/findByName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByNameJSON(@RequestParam String name) throws JsonProcessingException {
        List<Admin> adminList = adminService.findByAdminName(name);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(1002, "", adminList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 插入管理员信息（JSON格式）
     *
     * @param admin 待插入的管理员信息
     * @return 插入结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "admin/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(Admin admin) throws JsonProcessingException {
        boolean isOk = adminService.insert(admin);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(1003, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(1003, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    /**
     * 更新管理员信息（JSON格式）
     *
     * @param admin 待更新的管理员信息
     * @return 更新结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "admin/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody Admin admin) throws JsonProcessingException {
        System.out.println(admin);
        boolean isOk = adminService.update(admin);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(1004, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(1004, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 删除管理员信息（JSON格式）
     *
     * @param id 待删除的管理员ID
     * @return 删除结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "admin/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        boolean isOk = adminService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(1005, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(1005, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 上传管理员图片（JSON格式）
     *
     * @param multipartFile 上传的文件
     * @param request       请求对象
     * @return 上传结果的JSON字符串
     */
    @CrossOrigin
    @RequestMapping(value = "admin/upload.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile, ServletRequest request) throws JsonProcessingException {    //MultipartFile就是上传的文件,ServletRequest是客户端请求
        String oFileName = multipartFile.getOriginalFilename();       //获得上传文件全名
        String extension = FilenameUtils.getExtension(oFileName);   //获得文件后缀名，如jpg
        int i = new Random().nextInt(1000000);
        String newName = String.format("%06d", i);                            //生成随机的6位整数，不足前补0
        newName = System.currentTimeMillis() + newName + "." + extension;        //拼接文件的新名字
        System.out.println(newName);
        //realPath方法用于获取指定资源的绝对路径。它会返回Web内容的根目录的路径。而file对象用于检查upload文件夹是否存在，如果不存在则创建之
        //HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();		//该语句也可以获得根路径地址
        String realPath = request.getRealPath("upload");        //获取upload文件夹的真实地址
        File file = new File(realPath);
        if (!file.exists()) file.mkdir();                            //如果不存在upload文件夹就创建该文件夹
        System.out.println(realPath);
        String finalPath = realPath + File.separator + newName;        //文件新路径
        System.out.println(finalPath);
        JSONResponse jsonResponse = new JSONResponse();
        try {
            multipartFile.transferTo(new File(finalPath));        //把上传的文件，拷贝到文件新路径
            jsonResponse.makeSuccessResponse(1006, "文件上传成功！", newName);    //发送成功，并把新的名字放到data中去。
        } catch (IOException e) {
            jsonResponse.makeFailResponse(1006, "文件上传失败！", null);
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 分页查询所有管理员信息（JSON格式）
     *
     * @param pageSize 每页行数
     * @param pageNum  请求页数
     * @return 分页查询结果的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "admin/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    ////pageSize每页行数，pageNum请求页数
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminService.findAll();
        //生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(1007, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }
}
