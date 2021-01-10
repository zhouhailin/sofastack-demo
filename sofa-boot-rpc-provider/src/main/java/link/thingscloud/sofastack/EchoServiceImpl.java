package link.thingscloud.sofastack;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Service;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
@Service
@SofaService(bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String str) {
        System.out.println("echo : " + str);
        return str;
    }

    @Override
    public void invokeOneWay(String str) {
        System.out.println("invokeOneWay : " + str);
    }
}
