/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dalmia.common;

import com.dalmia.app.jbpm.BPMLogic;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.model.TaskSummary;

/**
 *
 * @author manasa.t
 */
@WebServlet("/approveservlet")
public class ApproveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
                    final JPanel panel = new JPanel();
                    String query = "select Scheme_No from qd_definition_header order by QD_Definition_Header_ID desc limit 1 ";
                    JDBCConnection jdbc = new JDBCConnection();
                    List<Object[]> list = jdbc.executeSelectQuery(query);
                    Object[] obj = list.get(0);
                    String schemeNo = String.valueOf(obj[0]);
                    System.out.println("schemeNo in ApproveServlet = " + schemeNo);
                    String query1 = "update qd_definition_header set Approve_Status = 'Approved' where Scheme_No = '"+schemeNo+"'";
                    jdbc.executeUpdateQuery(query1);
                    JOptionPane.showMessageDialog(panel, "Scheme Approved successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
                    ProcessInstance processInstance = BPMLogic.startWorkflow();
                    Long processInstanceId = processInstance.getId();
                    TaskSummary taskSummary = BPMLogic.startAndCompleteTask("admin",processInstanceId);
                    processInstanceId = taskSummary.getProcessInstanceId();
                    request.setAttribute("processInstanceid",processInstanceId);        
                } catch (Exception e) {
                    System.out.println("Scheme approved succesfully");
                }
    }
    
}
