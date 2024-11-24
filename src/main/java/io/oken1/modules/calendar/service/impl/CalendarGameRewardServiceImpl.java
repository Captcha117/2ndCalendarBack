package io.oken1.modules.calendar.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarGameRewardDao;
import io.oken1.modules.calendar.entity.CalendarGameRewardEntity;
import io.oken1.modules.calendar.service.CalendarGameRewardService;


@Service("calendarGameRewardService")
public class CalendarGameRewardServiceImpl extends ServiceImpl<CalendarGameRewardDao, CalendarGameRewardEntity> implements CalendarGameRewardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarGameRewardEntity> page = this.page(
                new Query<CalendarGameRewardEntity>().getPage(params),
                new QueryWrapper<CalendarGameRewardEntity>()
        );

        return new PageUtils(page);
    }

}