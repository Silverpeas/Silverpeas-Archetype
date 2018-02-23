#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
CREATE INDEX idx_${ClassNamePrefix} ON SC_${ClassNamePrefix} (instanceId, id);