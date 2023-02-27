package tech.guanli.boot.suite.booster.launcher.model.template.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Field {

	private String name;

	private String type;

	private Boolean nullable;

	private String comment;

}
