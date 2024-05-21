package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.Adoption;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * AdoptionController 类是一个控制器类，用于处理与收养相关的请求
 */
@Controller
public class AdoptionController {
    @Autowired
    private AdoptionService adoptionService;
    private ModelAndView modelAndView;


    /**
     * findAll 方法用于获取所有收养信息，并返回给用户
     *
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/findAll.action", method = RequestMethod.GET)
    public ModelAndView findAll() {
        List<Adoption> adoptionList = adoptionService.findAll();
        modelAndView = new ModelAndView("/admin/adoption/allAdoption");
        modelAndView.addObject("list", adoptionList);
        return modelAndView;
    }

    /**
     * findById 方法根据管理员ID查找管理员信息，并返回给用户
     *
     * @param id 管理员ID
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/findById.action", method = RequestMethod.GET)
    public ModelAndView findById(@RequestParam Integer id) {
        Adoption adoptionList = adoptionService.findByAdoptionId(id);
        modelAndView = new ModelAndView("/admin/adoption/findById");
        modelAndView.addObject("list", adoptionList);
        return modelAndView;
    }

    /**
     * findByUserId 方法根据用户ID查找收养信息，并返回给用户
     *
     * @param userId 用户ID
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/findByUserId.action", method = RequestMethod.GET)
    public ModelAndView findByUserId(@RequestParam Integer userId) {
        List<Adoption> adoptionList = adoptionService.findByAdoptionUserId(userId);
        modelAndView = new ModelAndView("/admin/adoption/findByUserId");
        modelAndView.addObject("list", adoptionList);
        return modelAndView;
    }

    /**
     * findByPetId 方法根据宠物ID查找收养信息，并返回给用户
     *
     * @param petId 宠物ID
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/findByPetId.action", method = RequestMethod.GET)
    public ModelAndView findByPetId(@RequestParam Integer petId) {
        List<Adoption> adoptionList = adoptionService.findByAdoptionPetId(petId);
        modelAndView = new ModelAndView("/admin/adoption/findByPetId");
        modelAndView.addObject("list", adoptionList);
        return modelAndView;
    }

    /**
     * insert 方法用于插入收养信息，并返回操作结果给用户
     *
     * @param adoption Adoption 对象，包含收养信息
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/insert.action", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute Adoption adoption) {
        adoption.setAdoptTime(new Date());
        if (adoptionService.insert(adoption)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            modelAndView.addObject("url", "adoption/findAll.action");
            return modelAndView;
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
            return modelAndView;
        }
    }

    /**
     * update 方法用于更新收养信息，并返回操作结果给用户
     *
     * @param adoption Adoption 对象，包含收养信息
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/update.action", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Adoption adoption) {
        // 执行更新操作
        if (adoptionService.update(adoption)) {
            // 更新成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            // 更新成功后跳转到所有收养信息页
            modelAndView.addObject("url", "adoption/findAll.action");
        } else {
            // 更新失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
        }
        return modelAndView;
    }

    /**
     * delete 方法用于删除收养信息，并返回操作结果给用户
     *
     * @param id 收养信息ID
     * @return ModelAndView 对象，包含视图和模型数据
     */
    @RequestMapping(value = "adoption/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        // 执行删除操作
        if (adoptionService.delete(id)) {
            // 删除成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "删除成功");
            modelAndView.addObject("url", "adoption/findAll.action");
            return modelAndView;
        } else {
            // 删除失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "删除失败");
            return modelAndView;
        }
    }


    @CrossOrigin
    @GetMapping(value = "adoption/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 获取所有 Adoption 数据
    public String findAllJSON() throws JsonProcessingException {
        List<Adoption> adoptionList = adoptionService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(2000, "", adoptionList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "adoption/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 根据 Adoption ID 获取 Adoption 数据
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        Adoption adoptionList = adoptionService.findByAdoptionId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(2001, "", adoptionList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "adoption/findByUserId.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 根据 User ID 获取 Adoption 数据
    public String findByUserIdJSON(@RequestParam Integer userId) throws JsonProcessingException {
        List<Adoption> adoptionList = adoptionService.findByAdoptionUserId(userId);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(2002, "", adoptionList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "adoption/findByPetId.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 根据 Pet ID 获取 Adoption 数据
    public String findByPetIdJSON(@RequestParam Integer petId) throws JsonProcessingException {
        List<Adoption> adoptionList = adoptionService.findByAdoptionPetId(petId);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(2003, "", adoptionList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @PostMapping(value = "adoption/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 插入 Adoption 数据
    public String insertJSON(Adoption adoption) throws JsonProcessingException {
        adoption.setAdoptTime(new Date());
        boolean isOk = adoptionService.insert(adoption);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(2004, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(2004, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    @CrossOrigin
    @PostMapping(value = "adoption/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 更新 Adoption 数据
    public String updateJSON(@RequestBody Adoption adoption) throws JsonProcessingException {
        System.out.println(adoption);
        boolean isOk = adoptionService.update(adoption);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(2005, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(2005, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @PostMapping(value = "adoption/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 删除 Adoption 数据
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        boolean isOk = adoptionService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(2006, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(2006, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    @CrossOrigin
    @GetMapping(value = "adoption/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    // 获取所有 Adoption 数据（分页）
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<Adoption> list = adoptionService.findAll();
        // 生成 PageInfo 类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        PageInfo<Adoption> pageInfo = new PageInfo<>(list);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(2007, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }
}
