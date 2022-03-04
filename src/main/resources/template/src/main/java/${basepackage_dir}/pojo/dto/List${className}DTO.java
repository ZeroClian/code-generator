<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
package ${basepackage}.pojo.dto;

import lombok.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}查询参数类
 * @author ${author}
 * @version ${version}
 */
@Data
public class List${className}DTO {


}
