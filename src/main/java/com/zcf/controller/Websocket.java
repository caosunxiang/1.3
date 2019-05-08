package com.zcf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zcf.common.json.Body;
import com.zcf.utils.JsonUtils;
import com.zcf.websocket.WebSocket;
/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/Websocket")
@CrossOrigin
public class Websocket {
/**
 * 加水服務
 * @param table
 * @param sid
 * @return
 */
	@PostMapping("/water")
public Body watersocket(String table ,String sid) {
	 WebSocket websocket=new WebSocket();
	 Map<String, Object> msg=new HashMap<>();
	 msg.put("touser", sid);
		msg.put("data", table+"需要加水服務");
		websocket.onMessage(JsonUtils.objectToJson(msg));
		return Body.newInstance(201, "需求已發送，請耐心等待");
}
	/**
	 * 加水服務
	 * @param table
	 * @param sid
	 * @return
	 */
		@PostMapping("/worker")
	public Body workersocket(String table ,String sid) {
		 WebSocket websocket=new WebSocket();
		 Map<String, Object> msg=new HashMap<>();
		 msg.put("touser", sid);
			msg.put("data", table+"需要人員服務");
			websocket.onMessage(JsonUtils.objectToJson(msg));
			return Body.newInstance(201, "需求已發送，請耐心等待");
	}
		
}
