package rpc;

import entity.RpcRequest;

public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

}

