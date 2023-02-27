package ${basePackage}.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import tech.guanli.boot.internal.model.implemention.PageData;

public abstract class BasicCoreService<Payload extends tech.guanli.boot.internal.model.Payload<Id>, Parameter extends tech.guanli.boot.internal.model.Parameter, Returnable extends tech.guanli.boot.internal.model.Returnable, Id extends Serializable, Persistable extends tech.guanli.boot.internal.model.Persistable<Id>>
		implements CoreService<Payload, Parameter, Returnable, Id, Persistable> {

	@Autowired
	protected CoreMapper<Id, Persistable> mapper;

	@Autowired
	protected BasicCoreManager<Id, Persistable> manager;

	@Autowired
	protected CoreStruct<Payload, Returnable, Id, Persistable> struct;

	protected PageData<Returnable> list(Parameter parameter, QueryWrapper<Persistable> queryWrapper) {
		Page<Persistable> data = mapper.selectPage(new Page<>(parameter.getPageNumber(), parameter.getPageSize()),
				queryWrapper);
		PageData<Returnable> pageData = new PageData<>();
		pageData.setData(new ArrayList<>()).setPageNumber(parameter.getPageNumber())
				.setPageSize(parameter.getPageSize()).setTotal(data.getTotal()).setTotalPage(data.getPages());
		data.getRecords().forEach(persistable -> {
			pageData.getData().add(struct.persistableToReturnable(persistable));
		});
		return pageData;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void create(Payload payload) {
		mapper.insert(struct.payLoadToPersistable(payload));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Id id) {
		mapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(Payload payload) {
		Optional.ofNullable(mapper.selectById(payload.getId())).ifPresent(persistable -> {
			struct.payLoadToPersistable(payload, persistable);
			mapper.updateById(persistable);
		});
	}

	@Override
	public PageData<Returnable> list(Parameter parameter) {
		Page<Persistable> data = mapper.selectPage(new Page<>(parameter.getPageNumber(), parameter.getPageSize()),
				Wrappers.emptyWrapper());
		PageData<Returnable> pageData = new PageData<>();
		pageData.setData(new ArrayList<>()).setPageNumber(parameter.getPageNumber())
				.setPageSize(parameter.getPageSize()).setTotal(data.getTotal()).setTotalPage(data.getPages());
		data.getRecords().forEach(persistable -> {
			pageData.getData().add(struct.persistableToReturnable(persistable));
		});
		return pageData;
	}

	@Override
	public Returnable details(Id id) {
		return struct.persistableToReturnable(mapper.selectById(id));
	}
}
