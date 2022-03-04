<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#include "/entity.include">
package ${basepackage}.pojo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import cn.github.zeroclian.jpa.JPAManageable;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}实体类
 * @author ${author}
 * @version ${version}
 */
@Data
@Entity
@Table(name = "${table.sqlName}" )
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ${className} extends JPAManageable {

<#list table.columns as column>
	<#if column.columnNameLower!='id' && column.columnNameLower!='createTime' && column.columnNameLower!='updateTime'>
	/**
	 * ${column.columnAlias}<@defaultValue column/><#if !column.nullable>, 非空</#if>, ${column.sqlTypeName}
	 */
	<@columnAnnotation column/>
	private ${column.simpleJavaType} ${column.columnNameLower?replace('^is', '', 'r')?uncap_first};

	</#if>
</#list>

}
