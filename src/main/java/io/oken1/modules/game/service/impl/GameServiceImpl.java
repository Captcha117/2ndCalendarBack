package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.DateUtils;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;
import io.oken1.modules.game.dao.GameDao;
import io.oken1.modules.game.entity.GameEntity;
import io.oken1.modules.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("GameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GameEntity> page = this.page(
                new Query<GameEntity>().getPage(params),
                new QueryWrapper<GameEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 获取游戏列表
     *
     * @return 游戏列表
     */
    @Override
    public List<LinkedHashMap> getGameList() {
        return gameDao.getGameList();
    }

}