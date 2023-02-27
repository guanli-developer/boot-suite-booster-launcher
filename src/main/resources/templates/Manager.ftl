package ${basePackage}.manager;

import org.springframework.stereotype.Service;

import ${basePackage}.core.BasicCoreManager;
import ${basePackage}.model.persistable.${name}Persistable;

@Service
public class ${name}Manager extends BasicCoreManager<${idType}, ${name}Persistable> {

}
