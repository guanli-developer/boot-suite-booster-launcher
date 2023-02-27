package ${basePackage}.mapstruct;

import org.mapstruct.Builder;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import ${basePackage}.core.CoreStruct;
import ${basePackage}.model.payload.${name}Payload;
import ${basePackage}.model.persistable.${name}Persistable;
import ${basePackage}.model.returnable.${name}Returnable;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
@DecoratedWith(${name}StructDecorator.class)
public interface ${name}Struct extends CoreStruct<${name}Payload, ${name}Returnable, ${idType}, ${name}Persistable> {

}
