package cn.mghio.imock;

import java.util.List;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public interface IMockCreator {

  <T> T createMock(Class<T> mockTargetClass, List<InvocationDetail> behaviorList);

}
