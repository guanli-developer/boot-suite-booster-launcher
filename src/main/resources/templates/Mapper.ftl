package ${basePackage}.mapper;

import org.apache.ibatis.annotations.Mapper;

import ${basePackage}.core.CoreMapper;
import ${basePackage}.model.persistable.${name}Persistable;

@Mapper
public interface ${name}Mapper extends CoreMapper<${idType}, ${name}Persistable> {

}
