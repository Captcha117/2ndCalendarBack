package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_game")
public class CalendarGameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 游戏id
	 */
	@TableId
	private String id;
	/**
	 * 游戏名称
	 */
	private String name;
	/**
	 * 游戏code
	 */
	private String code;

}
