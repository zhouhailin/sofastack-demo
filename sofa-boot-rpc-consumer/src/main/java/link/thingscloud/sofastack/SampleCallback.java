package link.thingscloud.sofastack;

import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.invoke.SofaResponseCallback;
import com.alipay.sofa.rpc.core.request.RequestBase;
import org.springframework.stereotype.Service;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
@Service
public class SampleCallback implements SofaResponseCallback {
    @Override
    public void onAppResponse(Object appResponse, String methodName, RequestBase request) {
        System.out.println("异步回调 ： " + appResponse);

    }

    @Override
    public void onAppException(Throwable throwable, String methodName, RequestBase request) {
        throwable.printStackTrace();
    }

    @Override
    public void onSofaException(SofaRpcException sofaException, String methodName, RequestBase request) {
        sofaException.printStackTrace();
    }
}
