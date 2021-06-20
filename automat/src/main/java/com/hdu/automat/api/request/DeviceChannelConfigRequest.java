package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class DeviceChannelConfigRequest implements Serializable {

    private List<DeviceChannel> channelList;

    @Setter
    @Getter
    public class DeviceChannel implements Serializable{

        // 通道ID
        private Integer channelId;

        // 商品名称
        private String itemName;
    }
}
