package ${basePackage}.core;

import java.io.Serializable;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CoreMapper<Id extends Serializable, Persistable extends tech.guanli.boot.internal.model.Persistable<Id>>
		extends BaseMapper<Persistable> {

}
