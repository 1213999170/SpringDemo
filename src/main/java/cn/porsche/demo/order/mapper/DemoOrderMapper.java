package cn.porsche.demo.order.mapper;

import cn.porsche.demo.order.entity.DemoOrderEntity;
import cn.porsche.demo.order.entity.DemoOrderStockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface DemoOrderMapper extends BaseMapper<DemoOrderEntity> {

  Integer insertBatch(List<DemoOrderEntity> list);

  // current * size, size
  List<DemoOrderEntity> getByLimit(int begin, int size);

  List<DemoOrderStockEntity> getOrderStockList();

  List<DemoOrderStockEntity> getOrderStockListByDealerCode(Integer dealerCode);

}
