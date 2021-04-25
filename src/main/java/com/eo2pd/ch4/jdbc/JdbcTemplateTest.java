package com.eo2pd.ch4.jdbc;

import com.eo2pd.ch4.dao.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    public void mainTest() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double)");
        System.out.println("账户表 account 创建成功");
    }
    @Test
    public void addAccountTest() {
// 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
// 获取 AccountDao 实例

        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
// 创建 Account 对象，并向 Account 对象中添加数据
        Account account = new Account();
        account.setUsername("tom");

        account.setBalance(1000.00);
// 执行 addAccount()方法，并获取返回结果
        int num = accountDao.addAccount(account);
        if (num > 0) {
            System.out.println("成功插入了" + num + "条数据！");
        } else {
            System.out.println("插入操作执行失败！");
        }
    }
    @Test
    public void updateAccountTest() {
// 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
// 获取 AccountDao 实例
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
// 创建 Account 对象，并向 Account 对象中添加数据
        Account account = new Account();
        account.setId(1);
        account.setUsername("tom");
        account.setBalance(2000.00);
// 执行 updateAccount()方法，并获取返回结果
        int num = accountDao.updateAccount(account);
        if (num > 0) {
            System.out.println("成功修改了" + num + "条数据！");
        } else {
            System.out.println("修改操作执行失败！");
        }
    }
    @Test
    public void deleteAccountTest() {
// 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
// 获取 AccountDao 实例
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
// 执行 deleteAccount()方法，并获取返回结果
        int num = accountDao.deleteAccount(1);
        if (num > 0) {
            System.out.println("成功删除了" + num + "条数据！");
        } else {
            System.out.println("删除操作执行失败！");

        }
    }
}
