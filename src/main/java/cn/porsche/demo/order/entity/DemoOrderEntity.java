package cn.porsche.demo.order.entity;

import cn.porsche.digital.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单表
 */
@Data
@TableName("demo_order")
@EqualsAndHashCode(callSuper = true)
public class DemoOrderEntity extends BaseEntity {

  private static final long serialVersionUID = 2024689417500752221L;

  private Integer dealerCode;
  private String aaa;
  private String bbb;
  private String ccc;
  private String ddd;
  private String eee;
  private String fff;
  private String ggg;
  private String hhh;
  private String iii;
  private String jjj;
  private String kkk;
  private String lll;
  private String mmm;
  private String nnn;
  private String ooo;
  private String ppp;
  private String qqq;
  private String rrr;
  private String sss;
  private String ttt;

  public DemoOrderEntity(Integer dc, String x) {
    dealerCode = dc;
    aaa = x;
    bbb = x;
    ccc = x;
    ddd = x;
    eee = x;
    fff = x;
    ggg = x;
    hhh = x;
    iii = x;
    jjj = x;
    kkk = x;
    lll = x;
    mmm = x;
    nnn = x;
    ooo = x;
    ppp = x;
    qqq = x;
    rrr = x;
    sss = x;
    ttt = x;
  }
}
