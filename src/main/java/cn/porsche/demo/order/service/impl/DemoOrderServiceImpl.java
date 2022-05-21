package cn.porsche.demo.order.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.porsche.demo.order.entity.DemoOrderEntity;
import cn.porsche.demo.order.entity.DemoOrderStockEntity;
import cn.porsche.demo.order.mapper.DemoOrderMapper;
import cn.porsche.demo.order.service.DemoOrderService;
import cn.porsche.digital.common.context.PaginationContext;
import cn.porsche.digital.common.resource.PagedResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoOrderServiceImpl implements DemoOrderService {

  @Autowired
  private DemoOrderMapper demoOrderMapper;

  private static final int RANDOM_RANGE = 1000000;
  private static final int BATCH_SIZE = 1000;

  private List<DemoOrderEntity> createRandomEntities(int n, List<Integer> dealerCodeList) {
    int dealerCount = dealerCodeList.size();
    List<DemoOrderEntity> entities = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      int dealerCodeIndex = (int) (Math.random() * dealerCount);
      String rs = String.valueOf((int)(Math.random() * RANDOM_RANGE + 1));
      DemoOrderEntity entity = new DemoOrderEntity(dealerCodeList.get(dealerCodeIndex), rs);
      entities.add(entity);
    }
    return entities;
  }

  @Override
  public Boolean createRandomRecords(int n, List<Integer> dealerCodeList) {
    if (n < 0 || CollUtil.isEmpty(dealerCodeList)) {
      return false;
    }

    for (int i = 0; i < n; i++) {
      List<DemoOrderEntity> entities = createRandomEntities(BATCH_SIZE, dealerCodeList);
      demoOrderMapper.insertBatch(entities);
    }

    return true;
  }

  @Override
  public List<DemoOrderEntity> getPageResult(int pageNum, int size) {

    PaginationContext.setPager(String.valueOf(pageNum), String.valueOf(size), "");
    List<DemoOrderEntity> result;
    try {
      PaginationContext.startSortAndPage();
      result = demoOrderMapper.selectList(null);
    } finally {
      PaginationContext.removePager();
    }

    return result;
  }

  @Override
  public PagedResult<DemoOrderStockEntity> getOrderStockList() {
    PaginationContext.startSortAndPage();

    List<DemoOrderStockEntity> orderStockEntities = demoOrderMapper.getOrderStockList();
    return new PagedResult<>(orderStockEntities);
  }

  @Override
  public PagedResult<DemoOrderStockEntity> getOrderStockListByDealerCode(Integer dealerCode) {
    PaginationContext.startSortAndPage();

    List<DemoOrderStockEntity> orderStockEntities = demoOrderMapper.getOrderStockListByDealerCode(dealerCode);
    return new PagedResult<>(orderStockEntities);
  }

}
