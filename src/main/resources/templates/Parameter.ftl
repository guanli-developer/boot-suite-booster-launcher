package ${basePackage}.model.payload;

<#list imports as import>
import ${import.fullClassName};
</#list>

import lombok.Data;
import tech.guanli.boot.internal.model.Parameter;

<#if comment?? && comment != "">
/**
 * ${comment}
 */
</#if>
@Data
public class ${name}Parameter implements Parameter {

	private Integer pageSize;

	private Integer pageNumber;

  <#list fields as field>
  <#if field.comment?? && field.comment != "">
  /**
   * ${field.comment}
   */
  </#if>
	private ${field.type} ${field.name};

  </#list>
}
