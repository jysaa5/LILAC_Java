package annotation_ex;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Ŀ���� ������̼�
//@�������̽�
//JVM ����ÿ� �����ϰ� �Ϸ���, @Retention(RetentionPolicy.RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface Count100 {

}
