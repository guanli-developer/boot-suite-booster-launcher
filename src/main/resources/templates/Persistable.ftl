package ${basePackage}.model.persistable;

<#list imports as import>
import ${import.fullClassName};
</#list>

<#if autoIncrece == true>
import com.baomidou.mybatisplus.annotation.IdType;
</#if>
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.guanli.boot.internal.model.Persistable;

<#if comment?? && comment != "">
/**
 * ${comment}
 */
</#if>
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("${tableName}")
public class ${name}Persistable implements Persistable<${idType}> {

  <#list fields as field>
  <#if field.comment?? && field.comment != "">
  /**
   * ${field.comment}
   */
  </#if>
  <#if field.name == "id">
  @TableId<#if autoIncrece == true>(type = IdType.AUTO)</#if>
  </#if>
	private ${field.type} ${field.name};

  </#list>
}