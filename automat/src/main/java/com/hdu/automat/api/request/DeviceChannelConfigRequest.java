package com.hdu.automat.api.request;

import com.hdu.automat.biz.constants.AutoMatConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class DeviceChannelConfigRequest implements Serializable {

    private static final long serialVersionUID = -7124109033372115940L;

    private List<DeviceChannel> channelList;

    @Setter
    @Getter
    public class DeviceChannel implements Serializable{

        private static final long serialVersionUID = 8776811714782213366L;
        // 通道ID
        private Integer channelId;

        // 商品名称
        private String itemName;

        private Long price = AutoMatConstants.PRICE;
    }
}
