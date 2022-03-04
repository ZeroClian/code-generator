<#include "/variable.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
package ${basepackage}.${servicePackage}.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ${basepackage}.pojo.entity.${className};
import ${basepackage}.management.${className}Manager;
import ${basepackage}.${daoPackage}.${className}Repository;
import ${basepackage}.pojo.dto.Save${className}DTO;
import ${basepackage}.pojo.dto.Update${className}DTO;
import ${basepackage}.pojo.dto.List${className}DTO;
import ${basepackage}.pojo.vo.List${className}VO;
import ${basepackage}.pojo.vo.${className}VO;
import ${basepackage}.pojo.vo.Get${className}VO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}服务层实现
 * @author ${author}
 * @version ${version}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ${servicePrefix}${className}${serviceSuffix} implements ${service} {


    private final ${className}Repository ${classNameFirstLower}Repository;

    @Override
    public CrudRepository<${className}, Integer> getRepository() {
        return this.${classNameFirstLower}Repository;
    }

    @Override
    public List<List${className}VO> list${className}(List${className}DTO ${classNameFirstLower}Dto){
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${className}VO save${className}(Save${className}DTO save${className}Dto){
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${className}VO update${className}(Update${className}DTO update${className}Dto,Integer ${classNameFirstLower}Id){
        throw new UnsupportedOperationException("未实现");
    }

<#list table.columns as column>
    <#if column.pk>
    @Override
    public Get${className}VO get${className}(Integer ${classNameFirstLower}Id){
    </#if>
</#list>
        throw new UnsupportedOperationException("未实现");
    }

<#list table.columns as column>
<#if column.pk>
    @Override
    public void deleteBy${className}Id(Integer ${classNameFirstLower}Id){
</#if>
</#list>
        throw new UnsupportedOperationException("未实现");
    }

}
