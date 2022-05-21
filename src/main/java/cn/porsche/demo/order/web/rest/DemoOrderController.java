package cn.porsche.demo.order.web.rest;

import cn.porsche.demo.order.entity.DemoOrderStockEntity;
import cn.porsche.demo.order.service.DemoOrderService;
import cn.porsche.demo.order.web.rest.resource.DealerCodeListResource;
import cn.porsche.demo.order.web.rest.resource.DemoOrderStockResource;
import cn.porsche.digital.common.resource.PagedResult;
import cn.porsche.digital.common.resource.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/v1/demo/order")
public class DemoOrderController {

  @Autowired
  private DemoOrderService demoOrderService;

  @PostMapping("/random/{num}")
  @ApiOperation("创建 num 条随机的库存记录")
  public Result<Boolean> createRandomRecords(@PathVariable(value = "num") Integer num,
      @RequestBody DealerCodeListResource dealerCodeListResource) {
    if (num == null || num == 0) {
      return new Result<>(true);
    }
    Boolean result = demoOrderService.createRandomRecords(num, dealerCodeListResource.getDealerCodeList());
    return new Result(result);
  }

  @GetMapping("/list")
  @ApiOperation("获取Order Stock联合列表")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "pageNum", value = "Page number", dataTypeClass = String.class, paramType = "query"),
      @ApiImplicitParam(name = "pageSize", value = "Page size", dataTypeClass = String.class, paramType = "query"),
      @ApiImplicitParam(name = "orderBy", value = "Order by", dataTypeClass = String.class, paramType = "query")})
  public PagedResult<DemoOrderStockEntity> getOrderStockList(
      @RequestParam(value = "dealerCode", required = false) Integer dealerCode) {
    PagedResult<DemoOrderStockEntity> orderStockPageResult;

    if (dealerCode == null) {
      orderStockPageResult = demoOrderService.getOrderStockList();
    } else {
      orderStockPageResult = demoOrderService.getOrderStockListByDealerCode(dealerCode);
    }

    return orderStockPageResult;

//    List<DemoOrderStockResource> resources = DemoOrderStockResource.toResource(orderStockPageResult.getData());
//
//    return new PagedResult<>(orderStockPageResult, resources);
  }
}
