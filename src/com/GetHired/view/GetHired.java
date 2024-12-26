/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GetHired.view;
import com.GetHired.model.GetHiredModel;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 *@author Adita Maharjan Lmu Id: 23048638
 */
public class GetHired extends javax.swing.JFrame {
    private java.awt.CardLayout cardLayout;
    private LinkedList<GetHiredModel> joblist=new LinkedList<>();
    private LinkedList<GetHiredModel> applicationList=new LinkedList<>();
    private LinkedList<GetHiredModel> companyList=new LinkedList<>();
    
    

    /**
     * Creates new form GetHired
     */
    public GetHired() {
        initComponents();
        initializeLayout();
        loadJobinitialdata();
        loadApplicationInitialData();
        loadCompanyInitialData();
        
         
    }
   private void loadScreen(String screenName) {
        cardLayout.show(getContentPane(), screenName);
    }
   private void initializeLayout() {
        cardLayout = new java.awt.CardLayout();
        getContentPane().setLayout(cardLayout);

        // Add panels with unique identifiers
         getContentPane().add(pnlLogin, "LoginScreen");
         getContentPane().add(pnlAdminMain, "AdminScreen");
         getContentPane().add(pnlRegister,"RegisterScreen");
         getContentPane().add(pnlFindAJob, "JobScreen");
         getContentPane().add(pnlWelcome, "WelcomeScreen");
         getContentPane().add(pnlMainFindACompany, "CompanyScreen");
         getContentPane().add(pnlMainBuildProfile, "ProfileScreen");

        // Start with the login screen
        loadScreen("LoginScreen");
    }
   public void loadJobToTable(){
     DefaultTableModel model = (DefaultTableModel) tblAddJob.getModel();
    model.setRowCount(0);
    for (GetHiredModel job:joblist){
        
        model.addRow(new Object[]{job.getJobId() ,  job.getJobName(), job.getJobType(),job.getJobLocation() ,job.getJobSalary(),job.getJobDeadline(),  job.getJobQualification(),job.getCompanyName()
        });
        
    }}
   public void loadJobinitialdata(){
       GetHiredModel Job1=new GetHiredModel(001, "Technical Assistant","Full-Time", "Kathmandu", 10000, "2025/01/30","Bachlors in Technical Studies", "Technical Axis Pvt.Ltd");
        GetHiredModel Job2=new GetHiredModel(002, "Civil Engineer","Full-Time", "Bhaktapur", 550000, "2025/02/30","Bachlors in Engineering", "Civil Homes");
        GetHiredModel Job3=new GetHiredModel(003, "Teacher","Part-Time", "Lalitpur", 10000, "2025/01/10","Bachlors in Arts", "Prerana Vidyshram");
        joblist.add(Job1);
        joblist.add(Job2);
        joblist.add(Job3);
        loadJobToTable();
   }
     public void loadCompanyToTable(){
     DefaultTableModel model = (DefaultTableModel) TblFindACompany.getModel();
    model.setRowCount(0);
    for (GetHiredModel Company:companyList){
        model.addRow(new Object[]{Company.getCompanyId(),Company.getCompanyName(),Company.getCompanyLocation(),Company.getCompanyContact(),Company.getJobVacancyStatus()});
    }}
       
    public void loadCompanyInitialData(){
GetHiredModel Company1=new GetHiredModel(1,"DigitalAge Nepal", "Patan", "9876579432","Not Available");
GetHiredModel Company2=new GetHiredModel(2,"Prerana Vidyshram","Godawari","01-5678543","Available");
GetHiredModel Company3=new GetHiredModel(3,"Civil Homes","Bhaktapur","01-7665624","Available");
companyList.add(Company1);
companyList.add(Company2);
companyList.add(Company3);
loadCompanyToTable();
}

     public void loadApplicationsToTable(){
     DefaultTableModel model = (DefaultTableModel) tblViewApplication.getModel();
    model.setRowCount(0);
    for (GetHiredModel application:applicationList){
        model.addRow(new Object[]{application.getUserName(),application.getUserAddress(),application.getUserContactNo(), application.getUserQualification(),application.getJobId()});
 }}
      public void loadApplicationInitialData(){
        GetHiredModel Application1=new GetHiredModel("Sina Shrestha","Lalitpur","9865748323", "Bachlors in Arts",003);
        GetHiredModel Application2=new GetHiredModel("Rubina Magar","Kathmandu","9887676457", "Bachlors in Technical Studies",001);
        GetHiredModel Application3=new GetHiredModel("Roshan Ghimire","Bhaktapur","9856748932", "Bachlors in Engineering",002);
        applicationList.add(Application1);
        applicationList.add(Application2);
        applicationList.add(Application3);
        loadApplicationsToTable();
} 
    
    private boolean addJob() {
    int JobId=Integer.parseInt(txtFldJobId.getText()) ;
    String JobName=txtFldJobTitle.getText(); 
    String JobType=txtFldJobType.getText();
    String JobLocation=txtFldJobLocation.getText();
    int Salary=Integer.parseInt(txtFldSalary.getText());
    String Deadline=txtFldDeadline.getText();
    String Qualification=txtFldQualification.getText();
    String CompanyName=txtFldCompanyNameAddJob.getText();
    if (txtFldJobId.getText().isEmpty()||txtFldJobTitle.getText().isEmpty()||txtFldJobType.getText().isEmpty()||txtFldJobLocation.getText().isEmpty()||txtFldSalary.getText().isEmpty()
        ||txtFldDeadline.getText().isEmpty()||txtFldQualification.getText().isEmpty()||txtFldCompanyNameAddJob.getText().isEmpty()){
    JOptionPane.showMessageDialog(this,"Please Fill All The Fields,Job NOt Added!!","NOT-Sucessful",JOptionPane.ERROR_MESSAGE);
    }
    else{
    GetHiredModel job=new GetHiredModel( JobId, JobName, JobType, JobLocation,Salary, Deadline,Qualification, CompanyName);
        joblist.add(job);
        loadJobToTable();
    return true;
    }
    return false;
    }
private boolean deletedJob(int JobId){
    for (GetHiredModel job:joblist){
        if(job.getJobId()==JobId){
            joblist.remove(job);
            loadJobToTable();
            return true;
        }
       
    }
    loadJobToTable();
     return false;
   
    }
private Boolean updateJob(GetHiredModel job){
        int JobID=job.getJobId();
        for (GetHiredModel jobupdate:joblist){
          if(JobID==jobupdate.getJobId()){
             jobupdate.setJobName(job.getJobName());
             jobupdate.setJobLocation(job.getJobLocation());
             jobupdate.setJobDeadline(job.getJobDeadline());
             jobupdate.setJobLocation(job.getJobLocation());
             jobupdate.setJobQualification(job.getJobQualification());
             jobupdate.setJobSalary(job.getJobSalary());
             jobupdate.setJobType(job.getJobType());
             jobupdate.setJobCompanyName(job.getJobCompanyName());
             loadJobToTable();
              return true;
              }
        }
    loadJobToTable();
     return false;

}


    private void addCompany(GetHiredModel Company) {
        companyList.add(Company);
         loadCompanyToTable();
        }
    
    private boolean deletedCompany(int CompanyId){
        
    for (GetHiredModel company:companyList){
        
        if(company.getCompanyId()==CompanyId){
            companyList.remove(company);
            loadCompanyToTable();
            return true;
        }
       
    }
    loadCompanyToTable();
     return false;
   
    }
    private Boolean updateCompany(GetHiredModel company){
        int ID=company.getCompanyId();
        for (GetHiredModel Companyupdate:companyList){
          if(ID==Companyupdate.getCompanyId()){
            Companyupdate.setCompanyName(company.getCompanyName());
            Companyupdate.setCompanyLocation(company.getCompanyLocation());
            Companyupdate.setCompanyContact(company.getCompanyContact());
            Companyupdate.setJobVacancyStatus(company.getJobVacancyStatus());
             loadCompanyToTable();
              return true;
              }
        }
    loadJobToTable();
     return false;}
    private boolean addApplication() {
        loadApplicationsToTable();
         int JobId=Integer.parseInt(txtFieldJobId.getText());
        String Name=txtFieldFullName.getText();
        String Qualification=txtFieldQualification.getText();
        String Address=txtFieldAddress.getText();
        String Contact=txtFieldContactNo.getText();
        if(txtFieldJobId.getText().isEmpty()||
                txtFieldFullName.getText().isEmpty()||
                txtFieldQualification.getText().isEmpty()||
                txtFieldAddress.getText().isEmpty()||
               txtFieldContactNo.getText().isEmpty()){
        return false;
    }
        else{
        GetHiredModel Application=new GetHiredModel(Name,Address,Contact,Qualification,JobId);
        applicationList.add(Application);
        loadApplicationsToTable();
        return true;
        }
    }
      
