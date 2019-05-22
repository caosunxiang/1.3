package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFood;
import com.zcf.pojo.DbOrder;
import com.zcf.pojo.DbOrderFood;
import com.zcf.pojo.DbUserDiscounts;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.mapper.DbOrderFoodMapper;
import com.zcf.mapper.DbOrderMapper;
import com.zcf.mapper.DbStrolleyMapper;
import com.zcf.mapper.DbUserDiscountsMapper;
import com.zcf.service.DbOrderService;
import com.zcf.utils.JsonUtils;
import com.zcf.utils.StringHideUtils;
import com.zcf.utils.Timetool;
import com.zcf.websocket.WebSocket;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class DbOrderServiceImpl extends ServiceImpl<DbOrderMapper, DbOrder> implements DbOrderService {
	@Autowired
	private DbOrderMapper dbOrderMapper;
	@Autowired
	private DbOrderFoodMapper dbOrderFoodMapper;
	@Autowired
	private DbFoodMapper dbFoodMapper;
	@Autowired
	private DbUserDiscountsMapper userDiscountsMapper;
	@Autowired
	private DbStrolleyMapper dbStrolleyMapper;

	@Override
	public Body addorder(DbOrder dbOrder, String fid,String msg,String price,String st) {
		// 分割字符串填入集合
		List<String> list = StringHideUtils.divide(fid);
		List<String> list1 =StringHideUtils.divide(msg);
		List<String> list2 =StringHideUtils.divide(price);
		List<String> list3 =StringHideUtils.divide(st);
		// 添加订单
		Integer count = dbOrderMapper.insert(dbOrder);
		for (int i=0;i<list.size();i++) {
			// 为订单里的菜品添加月销售额
			DbFood dbFood = dbFoodMapper.selectById(list.get(i));
			Integer num = dbFood.getfMonth();
			dbFood.setfMonth(num++);
			// 把单独的菜品关联到订单中
			DbOrderFood entity = new DbOrderFood();
			entity.setOfFoodid(list.get(i));
			entity.setOfRemark(list1.get(i));
			entity.setOfPrice(list2.get(i));
			entity.setOfOrderid(dbOrder.getoId());
			dbOrderFoodMapper.insert(entity);
			dbStrolleyMapper.deleteById(list3.get(i));
			dbFoodMapper.updateById(dbFood);
		}
		if (count == 1) {
			return Body.newInstance(dbOrder);
		}
		return Body.newInstance(201, "添加失敗");
	}

	@Override
	public Body getone(String oid) {
		List<Map<String, Object>> list = dbOrderMapper.getone(oid);
		return Body.newInstance(list);
	}

	@Override
	public Body usedis(String oid, String did, String dtitle, BigDecimal dprice, BigDecimal res) {
		DbOrder dbOrder = dbOrderMapper.selectById(oid);
		BigDecimal totle = dbOrder.getoTotal();
		if (totle.compareTo(res) == -1) {
			return Body.newInstance(201, "條件不足無法使用");
		}
		dbOrder.setoDiscounts(did);
		dbOrder.setoDiscountsPrice(dprice);
		dbOrder.setoDiscountsRemark(dtitle);
		Integer count = dbOrderMapper.updateById(dbOrder);
		if (count == 1) {
			return Body.newInstance(dbOrder);
		}
		return Body.newInstance(201, "優惠券使用失敗");
	}

	@Override
	public Body order(String oid, String ostate) {
		DbOrder dbOrder = dbOrderMapper.selectById(oid);
		if (dbOrder.getoDiscountsPrice() != null) {
			dbOrder.setoTotal(dbOrder.getoTotal().subtract(dbOrder.getoDiscountsPrice()));
		}
		dbOrder.setoState(ostate);
		dbOrder.setoOvertime(Hutool.parseDateToString());
		Integer count = dbOrderMapper.updateById(dbOrder);
		if (count == 1) {
			if (ostate.equals("1")) {
				EntityWrapper<DbUserDiscounts> wrapper = new EntityWrapper<>();
				wrapper.eq("ud_userid", dbOrder.getOrderToUser());
				wrapper.eq("ud_discountsid", dbOrder.getoDiscounts());
				userDiscountsMapper.delete(wrapper);
				return Body.newInstance(202, "請到前台付款");
			} else if (ostate.equals("2")) {
				// 推送结账信息
				WebSocket socket = new WebSocket();
				Map<String, Object> msg = new HashMap<String, Object>();
				msg.put("touser", dbOrder.getOrderToShop());
				msg.put("data", dbOrder.getoStrolleyTable() + "需要結賬服務");
				socket.onMessage(JsonUtils.objectToJson(msg));
				EntityWrapper<DbUserDiscounts> wrapper = new EntityWrapper<>();
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
		EntityWrapper<DbOrder> wrapper = new EntityWrapper<>();
		wrapper.eq("order_to_shop", openid);
		wrapper.ne("o_state", "0");
		Integer count = dbOrderMapper.selectCount(wrapper);
		if (count != 0) {
			return Body.newInstance(count);
		}
		return Body.newInstance(201, "沒有已完成的訂單");
	}

	@Override
	public Body getbyuid(String uid) {
		List<Map<String, Object>> list = dbOrderMapper.getbyuid(uid);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}

	@Override
	public Body getbysid(String sid) {
		List<Map<String, Object>> list = dbOrderMapper.getbysid(sid);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}

	@Override
	public Body addtoorder(DbOrder dbOrder, String fid,String  message,String price,String st) {
		// 分割字符串填入集合
				List<String> list = StringHideUtils.divide(fid);
				List<String> list1 =StringHideUtils.divide(message);
				List<String> list2 =StringHideUtils.divide(price);
				List<String> list3 =StringHideUtils.divide(st);
				List<DbFood> dbFoods = new ArrayList<>();
				// 添加订单
				Integer count = dbOrderMapper.insert(dbOrder);
				for (int i=0;i<list.size();i++) {
					// 为订单里的菜品添加月销售额
					DbFood dbFood = dbFoodMapper.selectById(list.get(i));
					// 添加推送需要的菜品信息
					dbFoods.add(dbFood);
					Integer num = dbFood.getfMonth();
					dbFood.setfMonth(num++);
					// 把单独的菜品关联到订单中
					DbOrderFood entity = new DbOrderFood();
					entity.setOfFoodid(list.get(i));
					entity.setOfRemark(list1.get(i));
					entity.setOfPrice(list2.get(i));
					entity.setOfOrderid(dbOrder.getoId());
					dbOrderFoodMapper.insert(entity);
					dbStrolleyMapper.deleteById(list3.get(i));
					dbFoodMapper.updateById(dbFood);
				}
		if (count == 1) {
			WebSocket socket = new WebSocket();
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
		EntityWrapper<DbOrder> wrapper = new EntityWrapper<>();
		wrapper.eq("order_to_shop", sid);
		wrapper.eq("o_state", "0");
		List<DbOrder> list = dbOrderMapper.selectList(wrapper);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "還沒有訂單");
	}

	@Override
	public Body today() {
		List<DbOrder> list = dbOrderMapper.today();
		Map<String, Object> map = new HashMap<>();
		if (list.size() > 0) {
			BigDecimal money = new BigDecimal(0);
			BigDecimal avg = new BigDecimal(0);
			long time = 0;
			for (DbOrder dbOrder : list) {
				money = money.add(dbOrder.getoTotal());// 計算當日成交訂單金額
//				System.out.println(Hutool.parseStringToDate(dbOrder.getoTime()));
//				System.out.println(Hutool.parseStringToDate(dbOrder.getoOvertime()));
				Duration duration = Duration.between(Hutool.parseStringToDate(dbOrder.getoTime()),//获取两个时间相差多少
						Hutool.parseStringToDate(dbOrder.getoOvertime()));
				time=time+(duration.toMinutes());//取出对象中的分钟
//				System.out.println("两个时间相差："+time);
			}
			avg = money.divide(new BigDecimal(list.size()));// 計算當日訂單平均金額
			money.setScale(2, BigDecimal.ROUND_DOWN);
			avg.setScale(2, BigDecimal.ROUND_DOWN);
			map.put("money", money);
			map.put("avg", avg);
			map.put("time", time);
			return Body.newInstance(map);
		}
		return Body.newInstance(201, "今日尚無訂單");
	}
	@Override
	public Body finish(String oid) {
		List<Map<String, Object>>list=dbOrderMapper.finishone(oid);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "空訂單");
	}
	@Override
	public  Body getover(String sid) {
		EntityWrapper< DbOrder> wrapper=new EntityWrapper<>();
		wrapper.eq("order_to_shop", sid);
		wrapper.ne("o_state", 0);
		List<DbOrder>list=dbOrderMapper.selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "暫無已完成的訂單");
	}
	@Override
	public Body bytable(String table,String sid) {
		List<Map<String, Object>>list=dbOrderMapper.bytable(table, sid);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "尚無人員用餐");
	}
	@Override
	public  Body sevenago(){
		Map<String, Integer> map=dbOrderMapper.sevenago();
		if(map.size()>0) {
			return Body.newInstance(map);
			}
		return Body.newInstance(201, "服务器内部问题");
		}
	@Override
	public Body sevenhour() {
		Map<String,Integer> map=dbOrderMapper.sevenhour();
		if(map.size()>0) {
			return Body.newInstance(map);
		}
	return Body.newInstance(201, "服务器内部问题");
	}
}
