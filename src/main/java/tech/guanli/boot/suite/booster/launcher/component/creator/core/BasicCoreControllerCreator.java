package tech.guanli.boot.suite.booster.launcher.component.creator.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicCreator;
import tech.guanli.boot.suite.booster.launcher.model.template.core.controller.BasicCoreController;

@Component
public class BasicCoreControllerCreator extends BasicCreator {

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage());
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(
				new File(basePackageGenerator.getBasePackage() + "core" + File.separator
						+ "BasicCoreController.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("BasicCoreController.ftl");
			BasicCoreController basicCoreController = new BasicCoreController();
			basicCoreController.setBasePackage(configurationProperty.getRootPackage());
			template.process(basicCoreController, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
