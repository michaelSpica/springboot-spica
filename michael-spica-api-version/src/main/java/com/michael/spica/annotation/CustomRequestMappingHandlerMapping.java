package com.michael.spica.annotation;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by michael on 2019/5/8.
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    public CustomRequestMappingHandlerMapping() {
    }

    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        ApiVersion apiVersion = (ApiVersion) AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return this.createRequestCondition(apiVersion);
    }

    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = (ApiVersion)AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return this.createRequestCondition(apiVersion);
    }

    private RequestCondition<ApiVersionCondition> createRequestCondition(ApiVersion apiVersion) {
        if (Objects.isNull(apiVersion)) {
            return null;
        } else {
            int value = apiVersion.value();
            Assert.isTrue(value >= 1, "[MichaelSpica]API Version Must be greater than or equal to 1.");
            return new ApiVersionCondition(value);
        }
    }
}
