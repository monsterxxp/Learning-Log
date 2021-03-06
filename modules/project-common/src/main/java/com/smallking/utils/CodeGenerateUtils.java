package com.smallking.utils;

import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：代码生成器
 * Created by Ay on 2017/5/1.
 */
public class CodeGenerateUtils {

    private final String AUTHOR = "WangShaoXiong";
    private final String CURRENT_DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    /** 表名称 **/
    private final String tableName = "sys_parameter";
    private final String packageName = "com.smallking";
    private final String tableAnnotation = "参数配置";
    private final String URL = "jdbc:mysql://localhost:3306/smallking";
    private final String USER = "root";
    private final String PASSWORD = "888888";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String diskPath = "E://CodeGenerate//";
    private final String changeTableName = replaceUnderLineAndUpperCase(tableName);

    public Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception{
        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
        codeGenerateUtils.generate();
    }

    public void generate() throws Exception{
        try {
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = null;
            resultSet = databaseMetaData.getColumns(null,"%", tableName,"%");
            //生成Mapper文件
            generateMapperFile(resultSet);
            //生成Dao文件
            generateDaoFile(resultSet);
            //生成Repository文件
            generateRepositoryFile(resultSet);
            //生成服务层接口文件
            generateServiceInterfaceFile(resultSet);
            //生成服务实现层文件
            generateServiceImplFile(resultSet);
            //生成Controller层文件
            generateControllerFile(resultSet);
            //生成DTO文件
            generateDTOFile(resultSet);
            //生成前端VUE API文件
            generateApilFile(resultSet);
            List<DBColumnDefinition> columnDefinitionList = new ArrayList<>();
            DBColumnDefinition columnDefinition = null;
            while(resultSet.next()){
                //id字段略过
                if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
                columnDefinition = new DBColumnDefinition();
                columnDefinition.setColumnName(resultSet.getString("COLUMN_NAME"));
                columnDefinition.setColumnType(resultSet.getString("TYPE_NAME"));
                columnDefinition.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
                columnDefinition.setColumnComment(resultSet.getString("REMARKS"));
                columnDefinitionList.add(columnDefinition);
            }
            //生成Model文件
            generateModelFile(resultSet, columnDefinitionList);
            //生成前端VUE Index.vue文件
            generateIndexFile(resultSet, columnDefinitionList);
            //生成前端VUE FormDialog.vue文件
            generateFormFile(resultSet, columnDefinitionList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{

        }
    }

    private void generateModelFile(ResultSet resultSet, List<DBColumnDefinition> columnDefinitionList) throws Exception{

        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);

        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnDefinitionList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    private void generateIndexFile(ResultSet resultSet, List<DBColumnDefinition> columnDefinitionList) throws Exception{

        final String suffix = ".vue";
        final String path = diskPath + "index" + suffix;
        final String templateName = "Index.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnDefinitionList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    private void generateFormFile(ResultSet resultSet, List<DBColumnDefinition> columnDefinitionList) throws Exception{

        final String suffix = ".vue";
        final String path = diskPath + "FormDialog" + suffix;
        final String templateName = "FormDialog.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnDefinitionList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    private void generateApilFile(ResultSet resultSet) throws Exception{
        final String suffix = ".js";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Api.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateDTOFile(ResultSet resultSet) throws Exception{
        final String suffix = "DTO.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "DTO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateControllerFile(ResultSet resultSet) throws Exception{
        final String suffix = "Controller.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateServiceImplFile(ResultSet resultSet) throws Exception{
        final String suffix = "ServiceImpl.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateServiceInterfaceFile(ResultSet resultSet) throws Exception{
        final String prefix = "I";
        final String suffix = "Service.java";
        final String path = diskPath + prefix + changeTableName + suffix;
        final String templateName = "ServiceInterface.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateRepositoryFile(ResultSet resultSet) throws Exception{
        final String suffix = "Repository.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Repository.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateDaoFile(ResultSet resultSet) throws Exception{
        final String suffix = "DAO.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "DAO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    private void generateMapperFile(ResultSet resultSet) throws Exception{
        final String suffix = "Mapper.xml";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("table_annotation",tableAnnotation);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }

    public String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }

}









