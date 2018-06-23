package com.cloud.auth.server.rpc;

import com.cloud.auth.server.configuration.KeyConfiguration;
import com.cloud.common.result.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiaShun
 * @date 2018/3/30 17:21
 */
@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private KeyConfiguration keyConfiguration;
    @RequestMapping(value = "/userPubKey",method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getUserPubKey(){
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getUserPubKey());
    }
}
