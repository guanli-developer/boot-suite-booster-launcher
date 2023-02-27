package ${basePackage}.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ${name}StructDecorator implements ${name}Struct {

	@Autowired
	@Qualifier("delegate")
	private ${name}Struct delegate;

}
