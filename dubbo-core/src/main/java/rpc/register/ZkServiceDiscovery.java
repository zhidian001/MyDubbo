package rpc.register;

import com.alibaba.nacos.api.naming.pojo.Instance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.zookeeper.data.Stat;
import rpc.loadBalancer.LoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpc.loadBalancer.RandomLoadBalancer;

import java.net.InetSocketAddress;
import java.util.List;

public class ZkServiceDiscovery implements ServiceDiscovery{
    private static final Logger logger = LoggerFactory.getLogger(ZkServiceDiscovery.class);
    private final LoadBalancer loadBalancer;

    public ZkServiceDiscovery(LoadBalancer loadBalancer) {
        if(loadBalancer == null) this.loadBalancer = new RandomLoadBalancer();
        else this.loadBalancer = loadBalancer;
    }
    @Override
    public InetSocketAddress lookupService(String serviceName) {
        //ZkClient zc = new ZkClient("127.0.0.1:2181",10000,10000,new SerializableSerializer());
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, serviceName);
        // load balancing
        String targetServiceUrl = loadBalancer.selectServiceAddress(serviceUrlList, serviceName);
        logger.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);

    }
}
