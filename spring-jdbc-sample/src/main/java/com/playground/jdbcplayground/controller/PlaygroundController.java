package com.playground.jdbcplayground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PlaygroundController
{
    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlTemplate;

    @RequestMapping("/select")
    public ResponseEntity<String> selectAllData()
    {
        String query = "select * from test_db.person";
        List<Map<String, Object>> results = mysqlTemplate.queryForList(query);
        return new ResponseEntity<>(results.toString(), HttpStatus.OK);

    }

    @RequestMapping("/insert")
    public ResponseEntity<String> insertData(@RequestParam("name") String name, @RequestParam("gender") String gender, @RequestParam("birth") String birth )
    {
        String query = "INSERT INTO test_db.person (name,sex,birth) values (\"" + name + "\",\"" + gender + "\",\""+ birth +"\")";
        mysqlTemplate.execute(query);
        return new ResponseEntity<>("Data inserted.", HttpStatus.OK);
    }

    @RequestMapping("/delete")
    public ResponseEntity<String> deleteAllData()
    {
        mysqlTemplate.execute("DELETE FROM test_db.person");
        return new ResponseEntity<>("Data inserted.", HttpStatus.OK);
    }


}
