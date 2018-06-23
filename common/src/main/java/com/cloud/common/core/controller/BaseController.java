package com.cloud.common.core.controller;

import com.cloud.common.core.service.BaseService;
import com.cloud.common.result.ObjectRestResponse;
import com.cloud.common.result.Result;
import com.cloud.common.result.ResultResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author JiaShun
 * @date 2018/3/25 11:30
 */
public class BaseController<T> {
    @Resource
    private BaseService baseService;

    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody T t) {
        baseService.save(t);
        return ResultResponse.SuccessResult();
    }

    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam Integer id) {
        baseService.deleteById(id);
        return ResultResponse.SuccessResult();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody T t) {
        baseService.update(t);
        return ResultResponse.SuccessResult();
    }

    @PostMapping("/detail")
    @ResponseBody
    public ObjectRestResponse<T> detail(@RequestParam Integer id) {
        ObjectRestResponse result = new ObjectRestResponse();
        Object t = baseService.findById(id);
        result.data((T)t);
        return result;
    }
}
