package practise2025.circuit_breaker;

public class RpcService {

    private CircuitBreaker<Response> circuitBreaker = new CircuitBreaker<>(3, 5, 2, 5);


    public Response rpc(int param1, int param2) throws ApiException {
        return new Response();
    }

    public Response protectedRpc(int param1, int param2) throws ApiException {

        try {
            return circuitBreaker.execute(() -> {
                return rpc(param1, param2);
            });
        } catch (ApiException e) {
            throw e;
        } catch (CircuitBreakException e) {
            throw new ApiException();
        }
    }

}
