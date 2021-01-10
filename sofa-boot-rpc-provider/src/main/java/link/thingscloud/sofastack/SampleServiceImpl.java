package link.thingscloud.sofastack;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Service;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
@Service
@SofaService(bindings = {@SofaServiceBinding(bindingType = "bolt"),
        @SofaServiceBinding(bindingType = "rest")})
public class SampleServiceImpl implements SampleService {
    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public String hello2() {
        return "Hello2";
    }
}
