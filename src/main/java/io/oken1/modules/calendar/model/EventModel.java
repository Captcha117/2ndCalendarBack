package io.oken1.modules.calendar.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.oken1.modules.calendar.entity.CalendarEventEntity;
import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class EventModel extends CalendarEventEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<CalendarEventRewardEntity> rewardList;

}
