package com.eo2pd.ch4.jdbc;

import com.eo2pd.ch4.dao.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("AccountDao")
public class AccountDaoImpl implements IAccountDao{
    // 声明 JdbcTemplate 属性及其 setter 方法
    @Autowired

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // 添加账户
    public int addAccount(Account account) {
// 定义 SQL
        String sql = "insert into account(username,balance) value(?,?)";
// 定义数组来存放 SQL 语句中的参数
        Object[] obj = new Object[] {
                account.getUsername(),
                account.getBalance()
        };
// 执行添加操作，返回的是受 SQL 语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;

    }
    // 更新账户
    public int updateAccount(Account account) {
// 定义 SQL
        String sql = "update account set username=?,balance=? where id = ?";
// 定义数组来存放 SQL 语句中的参数
        Object[] params = new Object[] {
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
// 执行添加操作，返回的是受 SQL 语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, params);
        return num;
    }
    // 删除账户
    public int deleteAccount(int id) {
// 定义 SQL
        String sql = "delete from account where id = ? ";
// 执行添加操作，返回的是受 SQL 语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }
    // 通过 id 查询账户数据信息
    public Account findAccountById(int id) {
//定义 SQL 语句
        String sql = "select * from account where id = ?";
// 创建一个新的 BeanPropertyRowMapper 对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);
// 将 id 绑定到 SQL 语句中，并通过 RowMapper 返回一个 Object 类型的单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
    // 查询所有账户信息
    public List<Account> findAllAccount() {
// 定义 SQL 语句
        String sql = "select * from account";
// 创建一个新的 BeanPropertyRowMapper 对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);
// 执行静态的 SQL 查询，并通过 RowMapper 返回结果
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
