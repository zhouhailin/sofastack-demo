package link.thingscloud.sofastack;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
@Service
public class DemoSampleServiceImpl {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private SampleService sampleService;

    @PostConstruct
    public void startup() {
        System.out.println("同步调用 ： " + sampleService.hello());
        System.out.println("同步调用 ： " + sampleService.hello2());
    }
}
