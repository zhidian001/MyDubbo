package rpc.loadBalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

public interface LoadBalancer {
    Instance select(List<Instance> instances);
    String selectServiceAddress(List<String> instances,String serviceName);

}
