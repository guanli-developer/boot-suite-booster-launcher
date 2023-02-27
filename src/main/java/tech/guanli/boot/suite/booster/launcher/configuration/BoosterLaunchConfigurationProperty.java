package tech.guanli.boot.suite.booster.launcher.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "tech.guanli.boot.booster-launch")
public class BoosterLaunchConfigurationProperty {

	private String projectOutputPath = "project";

	private String projectGroupId = "group";

	private String projectArtifactId = "artifact";

	private String projectVersion = "1.0.0-RELEASE";

	private String rootPackage = projectArtifactId;

	private String schema;

	private Boolean enableDevTool = true;


}
