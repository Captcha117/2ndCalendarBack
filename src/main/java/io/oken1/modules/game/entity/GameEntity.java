package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("game")
public class GameEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
}
