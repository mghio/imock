package cn.mghio.imock;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class IMock {

  private static final IMockCore IMOCK_CORE = new IMockCore();

  public static <T> T mock(Class<T> clazz) {
    return IMOCK_CORE.mock(clazz);
  }

  public static <T> InvocationDetail when(T methodCall) {
    return IMOCK_CORE.when(methodCall);
  }
}
