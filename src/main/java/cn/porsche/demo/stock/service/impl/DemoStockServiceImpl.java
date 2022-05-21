package cn.porsche.demo.stock.service.impl;

import cn.porsche.demo.order.entity.DemoOrderEntity;
import cn.porsche.demo.order.mapper.DemoOrderMapper;
import cn.porsche.demo.stock.entity.DemoStockEntity;
import cn.porsche.demo.stock.mapper.DemoStockMapper;
import cn.porsche.demo.stock.service.DemoStockService;
import cn.porsche.digital.common.context.PaginationContext;
import cn.porsche.digital.config.MybatisPlusConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoStockServiceImpl implements DemoStockService {

  @Autowired
  private DemoOrderMapper demoOrderMapper;

  @Autowired
  private DemoStockMapper demoStockMapper;

  private static final int RANDOM_RANGE = 1000000;

  private static final int BATCH_SIZE = 1000;

  private List<DemoStockEntity> createRelatedStockFromOrderListRandom(List<DemoOrderEntity> orderEntities) {
    int len = orderEntities.size();
    List<DemoStockEntity> stockEntities = new ArrayList<>();

    int remainLen = len;
    while (remainLen > len / 2) {
      int i = (int) (Math.random() * remainLen);
      DemoOrderEntity order = orderEntities.get(i);
      orderEntities.remove(i);
      remainLen--;

      String rs = String.valueOf((int)(Math.random() * RANDOM_RANGE + 1));
      DemoStockEntity stock = new DemoStockEntity(order.getDealerCode(), order.getId(), rs);
      stockEntities.add(stock);
    }
    return stockEntities;
  }

  @Override
  public Boolean syncOrderRecords(Integer startIndex, Integer endIndex) {


    int orderCount = demoOrderMapper.selectCount(null);

    List<DemoOrderEntity> orderCache = new ArrayList<>();

    int index = startIndex;
    while (index < endIndex && index < orderCount) {
      List<DemoOrderEntity> orderBatch = demoOrderMapper.getByLimit(index, BATCH_SIZE);
      index += BATCH_SIZE;

      orderCache.addAll(orderBatch);
      List<DemoStockEntity> stockEntities = createRelatedStockFromOrderListRandom(orderCache);
      demoStockMapper.insertBatch(stockEntities);
    }

    return true;
  }

}
