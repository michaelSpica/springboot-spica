package com.michael.spica.annotation;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michael on 2019/5/8.
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private static final Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");
    private int apiVersion;

    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher matcher = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (matcher.find()) {
            int version = Integer.valueOf(matcher.group(1));
            if (version >= this.apiVersion) {
                return this;
            }
        }

        return null;
    }

    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return this.apiVersion;
    }

    public ApiVersionCondition(final int apiVersion) {
        this.apiVersion = apiVersion;
    }
}
