package tech.guanli.boot.suite.booster.launcher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import tech.guanli.boot.suite.booster.launcher.configuration.BoosterLaunchConfigurationProperty;

@SpringBootApplication
@MapperScan(basePackageClasses = Application.class)
@EnableConfigurationProperties({ BoosterLaunchConfigurationProperty.class })
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
