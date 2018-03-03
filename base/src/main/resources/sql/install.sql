DROP DATABASE IF EXISTS rhine;
CREATE DATABASE rhine
  DEFAULT CHARSET = utf8
  COLLATE utf8_general_ci;
USE rhine;

DROP TABLE IF EXISTS company_info;
CREATE TABLE company_info
(
  id                                  INT      AUTO_INCREMENT PRIMARY KEY,
  createDate                          DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate                          DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status                              VARCHAR(20)                                                    NULL,

  businessLicenseNum                  VARCHAR(80)                                                    NOT NULL,
  accountOpenBank                     VARCHAR(36)                                                    NULL,
  SCEName                             VARCHAR(128)                                                   NULL,
  accountName                         VARCHAR(128)                                                   NULL,
  account                             VARCHAR(128)                                                   NULL,

  companyType                         VARCHAR(128)                                                   NOT NULL,
  remark                              VARCHAR(4000)                                                  NULL,

  businessLicenseFileID               VARCHAR(128)                                                   NULL,
  bankAccountCertificateFileID        VARCHAR(128)                                                   NULL,
  organizationCreditCertificateFileID VARCHAR(128)                                                   NULL,
  authorizationCreditInquiryFileID    VARCHAR(128)                                                   NULL,
  legalRepresentativeIDFileID         VARCHAR(128)                                                   NULL,
  financialReportFileID               VARCHAR(128)                                                   NULL,
  constitutionID                      VARCHAR(128)                                                   NULL,
  confirmDate                         DATETIME                                                       NULL,
  CONSTRAINT company_info_businessLicenseNum_uindex
  UNIQUE (businessLicenseNum)
);

DROP TABLE IF EXISTS company_info_Archive;
CREATE TABLE company_info_Archive
(
  id                 INT      AUTO_INCREMENT PRIMARY KEY,
  createDate         DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate         DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status             VARCHAR(20)                                                    NULL,

  businessLicenseNum VARCHAR(80)                                                    NOT NULL,
  SCEName            VARCHAR(128)                                                   NULL,
  companyType        VARCHAR(128)                                                   NOT NULL


);


DROP TABLE IF EXISTS logincode;
CREATE TABLE logincode
(
  id                 INT      AUTO_INCREMENT PRIMARY KEY,
  createDate         DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate         DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status             VARCHAR(20)                                                    NULL,

  businessLicenseNum VARCHAR(80)                                                    NULL,
  phoneNum           CHAR(11)                                                       NULL,
  code               CHAR(6)                                                        NULL,
  type               VARCHAR(20)                                                    NULL

);

DROP EVENT IF EXISTS e_clean_logincode;
CREATE EVENT e_clean_logincode
  ON SCHEDULE EVERY 1 MINUTE DO DELETE FROM logincode
WHERE type = 'login' AND (UNIX_TIMESTAMP(CURRENT_TIMESTAMP) - UNIX_TIMESTAMP(createDate)) > 60;


DROP TABLE IF EXISTS spreckeyinfo;
CREATE TABLE spreckeyinfo
(
  id          INT      AUTO_INCREMENT PRIMARY KEY,
  createDate  DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate  DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status      VARCHAR(20)                                                    NULL,

  companyType INT                                                            NOT NULL,
  recprivkey  VARCHAR(900)                                                   NULL,
  recpubkey   VARCHAR(300)                                                   NULL,
  enc         BLOB                                                           NULL,
  phoneNum    CHAR(11)                                                       NULL
);

