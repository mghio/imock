package cn.mghio.imock;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class Target {

  public String foo(String name) {
    return String.format("Hello, %s", name);
  }

}
