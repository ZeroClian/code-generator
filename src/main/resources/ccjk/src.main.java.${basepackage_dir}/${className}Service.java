
<#assign className=table.className>
<#assign classNameFirstLower=className?uncap_first>
<#assign classNameUnder=classNameFirstLower?replace('([A-Z])', '_$1', 'r')?lower_case >
package ${basepackage};

import com.ccjk.co3.BaseResourceService;
import hwp.sqlte.SqlBuilder;
import hwp.sqlte.SqlteTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}接口
 * @author ${author}
 * @version ${version}
 */
@Service
public class ${className}Service extend BaseResourceService<Integer, ${className}>{

    public ${className}Service(SqlteTemplate db) {
        super(db);
    }

    @Override
    public Class<${className}> getResourceClass() {
            return ${className}.class;
    }

    @Override
    public void save(${className} ${classNameFirstLower}) {
        ${classNameFirstLower}.createdAt = LocalDateTime.now();
        super.save(${classNameFirstLower});
    }

    /**
     * 物理删除
     */
    @Override
    public void delete(${className} ${classNameFirstLower}) {
        db.delete(${classNameFirstLower});
    }

    /**
     * 根据sql查询列表
     *
     * @param sql 执行sql
     */
    public List<${className}> getList(SqlBuilder sql) {
        return db.query(sql).list(${className}.class);
    }

}
