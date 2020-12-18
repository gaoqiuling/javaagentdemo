package com.itisacat.rpc.demo;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcClient {
}
