package tech.guanli.boot.suite.booster.launcher.component.creator.business.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicBusinessCreator;

@Component
public class ServiceCreator extends BasicBusinessCreator {

	@Autowired
	private ServiceImplementCreator implementCreator;

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage() + File.separator + "service");
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(new File(basePackageGenerator.getBasePackage() + File.separator
				+ "service" + File.separator + model.getName() + "Service.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("Service.ftl");
			template.process(model, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		implementCreator.setModel(model);
		implementCreator.create();
	}

}
