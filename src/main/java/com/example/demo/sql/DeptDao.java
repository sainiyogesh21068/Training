package com.example.demo.sql;

import com.example.demo.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DeptDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Collection<Dept> findAll(){
        List<Dept> deptList = new ArrayList<>();
        deptList = jdbcTemplate.query("Select * from dept", new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet resultSet, int i) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptId(resultSet.getInt("dept_id"));
                dept.setDeptName(resultSet.getString("dept_name"));
                return dept;
            }
        });
        return deptList;
    }

    public Collection<Dept> findById(Integer id){
        List<Dept> deptList = new ArrayList<>();
//        MapSqlParameterSource params = new MapSqlParameterSource().addValue("dept_id",id);
        deptList = jdbcTemplate.query( "Select * from dept where dept_id = ?", new Object[] {id}, new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet resultSet, int i) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptId(resultSet.getInt("dept_id"));
                dept.setDeptName(resultSet.getString("dept_name"));
                return dept;
            }
        });
        return deptList;
    }

    public boolean saveDept(Dept dept){
        String insert = "Insert into dept values(?,?)";
        int result = jdbcTemplate.update(insert, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,dept.getDeptId());
                preparedStatement.setString(2,dept.getDeptName());
            }
        });
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean delDept(int id){
        String delete = "Delete from dept where dept_id=?";
        int result = jdbcTemplate.update(delete, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,id);
            }
        });
        if(result>0){
            return true;
        }
        return false;
    }
}
