package tech.guanli.boot.suite.booster.launcher.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("columns")
public class Column {

	private String tableSchema;

	private String tableName;

	private String columnName;

	private Long ordinalPosition;

	private String isNullable;

	private String dataType;

	private String columnComment;

}
