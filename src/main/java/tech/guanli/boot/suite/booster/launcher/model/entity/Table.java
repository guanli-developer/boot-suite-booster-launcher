package tech.guanli.boot.suite.booster.launcher.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("tables")
public class Table {

	private String tableName;

	private Long autoIncrement;

	private String tableComment;

	private String tableSchema;

}
