
<#assign className=table.className>
<#assign classNameFirstLower=className?uncap_first>
<#assign classNameUnder=classNameFirstLower?replace('([A-Z])', '_$1', 'r')?lower_case >
package ${basepackage};

import com.ccjk.co3.BaseResourceService;
import hwp.sqlte.Page;
import hwp.sqlte.SqlBuilder;
import hwp.sqlte.SqlteTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}接口
 * @author ${author}
 */
@Service
public class ${className}Service extends BaseResourceService<Integer, ${className}>{

private static final String TABLE_NAME = "${table.sqlName}";

    public ${className}Service(SqlteTemplate db) {
        super(db);
    }

    @Override
    public Class<${className}> getResourceClass() {
            return ${className}.class;
    }

    @Override
    public void save(${className} ${classNameFirstLower}) {
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
     * @param sql 查询语句
     * @return  {@link ${className} ${className}}
     */
    public List<${className}> getList(SqlBuilder sql) {
        return db.query(sql).list(${className}.class);
    }

    /**
     * 根据sql查询列表
     *
     * @param from 页数
     * @param size 条数
     * @return  {@link ${className} ${className}}
     */
    public Page<${className}> getPage(Integer from, Integer size) {
        return db.queryPage(sql -> sql.from("${classNameUnder}").limit(from, size), ${className}::new);
    }

}
