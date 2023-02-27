package tech.guanli.boot.suite.booster.launcher.component.creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.model.template.application.Application;

@Component
public class ApplicationCreator extends BasicCreator {

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage());
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(
				new File(basePackageGenerator.getBasePackage() + "Application.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("Application.ftl");
			Application application = new Application();
			application.setBasePackage(configurationProperty.getRootPackage());
			template.process(application, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
