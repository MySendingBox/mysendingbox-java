package com.mysendingbox.net;

import com.mysendingbox.exception.APIException;
import com.mysendingbox.exception.AuthenticationException;
import com.mysendingbox.exception.InvalidRequestException;
import com.mysendingbox.exception.RateLimitException;

import java.io.IOException;
import java.util.Map;

public abstract class APIResource  {

    private static ResponseGetter responseGetter = new ResponseGetter();

    public static final String CHARSET = "UTF-8";

    public enum RequestMethod {
        GET, POST, PUT, DELETE
    }

    public enum RequestType {
        NORMAL, MULTIPART, JSON
    }

    public static <T> MysendingboxResponse<T> request(APIResource.RequestMethod method, APIResource.RequestType type,
                                  String url, Map<String, Object> params, Class<T> clazz,
                                  RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        return responseGetter.request(method, url, params, clazz, type, options);
    }

}
