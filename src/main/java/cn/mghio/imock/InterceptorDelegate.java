package cn.mghio.imock;

import java.lang.reflect.Method;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.FieldValue;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.This;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class InterceptorDelegate {

  @RuntimeType
  public static Object intercept(@This Object mock, @Origin Method invokedMethod,
      @FieldValue("interceptor") IMockInterceptor interceptor, @AllArguments Object[] arguments) {

    return interceptor.invoke(mock, invokedMethod, arguments);
  }

}
