/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GetHired.model;

/**
 *
 * @author Adita Maharjan
 * Lmu Id: 23048638
 */
public class GetHiredModel {
    private String UserName;
    private String UserAddress;
    private String UserContactNo;
    private String UserDOB;
    private String UserGender;
    private String UserEmail;
    private String UserQualification;
    private String UserYearsOfExperience;
    
    private int CompanyId;
    private String CompanyName;
    private String CompanyLocation;
    private String CompanyContact;
    private String JobVacancyStatus;
    
    private int JobId;
    private String JobName;
    private String JobType;
    private String JobLocation;
    private int  JobSalary;
    private String  JobDeadline;
    private String  JobQualification;
    private String  JobCompanyName;

    public GetHiredModel(String UserName, String UserAddress, String UserContactNo, String UserDOB, String UserGender, String UserEmail, String UserQualification, String UserYearsOfExperience) {
        this.UserName = UserName;
        this.UserAddress = UserAddress;
        this.UserContactNo = UserContactNo;
        this.UserDOB = UserDOB;
        this.UserGender = UserGender;
        this.UserEmail = UserEmail;
        this.UserQualification = UserQualification;
        this.UserYearsOfExperience = UserYearsOfExperience;
    }

    public GetHiredModel(int CompanyId, String CompanyName, String CompanyLocation, String CompanyContact,String JobVacancyStatus) {
        this.CompanyId = CompanyId;
        this.CompanyName = CompanyName;
        this.CompanyLocation = CompanyLocation;
        this.CompanyContact = CompanyContact;
        this.JobVacancyStatus=JobVacancyStatus;
    }

    public GetHiredModel(int JobId, String JobName, String JobType, String JobLocation, int JobSalary, String JobDeadline, String JobQualification, String JobCompanyName) {
        this.JobId = JobId;
        this.JobName = JobName;
        this.JobType = JobType;
        this.JobLocation = JobLocation;
        this.JobSalary = JobSalary;
        this.JobDeadline = JobDeadline;
        this.JobQualification = JobQualification;
        this.JobCompanyName = JobCompanyName;
    }

    public GetHiredModel(String UserName, String UserAddress, String UserContactNo, String UserQualification, int JobId) {
        this.UserName = UserName;
        this.UserAddress = UserAddress;
        this.UserContactNo = UserContactNo;
        this.UserQualification = UserQualification;
        this.JobId = JobId;
    }
    

    public String getUserName() {
        return UserName;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public String getUserContactNo() {
        return UserContactNo;
    }

    public String getUserDOB() {
        return UserDOB;
    }

    public String getUserGender() {
        return UserGender;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserQualification() {
        return UserQualification;
    }

    public String getUserYearsOfExperience() {
        return UserYearsOfExperience;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getCompanyLocation() {
        return CompanyLocation;
    }

    public String getCompanyContact() {
        return CompanyContact;
    }

    public String getJobVacancyStatus() {
        return JobVacancyStatus;
    }

    public int getJobId() {
        return JobId;
    }

    public String getJobName() {
        return JobName;
    }

    public String getJobType() {
        return JobType;
    }

    public String getJobLocation() {
        return JobLocation;
    }

    public int getJobSalary() {
        return JobSalary;
    }

    public String getJobDeadline() {
        return JobDeadline;
    }

    public String getJobQualification() {
        return JobQualification;
    }

    public String getJobCompanyName() {
        return JobCompanyName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setUserAddress(String UserAddress) {
        this.UserAddress = UserAddress;
    }

    public void setUserContactNo(String UserContactNo) {
        this.UserContactNo = UserContactNo;
    }

    public void setUserDOB(String UserDOB) {
        this.UserDOB = UserDOB;
    }

    public void setUserGender(String UserGender) {
        this.UserGender = UserGender;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public void setUserQualification(String UserQualification) {
        this.UserQualification = UserQualification;
    }

    public void setUserYearsOfExperience(String UserYearsOfExperience) {
        this.UserYearsOfExperience = UserYearsOfExperience;
    }

    public void setCompanyId(int CompanyId) {
        this.CompanyId = CompanyId;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setCompanyLocation(String CompanyLocation) {
        this.CompanyLocation = CompanyLocation;
    }

    public void setCompanyContact(String CompanyContact) {
        this.CompanyContact = CompanyContact;
    }

    public void setJobVacancyStatus(String JobVacancyStatus) {
        this.JobVacancyStatus = JobVacancyStatus;
    }

    public void setJobId(int JobId) {
        this.JobId = JobId;
    }

    public void setJobName(String JobName) {
        this.JobName = JobName;
    }

    public void setJobType(String JobType) {
        this.JobType = JobType;
    }

    public void setJobLocation(String JobLocation) {
        this.JobLocation = JobLocation;
    }

    public void setJobSalary(int JobSalary) {
        this.JobSalary = JobSalary;
    }

    public void setJobDeadline(String JobDeadline) {
        this.JobDeadline = JobDeadline;
    }

    public void setJobQualification(String JobQualification) {
        this.JobQualification = JobQualification;
    }

    public void setJobCompanyName(String JobCompanyName) {
        this.JobCompanyName = JobCompanyName;
    }
    
}
