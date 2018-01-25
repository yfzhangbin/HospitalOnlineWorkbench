package dao;

import model.Doctor;
import util.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 医生数据库访问类
 */
public class DoctorDao {

    /**
     * 新增
     * @param doctor
     */
    public void add(Doctor doctor) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into doctor (name, sex, birthday, phone, level, department_id, createtime, updatetime) values (?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, doctor.getName());
                preparedStatement.setString(2, doctor.getSex());
                preparedStatement.setDate(3, doctor.getBirthday());
                preparedStatement.setString(4, doctor.getPhone());
                preparedStatement.setString(5, doctor.getLevel());
                preparedStatement.setInt(6, doctor.getDepartmentId());
                preparedStatement.setDate(7, new java.sql.Date(new Date().getTime()));
                preparedStatement.setDate(8, new java.sql.Date(new Date().getTime()));
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
                PreparedStatement preparedStatement = connection.prepareStatement("delete from doctor where id=?");
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
     * @param doctor
     */
    public void update(Doctor doctor) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("update doctor set name=?, sex=?, birthday=?, phone=?, level=?, department_id=?, updatetime=? where id=?");
                preparedStatement.setString(1, doctor.getName());
                preparedStatement.setString(2, doctor.getSex());
                preparedStatement.setDate(3, doctor.getBirthday());
                preparedStatement.setString(4, doctor.getPhone());
                preparedStatement.setString(5, doctor.getLevel());
                preparedStatement.setInt(6, doctor.getDepartmentId());
                preparedStatement.setDate(7, new java.sql.Date(new Date().getTime()));
                preparedStatement.setInt(8, doctor.getId());
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
    public List<Doctor> getAll() {
        Connection connection = DbUtil.getConnection();
        List<Doctor> docs = new ArrayList<Doctor>();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from doctor");
                while (rs.next()) {
                    Doctor doc = new Doctor();
                    doc.setId(rs.getInt("id"));
                    doc.setName(rs.getString("name"));
                    doc.setSex(rs.getString("sex"));
                    doc.setBirthday(rs.getDate("birthday"));
                    doc.setPhone(rs.getString("phone"));
                    doc.setLevel(rs.getString("level"));
                    doc.setDepartmentId(rs.getInt("department_id"));
                    doc.setCreatetime(rs.getDate("createtime"));
                    doc.setUpdatetime(rs.getDate("updatetime"));
                    docs.add(doc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return docs;
    }

    /**
     * 查询单条
     * @param id
     * @return
     */
    public Doctor getById(int id) {
        Connection connection = DbUtil.getConnection();
        Doctor doc = new Doctor();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from doctor where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                doc.setId(rs.getInt("id"));
                doc.setName(rs.getString("name"));
                doc.setSex(rs.getString("sex"));
                doc.setBirthday(rs.getDate("birthday"));
                doc.setPhone(rs.getString("phone"));
                doc.setLevel(rs.getString("level"));
                doc.setDepartmentId(rs.getInt("department_id"));
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
