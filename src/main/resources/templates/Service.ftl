package ${basePackage}.service;

import ${basePackage}.core.CoreService;
import ${basePackage}.model.payload.${name}Parameter;
import ${basePackage}.model.payload.${name}Payload;
import ${basePackage}.model.persistable.${name}Persistable;
import ${basePackage}.model.returnable.${name}Returnable;

public interface ${name}Service
		extends CoreService<${name}Payload, ${name}Parameter, ${name}Returnable, ${idType}, ${name}Persistable> {

}
