package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动平台
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_event_platform")
public class CalendarEventPlatformEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 平台id
	 */
	@TableId
	private String id;
	/**
	 * 平台名称
	 */
	private String name;
	/**
	 * 平台code
	 */
	private String code;

}
