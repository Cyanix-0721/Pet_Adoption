package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.entity.Reply;
import com.pet_adoption.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 回复控制器
 */
@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    private ModelAndView modelAndView;

    /**
     * 查看所有回复
     *
     * @return ModelAndView
     */
    @GetMapping("reply/findAll.action")
    public ModelAndView findAll() {
        List<Reply> replyList = replyService.findAll();
        modelAndView = new ModelAndView("/reply/reply/allReply");
        modelAndView.addObject("list", replyList);
        return modelAndView;
    }

    /**
     * 根据回复ID查看回复
     *
     * @param id 回复ID
     * @return ModelAndView
     */
    @GetMapping("reply/findById.action")
    public ModelAndView findById(@RequestParam Integer id) {
        Reply replyList = replyService.findByReplyId(id);
        modelAndView = new ModelAndView("/reply/reply/findById");
        modelAndView.addObject("list", replyList);
        return modelAndView;
    }

    /**
     * 根据回复用户名查看回复
     *
     * @param name 回复用户名
     * @return ModelAndView
     */
    @GetMapping("reply/findByName.action")
    public ModelAndView findByName(@RequestParam String name) {
        List<Reply> replyList = replyService.findByReplyUserName(name);
        modelAndView = new ModelAndView("/reply/reply/findByName");
        modelAndView.addObject("list", replyList);
        return modelAndView;
    }

    /**
     * 插入回复
     *
     * @param reply 回复对象
     * @return ModelAndView
     */
    @RequestMapping("reply/insert.action")
    public ModelAndView insert(@ModelAttribute Reply reply) {
        reply.setReplyTime(new Date());
        if (replyService.insert(reply)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            modelAndView.addObject("url", "reply/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * 更新回复
     *
     * @param reply 回复对象
     * @return ModelAndView
     */
    @RequestMapping("reply/update.action")
    public ModelAndView update(@ModelAttribute Reply reply) {
        if (replyService.update(reply)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            modelAndView.addObject("url", "reply/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
            return modelAndView;
        }
    }

    /**
     * 删除回复
     *
     * @param id 回复ID
     * @return ModelAndView
     */
    @RequestMapping(value = "reply/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        if (replyService.delete(id)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "删除成功");
            modelAndView.addObject("url", "reply/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "删除失败");
            return modelAndView;
        }
    }


    /**
     * GET请求，获取所有回复的JSON格式数据
     *
     * @return 响应体中包含所有回复的JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "reply/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        // 获取所有回复列表
        List<Reply> replyList = replyService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(7000, "", replyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * GET请求，根据回复ID获取回复的JSON格式数据
     *
     * @param id 回复ID
     * @return 响应体中包含回复的JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "reply/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        // 根据回复ID获取回复列表
        Reply replyList = replyService.findByReplyId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(7001, "", replyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * GET请求，根据回复用户名获取回复的JSON格式数据
     *
     * @param name 回复用户名
     * @return 响应体中包含回复的JSON字符串
     * @throws JsonProcessingException JSON处理异常
     */

    @CrossOrigin
    @GetMapping(value = "reply/findByName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByNameJSON(@RequestParam String name) throws JsonProcessingException {
        // 根据回复用户名获取回复列表
        List<Reply> replyList = replyService.findByReplyUserName(name);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(7002, "", replyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * POST请求，插入回复
     *
     * @param reply 待插入的回复对象
     * @return 响应体中包含是否插入成功的信息
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "reply/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(Reply reply) throws JsonProcessingException {
        // 插入回复
        reply.setReplyTime(new Date());
        boolean isOk = replyService.insert(reply);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(7003, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(7003, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    /**
     * POST请求，更新回复
     *
     * @param reply 待更新的回复对象
     * @return 响应体中包含是否更新成功的信息
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "reply/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody Reply reply) throws JsonProcessingException {
        // 更新回复
        System.out.println(reply);
        boolean isOk = replyService.update(reply);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(7004, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(7004, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * POST请求，删除回复
     *
     * @param id 回复ID
     * @return 响应体中包含是否删除成功的信息
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "reply/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        // 删除回复
        boolean isOk = replyService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(7005, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(7005, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 获取所有回复的分页数据
     *
     * @param pageSize 每页行数，默认为5
     * @param pageNum  请求页数，默认为1
     * @return 分页数据的JSON响应
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "reply/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    //pageSize每页行数，pageNum请求页数
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<Reply> list = replyService.findAll();
        //生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        PageInfo<Reply> pageInfo = new PageInfo<>(list);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(7006, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

}