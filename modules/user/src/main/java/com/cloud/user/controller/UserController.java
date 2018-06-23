package com.cloud.user.controller;

import com.cloud.common.core.controller.BaseController;
import com.cloud.common.result.Result;
import com.cloud.common.result.ResultResponse;
import com.cloud.user.service.IUserService;
import com.cloud.user.vo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author JiaShun
 * @date 2018/3/26 16:45
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<User> {
    @Autowired
    private IUserService userService;
    @RequestMapping("/list")
    @ResponseBody
    public Result list(@RequestBody Map<String,Object> map){
        ResultResponse result = new ResultResponse();
        int page = Integer.parseInt(map.get("page").toString());
        int size = Integer.parseInt(map.get("size").toString());
        PageHelper.startPage(page,size);
        List<User> list = userService.list(map);
        PageInfo info = new PageInfo(list);
        return result.SuccessResult(info);
    }

    @RequestMapping("/getById")
    @ResponseBody
    public Result getById(@RequestParam Integer id){
        ResultResponse result = new ResultResponse();
        User user = userService.findById(id);
        return result.SuccessResult(user);
//        throw  new BaseException("Test Exception");
//        try{
           //throw new UserTokenException("user token exception");
//        }catch (Exception e){
//            e.printStackTrace();
//            return result.FailResult(e.getMessage());
//        }
    }
}
