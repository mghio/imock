package cn.mghio.imock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class IMockCore {

  private final List<InvocationDetail> invocationDetailList = new ArrayList<>(8);

  private final IMockCreator mockCreator = new ByteBuddyIMockCreator();

  public <T> T mock(Class<T> mockTargetClass) {
    T result = mockCreator.createMock(mockTargetClass, invocationDetailList);
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T> InvocationDetail<T> when(T methodCall) {
    int currentSize = invocationDetailList.size();
    return (InvocationDetail<T>) invocationDetailList.get(currentSize - 1);
  }
}
