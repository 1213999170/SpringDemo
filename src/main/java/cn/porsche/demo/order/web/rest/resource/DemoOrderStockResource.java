package cn.porsche.demo.order.web.rest.resource;

import cn.hutool.core.bean.BeanUtil;
import cn.porsche.demo.order.entity.DemoOrderStockEntity;
import cn.porsche.digital.common.entity.BaseEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class DemoOrderStockResource extends BaseEntity {

  private Integer dealerCode;
  private String aaa;

  private Integer stockId;
  private String saaa;

  public static DemoOrderStockResource toResource(DemoOrderStockEntity orderStock) {
    DemoOrderStockResource resource = new DemoOrderStockResource();
    BeanUtil.copyProperties(orderStock, resource);
    return resource;
  }

  public static List<DemoOrderStockResource> toResource(List<DemoOrderStockEntity> orderStockEntityList) {
    return orderStockEntityList.stream().map(DemoOrderStockResource::toResource).collect(Collectors.toList());
  }
}
