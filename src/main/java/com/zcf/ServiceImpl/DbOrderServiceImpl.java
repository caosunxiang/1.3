package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFood;
import com.zcf.pojo.DbOrder;
import com.zcf.pojo.DbOrderFood;
import com.zcf.pojo.DbUserDiscounts;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.mapper.DbOrderFoodMapper;
import com.zcf.mapper.DbOrderMapper;
import com.zcf.mapper.DbUserDiscountsMapper;
import com.zcf.service.DbOrderService;
import com.zcf.utils.JsonUtils;
import com.zcf.websocket.WebSocket;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbOrderServiceImpl extends ServiceImpl<DbOrderMapper, DbOrder> implements DbOrderService {
@Autowired
private DbOrderMapper dbOrderMapper;
@Autowired
private DbOrderFoodMapper dbOrderFoodMapper;
@Autowired
private DbFoodMapper dbFoodMapper;
@Autowired 
private DbUserDiscountsMapper userDiscountsMapper;
@Override
public Body addorder(DbOrder dbOrder,String fid) {
	//分割字符串填入集合
	List<String > list=new ArrayList<String>();
	fid=fid+",";
	 char a[]=fid.toCharArray();
	 Integer c=0;
		Integer changeCount =0;
	 for (int i = 0; i < a.length; i++) {
		 if(a[i]==',') {
			String string= fid.substring(c, i);
			c=i+1;
			System.out.println(string);
		 list.add(string);
		 changeCount++;
		 }
	 }
	 //添加订单
	Integer count=dbOrderMapper.insert(dbOrder);
	for (String string : list) {
		//为订单里的菜品添加月销售额
		DbFood dbFood=dbFoodMapper.selectById(string);
		Integer num=dbFood.getfMonth();
		dbFood.setfMonth(num++);
		//把单独的菜品关联到订单中
		DbOrderFood entity=new DbOrderFood();
		entity.setOfFoodid(string);
		entity.setOfOrderid(dbOrder.getoId());
		dbOrderFoodMapper.insert(entity);
		dbFoodMapper.updateById(dbFood);
	}
	if(count==1) {
		return Body.newInstance(dbOrder);
	}
	return Body.newInstance(201, "添加失敗");
}
@Override
public Body getone(String oid) {
	List<Map<String, Object>>list=dbOrderMapper.getone(oid);
	return Body.newInstance(list);
}
@Override
public Body usedis(String oid,String did,String dtitle,BigDecimal dprice,BigDecimal res) {
	DbOrder dbOrder=dbOrderMapper.selectById(oid);
	BigDecimal totle=dbOrder.getoTotal();
	if(totle.compareTo(res)==-1) {
		return Body.newInstance(201, "條件不足無法使用");
	}
	dbOrder.setoDiscounts(did);
	dbOrder.setoDiscountsPrice(dprice);
	dbOrder.setoDiscountsRemark(dtitle);
	Integer count=dbOrderMapper.updateById(dbOrder);
	if(count==1) {
		return Body.newInstance(dbOrder);
	}
	return Body.newInstance(201, "優惠券使用失敗");
}
@Override
public Body  order(String oid,String ostate) {
	DbOrder dbOrder=dbOrderMapper.selectById(oid);
	dbOrder.setoTotal(dbOrder.getoTotal().subtract(dbOrder.getoDiscountsPrice()));
	dbOrder.setoState(ostate);
	Integer count=dbOrderMapper.updateById(dbOrder);
	if(count==1) {
		if(ostate.equals("1")) {
			EntityWrapper<DbUserDiscounts>wrapper=new EntityWrapper<>();
			wrapper.eq("ud_userid", dbOrder.getOrderToUser());
			wrapper.eq("ud_discountsid", dbOrder.getoDiscounts());
			userDiscountsMapper.delete(wrapper);
			return Body.newInstance(202, "請到前台付款");
		}else {
			//推送结账信息
			WebSocket socket=new WebSocket();
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("touser", dbOrder.getOrderToShop());
			msg.put("data", dbOrder.getoStrolleyTable()+"需要結賬服務");
			socket.onMessage(JsonUtils.objectToJson(msg));
			EntityWrapper<DbUserDiscounts>wrapper=new EntityWrapper<>();
			wrapper.eq("ud_userid", dbOrder.getOrderToUser());
			wrapper.eq("ud_discountsid", dbOrder.getoDiscounts());
			userDiscountsMapper.delete(wrapper);
			return Body.newInstance(200, "請稍後...");
		}
	}
	return Body.newInstance(201, "訂單生成功失敗");
}
@Override
public Body over(String openid) {
	EntityWrapper<DbOrder>wrapper=new EntityWrapper<>();
	wrapper.eq("order_to_shop", openid);
	wrapper.eq("o_state", "1");
	Integer count=dbOrderMapper.selectCount(wrapper);
	if(count!=0) {
		return Body.newInstance(count);
	}
	return Body.newInstance(201, "沒有已完成的訂單");
}
@Override
public Body getbyuid(String uid) {
	List<Map<String, Object> >list=dbOrderMapper.getbyuid(uid);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "查詢無果");
}
@Override
public Body getbysid(String sid) {
	List<Map<String, Object> >list=dbOrderMapper.getbysid(sid);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "查詢無果");
}
@Override
public Body addtoorder(DbOrder dbOrder,String fid) {
	//分割字符串填入集合
		List<String > list=new ArrayList<String>();
		fid=fid+",";
		 char a[]=fid.toCharArray();
		 Integer c=0;
			Integer changeCount =0;
		 for (int i = 0; i < a.length; i++) {
			 if(a[i]==',') {
				String string= fid.substring(c, i);
				c=i+1;
				System.out.println(string);
			 list.add(string);
			 changeCount++;
			 }
		 }
		 //添加订单
		Integer count=dbOrderMapper.insert(dbOrder);
		List<DbFood>dbFoods=new ArrayList<>();
		for (String string : list) {
			//为订单里的菜品添加月销售额
			DbFood dbFood=dbFoodMapper.selectById(string);
			//添加推送需要的菜品信息
			dbFoods.add(dbFood);
			Integer num=dbFood.getfMonth();
			dbFood.setfMonth(num++);
			//把单独的菜品关联到订单中
			DbOrderFood entity=new DbOrderFood();
			entity.setOfFoodid(string);
			entity.setOfOrderid(dbOrder.getoId());
			dbOrderFoodMapper.insert(entity);
			dbFoodMapper.updateById(dbFood);
		}
		if(count==1) {
			WebSocket socket=new WebSocket();
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("touser", dbOrder.getOrderToShop());
			msg.put("data", dbFoods);
			socket.onMessage(JsonUtils.objectToJson(msg));
			return Body.newInstance(dbOrder);
		}
		return Body.newInstance(201, "添加失敗");
}
@Override
public Body table(String sid) {
	EntityWrapper< DbOrder>wrapper=new EntityWrapper<>();
	wrapper.eq("order_to_shop", sid);
	wrapper.eq("o_state", "0");
	List<DbOrder> list=dbOrderMapper.selectList(wrapper);
	if (list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "還沒有訂單");
}
}
