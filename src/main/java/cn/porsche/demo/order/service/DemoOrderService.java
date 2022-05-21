package cn.porsche.demo.order.service;

import cn.porsche.demo.order.entity.DemoOrderEntity;
import cn.porsche.demo.order.entity.DemoOrderStockEntity;
import cn.porsche.digital.common.resource.PagedResult;
import java.util.List;

public interface DemoOrderService {

  Boolean createRandomRecords(int n, List<Integer> dealerCodeList);

  List<DemoOrderEntity> getPageResult(int pageNum, int size);

  PagedResult<DemoOrderStockEntity> getOrderStockList();

  PagedResult<DemoOrderStockEntity> getOrderStockListByDealerCode(Integer dealerCode);
}
