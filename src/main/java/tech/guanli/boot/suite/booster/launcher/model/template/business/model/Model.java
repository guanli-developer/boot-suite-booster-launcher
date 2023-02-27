package tech.guanli.boot.suite.booster.launcher.model.template.business.model;

import java.util.List;
import java.util.Set;

import lombok.Data;
import tech.guanli.boot.suite.booster.launcher.model.template.business.Field;
import tech.guanli.boot.suite.booster.launcher.model.template.business.Import;

@Data
public class Model {

	private String tableName;

	private String idType;

	private String basePackage;

	private String comment;

	private String name;

	private String path;

	private Boolean autoIncrece;

	private Set<Import> imports;

	private List<Field> fields;

}
