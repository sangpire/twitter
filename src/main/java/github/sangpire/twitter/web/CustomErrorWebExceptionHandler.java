package github.sangpire.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.HashMap;
import java.util.Map;

//@Component
public class CustomErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    // Define constructor here
    @Autowired
    public CustomErrorWebExceptionHandler(
        ServerCodecConfigurer serverCodecConfigurer,
        ErrorAttributes errorAttributes,
        ResourceProperties resourceProperties,
        ApplicationContext applicationContext
    ) {
        super(errorAttributes, resourceProperties, applicationContext);
        setMessageReaders(serverCodecConfigurer.getReaders());
        setMessageWriters(serverCodecConfigurer.getWriters());
    }

	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
      Map<String, String> result = new HashMap<>();
      result.put("error", "occured");

		 return RouterFunctions
		 		.route(RequestPredicates.all(), serverRequest -> {
		 		  Throwable throwable = errorAttributes.getError(serverRequest);
                  System.out.println(throwable);
		 		  return ServerResponse.status(500)
                      .contentType(MediaType.APPLICATION_JSON_UTF8)
                      .body(BodyInserters.fromObject(result));
                });
	}

}