package com.zcf.ServiceImpl;

import com.zcf.pojo.DbOrder;
import com.zcf.pojo.DbOrderFood;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.mapper.DbOrderFoodMapper;
import com.zcf.mapper.DbOrderMapper;
import com.zcf.service.DbOrderFoodService;
import com.zcf.utils.IDUtils;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbOrderFoodServiceImpl extends ServiceImpl<DbOrderFoodMapper, DbOrderFood> implements DbOrderFoodService {
@Autowired
 private DbOrderFoodMapper dbOrderFoodMapper;
@Autowired
private DbOrderMapper dbOrderMapper;
@Override
public Body add(String table,BigDecimal subtotal,String sid, String sname, String sename,String fid,String remark) {
	DbOrder dbOrder = new DbOrder();
	dbOrder.setoId(IDUtils.genItemId() + "");
	dbOrder.setOrderToShop(sid);
	dbOrder.setoServiceCharge(subtotal.multiply(new BigDecimal(0.1)));
	dbOrder.setoShopEname(sename);
	dbOrder.setoShopName(sname);
	dbOrder.setoStrolleyTable(table);
	dbOrder.setoSubtotal(subtotal);
	dbOrder.setoTime(Hutool.parseDateToString());
	dbOrder.setoTotal(dbOrder.getoServiceCharge().add(subtotal));
	dbOrderMapper.insert(dbOrder);
	DbOrderFood food=new DbOrderFood();
	food.setOfFoodid(fid);
	food.setOfOrderid(dbOrder.getoId());
	food.setOfPrice(subtotal.toString());
	food.setOfRemark(remark);
	dbOrderFoodMapper.insert(food);
	return Body.BODY_200;
}
}
