package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 游戏
 *
 * @author oken1
 * @email /
 * @date 2025-05-14 10:38:02
 */
@Data
@TableName("calendar_custom")
public class CalendarCustomEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 提醒
     */
    private String remind;
    /**
     * 分类
     */
    private String type;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否删除（0：未删除，1：已删除）
     */
    private Boolean deleted;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
}
