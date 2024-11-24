package io.oken1.modules.calendar.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarGameDao;
import io.oken1.modules.calendar.entity.CalendarGameEntity;
import io.oken1.modules.calendar.service.CalendarGameService;


@Service("calendarGameService")
public class CalendarGameServiceImpl extends ServiceImpl<CalendarGameDao, CalendarGameEntity> implements CalendarGameService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarGameEntity> page = this.page(
                new Query<CalendarGameEntity>().getPage(params),
                new QueryWrapper<CalendarGameEntity>()
        );

        return new PageUtils(page);
    }

}