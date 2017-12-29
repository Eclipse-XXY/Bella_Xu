package com.ctdcn.fsss.admin.common;

import java.util.Date;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

/**
 * 
 * @Description: 封装一个 ObjectMapper 给MappingJacksonHttpMessageConverter
 *               用来添加序列化，解决date转换json格式问题
 * @author zhaojimeng
 * @date 2014年6月23日 下午10:03:27
 * 
 */
public class DateObjectMapper extends ObjectMapper {
	public DateObjectMapper() {
		super();

		SimpleModule testModule = new SimpleModule("TestModule", new Version(0,
				0, 1, null));

		// // deserializers
		testModule.addDeserializer(Date.class, new JsonDateDeserializer(
				Date.class));

		// serializers
		testModule.addSerializer(Date.class, new JsonDateSerializer());

		registerModule(testModule);

		// add handler to handler unkonwn object property
		// getDeserializationConfig().addHandler(
		// new DeserializationUnknownPropertyHandler());

		// config to ignore unknown property
		configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
	}
}
