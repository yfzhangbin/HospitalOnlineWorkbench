package dao;

import model.Registration;
import util.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationDao {

    /**
     * 新增
     * @param registration
     */
    public void add(Registration registration) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into registration (patient_id, department_id, examination_id, diagnosis_id, status, createtime, updatetime) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, registration.getPatientId());
                preparedStatement.setInt(2, registration.getDepartmentId());
                preparedStatement.setInt(3, registration.getExaminationId());
                preparedStatement.setInt(4, registration.getDiagnosisId());
                preparedStatement.setString(5, registration.getStatus());
                preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
                preparedStatement.setDate(7, new java.sql.Date(new Date().getTime()));
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
                PreparedStatement preparedStatement = connection.prepareStatement("delete from registration where id=?");
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
     * @param registration
     */
    public void update(Registration registration) {
        Connection connection = DbUtil.getConnection();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("update registration set examination_id=?, diagnosis_id=?, status=?, updatetime=? where id=?");
                preparedStatement.setInt(1, registration.getExaminationId());
                preparedStatement.setInt(2, registration.getDiagnosisId());
                preparedStatement.setString(3, registration.getStatus());
                preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
                preparedStatement.setInt(5, registration.getId());
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
    public List<Registration> getAll(String status) {
        Connection connection = DbUtil.getConnection();
        List<Registration> results = new ArrayList<Registration>();
        try {
            if (connection != null) {
                PreparedStatement preparedStatement;
                if (status != null) {
                    preparedStatement = connection.prepareStatement("select a.*, b.name as patient_name, c.name as department_name from registration a, patient b, department c where a.patient_id = b.id and a.department_id = c.id and status=?");
                    preparedStatement.setString(1, status);
                } else {
                    preparedStatement = connection.prepareStatement("select a.*, b.name as patient_name, c.name as department_name from registration a, patient b, department c where a.patient_id = b.id and a.department_id = c.id");
                }
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Registration doc = new Registration();
                    doc.setId(rs.getInt("id"));
                    doc.setPatientId(rs.getInt("patient_id"));
                    doc.setPatientName(rs.getString("patient_name"));
                    doc.setDepartmentId(rs.getInt("department_id"));
                    doc.setDepartmentName(rs.getString("department_name"));
                    doc.setExaminationId(rs.getInt("examination_id"));
                    doc.setDiagnosisId(rs.getInt("diagnosis_id"));
                    doc.setStatus(rs.getString("status"));
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
    public Registration getById(int id) {
        Connection connection = DbUtil.getConnection();
        Registration doc = new Registration();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.*, b.name as patient_name, c.name as department_name from registration a, patient b, department c where a.id=? and a.patient_id = b.id and a.department_id = c.id");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                doc.setId(rs.getInt("id"));
                doc.setPatientId(rs.getInt("patient_id"));
                doc.setPatientName(rs.getString("patient_name"));
                doc.setDepartmentId(rs.getInt("department_id"));
                doc.setDepartmentName(rs.getString("department_name"));
                doc.setExaminationId(rs.getInt("examination_id"));
                doc.setDiagnosisId(rs.getInt("diagnosis_id"));
                doc.setStatus(rs.getString("status"));
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
