<#include "/variable.include">
<#assign className=table.className>
<#assign classNameFirstLower=className?uncap_first>
package ${basepackage}.${servicePackage};

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import ${basepackage}.pojo.entity.${className};
import ${basepackage}.pojo.dto.Save${className}DTO;
import ${basepackage}.pojo.dto.List${className}DTO;
import ${basepackage}.pojo.vo.${className}VO;
import ${basepackage}.pojo.dto.Update${className}DTO;
import ${basepackage}.pojo.vo.List${className}VO;
import ${basepackage}.pojo.vo.Get${className}VO;
import cn.github.zeroclian.jpa.CrudManager;
import java.util.List;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}服务层接口
 * @author ${author}
 * @version ${version}
 */
@Validated
public interface ${service} extends CrudManager<${className}, Integer> {

    /**
     * 查询${table.remarks?replace(';', '', 'r')?trim}列表
     * @param ${classNameFirstLower}Dto 查询实体对象
     */
    List<List${className}VO> list${className}(List${className}DTO ${classNameFirstLower}Dto);

    /**
     * 保存${table.remarks?replace(';', '', 'r')?trim}
     * @param save${className}Dto 保存实体对象
     */
    ${className}VO save${className}(@Valid Save${className}DTO save${className}Dto);

    /**
     * 更新${table.remarks?replace(';', '', 'r')?trim}
     * @param update${className}Dto 更新实体对象
     */
    ${className}VO update${className}(@Valid Update${className}DTO update${className}Dto,Integer ${classNameFirstLower}Id);

    /**
     * 根据${table.remarks?replace(';', '', 'r')?trim} ID 查找 ${table.remarks?replace(';', '', 'r')?trim}
     * @param ${classNameFirstLower}Id   ${table.remarks?replace(';', '', 'r')?trim} ID
     */
<#list table.columns as column>
    <#if column.pk>
    Get${className}VO get${className}(@NotNull(message = "${column.columnAlias?replace(" ", "")}不能为空") Integer ${classNameFirstLower}Id);
    </#if>
</#list>

    /**
     * 根据${table.remarks?replace(';', '', 'r')?trim} ID 删除 ${table.remarks?replace(';', '', 'r')?trim}
     * @param ${classNameFirstLower}Id   ${table.remarks?replace(';', '', 'r')?trim} ID
     */
<#list table.columns as column>
<#if column.pk>
    void deleteBy${className}Id(@NotNull(message = "${column.columnAlias?replace(" ", "")}不能为空") Integer ${classNameFirstLower}Id);
</#if>
</#list>

}
