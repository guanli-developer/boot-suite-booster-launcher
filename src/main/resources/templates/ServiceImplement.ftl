package ${basePackage}.service.implement;

import org.springframework.stereotype.Service;

import ${basePackage}.core.BasicCoreService;
import ${basePackage}.model.payload.${name}Parameter;
import ${basePackage}.model.payload.${name}Payload;
import ${basePackage}.model.persistable.${name}Persistable;
import ${basePackage}.model.returnable.${name}Returnable;

@Service
public class ${name}Service extends BasicCoreService<${name}Payload, ${name}Parameter, ${name}Returnable, ${idType}, ${name}Persistable>
		implements ${basePackage}.service.${name}Service {

}
