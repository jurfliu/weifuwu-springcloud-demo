package com.ljf.weifuwu.springcloud.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ZuulFallBackHandler implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        return "ms-eureka-provider";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                System.out.println("HttpStatus.BAD_REQUEST:"+HttpStatus.BAD_REQUEST);
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                System.out.println("HttpStatus.BAD_REQUEST.value():"+HttpStatus.BAD_REQUEST.value());
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                System.out.println("HttpStatus.BAD_REQUEST.getReasonPhrase():"+HttpStatus.BAD_REQUEST.getReasonPhrase());
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
               // return new ByteArrayInputStream(("fallback" + ZuulFallBackHandler.this.getRoute()).getBytes());
                return new ByteArrayInputStream(("fallback( code:" + Integer.toString(this.getRawStatusCode()) + "  message:" + this.getStatusText()+")").getBytes());

            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
