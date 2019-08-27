package com.lj.distributecache;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.service.ISystemParamsService;

/***
 * 从CC读取参数
 * @author danff
 *
 */
public class JedisConnectionFactoryFromCC extends JedisConnectionFactory{
	private ISystemParamsService systemParamService;

	public ISystemParamsService getSystemParamService() {
		return systemParamService;
	}

	public void setSystemParamService(ISystemParamsService systemParamService) {
		this.systemParamService = systemParamService;
		//-----从CC获取参数设置Redis Service--------
		FindSystemGroup fsg = new FindSystemGroup();
		fsg.setSystemAliasName("cc");
		fsg.setGroupName("redis");
		//----从CC获取参数组------------
		Map<String,String> fsgr = systemParamService.findSystemGroup(fsg).getGroupMaps();
		String ip = fsgr.get("ip");
		String port = fsgr.get("port");
		String timeout = fsgr.get("timeout");
		String password = fsgr.get("password");
		super.setHostName(ip);
		super.setPort(Integer.parseInt(port));
		super.setPassword(password);
		if(StringUtils.isNotEmpty(timeout)){//有timeout参数
			super.setTimeout(Integer.valueOf(timeout));
		}
	}

}
