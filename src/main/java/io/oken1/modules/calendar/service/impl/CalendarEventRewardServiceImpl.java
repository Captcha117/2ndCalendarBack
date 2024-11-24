package io.oken1.modules.calendar.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarEventRewardDao;
import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.oken1.modules.calendar.service.CalendarEventRewardService;


@Service("calendarEventRewardService")
public class CalendarEventRewardServiceImpl extends ServiceImpl<CalendarEventRewardDao, CalendarEventRewardEntity> implements CalendarEventRewardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventRewardEntity> page = this.page(
                new Query<CalendarEventRewardEntity>().getPage(params),
                new QueryWrapper<CalendarEventRewardEntity>()
        );

        return new PageUtils(page);
    }

}