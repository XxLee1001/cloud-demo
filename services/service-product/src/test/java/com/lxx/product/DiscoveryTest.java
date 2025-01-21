package com.lxx.product;

import com.alibaba.cloud.nacos.NacosServiceInstance;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * @author lxx
 */
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void nacosServiceDiscoveryTest() throws NacosException {
        for (String service : nacosServiceDiscovery.getServices()) {
            System.out.println("service= " + service);
            for (ServiceInstance instance : nacosServiceDiscovery.getInstances(service)) {
                System.out.println("IP: " + instance.getHost() + " port: " + instance.getPort());
            }
        }
    }

    @Test
    void discoveryClientTest() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service= " + service);

            for (ServiceInstance instance : discoveryClient.getInstances(service)) {
                System.out.println("IP: " + instance.getHost() + " port: " + instance.getPort());
            }
        }
    }

}
