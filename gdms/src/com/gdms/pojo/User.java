package com.gdms.pojo;

public class User {
    private Integer id;

    private String workId;

    private String password;

    private String major;

    private String introduction;

    private Integer grade;

    private String name;

    private String jobtitle;

    private Integer amount;

    private Integer issueId;
    
    private Integer type;
    
    private Integer total;

	private static final int TEACHER=1;
	private static final int LEADER=4;//院领导
	private static final int DIRECTOR=2;//系主任
    
    public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }
	public boolean havePermission(int permission)
	{
		int tmp=this.type&permission;
		if(tmp==permission)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean haveTeacherPermission()
	{
		return havePermission(TEACHER);
	}
	public boolean haveLeaderPermission()
	{
		return havePermission(LEADER);
	}
	public boolean haveDirectorPermission()
	{
		return havePermission(DIRECTOR);
	}
	public boolean isStudent()
	{
		if(this.type==8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}