#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
CREATE TABLE SC_${ClassNamePrefix} (
  id             VARCHAR(40) PRIMARY KEY,
  instanceId     VARCHAR(30) NOT NULL,
  createDate     DATETIME    NOT NULL,
  createdBy      VARCHAR(40) NOT NULL,
  lastUpdateDate DATETIME    NOT NULL,
  lastUpdatedBy  VARCHAR(40) NOT NULL,
  version        BIGINT      NOT NULL
);