DROP TABLE IF EXISTS user_key_info;
CREATE TABLE user_key_info
(
  id                 INT      AUTO_INCREMENT PRIMARY KEY,
  createDate         DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate         DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status             VARCHAR(20)                                                    NULL,

  companyId          INT                                                            NOT NULL,
  Tag                VARCHAR(30)                                                    NULL,
  pubKey             VARCHAR(255)                                                   NULL,
  pubkeyBrief        VARCHAR(255)                                                   NULL,
  pubKeySigned       VARCHAR(255)                                                   NULL,
  businessLicenseNum VARCHAR(80)                                                    NOT NULL,
  role1              VARCHAR(30)                                                    NOT NULL,
  role2              VARCHAR(30)                                                    NULL,
  phoneNum           CHAR(11)                                                       NULL,
  isRegConfirmed     INT      DEFAULT 0                                             NULL,
  CONSTRAINT user_key_info_phoneNum_uindex
  UNIQUE (pubKeySigned)
);


DROP TABLE IF EXISTS tbl_operator_log;
CREATE TABLE tbl_operator_log
(
  id           INT      AUTO_INCREMENT PRIMARY KEY,
  createDate   DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status       VARCHAR(20)                                                    NULL,

  logId        VARCHAR(255)                                                   NULL,
  pubKeySigned VARCHAR(255)                                                   NULL,
  title        VARCHAR(255)                                                   NULL,
  opertype     VARCHAR(5)                                                     NULL,
  params       BLOB                                                           NULL,
  remoteAddr   VARCHAR(255)                                                   NULL,
  requestUri   VARCHAR(255)                                                   NULL,
  method       VARCHAR(255)                                                   NULL,
  --   operateTime TIMESTAMP     NULL,
  --   endTime     TIMESTAMP     NULL,
  details      VARCHAR(4000)                                                  NULL
);


DROP TABLE IF EXISTS COUMaturityDate;
CREATE TABLE COUMaturityDate
(
  id         INT      AUTO_INCREMENT PRIMARY KEY,
  createDate DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status     VARCHAR(20)                                                    NULL,

  dueDay     INT                                                            NULL
);

DROP TABLE IF EXISTS contract_info;
CREATE TABLE contract_info
(
  id                        INT      AUTO_INCREMENT PRIMARY KEY,
  createDate                DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate                DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status                    VARCHAR(20)                                                    NULL,

  contractID                VARCHAR(60)                                                    NOT NULL,
  contractName              VARCHAR(100)                                                   NOT NULL,
  fromSCEBusinessLicenseNum VARCHAR(80)                                                    NOT NULL,
  toSCEBusinessLicenseNum   VARCHAR(80)                                                    NOT NULL,
  toSCEName                 VARCHAR(60)                                                    NOT NULL,
  contractStartDate         DATETIME                                                       NOT NULL,
  contractEndDate           DATETIME                                                       NULL,
  --   uploadDate                DATETIME                                                       NOT NULL,
  contractFileID            VARCHAR(60)                                                    NULL,
  CONSTRAINT contract_info_contractID_uindex
  UNIQUE (contractID),
  KEY(fromSCEBusinessLicenseNum),
  KEY(toSCEBusinessLicenseNum),
  KEY(updateDate)
);

DROP TABLE IF EXISTS IVActive;
CREATE TABLE IVActive
(
  id            INT      AUTO_INCREMENT PRIMARY KEY,
  createDate    DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status        VARCHAR(20)                                                    NULL,

  pubKeySigned  VARCHAR(255)                                                   NOT NULL,
  IVAddress     VARCHAR(64)                                                    NOT NULL,
  encryptIV     BLOB                                                           NOT NULL,

  IVBrief         VARCHAR(255)                                                   NOT NULL,
  IVSigned        VARCHAR(255)                                                   NOT NULL,
  warningBrief    VARCHAR(255)                                                   NULL,
  warningSigned   VARCHAR(255)                                                   NULL,
  role            VARCHAR(30)                                                    NOT NULL,
  contractID      VARCHAR(60)                                                    NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL,
  UNIQUE (pubKeySigned, IVAddress)
);
DROP TABLE IF EXISTS IVActive_Temp;
CREATE TABLE IVActive_Temp
(
  id              INT      AUTO_INCREMENT PRIMARY KEY,
  createDate      DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status          VARCHAR(20)                                                    NULL,

  pubKeySigned    VARCHAR(255)                                                   NOT NULL,
  IVAddress       VARCHAR(64)                                                    NOT NULL,
  encryptIV       BLOB                                                           NOT NULL,

  IVBrief         VARCHAR(255)                                                   NOT NULL,
  IVSigned        VARCHAR(255)                                                   NOT NULL,
  warningBrief    VARCHAR(255)                                                   NULL,
  warningSigned   VARCHAR(255)                                                   NULL,
  datasource      VARCHAR(80)                                                    NULL, #front/backend
  role            VARCHAR(30)                                                    NOT NULL,
  contractID      VARCHAR(60)                                                    NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL
);


