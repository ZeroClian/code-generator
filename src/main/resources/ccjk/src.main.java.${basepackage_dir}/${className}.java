<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>

package ${basepackage};

import com.ccjk.co3.Resource;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import hwp.sqlte.Column;
import hwp.sqlte.Table;


/**
 * ${table.remarks?replace(';', '', 'r')?trim}实体类
 * @author ${author}
 */
@Table(name = "${table.sqlName}" )
public class ${className} implements Resource {

<#list table.columns as column>
	<#if column.columnNameLower!='createTime' && column.columnNameLower!='updateTime'>
	/**
	 * ${column.columnAlias}<#if column.defaultValue!='null'>, 默认值为${column.defaultValue}</#if><#if !column.nullable>, 非空</#if>, ${column.sqlTypeName}
	 */
	<#if !column.nullable>@NotNull(message = "${column.columnAlias}不能为空")</#if>
	<#if enableColumnAnnotation=='true'>@Column(name = "${column.sqlName}")</#if>
	public ${column.simpleJavaType} ${column.columnNameLower?replace('^is', '', 'r')?uncap_first};
	</#if>
</#list>

}
