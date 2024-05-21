package com.pet_adoption.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet_adoption.entity.JSONResponse;
import com.pet_adoption.entity.Pet;
import com.pet_adoption.service.PetService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * 宠物控制器
 */
@Controller
public class PetController {
    @Autowired
    private PetService petService;
    private ModelAndView modelAndView;

    /**
     * 查找宠物信息
     *
     * @return 查询到的宠物列表
     */
    @RequestMapping(value = "pet/findAll.action", method = RequestMethod.GET)
    public ModelAndView findAll() {
        List<Pet> petList = petService.findAll();
        modelAndView = new ModelAndView("/admin/pet/allPet");
        modelAndView.addObject("list", petList);
        return modelAndView;
    }

    /**
     * 查找宠物信息 by ID
     *
     * @param id 宠物ID
     * @return 查询到的宠物列表
     */
    @RequestMapping(value = "pet/findById.action", method = RequestMethod.GET)
    public ModelAndView findById(@RequestParam Integer id) {
        Pet petList = petService.findByPetId(id);
        modelAndView = new ModelAndView("/admin/pet/findById");
        modelAndView.addObject("list", petList);
        return modelAndView;
    }

    /**
     * 查找宠物信息 by Name
     *
     * @param name 宠物名称
     * @return 查询到的宠物列表
     */
    @RequestMapping(value = "pet/findByName.action", method = RequestMethod.GET)
    public ModelAndView findByName(@RequestParam String name) {
        List<Pet> petList = petService.findByPetName(name);
        modelAndView = new ModelAndView("/admin/pet/findByName");
        modelAndView.addObject("list", petList);
        return modelAndView;
    }

    /**
     * 查找宠物信息 by Type
     *
     * @param type 宠物类型
     * @return 查询到的宠物列表
     */
    @RequestMapping(value = "pet/findByType.action", method = RequestMethod.GET)
    public ModelAndView findByType(@RequestParam String type) {
        List<Pet> petList = petService.findByPetType(type);
        modelAndView = new ModelAndView("/admin/pet/findByType");
        modelAndView.addObject("list", petList);
        return modelAndView;
    }

    /**
     * 插入宠物信息
     *
     * @param pet 待插入的宠物信息
     * @return 是否成功插入
     */
    @RequestMapping(value = "pet/insert.action", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute Pet pet) {
        if (petService.insert(pet)) {
            // 插入成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "插入成功");
            // 插入成功后跳转到所有宠物列表页
            modelAndView.addObject("url", "pet/findAll.action");
        } else {
            // 插入失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "插入失败");
        }
        return modelAndView;
    }

    /**
     * 修改宠物信息
     *
     * @param pet 待修改的宠物信息
     * @return 是否成功修改
     */
    @RequestMapping(value = "pet/update.action", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Pet pet) {
        // 执行更新操作
        if (petService.update(pet)) {
            // 更新成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "更新成功");
            // 更新成功后跳转到所有宠物列表页
            modelAndView.addObject("url", "pet/findAll.action");
            return modelAndView;
        } else {
            // 更新失败
            modelAndView = new ModelAndView("fail");
            modelAndView.addObject("msg", "更新失败");
            return modelAndView;
        }
    }

