package tech.guanli.boot.suite.booster.launcher.component.creator.business.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicBusinessCreator;

@Component
public class ManagerCreator extends BasicBusinessCreator {

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage() + File.separator + "manager");
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(new File(basePackageGenerator.getBasePackage() + File.separator
				+ "manager" + File.separator + model.getName() + "Manager.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("Manager.ftl");
			template.process(model, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
