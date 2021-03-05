import rpc.netty.server.NettyServer;
import rpc.register.DefaultServiceRegistry;
import rpc.register.ServiceRegistry;

public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }

}
