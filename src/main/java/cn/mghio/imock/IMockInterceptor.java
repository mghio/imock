package cn.mghio.imock;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author mghio
 * @date: 2020-05-30
 * @version: 1.0
 * @description:
 * @since JDK 1.8
 */
public class IMockInterceptor {

  private List<InvocationDetail> recordedInvocationDetails;

  public IMockInterceptor(List<InvocationDetail> recordedInvocationDetails) {
    this.recordedInvocationDetails = recordedInvocationDetails;
  }

  public Object invoke(Object mock, Method invokedMethod, Object[] arguments) {
    String methodName = invokedMethod.getName();
    String attachedClassName = mock.getClass().getName();

    InvocationDetail invocationDetail = new InvocationDetail(attachedClassName, methodName, arguments);
    if (!recordedInvocationDetails.contains(invocationDetail)) {
      recordedInvocationDetails.add(invocationDetail);
      return invokedMethod.getDefaultValue();
    } else {
      int index = recordedInvocationDetails.indexOf(invocationDetail);
      InvocationDetail recordedBehaviourDetail = recordedInvocationDetails.get(index);
      return recordedBehaviourDetail.getResult();
    }
  }
}