DROP TABLE IF EXISTS IVArchive;
CREATE TABLE IVArchive
(
  id              INT      AUTO_INCREMENT PRIMARY KEY,
  createDate      DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status          VARCHAR(20)                                                    NULL,

  pubKeySigned    VARCHAR(255)                                                   NOT NULL,
  IVAddress       VARCHAR(64)                                                    NOT NULL,
  encryptIV       BLOB                                                           NOT NULL,

  IVBrief         VARCHAR(255)                                                   NOT NULL,
  IVSigned        VARCHAR(255)                                                   NOT NULL,
  warningBrief    VARCHAR(255)                                                   NULL,
  warningSigned   VARCHAR(255)                                                   NULL,
  role            VARCHAR(30)                                                    NOT NULL,
  contractID      VARCHAR(60)                                                    NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL,
  INDEX IVAddress_pubKeySigned(IVAddress,pubKeySigned),
  KEY(pubKeySigned),
  KEY(IVAddress),
  KEY(createDate),
  KEY(updateDate)
);

DROP TABLE IF EXISTS IVCancel;
CREATE TABLE IVCancel
(
  id              INT      AUTO_INCREMENT PRIMARY KEY,
  createDate      DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status          VARCHAR(20)                                                    NULL,

  pubKeySigned    VARCHAR(255)                                                   NOT NULL,
  IVAddress       VARCHAR(64)                                                    NOT NULL,
  encryptIV       BLOB                                                           NOT NULL,

  IVBrief         VARCHAR(255)                                                   NOT NULL,
  IVSigned        VARCHAR(255)                                                   NOT NULL,
  role            VARCHAR(30)                                                    NOT NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL
);

DROP TABLE IF EXISTS file_info;
CREATE TABLE file_info
(
  id         INT      AUTO_INCREMENT PRIMARY KEY,
  createDate DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status     VARCHAR(20)                                                    NULL,

  fileOwner  VARCHAR(64)                                                    NULL,
  fileName   VARCHAR(255)                                                   NOT NULL,
  fileData   LONGBLOB                                                       NOT NULL
);
-- COU
DROP TABLE IF EXISTS COUActive;
CREATE TABLE COUActive
(
  id              INT      AUTO_INCREMENT PRIMARY KEY,
  createDate      DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status          VARCHAR(20)                                                    NULL,

  pubKeySigned    VARCHAR(255)                                                   NOT NULL,
  COUAddress      VARCHAR(64)                                                    NOT NULL,
  encryptCOU      BLOB                                                           NOT NULL,

  COUBrief        VARCHAR(255)                                                   NOT NULL,
  COUSigned       VARCHAR(255)                                                   NOT NULL,
  amount          BIGINT                                                         NULL,
  remark          VARCHAR(255)                                                   NULL,
  DFCAmount       BIGINT                                                         NULL,
  warningBrief    VARCHAR(255)                                                   NULL,
  warningSigned   VARCHAR(255)                                                   NULL,
  protocolFileId  INT                                                            NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL,
  UNIQUE (pubKeySigned, COUAddress)
);

