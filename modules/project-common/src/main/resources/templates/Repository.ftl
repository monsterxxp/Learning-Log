package ${package_name}.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ${package_name}.model.${table_name};

/**
* 描述：${table_annotation} Repository接口
* @author ${author}
* @date ${date}
*/
@Repository
public interface ${table_name}Repository extends JpaRepository<${table_name}, String> {



}
