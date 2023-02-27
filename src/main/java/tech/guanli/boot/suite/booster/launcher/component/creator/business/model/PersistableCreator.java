package tech.guanli.boot.suite.booster.launcher.component.creator.business.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicBusinessCreator;

@Component
public class PersistableCreator extends BasicBusinessCreator {

	@Override
	public void create() {
		File direcotory = new File(
				basePackageGenerator.getBasePackage() + File.separator + "model" + File.separator + "persistable");
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(new File(basePackageGenerator.getBasePackage() + File.separator
				+ "model" + File.separator + "persistable" + File.separator + model.getName() + "Persistable.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("Persistable.ftl");
			template.process(model, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
