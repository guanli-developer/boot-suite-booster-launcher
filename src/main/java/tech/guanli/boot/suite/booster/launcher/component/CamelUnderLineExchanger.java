package tech.guanli.boot.suite.booster.launcher.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CamelUnderLineExchanger implements InitializingBean {

	private final Map<String, String> underLineCamelMap = new HashMap<>(36);

	private final Map<String, String> camelUnderLineMap = new HashMap<>(36);

	@Override
	public void afterPropertiesSet() throws Exception {
		for (char c = 'A'; c <= 'Z'; c++) {
			camelUnderLineMap.put(String.valueOf(c), "_" + String.valueOf(c).toLowerCase());
		}
		for (char c = 'a'; c <= 'z'; c++) {
			underLineCamelMap.put("_" + String.valueOf(c), String.valueOf(c).toUpperCase());
		}
	}

	public String underLineToCamel(String underLine) {
		String camel = underLine;
		for (Entry<String, String> entry : underLineCamelMap.entrySet()) {
			if (camel.contains(entry.getKey())) {
				camel = camel.replace(entry.getKey(), entry.getValue());
			}
		}
		return camel;
	}

	public String camelToUnderLine(String camel) {
		String underLine = camel;
		for (Entry<String, String> entry : camelUnderLineMap.entrySet()) {
			if (underLine.contains(entry.getKey())) {
				underLine = underLine.replace(entry.getKey(), entry.getValue());
			}
		}
		return underLine;
	}

	public String lowerCamelToUpperCamel(String lowerCamel) {
		return lowerCamel.substring(0, 1).toUpperCase() + lowerCamel.substring(1);
	}

	public String upperCamelToLowerCamel(String upperCamel) {
		return upperCamel.substring(0, 1).toLowerCase() + upperCamel.substring(1);
	}

}
