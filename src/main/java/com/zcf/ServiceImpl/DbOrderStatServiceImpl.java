package com.zcf.ServiceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbOrderMapper;
import com.zcf.pojo.DbOrder;
import com.zcf.service.DbOrderStatService;
@Service
public class DbOrderStatServiceImpl extends ServiceImpl<DbOrderMapper, DbOrder> implements DbOrderStatService {
@Autowired
private DbOrderMapper dbOrderMapper;


Calendar ncalendar = Calendar.getInstance();
	@Override
	public Body statisH() {
		Integer count1=dbOrderMapper.onehour();
		Integer count2=dbOrderMapper.towhour()-count1;
		Integer count3=dbOrderMapper.threehour()-count1-count2;
		Integer count4=dbOrderMapper.fourhour()-count1-count2-count3;
		
		Map<Integer,Integer>map1=new HashMap<>();
		Map<Integer,Integer>map2=new HashMap<>();
		Map<Integer,Integer>map3=new HashMap<>();
		Map<Integer,Integer>map4=new HashMap<>();

		
		Integer hour1=ncalendar.get(Calendar.HOUR_OF_DAY);
		Integer hour2=ncalendar.get(Calendar.HOUR_OF_DAY)-1;
		Integer hour3=ncalendar.get(Calendar.HOUR_OF_DAY)-2;
		Integer hour4=ncalendar.get(Calendar.HOUR_OF_DAY)-3;
		
		map1.put(hour1, count1);
		map2.put(hour2, count2);
		map3.put(hour3, count3);
		map4.put(hour4, count4);
		
		List<Map<Integer,Integer>>list=new ArrayList<>();
		list.add(map4);
		list.add(map3);
		list.add(map2);
		list.add(map1);
		
		if(list.size()>0){
			
			return Body.newInstance(list);

	}
	return Body.BODY_400;


	}
	
	@Override
	public Body statisD() {	

		
		Integer count1=dbOrderMapper.todaycount();//今天的订单数量
		Integer count2=dbOrderMapper.oneday();//昨天的订单数量
		Integer count3=dbOrderMapper.towday();//两天前的订单数量
		Integer count4=dbOrderMapper.threeday();//三天前的订单数量
		Map<String,Integer>map1=new HashMap<>();
		Map<String,Integer>map2=new HashMap<>();
		Map<String,Integer>map3=new HashMap<>();
		Map<String,Integer>map4=new HashMap<>();

		Integer month=ncalendar.get(Calendar.MONTH)+1;//月份
		Integer day1=ncalendar.get(Calendar.DAY_OF_MONTH);
		Integer day2=ncalendar.get(Calendar.DAY_OF_MONTH)-1;
		Integer day3=ncalendar.get(Calendar.DAY_OF_MONTH)-2;
		Integer day4=ncalendar.get(Calendar.DAY_OF_MONTH)-3;

		String smonth=month.toString();
		
		String sday1=day1.toString();
		String date1 =smonth.concat("-").concat(sday1);
		map1.put(date1, count1);
		
		String sday2=day2.toString();
		String date2 =smonth.concat("-").concat(sday2);
		map2.put(date2, count2);
		
		String sday3=day3.toString();
		String date3 =smonth.concat("-").concat(sday3);
		map3.put(date3, count3);
		
		String sday4=day4.toString();
		String date4 =smonth.concat("-").concat(sday4);
		map4.put(date4, count4);
		
		List<Map<String,Integer>> list=new ArrayList<>();
		list.add(map4);
		list.add(map3);
		list.add(map2);
		list.add(map1);
		
		if(list.size()>0){
		
				return Body.newInstance(list);
	
		}
		return Body.BODY_400;
	}
}
