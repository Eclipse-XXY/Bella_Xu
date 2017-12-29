package com.ctdcn.fsss.admin.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description: 日期 转换json时格式化工具
 * @author zhaojimeng
 * @date 2014年6月23日 下午8:13:58
 * 
 */
@Component
public class JsonDateSerializer extends JsonSerializer<Date> {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public void serialize(Date date, JsonGenerator gen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		// TODO Auto-generated method stub

		String formattedDate = dateFormat.format(date);

		gen.writeString(formattedDate);
	}

}
