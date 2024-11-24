package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_event")
public class CalendarEventEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 活动id
	 */
	@TableId
	private String id;
	/**
	 * 游戏id
	 */
	private String gameId;
	/**
	 * 活动名称
	 */
	private String name;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 平台code
	 */
	private String platformCode;
	/**
	 * 类目id
	 */
	private String categoryId;
	/**
	 * 图片地址
	 */
	private String imgUrl;
	/**
	 * 详情地址
	 */
	private String detailUrl;
	/**
	 * 活动地址
	 */
	private String eventUrl;
	/**
	 * 提示
	 */
	private String tip;

}
