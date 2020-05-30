package cn.mghio.imock;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class InvocationDetail<T> {

  private String attachedClassName;

  private String methodName;

  private Object[] arguments;

  private T result;

  public InvocationDetail(String attachedClassName, String methodName, Object[] arguments) {
    this.attachedClassName = attachedClassName;
    this.methodName = methodName;
    this.arguments = arguments;
  }

  public void thenReturn(T t) {
    this.result = t;
  }

  public T getResult() {
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InvocationDetail<?> behaviour = (InvocationDetail<?>) o;
    return Objects.equals(attachedClassName, behaviour.attachedClassName) &&
        Objects.equals(methodName, behaviour.methodName) &&
        Arrays.equals(arguments, behaviour.arguments);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(attachedClassName, methodName);
    result = 31 * result + Arrays.hashCode(arguments);
    return result;
  }
}
