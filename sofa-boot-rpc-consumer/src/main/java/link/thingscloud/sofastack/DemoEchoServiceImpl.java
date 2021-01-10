package link.thingscloud.sofastack;

import com.alipay.sofa.rpc.api.future.SofaResponseFuture;
import com.alipay.sofa.rpc.common.RpcConstants;
import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
@Service
public class DemoEchoServiceImpl {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private EchoService echoService1;
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt", invokeType = RpcConstants.INVOKER_TYPE_FUTURE))
    private EchoService echoService2;
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt", invokeType = RpcConstants.INVOKER_TYPE_CALLBACK, callbackRef = "sampleCallback"))
    private EchoService echoService3;
//    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt", invokeType = RpcConstants.INVOKER_TYPE_ONEWAY))
//    private EchoService echoService4;

    @PostConstruct
    public void startup() {
        System.out.println("同步调用 ： " + echoService1.echo(new Date().toString()));
        echoService2.echo(new Date().toString());
        try {
//            Future future = SofaResponseFuture.getFuture(true);
//            System.out.println(future.get());
            String result = (String) SofaResponseFuture.getResponse(1000, true);
            System.out.println("异步调用 ： " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RpcInvokeContext.getContext().setResponseCallback(new SampleCallback());
        echoService3.echo(new Date().toString());

        echoService1.invokeOneWay(new Date().toString());
    }
}
