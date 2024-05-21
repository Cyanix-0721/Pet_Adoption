package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.Comments;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 控制类CommentsController
 */
@Controller
public class CommentsController {
    /**
     * 评论服务对象
     */
    @Autowired
    private CommentsService commentsService;
    /**
     * 视图模型对象
     */
    private ModelAndView modelAndView;

    /**
     * 获取所有评论
     *
     * @return 视图模型对象
     */
    @GetMapping("comments/findAll.action")
    public ModelAndView findAll() {
        List<Comments> commentsList = commentsService.findAll();
        modelAndView = new ModelAndView("/comments/commnets/allComments");
        modelAndView.addObject("list", commentsList);
        return modelAndView;
    }

    /**
     * 根据评论ID获取评论
     *
     * @param id 评论ID
     * @return 视图模型对象
     */
    @GetMapping("comments/findById.action")
    public ModelAndView findById(@RequestParam Integer id) {
        Comments commentsList = commentsService.findByCommentsId(id);
        modelAndView = new ModelAndView("/comments/commnets/findById");
        modelAndView.addObject("list", commentsList);
        return modelAndView;
    }

    /**
     * 根据用户名获取评论
     *
     * @param name 用户名
     * @return 视图模型对象
     */
    @GetMapping("comments/findByName.action")
    public ModelAndView findByName(@RequestParam String name) {
        List<Comments> commentsList = commentsService.findByCommentsUserName(name);
        modelAndView = new ModelAndView("/comments/commnets/findByName");
        modelAndView.addObject("list", commentsList);
        return modelAndView;
    }

    /**
     * 增加评论
     *
     * @param comments 评论内容
     * @return 视图模型对象
     */
    @RequestMapping("comments/insert.action")
    public ModelAndView insert(@ModelAttribute Comments comments) {
        comments.setCommentTime(new Date());
        if (commentsService.insert(comments)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            modelAndView.addObject("url", "comments/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * 更新评论
     *
     * @param comments 评论内容
     * @return 视图模型对象
     */
    @RequestMapping("comments/update.action")
    public ModelAndView update(@ModelAttribute Comments comments) {
        if (commentsService.update(comments)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            // 更新成功后跳转到所有评论列表页
            modelAndView.addObject("url", "comments/findAll.action");
            return modelAndView;
        } else {
            // 更新失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
            return modelAndView;
        }
    }

    /**
     * 删除评论
     *
     * @param id 评论ID
     * @return 视图模型对象
     */
    @RequestMapping(value = "comments/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        if (commentsService.delete(id)) {
            // 删除成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            // 删除成功后跳转到所有评论列表页
            modelAndView.addObject("url", "comments/findAll.action");
            return modelAndView;
        } else {
            // 删除失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }


    @CrossOrigin
    @GetMapping(value = "comments/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        // 查询所有评论信息
        List<Comments> commentsList = commentsService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(5000, "", commentsList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据管理员ID获取评论信息（JSON格式）
     *
     * @param id 管理员ID
     * @return 评论信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "comments/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        // 根据管理员ID查询评论信息
        Comments commentsList = commentsService.findByCommentsId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(5001, "", commentsList);
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
    @GetMapping(value = "comments/findByName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByNameJSON(@RequestParam String name) throws JsonProcessingException {
        // 根据管理员姓名查询评论信息
        List<Comments> commentsList = commentsService.findByCommentsUserName(name);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(5002, "", commentsList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 插入管理员信息（JSON格式）
     *
     * @param comments 待插入的管理员信息
     * @return 插入结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "comments/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(Comments comments) throws JsonProcessingException {
        // 插入管理员信息
        comments.setCommentTime(new Date());
        boolean isOk = commentsService.insert(comments);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(5003, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(5003, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    /**
     * 更新管理员信息（JSON格式）
     *
     * @param comments 待更新的管理员信息
     * @return 更新结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "comments/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody Comments comments) throws JsonProcessingException {
        // 更新管理员信息
        System.out.println(comments);
        boolean isOk = commentsService.update(comments);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(5004, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(5004, "修改失败！", null);
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
    @PostMapping(value = "comments/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        // 删除管理员信息
        boolean isOk = commentsService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(5005, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(5005, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 分页查询信息（JSON格式）
     *
     * @param pageSize 每页行数
     * @param pageNum  请求页数
     * @return 分页查询结果的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "comments/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        // 分页查询评论信息
        PageHelper.startPage(pageNum, pageSize);
        List<Comments> list = commentsService.findAll();
        // 生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        PageInfo<Comments> pageInfo = new PageInfo<>(list);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(5006, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

}
