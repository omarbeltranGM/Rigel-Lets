package com.movilidad.utils;

import java.io.Serializable;
import javax.sql.DataSource;

/**
 *
 * @author alexander
 */

public class UtilityDataSource implements Serializable{
    
    private transient javax.sql.DataSource dataSource;
    
   
    
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    
}
