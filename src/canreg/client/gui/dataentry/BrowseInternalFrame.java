/*
 * BrowseInternalFrame.java
 *
 * Created on 07 February 2008, 12:19
 */
package canreg.client.gui.dataentry;

import cachingtableapi.DistributedTableDescription;
import cachingtableapi.DistributedTableModel;
import canreg.client.CanRegClientApp;
import canreg.client.DistributedTableDataSourceClient;
import canreg.client.gui.CanRegClientView;
import canreg.client.gui.tools.XTableColumnModel;
import canreg.common.DatabaseFilter;
import canreg.common.Globals;
import canreg.server.database.DatabaseRecord;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author  morten
 */
public class BrowseInternalFrame extends javax.swing.JInternalFrame implements ActionListener {

    private JDesktopPane dtp;
    private DistributedTableDescription tableDatadescription;
    private DistributedTableDataSourceClient tableDataSource;
    private TableModel tableDataModel;
    private JScrollPane resultScrollPane;
    private JTable resultTable = new JTable();
    private XTableColumnModel tableColumnModel;
    private LinkedList<String> variablesToShow;

    /** Creates new form BrowseInternalFrame
     * @param dtp 
     */
    public BrowseInternalFrame(JDesktopPane dtp) {
        this.dtp = dtp;
        initComponents();
        initOtherComponents();
        initValues();
    }
    ///
    // org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new java.util.List(), jTable1);
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonsPanel = new javax.swing.JPanel();
        createNextButton = new javax.swing.JButton();
        editTableRecordButton = new javax.swing.JButton();
        patientNumberTextField = new javax.swing.JTextField();
        editPatientNumberButton = new javax.swing.JButton();
        tumourNumberTextField = new javax.swing.JTextField();
        editTumourNumberButton = new javax.swing.JButton();
        rangeFilterPanel = new canreg.client.gui.components.RangeFilterPanel();
        navigationPanel = new canreg.client.gui.components.NavigationPanel();
        variablesPanel = new canreg.client.gui.components.VariablesPanel();
        resultPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(BrowseInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                browserClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        buttonsPanel.setName("buttonsPanel"); // NOI18N

        createNextButton.setText(resourceMap.getString("createNextButton.text")); // NOI18N
        createNextButton.setName("createNextButton"); // NOI18N

        editTableRecordButton.setText(resourceMap.getString("editTableRecordButton.text")); // NOI18N
        editTableRecordButton.setName("editTableRecordButton"); // NOI18N

        patientNumberTextField.setText(resourceMap.getString("patientNumberTextField.text")); // NOI18N
        patientNumberTextField.setName("patientNumberTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(BrowseInternalFrame.class, this);
        editPatientNumberButton.setAction(actionMap.get("editPatientID")); // NOI18N
        editPatientNumberButton.setName("editPatientNumberButton"); // NOI18N

        tumourNumberTextField.setName("tumourNumberTextField"); // NOI18N

        editTumourNumberButton.setAction(actionMap.get("editTumourID")); // NOI18N
        editTumourNumberButton.setName("editTumourNumberButton"); // NOI18N

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTableRecordButton, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(createNextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addGroup(buttonsPanelLayout.createSequentialGroup()
                        .addComponent(editPatientNumberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                    .addGroup(buttonsPanelLayout.createSequentialGroup()
                        .addComponent(editTumourNumberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tumourNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(createNextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTableRecordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPatientNumberButton)
                    .addComponent(patientNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTumourNumberButton)
                    .addComponent(tumourNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );

        rangeFilterPanel.setName("rangeFilterPanel"); // NOI18N

        navigationPanel.setName("navigationPanel"); // NOI18N

        variablesPanel.setName("variablesPanel"); // NOI18N

        resultPanel.setName("resultPanel"); // NOI18N

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resultPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rangeFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(navigationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(variablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rangeFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.LEADING, 0, 258, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(variablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(navigationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        rangeFilterPanel.initValues();
        rangeFilterPanel.setDeskTopPane(dtp);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initOtherComponents() {

        resultScrollPane = canreg.common.LazyViewport.createLazyScrollPaneFor(resultTable);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
                resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(resultScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE));
        resultPanelLayout.setVerticalGroup(
                resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(resultScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE));

        resultScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        resultTable.setColumnSelectionAllowed(true);
        resultPanel.setVisible(false);

        resultTable.setName("resultTable"); // NOI18N
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rowClicked(evt);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                columnTableMousePressed(evt);
            }
        });

    }

    private void initValues() {
        // Last:
        // hook the navigationpanel up to the resulttable
        navigationPanel.setTable(resultTable);
        rangeFilterPanel.setActionListener(this);
        variablesPanel.setDatabaseVariables(CanRegClientApp.getApplication().getGlobalToolBox().getVariables());
    // Task task = refresh();
    // task.run();
    // rangeFilterPanel.setRecordsTotal(tableDataModel.getRowCount());
    }

private void browserClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_browserClosed
    rangeFilterPanel.close();
    if (tableDatadescription != null) {
        try {
            CanRegClientApp.getApplication().releaseResultSet(tableDatadescription.getResultSetID());
        } catch (SecurityException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_browserClosed

private void rowClicked(java.awt.event.MouseEvent evt) {                            
        String referenceTable;
       
    if (evt.getClickCount() == 2) {
        JTable target = (JTable) evt.getSource();
        int rowNumber = target.getSelectedRow();
        TableModel model = target.getModel();
        int columnNumber = 0; 
        String lookUpVariable;
        if (rangeFilterPanel.getSelectedTable().equalsIgnoreCase(Globals.PATIENT_TABLE_NAME)){
            lookUpVariable = "ID";
            referenceTable = Globals.PATIENT_TABLE_NAME;
        } else {
            lookUpVariable = "REGNO";
            referenceTable = Globals.TUMOUR_TABLE_NAME;
        } 
        columnNumber = tableColumnModel.getColumnIndex(lookUpVariable, false);
        editRecord(""+tableDataModel.getValueAt(rowNumber,
            columnNumber), referenceTable);
    }
}

private void columnTableMousePressed(java.awt.event.MouseEvent evt) {
    if (evt.getButton()== java.awt.event.MouseEvent.BUTTON3){
        JTable target =(JTable) evt.getSource();
        int columnNumber = target.getSelectedColumn();

        JPopupMenu jpm = new JPopupMenu(""+columnNumber);
        jpm.add("Column "+tableColumnModel.getColumn(tableColumnModel.getColumnIndexAtX(evt.getX()), true).getHeaderValue());
        jpm.show(target, evt.getX(), evt.getY());
    }
}
/**
 * 
 * @return
 */
@Action
    public Task refresh() {
        navigationPanel.goToTopAction();
        resultPanel.setVisible(false);
        return new RefreshTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class RefreshTask extends org.jdesktop.application.Task<Object, Void> {
        String tableName = null;
        DatabaseFilter filter = new DatabaseFilter();
        
        
        RefreshTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to RefreshTask fields, here.
            super(app);
            tableName = rangeFilterPanel.getSelectedTable();
            variablesToShow = variablesPanel.getVariablesToShow(tableName);
            filter.setFilterString(rangeFilterPanel.getFilter().trim());
            filter.setSortByVariable(rangeFilterPanel.getSortByVariable().trim());
            tableDataSource = null;
        }
        @Override protected Object doInBackground() {
            try {
                setProgress(0, 0, 4);
                setMessage("Initiating query...");
                setProgress(1, 0, 4);
                System.out.println(Runtime.getRuntime().freeMemory()+" free memory.");
                // release old resultSet
                if (tableDatadescription!=null){
                    CanRegClientApp.getApplication().releaseResultSet(tableDatadescription.getResultSetID());
                }
                tableDatadescription = canreg.client.CanRegClientApp.getApplication().getDistributedTableDescription(filter, tableName);
                System.out.println(Runtime.getRuntime().freeMemory()+" free memory.");
                
                tableDataSource = new DistributedTableDataSourceClient(tableDatadescription);
                System.out.println(Runtime.getRuntime().freeMemory()+" free memory.");
                
                tableDataModel = new DistributedTableModel(tableDataSource); 
                // tableDataModel = new PagingTableModel(tableDataSource);
                
                System.out.println(Runtime.getRuntime().freeMemory()+" free memory.");
                setProgress(2, 0, 4);

                setMessage("Starting a new transaction...");
                rangeFilterPanel.setRecordsShown(tableDataModel.getRowCount());
                 
                setProgress(3, 0, 4);

                setMessage("Fetching data...");               
                resultTable.setColumnSelectionAllowed(false);
                resultTable.setModel(tableDataModel);
                tableColumnModel = new XTableColumnModel();
                resultTable.setColumnModel(tableColumnModel);
                resultTable.createDefaultColumnsFromModel();
                System.out.println(Runtime.getRuntime().freeMemory()+" free memory.");
                
                setProgress(4, 0, 4);
                setMessage("Finished");
                
                updateVariablesShown();
                
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(rootPane, "Not a valid filter.", "Error", JOptionPane.ERROR_MESSAGE);
                return "Not valid";
            } catch (RemoteException ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch(InterruptedException ignore) { }
         catch (Exception ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            return "OK";
        }
        @Override protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            boolean theResult = result.equals("OK");
            resultPanel.setVisible(theResult);
        }
    }

       private void hideSystemVariables() {
                TableColumn column;
                try{
                    column = tableColumnModel.getColumnByModelIndex(
                         tableColumnModel.getColumnIndex("ID"));
                    tableColumnModel.setColumnVisible(column, false);
                } catch (IllegalArgumentException iae){
                    //OK
                }
                try{
                    column = tableColumnModel.getColumnByModelIndex(
                         tableColumnModel.getColumnIndex("NEXT_RECORD_DB_ID"));
                    tableColumnModel.setColumnVisible(column, false);
                } catch (IllegalArgumentException iae){
                    //OK
                }
                try{
                    column = tableColumnModel.getColumnByModelIndex(
                         tableColumnModel.getColumnIndex("LAST_RECORD_DB_ID"));
                    tableColumnModel.setColumnVisible(column, false);
                } catch (IllegalArgumentException iae){
                    //OK
                }                    
        }
       
    private void updateVariablesShown(){
          String tableName = rangeFilterPanel.getSelectedTable();
          variablesToShow = variablesPanel.getVariablesToShow(tableName);
          // first set all invisible
          Enumeration<TableColumn> tcs = tableColumnModel.getColumns(false);
          while(tcs.hasMoreElements()){
                TableColumn column  = tcs.nextElement();
                tableColumnModel.setColumnVisible(column,variablesToShow.contains(column.getHeaderValue().toString()));               
          }
    }
    
    /**
     * 
     */
    @Action
    public void editPatientID() {
         editPatientID(patientNumberTextField.getText().trim());
     }

    /**
     * 
     * @param idString
     */
    public void editPatientID(String idString){
        String tableName = Globals.PATIENT_TABLE_NAME;
                
        RecordEditor recordEditor = new RecordEditor(dtp);
        recordEditor.setDocument(CanRegClientApp.getApplication().getDatabseDescription());
        recordEditor.setDictionary(CanRegClientApp.getApplication().getDictionary());
        DatabaseRecord record = null;        
        DatabaseFilter filter = new DatabaseFilter();
        filter.setFilterString("ID ="+idString+"");
        DistributedTableDescription distributedTableDescription;
        Object[][] rows;
        DatabaseRecord[] tumourRecords;
        
        try {
            distributedTableDescription = CanRegClientApp.getApplication().getDistributedTableDescription(filter, Globals.TUMOUR_TABLE_NAME);
            int numberOfRecords = distributedTableDescription.getRowCount();
            rows = CanRegClientApp.getApplication().retrieveRows(distributedTableDescription.getResultSetID(), 0, numberOfRecords);
            CanRegClientApp.getApplication().releaseResultSet(distributedTableDescription.getResultSetID());
            String[] columnNames = distributedTableDescription.getColumnNames();
            int ids[] = new int[numberOfRecords];
            boolean found = false;
            int idColumnNumber = 0;
            while (!found && idColumnNumber<columnNames.length){
                found = columnNames[idColumnNumber++].equalsIgnoreCase("ID");
            }
            if (found){
                idColumnNumber--;
                for (int j=0; j<numberOfRecords;j++){
                    ids[j]=(Integer) rows[j][idColumnNumber];
                    record = CanRegClientApp.getApplication().getRecord(ids[j], Globals.PATIENT_TABLE_NAME);
                    recordEditor.addRecord(record);
                    tumourRecords = CanRegClientApp.getApplication().getRecordsFromOtherTableBasedOnID(ids[j]+"", Globals.PATIENT_TABLE_NAME);
                    for (DatabaseRecord rec : tumourRecords){
                        recordEditor.addRecord(rec);
                    }
                }
                CanRegClientView.showAndCenterInternalFrame(dtp, recordEditor);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * 
     */
    @Action
    public void editTumourID() {
        editTumourID(tumourNumberTextField.getText().trim());
    }
    
    /**
     * 
     * @param idString
     */
    public void editTumourID(String idString) {
        
        RecordEditor recordEditor = new RecordEditor(dtp);
        recordEditor.setDocument(CanRegClientApp.getApplication().getDatabseDescription());
        recordEditor.setDictionary(CanRegClientApp.getApplication().getDictionary());
        DatabaseRecord record = null;        
        DatabaseFilter filter = new DatabaseFilter();
        filter.setFilterString("REGNO ='"+idString+"'");
        Object[][] rows;
        DatabaseRecord[] tumourRecords;
        
        try {
            DistributedTableDescription distributedTableDescription = CanRegClientApp.getApplication().getDistributedTableDescription(filter, Globals.TUMOUR_TABLE_NAME);
            int numberOfRecords = distributedTableDescription.getRowCount();
            rows = CanRegClientApp.getApplication().retrieveRows(distributedTableDescription.getResultSetID(),0, numberOfRecords);
            CanRegClientApp.getApplication().releaseResultSet(distributedTableDescription.getResultSetID());
            String[] columnNames = distributedTableDescription.getColumnNames();
            int ids[] = new int[numberOfRecords];
            boolean found = false;
            int idColumnNumber = 0;
            while (!found && idColumnNumber<columnNames.length){
                found = columnNames[idColumnNumber++].equalsIgnoreCase("ID");
            }

            if (found){
                idColumnNumber--;
                for (int j=0; j<numberOfRecords;j++){
                    ids[j]=(Integer) rows[j][idColumnNumber];
                    record = CanRegClientApp.getApplication().getRecord(ids[j], Globals.TUMOUR_TABLE_NAME);
                    recordEditor.addRecord(record);
                    
                    tumourRecords = CanRegClientApp.getApplication().getRecordsFromOtherTableBasedOnID(ids[j]+"", Globals.TUMOUR_TABLE_NAME);
                    for (DatabaseRecord rec : tumourRecords){
                        recordEditor.addRecord(rec);
                    }
                }
                CanRegClientView.showAndCenterInternalFrame(dtp, recordEditor);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Variable not found...", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * 
     * @param idString
     * @param tableName
     */
    public void editRecord(String idString, String tableName) {
        if (tableName.equalsIgnoreCase(Globals.TUMOUR_TABLE_NAME)){
            editTumourID(idString);
        } else {
            editPatientID(idString);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton createNextButton;
    private javax.swing.JButton editPatientNumberButton;
    private javax.swing.JButton editTableRecordButton;
    private javax.swing.JButton editTumourNumberButton;
    private canreg.client.gui.components.NavigationPanel navigationPanel;
    private javax.swing.JTextField patientNumberTextField;
    private canreg.client.gui.components.RangeFilterPanel rangeFilterPanel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JTextField tumourNumberTextField;
    private canreg.client.gui.components.VariablesPanel variablesPanel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        if ("refresh".equalsIgnoreCase(e.getActionCommand())){
            Task refreshTask = refresh();
            refreshTask.execute();
        }
    }
    
}
