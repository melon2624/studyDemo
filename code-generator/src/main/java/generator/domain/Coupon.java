package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
/**
 * 领到手的优惠券
 * @TableName coupon
 */
@TableName(value ="coupon")
public class Coupon implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主键
     */
    @TableField(value = "template_id")
    private Integer template_id;

    /**
     * 拥有这张券的用户ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 领券时间
     */
    @TableField(value = "created_time")
    private Date created_time;

    /**
     * 优惠券的状态，比如未用，已用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 冗余字段，方便查找
     */
    @TableField(value = "shop_id")
    private Long shop_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}