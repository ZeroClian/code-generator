
<#assign className=table.className>
<#assign classNameFirstLower=className?uncap_first>
<#assign classNameUnder=classNameFirstLower?replace('([A-Z])', '_$1', 'r')?lower_case >
package ${basepackage};

import com.ccjk.co3.ApiMessage;
import com.ccjk.co3.CrudApi;
import com.ccjk.co3.util.ValidationUtil;
import hwp.sqlte.SqlBuilder;
import io.javalin.http.Context;
import org.springframework.stereotype.Controller;
import java.util.List;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}接口
 * @author ${author}
 * @version ${version}
 */
@Controller
public class ${className}Api implements CrudApi {

    private final ${className}Service ${classNameFirstLower}Service;

    public ${className}Api(${className}Service ${classNameFirstLower}Service) {
        this.${classNameFirstLower}Service = ${classNameFirstLower}Service;
    }

    /**
     * 新增${table.remarks?replace(';', '', 'r')?trim}
     */
    @Override
    public void create(@NotNull Context context){
        ${className} ${classNameFirstLower} = context.bodyAsClass(${className}.class);
        ValidationUtil.validate(${classNameFirstLower});
        ${classNameFirstLower}Service.save(${classNameFirstLower});
        context.json(${classNameFirstLower});
    }

    /**
     * 更新${table.remarks?replace(';', '', 'r')?trim}
     */
    @Override
    @Transactional
    public void update(@NotNull Context context){
        ${className} update = context.bodyAsClass(${className}.class);
        ValidationUtil.validate(update);
        ${className} ${classNameFirstLower} = ${classNameFirstLower}Service.mustGet(update.id);
        update.id = ${classNameFirstLower}.id;
        ${classNameFirstLower}Service.update(update);
        context.json(ApiMessage.OK);
    }

    /**
     * 获取${table.remarks?replace(';', '', 'r')?trim}
     */
    @Override
    public void getOne(@NotNull Context context){
        ${className} ${classNameFirstLower} = ${classNameFirstLower}Service.mustGet(Integer.valueOf(context.pathParam("id")));
        context.json(${classNameFirstLower});
    }

    /**
     * 查询${table.remarks?replace(';', '', 'r')?trim}列表
     */
    public void getList(@NotNull Context context){
        Integer from = context.queryParamAsClass("from", Integer.class)
        .check(it -> it > 0, "from 必须大于 0")
        .get();
        Integer size = context.queryParamAsClass("size", Integer.class)
        .check(it -> it >= 10, "size 必须大于或等于 10")
        .get();
        SqlBuilder sql = new SqlBuilder();
        sql.from("${className}").limit(from, size);
        List<${className}> list = ${classNameFirstLower}Service.getList(sql);
        context.json(list);
    }

    /**
     * 删除${table.remarks?replace(';', '', 'r')?trim}
     */
    @Override
    public void delete(@NotNull Context context){
        ${className} ${classNameFirstLower} = ${classNameFirstLower}Service.mustGet(Integer.valueOf(context.pathParam("id")));
        ${classNameFirstLower}Service.delete(${classNameFirstLower});
        context.json(ApiMessage.Ok);
    }

}