DROP TABLE IF EXISTS COUActive_Temp;
CREATE TABLE COUActive_Temp
(
  id              INT      AUTO_INCREMENT PRIMARY KEY,
  createDate      DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status          VARCHAR(20)                                                    NULL,

  pubKeySigned    VARCHAR(255)                                                   NOT NULL,
  COUAddress      VARCHAR(64)                                                    NOT NULL,
  encryptCOU      BLOB                                                           NOT NULL,

  COUBrief        VARCHAR(255)                                                   NOT NULL,
  COUSigned       VARCHAR(255)                                                   NOT NULL,
  amount          BIGINT                                                         NULL,
  remark          VARCHAR(255)                                                   NULL,
  DFCAmount       BIGINT                                                         NULL,
  datasource      VARCHAR(80)                                                    NULL, #front/backend
  warningBrief    VARCHAR(255)                                                   NULL,
  warningSigned   VARCHAR(255)                                                   NULL,
  protocolFileId  INT                                                            NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL
);


DROP TABLE IF EXISTS COUArchive;
CREATE TABLE COUArchive
(
  id              INT      AUTO_INCREMENT PRIMARY KEY,
  createDate      DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status          VARCHAR(20)                                                    NULL,

  pubKeySigned    VARCHAR(255)                                                   NOT NULL,
  COUAddress      VARCHAR(64)                                                    NOT NULL,
  encryptCOU      BLOB                                                           NOT NULL,

  COUBrief        VARCHAR(255)                                                   NOT NULL,
  COUSigned       VARCHAR(255)                                                   NOT NULL,
  amount          BIGINT                                                         NULL,
  remark          VARCHAR(255)                                                   NULL,
  DFCAmount       BIGINT                                                         NULL,

  warningBrief    VARCHAR(255)                                                   NULL,
  warningSigned   VARCHAR(255)                                                   NULL,
  protocolFileId  INT                                                            NULL,
  pubKeySignedSrc VARCHAR(255)                                                   NULL,
  INDEX COUAddress_pubKeySigned(COUAddress,pubKeySigned),
  KEY(pubKeySigned),
  KEY(COUAddress),
  KEY(createDate),
  KEY(updateDate)
);
-- -- regulation_info -- --
DROP TABLE IF EXISTS regulation_info;
CREATE TABLE regulation_info
(
  id               INT      AUTO_INCREMENT PRIMARY KEY,
  createDate       DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status           VARCHAR(20)                                                    NULL,
  pubKeySigned     VARCHAR(255)                                                   NOT NULL,
  regulation       BLOB                                                           NOT NULL,
  regulationBrief  VARCHAR(255)                                                   NOT NULL,
  regulationSigned VARCHAR(255)                                                   NOT NULL
);

-- -- OnProcess -- --
DROP TABLE IF EXISTS OnProcess;
CREATE TABLE OnProcess
(
  id         INT      AUTO_INCREMENT PRIMARY KEY,
  createDate DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status     VARCHAR(20)                                                    NULL,

  callingAPI VARCHAR(30)                                                    NOT NULL,
  data       JSON                                                           NOT NULL,
  remark     VARCHAR(255)                                                   NULL,
  processTag VARCHAR(40)                                                    NULL,
  key(status)
);

-- -- CompanyDRActive -- --
DROP TABLE IF EXISTS CompanyDRActive;
CREATE TABLE CompanyDRActive
(
  id                   INT      AUTO_INCREMENT PRIMARY KEY,
  createDate           DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate           DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status               VARCHAR(20)                                                    NULL,

  businessLicenseNum   VARCHAR(80)                                                    NOT NULL,
  drBaseValue          BIGINT                                                         NULL,
  drShiftRange         BIGINT                                                         NULL,
  drShiftRate          BIGINT                                                         NULL,
  drFinalValue         BIGINT                                                         NULL,
  fiBusinessLicenseNum VARCHAR(80)                                                    NULL,

  UNIQUE (businessLicenseNum,fiBusinessLicenseNum)
);

