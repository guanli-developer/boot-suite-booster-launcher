package tech.guanli.boot.suite.booster.launcher.model.template.pom;

import java.util.List;

import lombok.Data;

@Data
public class Pom {
	private String groupId;

	private String artifactId;

	private String version;

	private String parentVersion;

	private List<Dependency> dependencies;
}
