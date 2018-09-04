package com.sl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * 用于在junit启动时加载spring容器
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
//指定junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-redis.xml"})
public class BaseTest {

}
