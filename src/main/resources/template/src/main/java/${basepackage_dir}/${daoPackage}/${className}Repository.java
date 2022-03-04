<#assign className = table.className>
package ${basepackage}.repository;

import ${basepackage}.pojo.entity.${className};
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${table.remarks?replace(';', '', 'r')?trim} 持久化层
 * @author ${author}
 * @version ${version}
 */
public interface ${className}Repository extends JpaRepository<${className}, Integer> {


}
