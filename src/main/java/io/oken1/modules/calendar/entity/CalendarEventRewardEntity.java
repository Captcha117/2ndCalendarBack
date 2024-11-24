package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动奖励
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_event_reward")
public class CalendarEventRewardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 活动奖励id
	 */
	@TableId
	private String id;
	/**
	 * 活动id
	 */
	private String eventId;
	/**
	 * 奖励code
	 */
	private String rewardCode;
	/**
	 * 奖励数量
	 */
	private String rewardNum;

}
