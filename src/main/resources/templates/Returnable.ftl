package tech.guanli.demo.model.returnable;

<#list imports as import>
import ${import.fullClassName};
</#list>

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.guanli.boot.internal.model.Returnable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ${name}Returnable implements Returnable {

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