    /**
     * 删除宠物信息
     *
     * @param id 宠物ID
     * @return 是否成功删除
     */
    @RequestMapping(value = "pet/delete.action", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Integer id) {
        // 执行删除操作
        if (petService.delete(id)) {
            // 删除成功
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("msg", "删除成功");
            modelAndView.addObject("url", "pet/findAll.action");
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
    @GetMapping(value = "pet/findAll.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllJSON() throws JsonProcessingException {
        List<Pet> petList = petService.findAll();
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(6000, "", petList);
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
    @GetMapping(value = "pet/findById.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIdJSON(@RequestParam Integer id) throws JsonProcessingException {
        Pet petList = petService.findByPetId(id);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(6001, "", petList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据管理员名称获取管理员信息（JSON格式）
     *
     * @param name 管理员名称
     * @return 管理员信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "pet/findByName.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByNameJSON(@RequestParam String name) throws JsonProcessingException {
        List<Pet> petList = petService.findByPetName(name);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(6002, "", petList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 根据管理员类型获取管理员信息（JSON格式）
     *
     * @param type 管理员类型
     * @return 管理员信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "pet/findByType.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByTypeJSON(@RequestParam String type) throws JsonProcessingException {
        List<Pet> petList = petService.findByPetName(type);
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(6003, "", petList);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 插入管理员信息（JSON格式）
     *
     * @param pet 待插入的管理员信息
     * @return 插入结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "pet/insert.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertJSON(Pet pet) throws JsonProcessingException {
        boolean isOk = petService.insert(pet);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(6004, "插入成功！", null);
        } else {
            jsonResponse.makeFailResponse(6004, "插入失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(writeValueAsString);
        return writeValueAsString;
    }

    /**
     * 更新管理员信息（JSON格式）
     *
     * @param pet 待更新的管理员信息
     * @return 更新结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "pet/update.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateJSON(@RequestBody Pet pet) throws JsonProcessingException {
        System.out.println(pet);
        boolean isOk = petService.update(pet);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(6005, "修改成功！", null);
        } else {
            jsonResponse.makeFailResponse(6005, "修改失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 删除管理员信息（JSON格式）
     *
     * @param id 管理员ID
     * @return 删除结果的JSON字符串
     */
    @CrossOrigin
    @PostMapping(value = "pet/delete.json.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteJSON(@RequestParam Integer id) throws JsonProcessingException {
        boolean isOk = petService.delete(id);
        JSONResponse jsonResponse = new JSONResponse();
        if (isOk) {
            jsonResponse.makeSuccessResponse(6006, "删除成功！", null);
        } else {
            jsonResponse.makeFailResponse(6006, "删除失败！", null);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 上传管理员头像（JSON格式）
     *
     * @param multipartFile 多部分文件
     * @param request       请求对象
     * @return 上传结果的JSON字符串
     */
    @CrossOrigin
    @RequestMapping(value = "pet/upload.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile, ServletRequest request) throws JsonProcessingException {
        String oFileName = multipartFile.getOriginalFilename();       //获得上传文件全名
        String extension = FilenameUtils.getExtension(oFileName);   //获得文件后缀名，如jpg
        int i = new Random().nextInt(1000000);
        String newName = String.format("%06d", i);                            //生成随机的6位整数，不足前补0
        newName = System.currentTimeMillis() + newName + "." + extension;        //拼接文件的新名字
        System.out.println(newName);
        //realPath方法用于获取指定资源的绝对路径。它会返回Web内容的根目录的路径。而file对象用于检查upload文件夹是否存在，如果不存在则创建之
        String realPath = request.getRealPath("upload");        //获取upload文件夹的真实地址
        File file = new File(realPath);
        if (!file.exists()) file.mkdir();                            //如果不存在upload文件夹就创建该文件夹
        System.out.println(realPath);
        String finalPath = realPath + File.separator + newName;        //文件新路径
        System.out.println(finalPath);
        JSONResponse jsonResponse = new JSONResponse();
        try {
            multipartFile.transferTo(new File(finalPath));        //把上传的文件，拷贝到文件新路径
            jsonResponse.makeSuccessResponse(6007, "文件上传成功！", newName);    //发送成功，并把新的名字放到data中去。
        } catch (IOException e) {
            jsonResponse.makeFailResponse(6007, "文件上传失败！", null);
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

    /**
     * 分页获取管理员信息（JSON格式）
     *
     * @param pageSize 每页行数
     * @param pageNum  请求页数
     * @return 分页后的管理员信息的JSON字符串
     */
    @CrossOrigin
    @GetMapping(value = "pet/allPage.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findAllByPage(@RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(name = "pageNum", defaultValue = "1") int pageNum)
            throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<Pet> list = petService.findAll();
        PageInfo<Pet> pageInfo = new PageInfo<>(list);    //生成PageInfo类，该类除了数据外还有其他资料，比如总共几页，当前页，下一页，上一页等属性。可以帮助客户端进行编程。
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.makeSuccessResponse(6008, "", pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonResponse);
    }

}
