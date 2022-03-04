<#include "/variable.include">
<#assign className=table.className>
<#assign classNameFirstLower=className?uncap_first>
<#assign classNameUnder=classNameFirstLower?replace('([A-Z])', '_$1', 'r')?lower_case >
package ${basepackage}.controller;

import org.springframework.web.bind.annotation.*;
import ${basepackage}.${servicePackage}.${className}${serviceSuffix};
import ${basepackage}.pojo.dto.Save${className}DTO;
import ${basepackage}.pojo.dto.List${className}DTO;
import ${basepackage}.pojo.vo.${className}VO;
import ${basepackage}.pojo.dto.Update${className}DTO;
import ${basepackage}.pojo.vo.List${className}VO;
import ${basepackage}.pojo.vo.Get${className}VO;
import java.util.List;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}接口
 * @author ${author}
 * @version ${version}
 */
@RestController
@RequestMapping("/${classNameUnder}")
public class ${className}Controller {

    private final ${className}${serviceSuffix} ${(className+serviceSuffix)?uncap_first};

    public ${className}Controller(${service} ${classNameFirstLower}Manager) {
        this.${classNameFirstLower}Manager = ${classNameFirstLower}Manager;
    }

    /**
     * 查询${table.remarks?replace(';', '', 'r')?trim}列表
     * @TODO
     * @param ${classNameFirstLower}Dto 查询实体对象
     */
    @GetMapping
    public List<List${className}VO> list${className}(List${className}DTO ${classNameFirstLower}Dto){
        return ${classNameFirstLower}Manager.list${className}(${classNameFirstLower}Dto);
    }

    /**
     * 新增${table.remarks?replace(';', '', 'r')?trim}
     * @TODO
     * @param save${className}Dto 保存实体对象
     */
    @PostMapping
    public ${className}VO save${className}(@RequestBody Save${className}DTO save${className}Dto){
        return ${classNameFirstLower}Manager.save${className}(save${className}Dto);
    }

    /**
     * 更新${table.remarks?replace(';', '', 'r')?trim}
     * @TODO
     * @param update${className}Dto 更新实体对象
     */
    @PutMapping("/{${classNameFirstLower}Id}")
    public ${className}VO update${className}(@RequestBody Update${className}DTO update${className}Dto,@PathVariable Integer ${classNameFirstLower}Id){
        return ${classNameFirstLower}Manager.update${className}(update${className}Dto,${classNameFirstLower}Id);
    }

    /**
     * 获取${table.remarks?replace(';', '', 'r')?trim}
     * @TODO
     * @param ${classNameFirstLower}Id   ${table.remarks?replace(';', '', 'r')?trim} ID
     */
    @GetMapping("/{${classNameFirstLower}Id}")
    <#list table.columns as column>
        <#if column.pk>
    public Get${className}VO get${className}(@PathVariable Integer ${classNameFirstLower}Id){
        </#if>
    </#list>
        return ${classNameFirstLower}Manager.get${className}(${classNameFirstLower}Id);
    }

    /**
     * 删除${table.remarks?replace(';', '', 'r')?trim}
     * @TODO
     * @param ${classNameFirstLower}Id   ${table.remarks?replace(';', '', 'r')?trim} ID
     */
    @DeleteMapping("/{${classNameFirstLower}Id}")
    <#list table.columns as column>
        <#if column.pk>
    public void deleteBy${className}Id(@PathVariable Integer ${classNameFirstLower}Id){
        </#if>
    </#list>
        ${classNameFirstLower}Manager.deleteBy${className}Id(${classNameFirstLower}Id);
    }

}
