package rpc.transport;


import entity.RpcRequest;
import rpc.serializer.CommonSerializer;

/**
 * 客户端类通用接口
 *
 * @author zhidian
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);

}

