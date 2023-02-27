package tech.guanli.boot.suite.booster.launcher.component;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import tech.guanli.boot.suite.booster.launcher.configuration.BoosterLaunchConfigurationProperty;

@Component
public class BasePackageGenerator implements InitializingBean {

	@Autowired
	private BoosterLaunchConfigurationProperty configurationProperty;

	@Getter
	private String basePackage;

	@Override
	public void afterPropertiesSet() throws Exception {
		StringBuilder basePackageBuilder = new StringBuilder(configurationProperty.getProjectOutputPath());
		basePackageBuilder.append(File.separator);
		basePackageBuilder.append("src");
		basePackageBuilder.append(File.separator);
		basePackageBuilder.append("main");
		basePackageBuilder.append(File.separator);
		basePackageBuilder.append("java");
		basePackageBuilder.append(File.separator);
		String[] directories = configurationProperty.getRootPackage().split("\\.");
		for (String directory : directories) {
			basePackageBuilder.append(directory);
			basePackageBuilder.append(File.separator);
		}
		basePackage = basePackageBuilder.toString();
	}

}
