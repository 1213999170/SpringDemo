package cn.porsche.demo.stock.web.rest;

import cn.porsche.demo.stock.service.DemoStockService;
import cn.porsche.digital.common.resource.Result;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/v1/demo/stock")
public class DemoStockController {

  @Autowired
  private DemoStockService demoStockService;

  @PostMapping("/sync_order")
  @ApiOperation("同步order数据创建对应的stock随机记录")
  public Result<Boolean> createRandomRecords(
      @RequestParam(value = "startIndex") Integer startIndex,
      @RequestParam(value = "endIndex") Integer endIndex) {
    Boolean result = demoStockService.syncOrderRecords(startIndex, endIndex);
    return new Result(result);
  }


}
