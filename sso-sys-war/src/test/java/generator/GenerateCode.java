package generator;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.ConfigGenerator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Author: D.Yang
 * Email: koyangslash@gmail.com
 * Date: 16/10/9
 * Time: 上午11:05
 * Describe: 代码生成器配置
 */
public class GenerateCode {

    /* 生成代码包名 */
    private static final String PACKAGE_NAME = "com.sso.sys.mybatis";
    
    private static final String SERVICE_PACKAGE_NAME = "com.sso.sys";
    /* 生成代码模块名 */
    private static final String MODEL_NAME = "user";

    public static void main(String[] args) {

        /* 获取 JDBC 配置文件 */
        Properties props = getProperties();

        /* 配置 Mybatis-Plus 代码生成器 */
        ConfigGenerator cg = new ConfigGenerator();

        /* Mysql 数据库相关配置 */
        cg.setDbDriverName("com.mysql.jdbc.Driver");
        cg.setDbUrl(props.getProperty("jdbc.url"));
        cg.setDbUser(props.getProperty("jdbc.username"));
        cg.setDbPassword(props.getProperty("jdbc.password"));

        /* 设置数据库前缀（例如`mp_user`生成实体类，false 为 MpUser.java , true 为 User.java）*/
        cg.setDbPrefix(true);

         /*
         * true 表示数据库设置全局下划线命名规则，默认 false
		 * ------------------------------------------------------------------------------------
		 * 【 开启该设置实体可无 @TableId(value = "test_id") 字段映射，启动配置对应也要开启 true 设置 】
		 */
        cg.setDbColumnUnderline(false);

        /*
         * 表主键 ID 生成类型, 自增该设置无效。
		 * <p>
		 * IdType.AUTO 			数据库ID自增
		 * IdType.INPUT			用户输入ID
		 * IdType.ID_WORKER		全局唯一ID，内容为空自动填充（默认配置）
		 * IdType.UUID			全局唯一ID，内容为空自动填充
		 * </p>
		 */
        cg.setIdType(IdType.ID_WORKER);

        String[] tables = {"sys_user"};
        cg.setTableNames(tables);
        /* 生成文件保存位置 */
        cg.setSaveDir(getRootPath() + "/src/main/java/");

        /* 生成代码包路径 */
        cg.setEntityPackage(PACKAGE_NAME + ".model." + MODEL_NAME); //entity 实体包路径
        cg.setMapperPackage(PACKAGE_NAME + ".mapper." + MODEL_NAME); //mapper 映射文件路径
        cg.setXmlPackage(PACKAGE_NAME+".xml." + MODEL_NAME); //xml层路径
        cg.setServicePackage(SERVICE_PACKAGE_NAME+".service." + MODEL_NAME); //service 层路径

        /* 生成代码 */
        AutoGenerator.run(cg);
    }

    /**
     * 获取配置文件
     *
     * @return 配置Props
     */
    private static Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/property/data-sources.properties");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 获取项目根路径
     *
     * @return 项目路径
     */
    private static String getRootPath() {
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseFile;
    }
}
