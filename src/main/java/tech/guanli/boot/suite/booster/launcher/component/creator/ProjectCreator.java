package tech.guanli.boot.suite.booster.launcher.component.creator;

import java.io.File;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProjectCreator extends BasicCreator {
	@Override
	public void create() {
		File project = new File(configurationProperty.getProjectOutputPath());
		if (!project.exists() || !project.isDirectory()) {
			project.mkdirs();
			log.info("project directory has been created at {}", project.getAbsolutePath());
		} else if (project.list().length > 0) {
			log.warn("project directort is not empty");
		}
	}
}