    private boolean deletedApplication(String UserName,int JobId){
    for (GetHiredModel application:applicationList){
        if(application.getJobId()==JobId){
            if(application.getUserName().equals(UserName)){
            applicationList.remove(application);
            loadApplicationsToTable();
            return true;
        }}
       
    }
    loadApplicationsToTable();
     return false;
   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAdminMain = new javax.swing.JPanel();
        lblAdminTitle = new javax.swing.JLabel();
        TbdPnlMain = new javax.swing.JTabbedPane();
        PnlAddajob = new javax.swing.JPanel();
        pnlAddajob = new javax.swing.JPanel();
        btnAddAJob = new javax.swing.JButton();
        btnUpdateAJob = new javax.swing.JButton();
        txtFldJobId = new javax.swing.JTextField();
        txtFldJobTitle = new javax.swing.JTextField();
        txtFldQualification = new javax.swing.JTextField();
        txtFldJobType = new javax.swing.JTextField();
        txtFldJobLocation = new javax.swing.JTextField();
        txtFldSalary = new javax.swing.JTextField();
        txtFldCompanyNameAddJob = new javax.swing.JTextField();
        txtFldDeadline = new javax.swing.JTextField();
        pnlDeleteJob3 = new javax.swing.JPanel();
        lblDeleteTitle4 = new javax.swing.JLabel();
        btnDeleteJob3 = new javax.swing.JButton();
        txtfieldDeleteJobId = new javax.swing.JTextField();
        txtFldDeleteJobTitle3 = new javax.swing.JTextField();
        btnLogOutAdmin3 = new javax.swing.JButton();
        pnlViewApplication = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewApplication = new javax.swing.JTable();
        pnlAddACompany = new javax.swing.JPanel();
        txtFldContactDetails = new javax.swing.JTextField();
        txtFldCompanyName = new javax.swing.JTextField();
        txtFldCompanyId = new javax.swing.JTextField();
        txtFldCompanyLocation = new javax.swing.JTextField();
        btnAddACompany = new javax.swing.JButton();
        pnlDeleteCompany = new javax.swing.JPanel();
        btnDeleteCompany = new javax.swing.JButton();
        txtfldDeleteCompanyId = new javax.swing.JTextField();
        txtFldDeleteCompanyTitle = new javax.swing.JTextField();
        lablDeleteTitle = new javax.swing.JLabel();
        LogOutAdmin = new javax.swing.JButton();
        comboBoxJobStatus = new javax.swing.JComboBox<>();
        lblJobStatus = new javax.swing.JLabel();
        btnUpdateDetails = new javax.swing.JButton();
        LblLogo = new javax.swing.JLabel();
        pnlRegister = new javax.swing.JPanel();
        LblLogo1 = new javax.swing.JLabel();
        lblAdminTitle1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNameRegister = new javax.swing.JLabel();
        txtFldNameRegister = new javax.swing.JTextField();
        txtFldAddressRegister = new javax.swing.JTextField();
        lblAddressRegister = new javax.swing.JLabel();
        lblContactNoRegister = new javax.swing.JLabel();
        txtFldContactNoRegister = new javax.swing.JTextField();
        txtFldDOBRegister = new javax.swing.JTextField();
        lblDoBRegister = new javax.swing.JLabel();
        txtFldEmailRegister = new javax.swing.JTextField();
        txtFldpasswordRegister = new javax.swing.JTextField();
        txtFldReconfirmPassword = new javax.swing.JTextField();
        lblEmailRegister = new javax.swing.JLabel();
        lblPasswordRegister = new javax.swing.JLabel();
        lblReconfirnPaaaword = new javax.swing.JLabel();
        btnRegisterForm = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        pnlWelcome = new javax.swing.JPanel();
        LblLogoWelcomePage = new javax.swing.JLabel();
        lblImageWelcome = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        lblGreeting1 = new javax.swing.JLabel();
        lblGreeting2 = new javax.swing.JLabel();
        lblGreeting3 = new javax.swing.JLabel();
        lblGreeting4 = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        btnFindAJob = new javax.swing.JButton();
        btnBuildYourProfile = new javax.swing.JButton();
        btnFindAaCompany = new javax.swing.JButton();
        lblGreeting5 = new javax.swing.JLabel();
        lblGreeting6 = new javax.swing.JLabel();
        lblGreeting7 = new javax.swing.JLabel();
        lblGreeting8 = new javax.swing.JLabel();
        btnLogOut2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pnlFindAJob = new javax.swing.JPanel();
        lblLogoJob = new javax.swing.JLabel();
        lblTitleJob = new javax.swing.JLabel();
        btnSortById = new javax.swing.JButton();
        PnlApplyForJob = new javax.swing.JPanel();
        txtFieldJobId = new javax.swing.JTextField();
        txtFieldContactNo = new javax.swing.JTextField();
        txtFieldAddress = new javax.swing.JTextField();
        txtFieldFullName = new javax.swing.JTextField();
        txtFieldQualification = new javax.swing.JTextField();
        BtnApplyForJob = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        lblTitleApply = new javax.swing.JLabel();
        btnDeleteApplication = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        scrollpaneAddJob = new javax.swing.JScrollPane();
        tblAddJob = new javax.swing.JTable();
        btnLogOutJob = new javax.swing.JButton();
        pnlMainFindACompany = new javax.swing.JPanel();
        lblAdminTitle2 = new javax.swing.JLabel();
        lblLogo2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblFindACompany = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        pnlMainBuildProfile = new javax.swing.JPanel();
        pnlBuildProfile = new javax.swing.JPanel();
        txtFldName = new javax.swing.JTextField();
        txtFldDoB = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblContactNo = new javax.swing.JLabel();
        txtFldAddress = new javax.swing.JTextField();
        btnCreateProfile = new javax.swing.JButton();
        BtnClearForm = new javax.swing.JButton();
        lblDoB = new javax.swing.JLabel();
        txtFldContactNo = new javax.swing.JTextField();
        comboBoxGender = new javax.swing.JComboBox<>();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtFldEmail = new javax.swing.JTextField();
        lblEfucation = new javax.swing.JLabel();
        txtFldEducation = new javax.swing.JTextField();
        lblYears = new javax.swing.JLabel();
        ComboBoxYearsOfExperience = new javax.swing.JComboBox<>();
        btnUpdateProfile = new javax.swing.JButton();
        pnlDeleteProfile = new javax.swing.JPanel();
        txtFldContactNoDelete = new javax.swing.JTextField();
        txtFldNameDelete = new javax.swing.JTextField();
        btnDeleteProfile = new javax.swing.JButton();
        btnClearFormDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        LblLogo2 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        btnLogOutProfile = new javax.swing.JButton();
        Back1 = new javax.swing.JButton();
        pnlLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        txtfldEmail = new javax.swing.JTextField();
        lblRegistration = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblLoginPageLogo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtfldPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        pnlAdminMain.setBackground(new java.awt.Color(154, 166, 178));
        pnlAdminMain.setMaximumSize(new java.awt.Dimension(832, 700));
        pnlAdminMain.setMinimumSize(new java.awt.Dimension(832, 700));
        pnlAdminMain.setPreferredSize(new java.awt.Dimension(832, 700));

        lblAdminTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblAdminTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminTitle.setText("ADMIN CONTROL");
        lblAdminTitle.setMaximumSize(new java.awt.Dimension(424, 48));
        lblAdminTitle.setMinimumSize(new java.awt.Dimension(424, 48));
        lblAdminTitle.setPreferredSize(new java.awt.Dimension(424, 48));

        TbdPnlMain.setBackground(new java.awt.Color(154, 166, 178));
        TbdPnlMain.setMaximumSize(new java.awt.Dimension(832, 700));
        TbdPnlMain.setMinimumSize(new java.awt.Dimension(832, 700));
        TbdPnlMain.setPreferredSize(new java.awt.Dimension(832, 700));

        PnlAddajob.setBackground(new java.awt.Color(217, 234, 253));
        PnlAddajob.setAlignmentX(0.0F);
        PnlAddajob.setAlignmentY(0.0F);
        PnlAddajob.setMaximumSize(new java.awt.Dimension(832, 700));
        PnlAddajob.setMinimumSize(new java.awt.Dimension(832, 700));
        PnlAddajob.setPreferredSize(new java.awt.Dimension(832, 700));

        pnlAddajob.setBackground(new java.awt.Color(217, 234, 253));
        pnlAddajob.setPreferredSize(new java.awt.Dimension(610, 246));

        btnAddAJob.setBackground(new java.awt.Color(154, 166, 178));
        btnAddAJob.setText("Add a job");
        btnAddAJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAJobActionPerformed(evt);
            }
        });

        btnUpdateAJob.setBackground(new java.awt.Color(154, 166, 178));
        btnUpdateAJob.setText("Update a job");
        btnUpdateAJob.setToolTipText("");
        btnUpdateAJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAJobActionPerformed(evt);
            }
        });

        txtFldJobId.setBorder(javax.swing.BorderFactory.createTitledBorder("Job Id"));

        txtFldJobTitle.setBorder(javax.swing.BorderFactory.createTitledBorder("Job Title"));
        txtFldJobTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldJobTitleActionPerformed(evt);
            }
        });

        txtFldQualification.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualification"));
        txtFldQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldQualificationActionPerformed(evt);
            }
        });

        txtFldJobType.setBorder(javax.swing.BorderFactory.createTitledBorder("Job Type"));

        txtFldJobLocation.setBorder(javax.swing.BorderFactory.createTitledBorder("Job location"));

        txtFldSalary.setBorder(javax.swing.BorderFactory.createTitledBorder("Offered Salary"));

        txtFldCompanyNameAddJob.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Name"));

        txtFldDeadline.setBorder(javax.swing.BorderFactory.createTitledBorder("Deadline"));

        javax.swing.GroupLayout pnlAddajobLayout = new javax.swing.GroupLayout(pnlAddajob);
        pnlAddajob.setLayout(pnlAddajobLayout);
        pnlAddajobLayout.setHorizontalGroup(
            pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddajobLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlAddajobLayout.createSequentialGroup()
                        .addComponent(btnAddAJob, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateAJob, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAddajobLayout.createSequentialGroup()
                        .addComponent(txtFldJobLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFldCompanyNameAddJob, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddajobLayout.createSequentialGroup()
                        .addComponent(txtFldJobType, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAddajobLayout.createSequentialGroup()
                        .addComponent(txtFldJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFldDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddajobLayout.createSequentialGroup()
                        .addComponent(txtFldJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(txtFldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123))
        );
        pnlAddajobLayout.setVerticalGroup(
            pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddajobLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldJobType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldJobLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldCompanyNameAddJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(pnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateAJob, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAJob))
                .addGap(15, 15, 15))
        );

        pnlDeleteJob3.setBackground(new java.awt.Color(154, 166, 178));

        lblDeleteTitle4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDeleteTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeleteTitle4.setText("Found your employee? Delete Job?");

        btnDeleteJob3.setBackground(new java.awt.Color(217, 234, 253));
        btnDeleteJob3.setText("Delete Job");
        btnDeleteJob3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJobActionPerformed(evt);
            }
        });

        txtfieldDeleteJobId.setBorder(javax.swing.BorderFactory.createTitledBorder("Job ID"));

        txtFldDeleteJobTitle3.setBorder(javax.swing.BorderFactory.createTitledBorder("Job Title"));

        btnLogOutAdmin3.setBackground(new java.awt.Color(217, 234, 253));
        btnLogOutAdmin3.setText("Logout");
        btnLogOutAdmin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDeleteJob3Layout = new javax.swing.GroupLayout(pnlDeleteJob3);
        pnlDeleteJob3.setLayout(pnlDeleteJob3Layout);
        pnlDeleteJob3Layout.setHorizontalGroup(
            pnlDeleteJob3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteJob3Layout.createSequentialGroup()
                .addGroup(pnlDeleteJob3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteJob3Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtfieldDeleteJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtFldDeleteJobTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteJob3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDeleteTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDeleteJob3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogOutAdmin3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteJob3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDeleteJob3Layout.setVerticalGroup(
            pnlDeleteJob3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteJob3Layout.createSequentialGroup()
                .addGroup(pnlDeleteJob3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDeleteJob3Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(lblDeleteTitle4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDeleteJob3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfieldDeleteJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldDeleteJobTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDeleteJob3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnLogOutAdmin3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteJob3)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout PnlAddajobLayout = new javax.swing.GroupLayout(PnlAddajob);
        PnlAddajob.setLayout(PnlAddajobLayout);
        PnlAddajobLayout.setHorizontalGroup(
            PnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAddajobLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(PnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAddajobLayout.createSequentialGroup()
                        .addComponent(pnlDeleteJob3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAddajobLayout.createSequentialGroup()
                        .addComponent(pnlAddajob, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))))
        );
        PnlAddajobLayout.setVerticalGroup(
            PnlAddajobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAddajobLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddajob, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDeleteJob3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        TbdPnlMain.addTab("Add a Job", PnlAddajob);

        pnlViewApplication.setMaximumSize(new java.awt.Dimension(832, 700));
        pnlViewApplication.setMinimumSize(new java.awt.Dimension(832, 700));
        pnlViewApplication.setPreferredSize(new java.awt.Dimension(832, 700));

        tblViewApplication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "Address", "Contact ", "Qualification", "Job Id"
            }
        ));
        tblViewApplication.setMaximumSize(new java.awt.Dimension(375, 80));
        tblViewApplication.setMinimumSize(new java.awt.Dimension(375, 80));
        jScrollPane1.setViewportView(tblViewApplication);

        javax.swing.GroupLayout pnlViewApplicationLayout = new javax.swing.GroupLayout(pnlViewApplication);
        pnlViewApplication.setLayout(pnlViewApplicationLayout);
        pnlViewApplicationLayout.setHorizontalGroup(
            pnlViewApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewApplicationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlViewApplicationLayout.setVerticalGroup(
            pnlViewApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewApplicationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        TbdPnlMain.addTab("View Applications", pnlViewApplication);

        pnlAddACompany.setBackground(new java.awt.Color(217, 234, 253));
        pnlAddACompany.setAutoscrolls(true);
        pnlAddACompany.setMaximumSize(new java.awt.Dimension(832, 700));
        pnlAddACompany.setMinimumSize(new java.awt.Dimension(832, 700));
        pnlAddACompany.setPreferredSize(new java.awt.Dimension(826, 600));

        txtFldContactDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact Details"));

        txtFldCompanyName.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Name"));
        txtFldCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldCompanyNameActionPerformed(evt);
            }
        });

        txtFldCompanyId.setBorder(javax.swing.BorderFactory.createTitledBorder("Company ID"));

        txtFldCompanyLocation.setBorder(javax.swing.BorderFactory.createTitledBorder("Location"));

        btnAddACompany.setBackground(new java.awt.Color(154, 166, 178));
        btnAddACompany.setText("Add a Company");
        btnAddACompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddACompanyActionPerformed(evt);
            }
        });

        pnlDeleteCompany.setBackground(new java.awt.Color(154, 166, 178));

        btnDeleteCompany.setBackground(new java.awt.Color(217, 234, 253));
        btnDeleteCompany.setText("Delete Company");
        btnDeleteCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCompanyActionPerformed(evt);
            }
        });

        txtfldDeleteCompanyId.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Id"));

        txtFldDeleteCompanyTitle.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Name"));

        lablDeleteTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lablDeleteTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lablDeleteTitle.setText("Delete Company?");

        LogOutAdmin.setBackground(new java.awt.Color(217, 234, 253));
        LogOutAdmin.setText("Log Out");
        LogOutAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDeleteCompanyLayout = new javax.swing.GroupLayout(pnlDeleteCompany);
        pnlDeleteCompany.setLayout(pnlDeleteCompanyLayout);
        pnlDeleteCompanyLayout.setHorizontalGroup(
            pnlDeleteCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteCompanyLayout.createSequentialGroup()
                .addGroup(pnlDeleteCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDeleteCompanyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lablDeleteTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDeleteCompanyLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtfldDeleteCompanyId, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(txtFldDeleteCompanyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnlDeleteCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(LogOutAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        pnlDeleteCompanyLayout.setVerticalGroup(
            pnlDeleteCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteCompanyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lablDeleteTitle)
                .addGroup(pnlDeleteCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDeleteCompanyLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnlDeleteCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfldDeleteCompanyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldDeleteCompanyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDeleteCompanyLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnDeleteCompany)
                        .addGap(18, 18, 18)
                        .addComponent(LogOutAdmin)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        comboBoxJobStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avaliable", "Not Avaliable" }));

        lblJobStatus.setText("Job Vacancy Status");

        btnUpdateDetails.setBackground(new java.awt.Color(154, 166, 178));
        btnUpdateDetails.setText("Update Details");
        btnUpdateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddACompanyLayout = new javax.swing.GroupLayout(pnlAddACompany);
        pnlAddACompany.setLayout(pnlAddACompanyLayout);
        pnlAddACompanyLayout.setHorizontalGroup(
            pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                        .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtFldCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFldCompanyId, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                                        .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFldCompanyLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblJobStatus))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxJobStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFldContactDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdateDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddACompany, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddACompanyLayout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(pnlDeleteCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAddACompanyLayout.setVerticalGroup(
            pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddACompanyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldCompanyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldCompanyLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldContactDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxJobStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJobStatus))
                .addGap(18, 18, 18)
                .addComponent(btnUpdateDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddACompany, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(pnlDeleteCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );

        TbdPnlMain.addTab("Add a company", pnlAddACompany);

        LblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N
        LblLogo.setText("jLabel2");

        javax.swing.GroupLayout pnlAdminMainLayout = new javax.swing.GroupLayout(pnlAdminMain);
        pnlAdminMain.setLayout(pnlAdminMainLayout);
        pnlAdminMainLayout.setHorizontalGroup(
            pnlAdminMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdminMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdminTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
            .addGroup(pnlAdminMainLayout.createSequentialGroup()
                .addComponent(TbdPnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAdminMainLayout.setVerticalGroup(
            pnlAdminMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminMainLayout.createSequentialGroup()
                .addGroup(pnlAdminMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminMainLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblAdminTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblLogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TbdPnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRegister.setBackground(new java.awt.Color(154, 166, 178));
        pnlRegister.setMaximumSize(new java.awt.Dimension(832, 600));
        pnlRegister.setMinimumSize(new java.awt.Dimension(832, 600));
        pnlRegister.setPreferredSize(new java.awt.Dimension(832, 600));

        LblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N
        LblLogo1.setText("jLabel2");

        lblAdminTitle1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblAdminTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminTitle1.setText("Register Now!");
        lblAdminTitle1.setMaximumSize(new java.awt.Dimension(424, 48));
        lblAdminTitle1.setMinimumSize(new java.awt.Dimension(424, 48));
        lblAdminTitle1.setPreferredSize(new java.awt.Dimension(424, 48));

        jPanel2.setBackground(new java.awt.Color(217, 234, 253));

        lblNameRegister.setText("Name");

        txtFldAddressRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAddressRegisterActionPerformed(evt);
            }
        });

        lblAddressRegister.setText("Address");

        lblContactNoRegister.setText("Contact No");

        txtFldContactNoRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldContactNoRegisterActionPerformed(evt);
            }
        });

        txtFldDOBRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldDOBRegisterActionPerformed(evt);
            }
        });

        lblDoBRegister.setText("Date Of Birth");

        txtFldEmailRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldEmailRegisterActionPerformed(evt);
            }
        });

        txtFldpasswordRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldpasswordRegisterActionPerformed(evt);
            }
        });

        txtFldReconfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldReconfirmPasswordActionPerformed(evt);
            }
        });

        lblEmailRegister.setText("Email ID");

        lblPasswordRegister.setText("Password");

        lblReconfirnPaaaword.setText("Reconfirm Password");

        btnRegisterForm.setBackground(new java.awt.Color(154, 166, 178));
        btnRegisterForm.setText("Register");
        btnRegisterForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterFormActionPerformed(evt);
            }
        });

        btnBackToLogin.setBackground(new java.awt.Color(154, 166, 178));
        btnBackToLogin.setText("Login?");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegisterForm, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(btnBackToLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldNameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPasswordRegister)
                                    .addComponent(lblEmailRegister)
                                    .addComponent(lblContactNoRegister)
                                    .addComponent(lblDoBRegister))
                                .addGap(225, 225, 225)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblAddressRegister)
                            .addGap(66, 66, 66)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFldContactNoRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFldAddressRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFldDOBRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFldEmailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFldpasswordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblReconfirnPaaaword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldReconfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(259, 259, 259))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFldNameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNameRegister))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddressRegister)
                            .addComponent(txtFldAddressRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContactNoRegister)
                            .addComponent(txtFldContactNoRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDoBRegister)
                            .addComponent(txtFldDOBRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailRegister)
                            .addComponent(txtFldEmailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtFldpasswordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPasswordRegister)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReconfirnPaaaword)
                    .addComponent(txtFldReconfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegisterForm)
                .addGap(18, 18, 18)
                .addComponent(btnBackToLogin)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                        .addComponent(LblLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdminTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdminTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pnlWelcome.setBackground(new java.awt.Color(154, 166, 178));
        pnlWelcome.setMaximumSize(new java.awt.Dimension(832, 600));
        pnlWelcome.setMinimumSize(new java.awt.Dimension(832, 600));
        pnlWelcome.setPreferredSize(new java.awt.Dimension(832, 600));

        LblLogoWelcomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N
        LblLogoWelcomePage.setText("jLabel2");

        lblImageWelcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/Untitled design (1) (1).png"))); // NOI18N
        lblImageWelcome.setText("jLabel1");

        lblWelcome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText(" Welcome to GetHired! ");

        lblGreeting1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting1.setText("Your journey to the perfect job starts here! ");
        lblGreeting1.setMaximumSize(new java.awt.Dimension(321, 20));
        lblGreeting1.setMinimumSize(new java.awt.Dimension(321, 20));
        lblGreeting1.setPreferredSize(new java.awt.Dimension(321, 20));

        lblGreeting2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting2.setText("Whether you're seeking your dream role or planning");

        lblGreeting3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting3.setText("your next career move, GetHired has the tools and ");
        lblGreeting3.setMaximumSize(new java.awt.Dimension(321, 20));
        lblGreeting3.setMinimumSize(new java.awt.Dimension(321, 20));
        lblGreeting3.setPreferredSize(new java.awt.Dimension(321, 20));

        lblGreeting4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting4.setText("and opportunities you need.");

        pnlButtons.setBackground(new java.awt.Color(217, 234, 253));
        pnlButtons.setMaximumSize(new java.awt.Dimension(741, 125));
        pnlButtons.setMinimumSize(new java.awt.Dimension(741, 125));

        btnFindAJob.setBackground(new java.awt.Color(154, 166, 178));
        btnFindAJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/job-seeker (1).png"))); // NOI18N
        btnFindAJob.setText("Find A Job");
        btnFindAJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindAJobActionPerformed(evt);
            }
        });

        btnBuildYourProfile.setBackground(new java.awt.Color(154, 166, 178));
        btnBuildYourProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resume (1).png"))); // NOI18N
        btnBuildYourProfile.setText("Build Your Profile");
        btnBuildYourProfile.setMaximumSize(new java.awt.Dimension(109, 27));
        btnBuildYourProfile.setMinimumSize(new java.awt.Dimension(109, 27));
        btnBuildYourProfile.setPreferredSize(new java.awt.Dimension(109, 27));
        btnBuildYourProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuildYourProfileActionPerformed(evt);
            }
        });

        btnFindAaCompany.setBackground(new java.awt.Color(154, 166, 178));
        btnFindAaCompany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/recruitment (1) (1).png"))); // NOI18N
        btnFindAaCompany.setText("Find A Company");
        btnFindAaCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindAaCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnFindAJob, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btnBuildYourProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btnFindAaCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFindAJob, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuildYourProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindAaCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        lblGreeting5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting5.setText("Explore tailored job recommendations, connect with top ");

        lblGreeting6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting6.setText("companies, and make your next big move.");

        lblGreeting7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGreeting7.setText("Let’s get you hired! ");

        lblGreeting8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGreeting8.setText("Feel free to explore or get started with your profile now.");

        btnLogOut2.setBackground(new java.awt.Color(217, 234, 253));
        btnLogOut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/logout (1) (1).png"))); // NOI18N
        btnLogOut2.setText("Log Out");
        btnLogOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Get Hired");

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addComponent(LblLogoWelcomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWelcomeLayout.createSequentialGroup()
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGreeting6)
                                    .addComponent(lblGreeting5)
                                    .addComponent(lblGreeting4)
                                    .addComponent(lblGreeting3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGreeting2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(275, 275, 275)
                                .addComponent(btnLogOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(684, 684, 684))
                            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGreeting1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGreeting8)
                                    .addComponent(lblGreeting7))
                                .addGap(20, 20, 20)
                                .addComponent(lblImageWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(672, 672, 672)))))
                .addGap(21, 21, 21))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblLogoWelcomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addComponent(btnLogOut2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImageWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGreeting1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGreeting2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGreeting3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGreeting4)
                        .addGap(34, 34, 34)
                        .addComponent(lblGreeting5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGreeting6)
                        .addGap(27, 27, 27)
                        .addComponent(lblGreeting7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGreeting8)))
                .addGap(18, 18, 18)
                .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlFindAJob.setBackground(new java.awt.Color(154, 166, 178));
        pnlFindAJob.setMaximumSize(new java.awt.Dimension(832, 600));
        pnlFindAJob.setMinimumSize(new java.awt.Dimension(832, 600));
        pnlFindAJob.setPreferredSize(new java.awt.Dimension(832, 600));

        lblLogoJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N
        lblLogoJob.setText("jLabel1");

        lblTitleJob.setBackground(new java.awt.Color(154, 166, 178));
        lblTitleJob.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitleJob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleJob.setText("Job Management System");
        lblTitleJob.setOpaque(true);

        btnSortById.setBackground(new java.awt.Color(217, 234, 253));
        btnSortById.setText("Sort By ID");

        PnlApplyForJob.setBackground(new java.awt.Color(217, 234, 253));

        txtFieldJobId.setBorder(javax.swing.BorderFactory.createTitledBorder("Job ID"));
        txtFieldJobId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldJobIdActionPerformed(evt);
            }
        });

        txtFieldContactNo.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact No."));
        txtFieldContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldContactNoActionPerformed(evt);
            }
        });

        txtFieldAddress.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        txtFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldAddressActionPerformed(evt);
            }
        });

        txtFieldFullName.setBorder(javax.swing.BorderFactory.createTitledBorder("Full Name"));
        txtFieldFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldFullNameActionPerformed(evt);
            }
        });

        txtFieldQualification.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualification"));
        txtFieldQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldQualificationActionPerformed(evt);
            }
        });

        BtnApplyForJob.setBackground(new java.awt.Color(154, 166, 178));
        BtnApplyForJob.setText("Apply For Job");
        BtnApplyForJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApplyForJobActionPerformed(evt);
            }
        });

        btnClearForm.setBackground(new java.awt.Color(154, 166, 178));
        btnClearForm.setText("Clear Form");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        lblTitleApply.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        lblTitleApply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleApply.setText("Apply for your dream job!!");

        btnDeleteApplication.setBackground(new java.awt.Color(154, 166, 178));
        btnDeleteApplication.setText("Delete Application");
        btnDeleteApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteApplicationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlApplyForJobLayout = new javax.swing.GroupLayout(PnlApplyForJob);
        PnlApplyForJob.setLayout(PnlApplyForJobLayout);
        PnlApplyForJobLayout.setHorizontalGroup(
            PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlApplyForJobLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlApplyForJobLayout.createSequentialGroup()
                        .addGroup(PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PnlApplyForJobLayout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(BtnApplyForJob, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteApplication)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PnlApplyForJobLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtFieldJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFieldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PnlApplyForJobLayout.setVerticalGroup(
            PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlApplyForJobLayout.createSequentialGroup()
                .addComponent(lblTitleApply, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldContactNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(PnlApplyForJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnApplyForJob)
                    .addComponent(btnClearForm)
                    .addComponent(btnDeleteApplication))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnBack.setBackground(new java.awt.Color(217, 234, 253));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        scrollpaneAddJob.setBackground(new java.awt.Color(154, 166, 178));

        tblAddJob.setBackground(new java.awt.Color(154, 166, 178));
        tblAddJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Job Category", "Type", "Job Location", "Offered Salary", "Deadline", "Qualifucation"
            }
        ));
        scrollpaneAddJob.setViewportView(tblAddJob);

        btnLogOutJob.setBackground(new java.awt.Color(217, 234, 253));
        btnLogOutJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/logout (1) (1).png"))); // NOI18N
        btnLogOutJob.setText("Log Out");
        btnLogOutJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutJobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFindAJobLayout = new javax.swing.GroupLayout(pnlFindAJob);
        pnlFindAJob.setLayout(pnlFindAJobLayout);
        pnlFindAJobLayout.setHorizontalGroup(
            pnlFindAJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindAJobLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFindAJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFindAJobLayout.createSequentialGroup()
                        .addComponent(PnlApplyForJob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlFindAJobLayout.createSequentialGroup()
                        .addComponent(lblLogoJob, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitleJob, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFindAJobLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogOutJob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSortById, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFindAJobLayout.createSequentialGroup()
                        .addComponent(scrollpaneAddJob)
                        .addContainerGap())))
        );
        pnlFindAJobLayout.setVerticalGroup(
            pnlFindAJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindAJobLayout.createSequentialGroup()
                .addGroup(pnlFindAJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogoJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitleJob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFindAJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSortById)
                    .addComponent(btnBack)
                    .addComponent(btnLogOutJob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollpaneAddJob, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlApplyForJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pnlMainFindACompany.setBackground(new java.awt.Color(154, 166, 178));
        pnlMainFindACompany.setMaximumSize(new java.awt.Dimension(832, 600));
        pnlMainFindACompany.setMinimumSize(new java.awt.Dimension(832, 600));
        pnlMainFindACompany.setPreferredSize(new java.awt.Dimension(832, 600));

        lblAdminTitle2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblAdminTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminTitle2.setText("Job Management System");

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/search (1).png"))); // NOI18N

        btnLogOut.setBackground(new java.awt.Color(217, 234, 253));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/logout (1) (1).png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        TblFindACompany.setBackground(new java.awt.Color(217, 234, 253));
        TblFindACompany.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CompanyId", "Name", "Address", "Contact Details", "Vacancy Open Status"
            }
        ));
        jScrollPane2.setViewportView(TblFindACompany);

        jButton3.setBackground(new java.awt.Color(217, 234, 253));
        jButton3.setText("Sort By CompanyId");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(217, 234, 253));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainFindACompanyLayout = new javax.swing.GroupLayout(pnlMainFindACompany);
        pnlMainFindACompany.setLayout(pnlMainFindACompanyLayout);
        pnlMainFindACompanyLayout.setHorizontalGroup(
            pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFindACompanyLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainFindACompanyLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainFindACompanyLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainFindACompanyLayout.createSequentialGroup()
                .addComponent(lblLogo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAdminTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainFindACompanyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMainFindACompanyLayout.setVerticalGroup(
            pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainFindACompanyLayout.createSequentialGroup()
                .addGroup(pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo2)
                    .addComponent(lblAdminTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainFindACompanyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogOut))
                    .addGroup(pnlMainFindACompanyLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(pnlMainFindACompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pnlBuildProfile.setBackground(new java.awt.Color(154, 166, 178));
        pnlBuildProfile.setMaximumSize(new java.awt.Dimension(832, 700));
        pnlBuildProfile.setMinimumSize(new java.awt.Dimension(832, 700));
        pnlBuildProfile.setPreferredSize(new java.awt.Dimension(832, 700));

        txtFldDoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldDoBActionPerformed(evt);
            }
        });

        lblName.setText("Name");

        lblAddress.setText("Address");

        lblContactNo.setText("Contact No");

        txtFldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAddressActionPerformed(evt);
            }
        });

        btnCreateProfile.setBackground(new java.awt.Color(217, 234, 253));
        btnCreateProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/add (1).png"))); // NOI18N
        btnCreateProfile.setText("  Create Profile");
        btnCreateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProfileActionPerformed(evt);
            }
        });

        BtnClearForm.setBackground(new java.awt.Color(217, 234, 253));
        BtnClearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/broom (1).png"))); // NOI18N
        BtnClearForm.setText("Clear Form");
        BtnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearFormActionPerformed(evt);
            }
        });

        lblDoB.setText("Date Of Birth");

        txtFldContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldContactNoActionPerformed(evt);
            }
        });

        comboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "others" }));
        comboBoxGender.setMaximumSize(new java.awt.Dimension(64, 22));
        comboBoxGender.setMinimumSize(new java.awt.Dimension(64, 22));
        comboBoxGender.setPreferredSize(new java.awt.Dimension(64, 22));

        lblGender.setText("Gender");

        lblEmail.setText("Email");

        lblEfucation.setText("Education");

        lblYears.setText("Years Of Experience");

        ComboBoxYearsOfExperience.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "1 years", "2 years", "3 years", "4 years", "5 years", "5-10 years" }));

        btnUpdateProfile.setBackground(new java.awt.Color(217, 234, 253));
        btnUpdateProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/changes (1).png"))); // NOI18N
        btnUpdateProfile.setText("Update Profile");

        pnlDeleteProfile.setBackground(new java.awt.Color(217, 234, 253));

        txtFldContactNoDelete.setActionCommand("<Not Set>");
        txtFldContactNoDelete.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact No."));

        txtFldNameDelete.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        btnDeleteProfile.setBackground(new java.awt.Color(154, 166, 178));
        btnDeleteProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/delete (1).png"))); // NOI18N
        btnDeleteProfile.setText("Delete Profile");

        btnClearFormDelete.setBackground(new java.awt.Color(154, 166, 178));
        btnClearFormDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/broom (1).png"))); // NOI18N
        btnClearFormDelete.setText("Clear Form");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Delete Profile?");

        javax.swing.GroupLayout pnlDeleteProfileLayout = new javax.swing.GroupLayout(pnlDeleteProfile);
        pnlDeleteProfile.setLayout(pnlDeleteProfileLayout);
        pnlDeleteProfileLayout.setHorizontalGroup(
            pnlDeleteProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteProfileLayout.createSequentialGroup()
                .addGroup(pnlDeleteProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDeleteProfileLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFldNameDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(txtFldContactNoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnClearFormDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDeleteProfileLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlDeleteProfileLayout.setVerticalGroup(
            pnlDeleteProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteProfileLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlDeleteProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDeleteProfileLayout.createSequentialGroup()
                        .addComponent(btnDeleteProfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearFormDelete)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteProfileLayout.createSequentialGroup()
                        .addGroup(pnlDeleteProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFldContactNoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldNameDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        LblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N
        LblLogo2.setText("jLabel2");

        lblTitle2.setBackground(new java.awt.Color(154, 166, 178));
        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Job Management System");
        lblTitle2.setOpaque(true);

        btnLogOutProfile.setBackground(new java.awt.Color(217, 234, 253));
        btnLogOutProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/logout (1) (1).png"))); // NOI18N
        btnLogOutProfile.setText("Log Out");
        btnLogOutProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutProfileActionPerformed(evt);
            }
        });

        Back1.setBackground(new java.awt.Color(217, 234, 253));
        Back1.setText("Back");
        Back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuildProfileLayout = new javax.swing.GroupLayout(pnlBuildProfile);
        pnlBuildProfile.setLayout(pnlBuildProfileLayout);
        pnlBuildProfileLayout.setHorizontalGroup(
            pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                        .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCreateProfile)
                            .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                                    .addComponent(lblDoB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFldDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                                    .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                                            .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblContactNo)
                                                .addComponent(lblAddress))
                                            .addGap(42, 42, 42))
                                        .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBuildProfileLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFldContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtFldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblYears, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEfucation)
                                    .addComponent(lblEmail)
                                    .addComponent(lblGender))
                                .addGap(28, 28, 28)
                                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFldEducation, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxYearsOfExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77))
                            .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnUpdateProfile)
                                .addGap(31, 31, 31)
                                .addComponent(BtnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                        .addComponent(pnlDeleteProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))))
            .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                .addComponent(LblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBuildProfileLayout.createSequentialGroup()
                        .addComponent(Back1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogOutProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        pnlBuildProfileLayout.setVerticalGroup(
            pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogOutProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Back1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                        .addComponent(comboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFldEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBuildProfileLayout.createSequentialGroup()
                        .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtFldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFldContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactNo)
                            .addComponent(lblEfucation))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoB)
                    .addComponent(txtFldDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblYears)
                    .addComponent(ComboBoxYearsOfExperience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(pnlBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateProfile)
                    .addComponent(btnCreateProfile)
                    .addComponent(BtnClearForm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDeleteProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout pnlMainBuildProfileLayout = new javax.swing.GroupLayout(pnlMainBuildProfile);
        pnlMainBuildProfile.setLayout(pnlMainBuildProfileLayout);
        pnlMainBuildProfileLayout.setHorizontalGroup(
            pnlMainBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainBuildProfileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBuildProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMainBuildProfileLayout.setVerticalGroup(
            pnlMainBuildProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainBuildProfileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBuildProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(832, 700));
        setMinimumSize(new java.awt.Dimension(832, 700));
        setResizable(false);

        pnlLogin.setBackground(new java.awt.Color(154, 166, 178));
        pnlLogin.setMaximumSize(new java.awt.Dimension(832, 700));
        pnlLogin.setMinimumSize(new java.awt.Dimension(832, 700));
        pnlLogin.setPreferredSize(new java.awt.Dimension(832, 700));

        btnLogin.setBackground(new java.awt.Color(217, 234, 253));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtfldEmail.setToolTipText("");
        txtfldEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email "));

        lblRegistration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistration.setText("Register now?");

        btnRegister.setBackground(new java.awt.Color(217, 234, 253));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblLoginPageLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/resized.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(217, 234, 253));
        jButton1.setText("Search For the Perfect Employee?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtfldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Connecting Talent with Opportunity.");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Find. Apply. Grow.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GetHired/resources/icon (1).jpg"))); // NOI18N

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegister)))
                        .addGap(330, 330, 330))))
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addComponent(lblLoginPageLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                                .addGap(0, 657, Short.MAX_VALUE)
                                .addComponent(jLabel4))))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(343, 343, 343)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLoginPageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(87, 87, 87)
                .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtfldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnLogin)
                .addGap(12, 12, 12)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistration)
                    .addComponent(btnRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        loadScreen("RegisterScreen");
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String EmailFromGUI=txtfldEmail.getText(); 
String PasswordfRomGUI=new String(txtfldPassword.getPassword());

        String Email="Admin";
        String Password="Admin";
        if(EmailFromGUI.equals(Email)){
            if(PasswordfRomGUI.equals(Password))// TODO add your handling code here:
        loadScreen("AdminScreen");
        }
        else{
            JOptionPane.showMessageDialog(this, "Please enter correct username or password", "Error!", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFldDoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldDoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldDoBActionPerformed

    private void txtFldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAddressActionPerformed

    private void btnCreateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateProfileActionPerformed

    private void txtFldContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldContactNoActionPerformed

    private void txtFldQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldQualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldQualificationActionPerformed

    private void txtFldJobTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldJobTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldJobTitleActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
                                        
       // TODO add your handling code here:
         // TODO add your handling code here:
        String username= txtfldEmail.getText();
        String password= txtfldPassword.getText();
        
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(pnlLogin, "Please fill out all the fields","Failed", JOptionPane.WARNING_MESSAGE);
        }
        else{
       
        loadScreen("WelcomeScreen");}
       // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtFldCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldCompanyNameActionPerformed

    private void txtFldAddressRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAddressRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAddressRegisterActionPerformed

    private void txtFldContactNoRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldContactNoRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldContactNoRegisterActionPerformed

    private void txtFldDOBRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldDOBRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldDOBRegisterActionPerformed

    private void txtFldEmailRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldEmailRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldEmailRegisterActionPerformed

    private void txtFldpasswordRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldpasswordRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldpasswordRegisterActionPerformed

    private void txtFldReconfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldReconfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldReconfirmPasswordActionPerformed

    private void btnRegisterFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterFormActionPerformed

    private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLoginActionPerformed
        // TODO add your handling code here:
        loadScreen("LoginScreen");
    }//GEN-LAST:event_btnBackToLoginActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDeleteCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCompanyActionPerformed
        // TODO add your handling code here:
        try{
         int CompanyId=Integer.parseInt(txtfldDeleteCompanyId.getText());
         
        if(deletedCompany(CompanyId)==true)
        {
        JOptionPane.showMessageDialog(this, "Company Deleted Sucessfully!!","Deleted",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        JOptionPane.showMessageDialog(this, "Enter Valid Id","Not Deleted",JOptionPane.ERROR_MESSAGE);
    }
       
        }
        catch(NumberFormatException e){
         JOptionPane.showMessageDialog(this, "Please Enter A number/ID","Not Deleted",JOptionPane.ERROR_MESSAGE);   
        }

    }//GEN-LAST:event_btnDeleteCompanyActionPerformed

    private void btnAddAJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAJobActionPerformed

try{
if (addJob()==true){
   JOptionPane.showMessageDialog(this,"Job added successfully","Success",JOptionPane.INFORMATION_MESSAGE);
}
else
{
     JOptionPane.showMessageDialog(this,"Job added successfully","Success",JOptionPane.INFORMATION_MESSAGE);
}}
catch(NumberFormatException e) {
        // Handle invalid input for CompanyId (non-numeric value)
        JOptionPane.showMessageDialog(this, "Invalid Company ID. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while adding the company.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    

    }//GEN-LAST:event_btnAddAJobActionPerformed

    private void BtnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearFormActionPerformed
        // TODO add your handling code here:
        txtFldName.setText("");
        txtFldAddress.setText("");
        txtFldDoB.setText("");
        txtFldContactNo.setText("");
        comboBoxGender.setSelectedItem("Avaliable");
        txtFldEmail.setText("");
        txtFldEducation.setText("");
        ComboBoxYearsOfExperience.setSelectedItem("None");
        
    }//GEN-LAST:event_BtnClearFormActionPerformed

    private void btnFindAJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindAJobActionPerformed
        // TODO add your handling code here:
        loadScreen("JobScreen");
    }//GEN-LAST:event_btnFindAJobActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        loadScreen("WelcomeScreen");
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFieldJobIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldJobIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldJobIdActionPerformed

    private void txtFieldContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldContactNoActionPerformed

    private void txtFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldAddressActionPerformed

    private void txtFieldFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldFullNameActionPerformed

    private void txtFieldQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldQualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldQualificationActionPerformed

    private void btnLogOutProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutProfileActionPerformed
        // TODO add your handling code here:
       loadScreen("LoginScreen");
    }//GEN-LAST:event_btnLogOutProfileActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        loadScreen("LoginScreen");
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        loadScreen("WelcomeScreen");
    }//GEN-LAST:event_BackActionPerformed

    private void btnBuildYourProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuildYourProfileActionPerformed
        // TODO add your handling code here:
        loadScreen("ProfileScreen");
    }//GEN-LAST:event_btnBuildYourProfileActionPerformed

    private void btnFindAaCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindAaCompanyActionPerformed
        // TODO add your handling code here:
        loadScreen("CompanyScreen");
    }//GEN-LAST:event_btnFindAaCompanyActionPerformed

    private void btnLogOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut2ActionPerformed
        // TODO add your handling code here:
        loadScreen("LoginScreen");
    }//GEN-LAST:event_btnLogOut2ActionPerformed

    private void btnLogOutJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutJobActionPerformed
        // TODO add your handling code here:
        loadScreen("LoginScreen");
    }//GEN-LAST:event_btnLogOutJobActionPerformed

    private void Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back1ActionPerformed
        // TODO add your handling code here:
        loadScreen("WelcomeScreen");
    }//GEN-LAST:event_Back1ActionPerformed

    private void BtnApplyForJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApplyForJobActionPerformed
