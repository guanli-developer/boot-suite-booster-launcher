package tech.guanli.boot.suite.booster.launcher.component.creator.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicCreator;
import tech.guanli.boot.suite.booster.launcher.model.template.core.service.BasicCoreService;

@Component
public class BasicCoreServiceCreator extends BasicCreator {

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage());
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(
				new File(basePackageGenerator.getBasePackage() + "core" + File.separator
						+ "BasicCoreService.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("BasicCoreService.ftl");
			BasicCoreService basicCoreService = new BasicCoreService();
			basicCoreService.setBasePackage(configurationProperty.getRootPackage());
			template.process(basicCoreService, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
