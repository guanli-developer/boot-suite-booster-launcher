package ${basePackage}.model.payload;

<#list imports as import>
import ${import.fullClassName};
</#list>

import lombok.Data;
import tech.guanli.boot.internal.model.Payload;

<#if comment?? && comment != "">
/**
 * ${comment}
 */
</#if>
@Data
public class ${name}Payload implements Payload<${idType}> {

	private static final long serialVersionUID = 1L;

  <#list fields as field>
  <#if field.comment?? && field.comment != "">
  /**
   * ${field.comment}
   */
  </#if> 
	private ${field.type} ${field.name};

  </#list>
}
