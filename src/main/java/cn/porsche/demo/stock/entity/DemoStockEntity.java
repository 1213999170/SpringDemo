package cn.porsche.demo.stock.entity;

import cn.porsche.digital.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存表
 */
@Data
@TableName("demo_stock")
@EqualsAndHashCode(callSuper = true)
public class DemoStockEntity extends BaseEntity {

  private static final long serialVersionUID = -5800266853662532370L;

  private Integer dealerCode;
  private Integer orderId;
  private String saaa;
  private String sbbb;
  private String sccc;
  private String sddd;
  private String seee;
  private String sfff;
  private String sggg;
  private String shhh;
  private String siii;
  private String sjjj;
  private String skkk;
  private String slll;
  private String smmm;
  private String snnn;
  private String sooo;
  private String sppp;
  private String sqqq;
  private String srrr;
  private String ssss;
  private String sttt;

  public DemoStockEntity(Integer dc, Integer oid, String x) {
    dealerCode = dc;
    orderId = oid;
    saaa = x;
    sbbb = x;
    sccc = x;
    sddd = x;
    seee = x;
    sfff = x;
    sggg = x;
    shhh = x;
    siii = x;
    sjjj = x;
    skkk = x;
    slll = x;
    smmm = x;
    snnn = x;
    sooo = x;
    sppp = x;
    sqqq = x;
    srrr = x;
    ssss = x;
    sttt = x;
  }
}
