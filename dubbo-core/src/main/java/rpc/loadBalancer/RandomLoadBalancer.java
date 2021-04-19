package rpc.loadBalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;
import java.util.Random;

public class RandomLoadBalancer implements LoadBalancer {

    @Override
    public Instance select(List<Instance> instances) {
        return instances.get(new Random().nextInt(instances.size()));
    }

    @Override
    public String selectServiceAddress(List<String> instances, String serviceName) {
        Random random = new Random();
        return instances.get(random.nextInt(instances.size()));
    }
    }

