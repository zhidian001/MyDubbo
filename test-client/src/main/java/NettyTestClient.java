import rpc.serializer.CommonSerializer;
import rpc.serializer.ProtobufSerializer;
import rpc.transport.RpcClient;
import rpc.transport.RpcClientProxy;
import rpc.transport.netty.client.NettyClient;

/**
 * 测试用Netty消费者
 *
 * @author zhidian
 */
public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }

}
