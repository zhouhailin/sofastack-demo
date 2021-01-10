package link.thingscloud.sofastack;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
public interface EchoService {

    String echo(String str);

    void invokeOneWay(String str);
//
//    String invokeSync(String str);
//
//    Future<String> invokeAsync(String str);

}
