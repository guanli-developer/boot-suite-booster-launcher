package tech.guanli.boot.suite.booster.launcher.component.creator.business.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.component.creator.BasicCreator;
import tech.guanli.boot.suite.booster.launcher.model.template.business.model.MapperPackage;

@Component
public class MapperPackageCreator extends BasicCreator {

	@Override
	public void create() {
		File direcotory = new File(basePackageGenerator.getBasePackage() + File.separator + "mapper");
		if (!direcotory.exists() || !direcotory.isDirectory()) {
			direcotory.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(new File(basePackageGenerator.getBasePackage() + File.separator
				+ "mapper" + File.separator + "MapperPackage.java"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("MapperPackage.ftl");
			MapperPackage mapperPackage = new MapperPackage();
			mapperPackage.setBasePackage(configurationProperty.getRootPackage());
			template.process(mapperPackage, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
