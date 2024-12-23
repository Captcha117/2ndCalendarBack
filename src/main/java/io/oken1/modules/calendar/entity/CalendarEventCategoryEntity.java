package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动类目
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_event_category")
public class CalendarEventCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类目id
	 */
	@TableId(type = IdType.ASSIGN_UUID)
	private String id;
	/**
	 * 游戏id
	 */
	private String gameId;
	/**
	 * 类目名称
	 */
	private String name;
	/**
	 * 类目编码
	 */
	private String code;

}
