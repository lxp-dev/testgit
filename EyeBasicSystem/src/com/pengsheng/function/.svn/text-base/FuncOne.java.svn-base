package com.pengsheng.function;


import java.math.BigDecimal;

import com.fr.script.AbstractFunction;

public class FuncOne extends AbstractFunction
{
  public Object run(Object[] arg0)
  {
    if (arg0 != null) {
      String str = arg0[0].toString();
      try {
		return new BigDecimal(str).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	  } catch (Exception e) {
		  return new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	  }
    }

    return new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  }
}