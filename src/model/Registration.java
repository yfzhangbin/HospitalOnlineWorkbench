package model;

import java.sql.Date;

/**
 * 挂号信息：关联后续诊断和检查信息
 */
public class Registration {
    private int id; // 编号
    private int patientId; // 病人编号
    private String patientName; // 病人姓名
    private int departmentId; // 科室编号
    private String departmentName; // 科室名称
    private int examinationId; // 检查编号
    private int diagnosisId; // 诊断编号
    private String status; // 就医状态：挂号、检查、诊断
    private Date createtime; // 挂号时间
    private Date updatetime; // 修改时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", examinationId=" + examinationId +
                ", diagnosisId=" + diagnosisId +
                ", status='" + status + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
