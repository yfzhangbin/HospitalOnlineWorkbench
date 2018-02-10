package dao;

import model.Patient;
import util.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 患者管理-数据库访问类
 */
public class PatientDao {

    /**
     * 新增
     * @param patient
     */
    public void add(Patient patient) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into patient (name, sex, birthday, phone, createtime, updatetime) values (?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, patient.getName());
                preparedStatement.setString(2, patient.getSex());
                preparedStatement.setDate(3, patient.getBirthday());
                preparedStatement.setString(4, patient.getPhone());
                preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
                preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
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
                PreparedStatement preparedStatement = connection.prepareStatement("delete from patient where id=?");
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
     * @param patient
     */
    public void update(Patient patient) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("update patient set name=?, sex=?, birthday=?, phone=?, updatetime=? where id=?");
                preparedStatement.setString(1, patient.getName());
                preparedStatement.setString(2, patient.getSex());
                preparedStatement.setDate(3, patient.getBirthday());
                preparedStatement.setString(4, patient.getPhone());
                preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
                preparedStatement.setInt(6, patient.getId());
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
    public List<Patient> getAll() {
        Connection connection = DbUtil.getConnection();
        List<Patient> results = new ArrayList<Patient>();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from patient");
                while (rs.next()) {
                    Patient doc = new Patient();
                    doc.setId(rs.getInt("id"));
                    doc.setName(rs.getString("name"));
                    doc.setSex(rs.getString("sex"));
                    doc.setBirthday(rs.getDate("birthday"));
                    doc.setPhone(rs.getString("phone"));
                    doc.setCreatetime(rs.getDate("createtime"));
                    doc.setUpdatetime(rs.getDate("updatetime"));
                    results.add(doc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return results;
    }

    /**
     * 查询单条
     * @param id
     * @return
     */
    public Patient getById(int id) {
        Connection connection = DbUtil.getConnection();
        Patient doc = new Patient();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from patient where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                doc.setId(rs.getInt("id"));
                doc.setName(rs.getString("name"));
                doc.setSex(rs.getString("sex"));
                doc.setBirthday(rs.getDate("birthday"));
                doc.setPhone(rs.getString("phone"));
                doc.setCreatetime(rs.getDate("createtime"));
                doc.setUpdatetime(rs.getDate("updatetime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return doc;
    }

}