-- -- CompanyDRArchive -- --
DROP TABLE IF EXISTS CompanyDRArchive;
CREATE TABLE CompanyDRArchive
(
  id                   INT      AUTO_INCREMENT PRIMARY KEY,
  createDate           DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate           DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status               VARCHAR(20)                                                    NULL,

  businessLicenseNum   VARCHAR(80)                                                    NOT NULL,
  fiBusinessLicenseNum VARCHAR(80)                                                    NULL,
  drBaseValue          BIGINT                                                         NULL,
  drShiftRange         BIGINT                                                         NULL,
  drShiftRate          BIGINT                                                         NULL,
  drFinalValue         BIGINT                                                         NULL,
  KEY(businessLicenseNum),
  KEY(fiBusinessLicenseNum),
  KEY(status),
  KEY(createDate),
  KEY(updateDate)
);

-- -- FIUpdateCQLog -- --
DROP TABLE IF EXISTS FIUpdateCQLog;
CREATE TABLE FIUpdateCQLog
(
  id           INT      AUTO_INCREMENT PRIMARY KEY,
  createDate   DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status       VARCHAR(20)                                                    NULL,

  pubKeySigned VARCHAR(255)                                                   NOT NULL,
  cqAdjust     LONG                                                           NOT NULL,
  cqSigned     VARCHAR(255)                                                   NOT NULL
);

-- -- DFCAgreeement -- --
DROP TABLE IF EXISTS DFCAgreement;
CREATE TABLE DFCAgreement
(
  id           INT      AUTO_INCREMENT PRIMARY KEY,
  createDate   DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status       VARCHAR(20)                                                    NULL,

  DFCAgreement VARCHAR(8196)                                                 NOT NULL,
  DFCAgreementHtml VARCHAR(10240)                                             NOT NULL,
  snTime       DATETIME                                                       NOT NULL,
  snBrief      VARCHAR(255)                                                   NOT NULL,
  snSigned     VARCHAR(255)                                                   NOT NULL,

  cTime        DATETIME                                                       NULL,
  cBrief       VARCHAR(255)                                                   NULL,
  cSigned      VARCHAR(255)                                                   NULL,

  fiTime       DATETIME                                                       NULL,
  fiBrief      VARCHAR(255)                                                   NULL,
  fiSigned     VARCHAR(255)                                                   NULL

);

-- -- EmailList -- --
DROP TABLE IF EXISTS EmailList;
CREATE TABLE EmailList
(
  id               INT      AUTO_INCREMENT PRIMARY KEY,
  createDate       DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updateDate       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  status           VARCHAR(20)                                                    NULL,
  operation VARCHAR(50)                                                           NOT NULL,
  email VARCHAR(50)                                                               NOT NULL,
  subject VARCHAR(50)                                                             NOT NULL,
  message VARCHAR(255)                                                            NOT NULL
);

-- -- CFList -- --
DROP TABLE IF EXISTS CFList;
CREATE TABLE CFList
(
  id           INT      AUTO_INCREMENT PRIMARY KEY,
  createDate   DATETIME DEFAULT CURRENT_TIMESTAMP                                  NOT NULL,
  updateDate   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP      NOT NULL,
  status       VARCHAR(20)                                                         NULL,

  pubKeySigned VARCHAR(255)                                                        NOT NULL,
  IVAddress    VARCHAR(64)                                                         NOT NULL,
  amount       BIGINT                                                              NOT NULL,

  UNIQUE (pubKeySigned, IVAddress)
);

-- -- company_business_data -- --
DROP TABLE IF EXISTS company_business_data;
CREATE TABLE company_business_data
(
  id                 INT      AUTO_INCREMENT PRIMARY KEY,
  createDate         DATETIME DEFAULT CURRENT_TIMESTAMP                                  NOT NULL,
  updateDate         DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP      NOT NULL,
  status             VARCHAR(20)                                                         NULL,
  nextUpdateDate     DATETIME                                                            NULL,
  companyName        VARCHAR(128)                                                        NOT NULL,
  businessLicenseNum VARCHAR(80)                                                         NULL,
  regNO              VARCHAR(80)                                                         NULL,
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
  UNIQUE(companyName)
);

