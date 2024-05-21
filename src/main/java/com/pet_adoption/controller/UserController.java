package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.entity.User;
import com.pet_adoption.service.UserService;
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

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView;


    /**
     * 注册用户
     * 请求路径：user/register.action
     * 请求方法：POST
     */
    @RequestMapping(value = "user/register.action", method = RequestMethod.POST)
    @RequestScope
    public ModelAndView register(@RequestParam String userName,
                                 @RequestParam String userPwd,
                                 @RequestParam String userPwdTwice, // 注册时需要确认密码
                                 HttpServletRequest request) {

        // 验证验证码是否正确
        if (!verifyCodeUtil.checkVerifyCode(request)) {
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "验证码错误");
            return modelAndView;
        }

        // 验证用户名、密码不为空
        if (userName.trim().isEmpty() || userPwd.trim().isEmpty() || userPwdTwice.trim().isEmpty()) {
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "注册失败，用户名或密码不能为空");
            return modelAndView;
        }

        // 检查两次输入的密码是否一致
        if (!userPwd.equals(userPwdTwice)) {
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "注册失败，两次输入的密码不一致");
            return modelAndView;
        }

        // 调用UserService的注册方法
        try {
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setUserPwd(userPwd); // 这里假设password已加密处理
            userService.insert(newUser);

            // 注册成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "注册成功，请登录");
            modelAndView.addObject("url", "/user/login.jsp");
            return modelAndView;

        } catch (Exception e) {
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "注册失败，可能原因：" + e.getMessage());
            return modelAndView;
        }
    }


    /**
     * 用户登录
     *
     * @param userName 用户姓名
     * @param userPwd  用户密码
     * @param request  请求
     * @param response 响应
     * @return 登录的用户信息
     */
    @RequestMapping(value = "user/login.action", method = RequestMethod.POST)
    @RequestScope//每次请求都会创建一个新的实例
    public ModelAndView login(@RequestParam String userName,
                              @RequestParam String userPwd,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        // 判断登录信息是否正确
        User user = userService.login(userName, userPwd);
        // 判断验证码是否正确
        if (!verifyCodeUtil.checkVerifyCode(request)) {
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "验证码错误");
        } else {
            if (userName.trim().isEmpty() || userPwd.trim().isEmpty()) {
                // 登录失败，用户名或密码为空
                modelAndView = new ModelAndView("fail");
                modelAndView.addObject("msg", "登录失败，用户名或密码为空");
            } else {
                if (user != null) {
                    // 登录成功
                    modelAndView = new ModelAndView("success");
                    modelAndView.addObject("msg", "登录成功");
                    modelAndView.addObject("url", "/user/index.jsp");

                    // 将登录信息保存到SESSION中
                    request.getSession().setAttribute("user", user);

                    // 将登录信息保存到COOKIE中
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null && cookies.length > 0) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("user")) {
                                cookie.setValue(userName);
                                break;
                            }
                        }
                        Cookie cookie = new Cookie("user", userName);
                        cookie.setMaxAge(3600); // 设置COOKIE的有效期为1小时
                        cookie.setPath("/user"); // 设置COOKIE的作用路径为根路径
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
     * 用户登出
     *
     * @param request  请求
     * @param response 响应
     * @return
     */

    @PostMapping("user/logout.action")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 删除SESSION中的登录信息
        request.getSession().removeAttribute("user");

        // 删除COOKIE中的登录信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        return "redirect:user/login.jsp";
    }

    /**
     * 查找用户信息
     *
     * @return 查询到的用户列表
     */

    @RequestMapping(value = "user/findAll.action", method = RequestMethod.GET)
    public ModelAndView findAll() {
        List<User> userList = userService.findAll();
        modelAndView = new ModelAndView("/admin/user/allUser");
        modelAndView.addObject("list", userList);
        return modelAndView;
    }

    /**
     * 根据用户ID查找用户信息
     *
     * @param id 用户id
     * @return 查询到的用户列表
     */
    @RequestMapping(value = "user/findById.action", method = RequestMethod.GET)
    public ModelAndView findById(@RequestParam Integer id) {
        User userList = userService.findByUserId(id);
        modelAndView = new ModelAndView("/admin/user/findById");
        modelAndView.addObject("list", userList);
        return modelAndView;
    }

    /**
     * 根据用户名查找用户信息
     *
     * @param name 用户用户名
     * @return 查询到的用户列表
     */
    @RequestMapping(value = "user/findByName.action", method = RequestMethod.GET)
    public ModelAndView findByName(@RequestParam String name) {
        List<User> userList = userService.findByUserName(name);
        modelAndView = new ModelAndView("/admin/user/findByName");
        modelAndView.addObject("list", userList);
        return modelAndView;
    }

    /**
     * 插入用户信息
     *
     * @param user 待插入的用户信息
     * @return 是否成功插入
     */

    @RequestMapping(value = "user/insert.action", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute User user) {
        if (userService.insert(user)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            // 插入成功后跳转到所有用户列表页
            modelAndView.addObject("url", "user/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * 修改用户信息
     *
     * @param user 待修改的用户信息
     * @return 是否成功修改
     */

    @RequestMapping(value = "user/update.action", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute User user) {
        // 执行更新操作
        if (userService.update(user)) {
            // 更新成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            // 更新成功后跳转到所有用户列表页
            modelAndView.addObject("url", "user/findAll.action");
        } else {
            // 更新失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
        }
        return modelAndView;
    }

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 是否成功删除
     */
    @RequestMapping(value = "user/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        // 执行删除操作
        if (userService.delete(id)) {
            // 删除成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "删除成功");
            //删除成功后跳转到所有管理员列表页
            modelAndView.addObject("url", "user/findAll.action");
            return modelAndView;
        } else {
            // 删除失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "删除失败");
            return modelAndView;
        }
    }

    /**
     * 获取所有用户信息（JSON格式）
     *
     * @return 所有用户信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "user/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        List<User> userList = userService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(8000, "", userList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "user/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        User userList = userService.findByUserId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(8001, "", userList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "user/findByName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByNameJSON(@RequestParam String name) throws JsonProcessingException {
        List<User> userList = userService.findByUserName(name);
        System.out.println(name);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(8002, "", userList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @PostMapping(value = "user/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(User user) throws JsonProcessingException {
        boolean isOk = userService.insert(user);
        System.out.println(isOk);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(8003, "创建成功！", null);
        } else {
            jsonResponse.makeFailResponse(8003, "创建失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    @CrossOrigin
    @PostMapping(value = "user/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody User user) throws JsonProcessingException {
        System.out.println(user);
        boolean isOk = userService.update(user);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(8004, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(8004, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @PostMapping(value = "user/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        boolean isOk = userService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(8005, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(8005, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @RequestMapping(value = "user/upload.action", produces = "application/json;charset=utf-8")
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
            jsonResponse.makeSuccessResponse(8006, "文件上传成功！", newName);    //发送成功，并把新的名字放到data中去。
        } catch (IOException e) {
            jsonResponse.makeFailResponse(8006, "文件上传失败！", null);
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "user/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    ////pageSize每页行数，pageNum请求页数
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);    //生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        JSONResponse jsonResponse = new JSONResponse();
        //设置Status=200，表示成功
        jsonResponse.makeSuccessResponse(8007, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

}