try{
    if(addApplication()==true){
        JOptionPane.showMessageDialog(this,"Applied!","Successful",JOptionPane.INFORMATION_MESSAGE);
    }
    else{
        JOptionPane.showMessageDialog(this,"Not Applied!","Not-Successful",JOptionPane.INFORMATION_MESSAGE);
    }// TODO add your handling code here:
}
catch(NumberFormatException e) {
        // Handle invalid input for CompanyId (non-numeric value)
        JOptionPane.showMessageDialog(this, "Invalid Job ID. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while adding the company.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnApplyForJobActionPerformed

    private void btnAddACompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddACompanyActionPerformed
        // TODO add your handling code here:
       try{ 
           int CompanyId=Integer.parseInt(txtFldCompanyId.getText());
       
        String CompanyName=txtFldCompanyName.getText();    
        String CompanyLocation=txtFldCompanyLocation.getText();
        String CompanyContact=txtFldContactDetails.getText();
        String JobVacancyStatus=(String) comboBoxJobStatus.getSelectedItem();
        if (txtFldCompanyId.getText().isEmpty() || 
            CompanyName.isEmpty() || 
            CompanyLocation.isEmpty() || 
            CompanyContact.isEmpty() || 
            JobVacancyStatus == null || JobVacancyStatus.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        GetHiredModel company=new GetHiredModel(CompanyId,CompanyName,CompanyLocation,CompanyContact,JobVacancyStatus);
        addCompany(company);
          JOptionPane.showMessageDialog(this, "Company Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }}
       catch (NumberFormatException e) {
        // Handle invalid input for CompanyId (non-numeric value)
        JOptionPane.showMessageDialog(this, "Invalid Company ID. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while adding the company.", "Error", JOptionPane.ERROR_MESSAGE);
    }
       
    }//GEN-LAST:event_btnAddACompanyActionPerformed

    private void btnDeleteApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteApplicationActionPerformed
        // TODO add your handling code here:
       try{ int JobId=Integer.parseInt(txtFieldJobId.getText());
        String Name=txtFieldFullName.getText();
        if(deletedApplication(Name,JobId)==true){
            JOptionPane.showMessageDialog(this,"Application Deleted","Successful",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this,"Application Not Deleted","Not-Successful",JOptionPane.INFORMATION_MESSAGE);
        }}
        catch (NumberFormatException e) {
        // Handle invalid JobId input (non-numeric value)
        JOptionPane.showMessageDialog(this, "Invalid Job ID. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while deleting the application.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnDeleteApplicationActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnLogOutAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutAdminActionPerformed
        // TODO add your handling code here:
        loadScreen("LoginScreen");
    }//GEN-LAST:event_btnLogOutAdminActionPerformed

    private void btnDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJobActionPerformed
        try{int JobId=Integer.parseInt(txtfieldDeleteJobId.getText());
        if(deletedJob(JobId)==true){

            JOptionPane.showMessageDialog(this,"Job Deleted Successfully!!","Successful",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this,"Job Deleted Successfully!!","Successful",JOptionPane.INFORMATION_MESSAGE);
        } 
        }
        catch (NumberFormatException e) {
        // Handle invalid input for JobId
        JOptionPane.showMessageDialog(this, "Invalid Job ID. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while deleting the job.", "Error", JOptionPane.ERROR_MESSAGE);
    }
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteJobActionPerformed

    private void btnUpdateAJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAJobActionPerformed
        // TODO add your handling code here:
    try{
    int JobId=Integer.parseInt(txtFldJobId.getText()) ;
    String JobName=txtFldJobTitle.getText(); 
    String JobType=txtFldJobType.getText();
    String JobLocation=txtFldJobLocation.getText();
    int Salary=Integer.parseInt(txtFldSalary.getText());
    String Deadline=txtFldDeadline.getText();
    String Qualification=txtFldQualification.getText();
    String CompanyName=txtFldCompanyNameAddJob.getText();
    if (txtFldJobId.getText().isEmpty()||txtFldJobTitle.getText().isEmpty()||txtFldJobType.getText().isEmpty()||txtFldJobLocation.getText().isEmpty()||txtFldSalary.getText().isEmpty()
        ||txtFldDeadline.getText().isEmpty()||txtFldQualification.getText().isEmpty()||txtFldCompanyNameAddJob.getText().isEmpty()){
    JOptionPane.showMessageDialog(this,"Please Fill All The Fields,Job NOt Updated!!","NOT-Sucessful",JOptionPane.ERROR_MESSAGE);
    }
    else{
   GetHiredModel updatedjob=new GetHiredModel( JobId, JobName, JobType, JobLocation,Salary, Deadline,Qualification, CompanyName);
        updateJob(updatedjob);
        JOptionPane.showMessageDialog(this,"Job Updated!!","Sucessful",JOptionPane.INFORMATION_MESSAGE);
  
    }}
    
    catch (NumberFormatException e) {
        // Handle cases where parsing integers fails (e.g., invalid number format)
        JOptionPane.showMessageDialog(this, "Invalid input for Job ID or Salary. Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Handle any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while adding the job.", "Error", JOptionPane.ERROR_MESSAGE);
          // Print stack trace for debugging purposes
    }
    
    }//GEN-LAST:event_btnUpdateAJobActionPerformed

    private void btnUpdateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDetailsActionPerformed
        // TODO add your handling code here:
      
        try{int CompanyId=Integer.parseInt(txtFldCompanyId.getText());
        String CompanyName=txtFldCompanyName.getText();    
        String CompanyLocation=txtFldCompanyLocation.getText();
        String CompanyContact=txtFldContactDetails.getText();
        String JobVacancyStatus=(String) comboBoxJobStatus.getSelectedItem();
        if(txtFldCompanyId.getText().isEmpty()||
            txtFldCompanyName.getText().isEmpty()||
            txtFldCompanyLocation.getText().isEmpty()||
            txtFldContactDetails.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Please Enter All Fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else{
        GetHiredModel updateCompany=new GetHiredModel(CompanyId,CompanyName,CompanyLocation,CompanyContact,JobVacancyStatus);
        updateCompany(updateCompany);
        JOptionPane.showMessageDialog(this,"Company Details Updated", "Sucessful", JOptionPane.INFORMATION_MESSAGE);
        }}
         catch (NumberFormatException e) {
        // Handle invalid number input for CompanyId
        JOptionPane.showMessageDialog(this, "Invalid Company ID. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Handle any other unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred while updating the details.", "Error", JOptionPane.ERROR_MESSAGE);
         // Optionally print the stack trace for debugging
    }
    }//GEN-LAST:event_btnUpdateDetailsActionPerformed

    private void LogOutAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutAdminActionPerformed
loadScreen("LoginScreen");        // TODO add your handling code here:
    }//GEN-LAST:event_LogOutAdminActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GetHired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetHired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetHired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetHired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetHired().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Back1;
    private javax.swing.JButton BtnApplyForJob;
    private javax.swing.JButton BtnClearForm;
    private javax.swing.JComboBox<String> ComboBoxYearsOfExperience;
    private javax.swing.JLabel LblLogo;
    private javax.swing.JLabel LblLogo1;
    private javax.swing.JLabel LblLogo2;
    private javax.swing.JLabel LblLogoWelcomePage;
    private javax.swing.JButton LogOutAdmin;
    private javax.swing.JPanel PnlAddajob;
    private javax.swing.JPanel PnlApplyForJob;
    private javax.swing.JTabbedPane TbdPnlMain;
    private javax.swing.JTable TblFindACompany;
    private javax.swing.JButton btnAddACompany;
    private javax.swing.JButton btnAddAJob;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnBuildYourProfile;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnClearFormDelete;
    private javax.swing.JButton btnCreateProfile;
    private javax.swing.JButton btnDeleteApplication;
    private javax.swing.JButton btnDeleteCompany;
    private javax.swing.JButton btnDeleteJob3;
    private javax.swing.JButton btnDeleteProfile;
    private javax.swing.JButton btnFindAJob;
    private javax.swing.JButton btnFindAaCompany;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLogOut2;
    private javax.swing.JButton btnLogOutAdmin3;
    private javax.swing.JButton btnLogOutJob;
    private javax.swing.JButton btnLogOutProfile;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegisterForm;
    private javax.swing.JButton btnSortById;
    private javax.swing.JButton btnUpdateAJob;
    private javax.swing.JButton btnUpdateDetails;
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JComboBox<String> comboBoxGender;
    private javax.swing.JComboBox<String> comboBoxJobStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lablDeleteTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressRegister;
    private javax.swing.JLabel lblAdminTitle;
    private javax.swing.JLabel lblAdminTitle1;
    private javax.swing.JLabel lblAdminTitle2;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblContactNoRegister;
    private javax.swing.JLabel lblDeleteTitle4;
    private javax.swing.JLabel lblDoB;
    private javax.swing.JLabel lblDoBRegister;
    private javax.swing.JLabel lblEfucation;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailRegister;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGreeting1;
    private javax.swing.JLabel lblGreeting2;
    private javax.swing.JLabel lblGreeting3;
    private javax.swing.JLabel lblGreeting4;
    private javax.swing.JLabel lblGreeting5;
    private javax.swing.JLabel lblGreeting6;
    private javax.swing.JLabel lblGreeting7;
    private javax.swing.JLabel lblGreeting8;
    private javax.swing.JLabel lblImageWelcome;
    private javax.swing.JLabel lblJobStatus;
    private javax.swing.JLabel lblLoginPageLogo;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblLogoJob;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameRegister;
    private javax.swing.JLabel lblPasswordRegister;
    private javax.swing.JLabel lblReconfirnPaaaword;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitleApply;
    private javax.swing.JLabel lblTitleJob;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblYears;
    private javax.swing.JPanel pnlAddACompany;
    private javax.swing.JPanel pnlAddajob;
    private javax.swing.JPanel pnlAdminMain;
    private javax.swing.JPanel pnlBuildProfile;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlDeleteCompany;
    private javax.swing.JPanel pnlDeleteJob3;
    private javax.swing.JPanel pnlDeleteProfile;
    private javax.swing.JPanel pnlFindAJob;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMainBuildProfile;
    private javax.swing.JPanel pnlMainFindACompany;
    private javax.swing.JPanel pnlRegister;
    private javax.swing.JPanel pnlViewApplication;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JScrollPane scrollpaneAddJob;
    private javax.swing.JTable tblAddJob;
    private javax.swing.JTable tblViewApplication;
    private javax.swing.JTextField txtFieldAddress;
    private javax.swing.JTextField txtFieldContactNo;
    private javax.swing.JTextField txtFieldFullName;
    private javax.swing.JTextField txtFieldJobId;
    private javax.swing.JTextField txtFieldQualification;
    private javax.swing.JTextField txtFldAddress;
    private javax.swing.JTextField txtFldAddressRegister;
    private javax.swing.JTextField txtFldCompanyId;
    private javax.swing.JTextField txtFldCompanyLocation;
    private javax.swing.JTextField txtFldCompanyName;
    private javax.swing.JTextField txtFldCompanyNameAddJob;
    private javax.swing.JTextField txtFldContactDetails;
    private javax.swing.JTextField txtFldContactNo;
    private javax.swing.JTextField txtFldContactNoDelete;
    private javax.swing.JTextField txtFldContactNoRegister;
    private javax.swing.JTextField txtFldDOBRegister;
    private javax.swing.JTextField txtFldDeadline;
    private javax.swing.JTextField txtFldDeleteCompanyTitle;
    private javax.swing.JTextField txtFldDeleteJobTitle3;
    private javax.swing.JTextField txtFldDoB;
    private javax.swing.JTextField txtFldEducation;
    private javax.swing.JTextField txtFldEmail;
    private javax.swing.JTextField txtFldEmailRegister;
    private javax.swing.JTextField txtFldJobId;
    private javax.swing.JTextField txtFldJobLocation;
    private javax.swing.JTextField txtFldJobTitle;
    private javax.swing.JTextField txtFldJobType;
    private javax.swing.JTextField txtFldName;
    private javax.swing.JTextField txtFldNameDelete;
    private javax.swing.JTextField txtFldNameRegister;
    private javax.swing.JTextField txtFldQualification;
    private javax.swing.JTextField txtFldReconfirmPassword;
    private javax.swing.JTextField txtFldSalary;
    private javax.swing.JTextField txtFldpasswordRegister;
    private javax.swing.JTextField txtfieldDeleteJobId;
    private javax.swing.JTextField txtfldDeleteCompanyId;
    private javax.swing.JTextField txtfldEmail;
    private javax.swing.JPasswordField txtfldPassword;
    // End of variables declaration//GEN-END:variables
}
