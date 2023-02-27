package tech.guanli.boot.suite.booster.launcher.component.creator.business.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicBusinessCreator;

@Component
public class ControllerCreator extends BasicBusinessCreator {

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage() + File.separator + "controller");
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(new File(basePackageGenerator.getBasePackage() + File.separator
				+ "controller" + File.separator + model.getName() + "Controller.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("Controller.ftl");
			template.process(model, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
