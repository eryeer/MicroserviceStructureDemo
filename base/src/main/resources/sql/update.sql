-- release.1.0.4.x mysql数据库表修改语句
USE rhine;
-- -- company_business_data -- --
DROP TABLE IF EXISTS company_business_data;
CREATE TABLE company_business_data
(
  id                 INT      AUTO_INCREMENT PRIMARY KEY,
  createDate         DATETIME DEFAULT CURRENT_TIMESTAMP                                  NOT NULL,
  updateDate         DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP      NOT NULL,
  status             VARCHAR(20)                                                         NULL,
  nextUpdateDate     DATETIME                                                            NULL,
  companyName        VARCHAR(128)                                                        NULL,
  businessLicenseNum VARCHAR(80)                                                         NOT NULL,
  companyType        VARCHAR(128)                                                        NULL,
  personName         VARCHAR(40)                                                         NULL,
  isLegPerson        INT                                                                 NULL,
  isHolder           INT                                                                 NULL,
  conRatio           INT                                                                 NULL,
  conAmount          BIGINT                                                              NULL,
  establishDate      DATETIME                                                            NULL,
  regCapital         BIGINT                                                              NULL,
  regOrg             VARCHAR(128)                                                        NULL,
  companyStatus      VARCHAR(128)                                                        NULL,
  dom                VARCHAR(400)                                                        NULL,
  opScope            VARCHAR(800)                                                        NULL,
  companyInsertTime  DATETIME                                                            NULL,
  companyUpdateTime  DATETIME                                                            NULL,
  KEY(nextUpdateDate),
  UNIQUE(businessLicenseNum)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


