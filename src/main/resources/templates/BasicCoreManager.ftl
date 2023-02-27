package ${basePackage}.core;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasicCoreManager<Id extends Serializable, Persistable extends tech.guanli.boot.internal.model.Persistable<Id>> {

	@Autowired
	protected CoreMapper<Id, Persistable> mapper;

}
 