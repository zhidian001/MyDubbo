import rpc.RpcClient;
import rpc.RpcClientProxy;
import rpc.netty.client.NettyClient;

/**
 * 测试用消费者（客户端）
 * @author liushuo
 */
public class TestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient("127.0.0.1", 9999);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

}
}
