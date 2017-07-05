package com.platform.config;

import com.mongodb.ServerAddress;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;
import org.assertj.core.util.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by zjy on 17/7/5.
 */
@Data
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongodbProperties {

//    private String[] hosts;
    private String username;
    private String password;
    private String database;
    private String authDatabase;
    private String host;
    private int port;
    private String mapPackage;
/*

    public List<ServerAddress> hosts() {
        List<ServerAddress> addresses = Lists.newArrayList();
        for (String hostInfo : hosts) {
            String host = hostInfo.split(":")[0];
            int port = NumberUtils.toInt(hostInfo.split(":")[1]);
            addresses.add(new ServerAddress(host, port));
        }
        return addresses;
    }
*/


}