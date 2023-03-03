package tech.guanli.boot.suite.booster.launcher.component.creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tech.guanli.boot.suite.booster.launcher.model.template.pom.Dependency;
import tech.guanli.boot.suite.booster.launcher.model.template.pom.Pom;

@Component
public class PomCreator extends BasicCreator {

	@Override
	public void create() {
		try (FileWriter fileWriter = new FileWriter(
				new File(configurationProperty.getProjectOutputPath() + File.separator + "pom.xml"));) {
			Configuration configuration = configurationFactory.createConfiguration();
			Template template = configuration.getTemplate("pom.ftl");
			Pom pom = new Pom();
			pom.setGroupId(configurationProperty.getProjectGroupId());
			pom.setArtifactId(configurationProperty.getProjectArtifactId());
			pom.setVersion(configurationProperty.getProjectVersion());
			pom.setDependencies(new ArrayList<>());
			List<Dependency> dependencies = pom.getDependencies();
			if (configurationProperty.getEnableDevTool()) {
				dependencies.add(new Dependency("org.springframework.boot", "spring-boot-devtools"));
			}
			dependencies.add(new Dependency("org.springframework.boot", "spring-boot-starter-web"));
			dependencies.add(new Dependency("tech.guanli.boot.suite", "internal-model"));
			dependencies.add(new Dependency("tech.guanli.boot.suite", "validate-spring-boot-starter"));

			template.process(pom, fileWriter);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
