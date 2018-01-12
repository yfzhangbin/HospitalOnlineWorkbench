package dao;

import model.Department;
import util.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 科室数据库访问类
 */
public class DepartmentDao {

    /**
     * 新增
     * @param dep
     */
    public void add(Department dep) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into department(name, address, createtime, updatetime) values (?, ?, ?, ?)");
                preparedStatement.setString(1, dep.getName());
                preparedStatement.setString(2, dep.getAddress());
                preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from department where id=?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
    }

    /**
     * 修改
     * @param dep
     */
    public void update(Department dep) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("update department set name=?, address=?, updatetime=? where id=?");
                preparedStatement.setString(1, dep.getName());
                preparedStatement.setString(2, dep.getAddress());
                preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
                preparedStatement.setInt(4, dep.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
    }

    /**
     * 查询全部
     * @return
     */
    public List<Department> getAll() {
        Connection connection = DbUtil.getConnection();
        List<Department> deps = new ArrayList<Department>();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from department");
                while (rs.next()) {
                    Department dep = new Department();
                    dep.setId(rs.getInt("id"));
                    dep.setName(rs.getString("name"));
                    dep.setAddress(rs.getString("address"));
                    dep.setCreatetime(rs.getDate("createtime"));
                    dep.setUpdatetime(rs.getDate("updatetime"));
                    deps.add(dep);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return deps;
    }

    /**
     * 查询单条
     * @param id
     * @return
     */
    public Department getById(int id) {
        Connection connection = DbUtil.getConnection();
        Department dep = new Department();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from department where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                dep.setId(rs.getInt("id"));
                dep.setName(rs.getString("name"));
                dep.setAddress(rs.getString("address"));
                dep.setCreatetime(rs.getDate("createtime"));
                dep.setUpdatetime(rs.getDate("updatetime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return dep;
    }

}
