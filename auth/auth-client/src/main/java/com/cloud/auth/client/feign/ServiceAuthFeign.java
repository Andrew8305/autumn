package com.cloud.auth.client.feign;

import com.cloud.common.result.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author JiaShun
 * @date 2018/3/30 16:52
 */
@FeignClient(value = "${auth.serviceId}",configuration = {})
public interface ServiceAuthFeign {
    @RequestMapping(value = "/client/userPubKey",method = RequestMethod.POST)
    ObjectRestResponse<byte[]> getUserPubKey();
}
