/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srg.data;

import java.sql.Connection;

import ComUtil.DatabaseConnection;


public class JAVa_DB {
    
    public static void main(String[] args){
        Connection conn = DatabaseConnection.getConnection();
        
        if (conn!=null){
            System.out.println("DatabaseConnection Success");
        }else{
            System.out.println("DatabaseConnection Fail");
        }
        
        
    }
    
}
