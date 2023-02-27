package ${basePackage}.core;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import tech.guanli.boot.internal.model.implemention.ResponseData;

public abstract class BasicCoreController<Payload extends tech.guanli.boot.internal.model.Payload<Id>, Parameter extends tech.guanli.boot.internal.model.Parameter, Returnable extends tech.guanli.boot.internal.model.Returnable, Id extends Serializable, Persistable extends tech.guanli.boot.internal.model.Persistable<Id>> {

	@Autowired
	protected CoreService<Payload, Parameter, Returnable, Id, Persistable> service;

	protected tech.guanli.boot.internal.model.Returnable defaultCreate(Payload payload) {
		service.create(payload);
		return ResponseData.success();
	}

	protected tech.guanli.boot.internal.model.Returnable defaultDelete(Id id) {
		service.delete(id);
		return ResponseData.success();
	}

	protected tech.guanli.boot.internal.model.Returnable defaultUpdate(Id id, Payload payload) {
		payload.setId(id);
		service.update(payload);
		return ResponseData.success();
	}

	protected tech.guanli.boot.internal.model.Returnable defaultList(Integer pageNumber, Integer pageSize,
			Parameter parameter) {
		parameter.setPageNumber(pageNumber);
		parameter.setPageSize(pageSize);
		return ResponseData.success(service.list(parameter));
	}

	protected tech.guanli.boot.internal.model.Returnable defaultDetails(Id id) {
		return ResponseData.success(service.details(id));
	}
}
