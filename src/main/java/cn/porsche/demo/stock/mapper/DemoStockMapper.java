package cn.porsche.demo.stock.mapper;

import cn.porsche.demo.stock.entity.DemoStockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface DemoStockMapper extends BaseMapper<DemoStockEntity> {

  Integer insertBatch(List<DemoStockEntity> list);

}
