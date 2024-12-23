package io.oken1.modules.calendar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 版本
 * 
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Data
@TableName("calendar_version")
public class CalendarVersionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 版本id
	 */
	@TableId(type = IdType.ASSIGN_UUID)
	private String id;
	/**
	 * 版本名 1.0.0
	 */
	private String name;
	/**
	 * 版本描述
	 */
	private String desc;
	/**
	 * 版本下载url
	 */
	private String downloadUrl;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
