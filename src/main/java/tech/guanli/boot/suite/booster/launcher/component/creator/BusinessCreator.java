package tech.guanli.boot.suite.booster.launcher.component.creator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import tech.guanli.boot.suite.booster.launcher.component.CamelUnderLineExchanger;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.controller.ControllerCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.manager.ManagerCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.mapper.MapperCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.mapper.MapperPackageCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.mapstruct.StructCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.model.ModelCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.business.service.ServiceCreator;
import tech.guanli.boot.suite.booster.launcher.mapper.ColumnMapper;
import tech.guanli.boot.suite.booster.launcher.mapper.TableMapper;
import tech.guanli.boot.suite.booster.launcher.model.entity.Column;
import tech.guanli.boot.suite.booster.launcher.model.entity.Table;
import tech.guanli.boot.suite.booster.launcher.model.template.business.Field;
import tech.guanli.boot.suite.booster.launcher.model.template.business.Import;
import tech.guanli.boot.suite.booster.launcher.model.template.business.JdbcTypeJavaTypeMapping;
import tech.guanli.boot.suite.booster.launcher.model.template.business.model.Model;

@Component
public class BusinessCreator extends BasicCreator {

	@Autowired
	private CamelUnderLineExchanger exchanger;

	@Autowired
	private JdbcTypeJavaTypeMapping typeMapping;

	@Autowired
	private TableMapper tableMapper;

	@Autowired
	private ColumnMapper columnMapper;

	@Autowired
	private ModelCreator modelCreator;

	@Autowired
	private StructCreator structCreator;

	@Autowired
	private MapperCreator mapperCreator;

	@Autowired
	private ManagerCreator managerCreator;

	@Autowired
	private ServiceCreator serviceCreator;

	@Autowired
	private ControllerCreator controllerCreator;

	@Autowired
	private MapperPackageCreator mapperPackageCreator;

	@Override
	public void create() {
		List<Table> tables = tableMapper.selectList(
				Wrappers.lambdaQuery(Table.class).eq(Table::getTableSchema, configurationProperty.getSchema()));
		mapperPackageCreator.create();
		for (Table table : tables) {
			Model model = new Model();
			model.setAutoIncrece(Objects.nonNull(table.getAutoIncrement()));
			model.setBasePackage(configurationProperty.getRootPackage());
			model.setComment(table.getTableComment());
			model.setFields(new ArrayList<>());
			model.setImports(new HashSet<>());
			model.setName(exchanger.lowerCamelToUpperCamel(exchanger.underLineToCamel(table.getTableName())));
			model.setPath(exchanger.underLineToCamel(table.getTableName()));
			model.setTableName(table.getTableName());
			List<Column> columns = columnMapper.selectList(
					Wrappers.lambdaQuery(Column.class).eq(Column::getTableSchema, configurationProperty.getSchema())
							.eq(Column::getTableName, table.getTableName()).orderByAsc(Column::getOrdinalPosition));
			for (Column column : columns) {
				if (typeMapping.isImportType(column.getDataType())) {
					model.getImports().add(new Import(typeMapping.getImportType(column.getDataType())));
				}
				model.getFields()
						.add(new Field(exchanger.underLineToCamel(column.getColumnName()),
								typeMapping.getJavaType(column.getDataType()),
								Objects.equals("YES", column.getIsNullable()), column.getColumnComment()));
			}
			if (columns.size() > 0) {
				model.setIdType(typeMapping.getJavaType(columns.get(0).getDataType()));
			} else {
				model.setIdType("Long");
			}
			modelCreator.setModel(model);
			modelCreator.create();
			structCreator.setModel(model);
			structCreator.create();
			mapperCreator.setModel(model);
			mapperCreator.create();
			managerCreator.setModel(model);
			managerCreator.create();
			serviceCreator.setModel(model);
			serviceCreator.create();
			controllerCreator.setModel(model);
			controllerCreator.create();
		}
	}

}
