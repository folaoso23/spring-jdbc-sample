package com.playground.jdbcplayground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaygroundController
{
    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    JdbcTemplate mysqlTemplate;

    @RequestMapping("/select")
    public void selectAllData()
    {
        // Call JdbcTemplate here
        System.out.println(mysqlTemplate.queryForList("select * from test_db.person").toString());
    }

    // Insert as POST Request?
    @RequestMapping("/insert")
    public void insertData()
    {
        mysqlTemplate.execute("INSERT INTO test_db.person (name,sex,birth) values (\"Tom Brady\",\"M\",\"1983-01-29\")");
    }


}
