package serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Halo
 * @create 2021/10/30 下午 10:51
 * @description
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    // 申明序列化的版本号码
    // 序列化的版本号与反序列化的版本号必须一致才不会出错！
    private static final long serialVersionUID = 1;
    private String name;
    private String loginName;
    // transient修饰的成员变量不参与序列化了
    private transient String passWord;
    private int age;
}
