package cn.mghio.imock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class IMockTest {

  @Test
  public void test_foo_method() {
    String exceptedResult = "Mocked mghio";
    Target mockTarget = IMock.mock(Target.class);

    IMock.when(mockTarget.foo("mghio")).thenReturn(exceptedResult);

    String actualResult = mockTarget.foo("mghio");

    assertEquals(exceptedResult, actualResult);
  }

}
