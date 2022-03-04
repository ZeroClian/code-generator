<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
package ${basepackage}.pojo.dto;

import lombok.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}实体类
 * @author ${author}
 * @version ${version}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Update${className}DTO {

<#list table.columns as column>
<#if column.columnNameLower!='id' && column.columnNameLower!='createTime' && column.columnNameLower!='updateTime' && column.columnNameLower!='organizationId'>
	/**
	 * ${column.columnAlias}
	 */
	<@generateValidField column/>
</#if>
</#list>

}
