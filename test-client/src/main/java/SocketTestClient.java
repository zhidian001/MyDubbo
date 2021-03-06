import rpc.serializer.CommonSerializer;
import rpc.serializer.KryoSerializer;
import rpc.transport.RpcClientProxy;
import rpc.transport.socket.client.SocketClient;

/**
 * 测试用消费者（客户端）
 *
 * @author zhidian
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        for(int i = 0; i < 20; i ++) {
            String res = helloService.hello(object);
            System.out.println(res);
        }
    }

}
