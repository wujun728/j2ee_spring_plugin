package ${packageName};
<#if isAutoImport?exists && isAutoImport==true>
import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Maps;
import io.github.wujun728.db.Db;
import io.github.wujun728.db.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
</#if>
/**
 * @description ${classInfo.classComment}
 * @author ${authorName}
 * @date ${.now?string('yyyy-MM-dd')}
 */
@RestController
@RequestMapping("/${classInfo.className?uncap_first}")
public class ${classInfo.className}Controller {

    /**
    * 新增或编辑
    */
    @PostMapping("/save")
    public Object save(${classInfo.className} ${classInfo.className?uncap_first}){
        ${classInfo.className} ${classInfo.className?uncap_first}One= Db.findById(${classInfo.className}.class,${classInfo.className?uncap_first}.getId());
        if(${classInfo.className?uncap_first}One!=null){
            Db.updateEntity(${classInfo.className?uncap_first});
            return ("编辑成功");
        }else{
            Db.saveEntity(${classInfo.className?uncap_first});
            return ("保存成功");
        }
    }

    /**
    * 删除
    */
    @PostMapping("/delete")
    public Object delete(int id){
        ${classInfo.className} ${classInfo.className?uncap_first}One= Db.findById(${classInfo.className}.class,id);
        if(${classInfo.className?uncap_first}One!=null){
            Db.deleteById("${classInfo.tableName}",id);
            return ("删除成功");
        }else{
            return ("没有找到该对象");
        }
    }

    /**
    * 查询
    */
    @PostMapping("/find")
    public Object find(int id){
        ${classInfo.className} ${classInfo.className?uncap_first}One= Db.findById(${classInfo.className}.class,id);
        if(${classInfo.className?uncap_first}One!=null){
            return (${classInfo.className?uncap_first}One);
        }else{
            return ("没有找到该对象");
        }
    }

    /**
    * 分页查询
    */
    @PostMapping("/list")
    public Object list(${classInfo.className} ${classInfo.className?uncap_first}) {
        List<${classInfo.className}> datas = Db.findEntityList(${classInfo.className}.class,"select * from ${classInfo.tableName}");
        return datas;
    }

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public Object page(${classInfo.className} ${classInfo.className?uncap_first},
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Map params = BeanUtil.beanToMap(${classInfo.className?uncap_first},true,true);
        Page<${classInfo.className}> page= Db.findPages(${classInfo.className}.class,pageNumber,pageSize, params);
        return (page);
    }


}

