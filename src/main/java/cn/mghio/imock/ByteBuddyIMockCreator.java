package cn.mghio.imock;

import java.lang.reflect.Modifier;
import java.util.List;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Default;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.springframework.objenesis.ObjenesisStd;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class ByteBuddyIMockCreator implements IMockCreator {

  private final ObjenesisStd objenesisStd = new ObjenesisStd();

  @Override
  public <T> T createMock(Class<T> mockTargetClass, List<InvocationDetail> behaviorList) {
    ByteBuddy byteBuddy = new ByteBuddy();

    Class<? extends T> classWithInterceptor = byteBuddy.subclass(mockTargetClass)
        .method(ElementMatchers.any())
        .intercept(MethodDelegation.to(InterceptorDelegate.class))
        .defineField("interceptor", IMockInterceptor.class, Modifier.PRIVATE)
        .implement(IMockIntercepable.class)
        .intercept(FieldAccessor.ofBeanProperty())
        .make()
        .load(getClass().getClassLoader(), Default.WRAPPER).getLoaded();

    T mockTargetInstance = objenesisStd.newInstance(classWithInterceptor);
    ((IMockIntercepable) mockTargetInstance).setInterceptor(new IMockInterceptor(behaviorList));

    return mockTargetInstance;
  }
}
