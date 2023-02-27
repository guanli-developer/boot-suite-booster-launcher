package tech.guanli.boot.suite.booster.launcher.model.template.business;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class JdbcTypeJavaTypeMapping implements InitializingBean {

	private Map<String, String> basicMap;

	private Map<String, String> importMap;

	public String getJavaType(String jdbcType) {
		return basicMap.get(jdbcType);
	}

	public Boolean isImportType(String jdbcType) {
		return importMap.containsKey(jdbcType);
	}

	public String getImportType(String jdbcType) {
		return importMap.get(jdbcType);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		basicMap = new HashMap<>();
		basicMap.put("int", "Integer");
		basicMap.put("bigint", "Long");
		basicMap.put("float", "Float");
		basicMap.put("double", "Double");
		basicMap.put("decimal", "BigDecimal");
		basicMap.put("timestamp", "Date");
		basicMap.put("datetime", "Date");
		basicMap.put("tinyint", "Boolean");
		basicMap.put("char", "String");
		basicMap.put("varchar", "String");
		basicMap.put("tinytext", "String");
		basicMap.put("text", "String");
		basicMap.put("mediumtext", "String");
		basicMap.put("longtext", "String");
		importMap = new HashMap<>();
		importMap.put("decimal", "java.math.BigDecimal");
		importMap.put("timestamp", "java.util.Date");
		importMap.put("datetime", "java.util.Date");
	}

}
