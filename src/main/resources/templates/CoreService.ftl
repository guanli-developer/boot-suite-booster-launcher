package ${basePackage}.core;

import java.io.Serializable;

import tech.guanli.boot.internal.model.implemention.PageData;

public interface CoreService<Payload extends tech.guanli.boot.internal.model.Payload<Id>, Parameter extends tech.guanli.boot.internal.model.Parameter, Returnable extends tech.guanli.boot.internal.model.Returnable, Id extends Serializable, Persistable extends tech.guanli.boot.internal.model.Persistable<Id>> {

	void create(Payload payload);

	void delete(Id id);

	void update(Payload payload);

	PageData<Returnable> list(Parameter parameter);

	Returnable details(Id id);

}
