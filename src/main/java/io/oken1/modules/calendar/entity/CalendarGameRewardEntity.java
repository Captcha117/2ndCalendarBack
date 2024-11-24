package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏奖励
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_game_reward")
public class CalendarGameRewardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 奖励id
	 */
	@TableId
	private String id;
	/**
	 * 游戏id
	 */
	private String gameId;
	/**
	 * 奖励名称
	 */
	private String name;
	/**
	 * 奖励code
	 */
	private String code;

}
