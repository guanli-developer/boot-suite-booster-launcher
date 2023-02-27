package tech.guanli.boot.suite.booster.launcher.component.creator.business.mapstruct;

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
public class StructCreator extends BasicBusinessCreator {

	@Autowired
	private StructDecoratorCreator decoratorCreator;

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage() + File.separator + "mapstruct");
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(new File(basePackageGenerator.getBasePackage() + File.separator
				+ "mapstruct" + File.separator + model.getName() + "Struct.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("Struct.ftl");
			template.process(model, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		decoratorCreator.setModel(model);
		decoratorCreator.create();
	}

}
