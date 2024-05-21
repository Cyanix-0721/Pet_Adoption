package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.Apply;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 控制类 ApplyController
 */
@Controller
public class ApplyController {
    /**
     * 依赖注入 ApplyService 服务
     */
    @Autowired
    private ApplyService applyService;
    /**
     * ModelAndView 对象
     */
    private ModelAndView modelAndView;

    /**
     * 获取全部 Apply 的请求处理方法
     *
     * @return 返回全部 Apply 的视图
     */
    @GetMapping("apply/findAll.action")
    public ModelAndView findAll() {
        List<Apply> applyList = applyService.findAll();
        modelAndView = new ModelAndView("/admin/apply/allApply");
        modelAndView.addObject("list", applyList);
        return modelAndView;
    }

    /**
     * 根据 ApplyId 获取 Apply 的请求处理方法
     *
     * @param id ApplyId 参数
     * @return 返回根据 ApplyId 获取的 Apply 的视图
     */
    @GetMapping("apply/findByApplyId.action")
    public ModelAndView findByApplyId(@RequestParam Integer id) {
        Apply applyList = applyService.findByApplyId(id);
        modelAndView = new ModelAndView("/admin/apply/findByApplyId");
        modelAndView.addObject("list", applyList);
        return modelAndView;
    }

    /**
     * 根据 ApplyName 获取 Apply 的请求处理方法
     *
     * @param name ApplyName 参数
     * @return 返回根据 ApplyName 获取的 Apply 的视图
     */
    @GetMapping("apply/findByApplyName.action")
    public ModelAndView findByApplyName(@RequestParam String name) {
        List<Apply> applyList = applyService.findByApplyName(name);
        modelAndView = new ModelAndView("/admin/apply/findByApplyName");
        modelAndView.addObject("list", applyList);
        return modelAndView;
    }

    /**
     * 根据 ApplyTime 获取 Apply 的请求处理方法
     *
     * @param time ApplyTime 参数
     * @return 返回根据 ApplyTime 获取的 Apply 的视图
     */
    @GetMapping("apply/findByApplyTime.action")
    public ModelAndView findByApplyTime(@RequestParam Date time) {
        List<Apply> applyList = applyService.findByApplyTime(time);
        modelAndView = new ModelAndView("/admin/apply/findByApply");
        modelAndView.addObject("list", applyList);
        return modelAndView;
    }

    /**
     * 根据 ApplyState 获取 Apply 的请求处理方法
     *
     * @param state ApplyState 参数
     * @return 返回根据 ApplyState 获取的 Apply 的视图
     */
    @GetMapping("apply/findByApplyState.action/{state}")
    public ModelAndView findByApplyState(@PathVariable Integer state) {
        List<Apply> applyList = applyService.findByApplyState(state);
        modelAndView = new ModelAndView("/admin/apply/findByApplyState");
        modelAndView.addObject("list", applyList);
        return modelAndView;
    }

    /**
     * 插入 Apply 的请求处理方法
     *
     * @param apply 需要插入的 Apply 对象
     * @return 返回插入结果的视图
     */
    @RequestMapping(value = "apply/insert.action", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute Apply apply) {
        apply.setApplyTime(new Date());
        if (applyService.insert(apply)) {
            ModelAndView modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            modelAndView.addObject("url", "apply/findAll.action");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * 更新 Apply 的请求处理方法
     *
     * @param apply 需要更新的 Apply 对象
     * @return 返回更新结果的视图
     */
    @RequestMapping(value = "apply/update.action", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Apply apply) {
        if (applyService.update(apply)) {
            ModelAndView modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            modelAndView.addObject("url", "apply/findAll.action");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
            return modelAndView;
        }
    }

    /**
     * 删除 Apply 的请求处理方法
     *
     * @param id ApplyId 参数
     * @return 返回删除结果的视图
     */
    @RequestMapping(value = "apply/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        if (applyService.delete(id)) {
            ModelAndView modelAndView = new ModelAndView("success");
            modelAndView.addObject("message", "删除成功");
            modelAndView.addObject("url", "apply/findAll.action");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("fail");
            modelAndView.addObject("message", "更新失败");
            return modelAndView;
        }
    }

    /**
     * 返回所有申请信息的JSON格式数据
     *
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "apply/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        //查找所有申请信息并返回JSON格式数据
        List<Apply> applyList = applyService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(3000, "", applyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据申请ID查找申请信息并返回JSON格式数据
     *
     * @param id 申请ID
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "apply/findByApplyId.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByApplyIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        //根据申请ID查找申请信息并返回JSON格式数据
        Apply applyList = applyService.findByApplyId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(3001, "", applyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据申请名称查找申请信息并返回JSON格式数据
     *
     * @param name 申请名称
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "apply/findByApplyName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByApplyNameJSON(@RequestParam String name) throws JsonProcessingException {
        //根据申请名称查找申请信息并返回JSON格式数据
        List<Apply> applyList = applyService.findByApplyName(name);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(3002, "", applyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据申请时间查找申请信息并返回JSON格式数据
     *
     * @param time 申请时间
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "apply/findByApplyTime.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByApplyTimeJSON(@RequestParam Date time) throws JsonProcessingException {
        //根据申请时间查找申请信息并返回JSON格式数据
        List<Apply> applyList = applyService.findByApplyTime(time);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(3003, "", applyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据申请状态查找申请信息并返回JSON格式数据
     *
     * @param state 申请状态
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "apply/findByApplyState.json.action/{state}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByApplyStateJSON(@PathVariable Integer state) throws JsonProcessingException {
        //根据申请状态查找申请信息并返回JSON格式数据
        List<Apply> applyList = applyService.findByApplyState(state);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(3004, "", applyList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 插入新的申请信息并返回JSON格式数据
     *
     * @param apply 申请信息
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "apply/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(Apply apply) throws JsonProcessingException {
        //插入新的申请信息并返回JSON格式数据
        apply.setApplyTime(new Date());
        boolean isOk = applyService.insert(apply);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(3005, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(3005, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    /**
     * 更新申请信息并返回JSON格式数据
     *
     * @param apply 更新的申请信息
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "apply/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody Apply apply) throws JsonProcessingException {
        //更新申请信息并返回JSON格式数据
        System.out.println(apply);
        boolean isOk = applyService.update(apply);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(3006, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(3006, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 删除申请信息并返回JSON格式数据
     *
     * @param id 申请ID
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @PostMapping(value = "apply/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        //删除申请信息并返回JSON格式数据
        boolean isOk = applyService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(3007, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(3007, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 按分页方式查找所有申请信息并返回JSON格式数据
     *
     * @param pageSize 每页行数
     * @param pageNum  请求页数
     * @return JSON格式的字符串
     * @throws JsonProcessingException JSON处理异常
     */
    @CrossOrigin
    @GetMapping(value = "apply/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        //按分页方式查找所有申请信息并返回JSON格式数据
        PageHelper.startPage(pageNum, pageSize);
        List<Apply> list = applyService.findAll();
        PageInfo<Apply> pageInfo = new PageInfo<>(list);    //生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(3008, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

}
