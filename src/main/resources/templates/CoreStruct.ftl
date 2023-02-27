package ${basePackage}.core;

import java.io.Serializable;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface CoreStruct<Payload extends tech.guanli.boot.internal.model.Payload<Id>, Returnable extends tech.guanli.boot.internal.model.Returnable, Id extends Serializable, Persistable extends tech.guanli.boot.internal.model.Persistable<Id>> {

	Returnable persistableToReturnable(Persistable persistable);

	@Mapping(target = "id", ignore = true)
	Persistable payLoadToPersistable(Payload payload);

	@Mapping(target = "id", ignore = true)
	void payLoadToPersistable(Payload payload, @MappingTarget Persistable persistable);

}
