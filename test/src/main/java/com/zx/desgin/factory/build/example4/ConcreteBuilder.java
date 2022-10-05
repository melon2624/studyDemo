package com.zx.desgin.factory.build.example4;

/**
 * @author zhangxin
 * @date 2022/8/29 17:45
 */
public class ConcreteBuilder {

    private String contractId;
    private String personName;
    private String companyName;
    private long beginDate;
    private long endDate;
    private String otherData;

    /**
     * 构造方法，传入必须要有的参数
     *
     * @param contractId 保险合同编号
     * @param beginDate  保险开始生效的日期
     * @param endDate    保险失效的日期
     */
    public ConcreteBuilder(String contractId, long beginDate, long endDate) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    /**
     * 选填数据，被保险人员的名称
     *
     * @param personName 被保险人员的名称
     * @return 构建器对象
     */
    public ConcreteBuilder setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    /**
     * 选填数据，被保险公司的名称
     *
     * @param companyName 被保险公司的名称
     * @return 构建器对象
     */
    public ConcreteBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ConcreteBuilder setOtherData(String otherData) {
        this.otherData = otherData;
        return this;
    }

    public InsuranceContract build() {
        return new InsuranceContract(this);
    }


    public String getContractId() {
        return contractId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public long getBeginDate() {
        return beginDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public String getOtherData() {
        return otherData;
    }
}
