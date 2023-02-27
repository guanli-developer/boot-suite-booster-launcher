package tech.guanli.boot.suite.booster.launcher.model.template.pom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Dependency {

	@NonNull
	private String groupId;

	@NonNull
	private String artifactId;

	private String version;

}
