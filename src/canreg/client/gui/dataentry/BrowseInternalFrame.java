/*
 * BrowseInternalFrame.java
 *
 * Created on 07 February 2008, 12:19
 */
package canreg.client.gui.dataentry;

import cachingtableapi.DistributedTableDescription;
import cachingtableapi.DistributedTableModel;
import canreg.client.DistributedTableDataSourceClient;
import canreg.common.DatabaseFilter;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author  morten
 */
public class BrowseInternalFrame extends javax.swing.JInternalFrame {

    private JDesktopPane dtp;
    private DistributedTableDescription tableDatadescription;
    private DistributedTableDataSourceClient tableDataSource;
    private DistributedTableModel tableDataModel;
    private JScrollPane resultScrollPane;
    private JTable resultTable;

    /** Creates new form BrowseInternalFrame */
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
        recordNumberTextField = new javax.swing.JTextField();
        editRecordNumberButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tableChooserComboBox = new javax.swing.JComboBox();
        refreshTableButton = new javax.swing.JButton();
        rangeFilterPanel = new canreg.client.gui.components.RangeFilterPanel();
        navigationPanel = new canreg.client.gui.components.NavigationPanel();
        variablesPanel1 = new canreg.client.gui.components.VariablesPanel();
        resultPanel = new javax.swing.JPanel();
        resultScrollPaneWiz = new javax.swing.JScrollPane();
        resultTableWiz = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(BrowseInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        buttonsPanel.setName("buttonsPanel"); // NOI18N

        createNextButton.setText(resourceMap.getString("createNextButton.text")); // NOI18N
        createNextButton.setName("createNextButton"); // NOI18N

        editTableRecordButton.setText(resourceMap.getString("editTableRecordButton.text")); // NOI18N
        editTableRecordButton.setName("editTableRecordButton"); // NOI18N

        recordNumberTextField.setText(resourceMap.getString("recordNumberTextField.text")); // NOI18N
        recordNumberTextField.setName("recordNumberTextField"); // NOI18N

        editRecordNumberButton.setText(resourceMap.getString("editRecordNumberButton.text")); // NOI18N
        editRecordNumberButton.setName("editRecordNumberButton"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        tableChooserComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Patient", "Tumour", "Both" }));
        tableChooserComboBox.setName("tableChooserComboBox"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(BrowseInternalFrame.class, this);
        refreshTableButton.setAction(actionMap.get("refresh")); // NOI18N
        refreshTableButton.setText(resourceMap.getString("refreshTableButton.text")); // NOI18N
        refreshTableButton.setName("refreshTableButton"); // NOI18N
        refreshTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableChooserComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 225, Short.MAX_VALUE)
            .addComponent(refreshTableButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tableChooserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshTableButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editRecordNumberButton, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(editTableRecordButton, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(createNextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(recordNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(createNextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTableRecordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editRecordNumberButton)
                .addGap(4, 4, 4)
                .addComponent(recordNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        rangeFilterPanel.setName("rangeFilterPanel"); // NOI18N

        navigationPanel.setName("navigationPanel"); // NOI18N

        variablesPanel1.setName("variablesPanel1"); // NOI18N

        resultPanel.setName("resultPanel"); // NOI18N

        resultScrollPaneWiz.setName("resultScrollPaneWiz"); // NOI18N

        resultTableWiz.setAutoCreateRowSorter(true);
        resultTableWiz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        resultTableWiz.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        resultTableWiz.setName("resultTableWiz"); // NOI18N
        resultScrollPaneWiz.setViewportView(resultTableWiz);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultScrollPaneWiz, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultScrollPaneWiz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rangeFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(variablesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(navigationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(variablesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(navigationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.TRAILING, 0, 254, Short.MAX_VALUE)
                    .addComponent(rangeFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        rangeFilterPanel.initValues();
        rangeFilterPanel.setDeskTopPane(dtp);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initOtherComponents() {
        resultTable = resultTableWiz;
        resultScrollPane = resultScrollPaneWiz;
        resultPanel.setVisible(false);
    }

    private void initValues() {
        // Last:
        // hook the navigationpanel up to the resulttable
        navigationPanel.setTable(resultTable);
        /* disabled
        Task task = refresh();
        task.run();
        */
    }

    private void refreshTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_refreshTableButtonActionPerformed

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
            tableName = tableChooserComboBox.getSelectedItem().toString();
            filter.setFilterString(rangeFilterPanel.getFilter());
        }
        @Override protected Object doInBackground() {
            try {
                setProgress(0, 0, 4);
                setMessage("Initiating query...");
                setProgress(1, 0, 4);

                tableDatadescription = canreg.client.CanRegClientApp.getApplication().getDistributedTableDescription(filter, tableName);

                tableDataSource = new DistributedTableDataSourceClient(tableDatadescription);
                tableDataModel = new DistributedTableModel(tableDataSource);
                setProgress(2, 0, 4);

                setMessage("Starting a new transaction...");
                rangeFilterPanel.setRecordsShown(tableDataModel.getRowCount());
                rangeFilterPanel.setRecordsTotal(tableDataModel.getRowCount());  
                setProgress(3, 0, 4);

                setMessage("Fetching data...");
                resultTable.setModel(tableDataModel);
                resultTable.setColumnSelectionAllowed(false);
                
                setProgress(4, 0, 4);
                setMessage("Finished");

            } catch (SQLException ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch(InterruptedException ignore) { }
         catch (Exception ex) {
                Logger.getLogger(BrowseInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
        }
        @Override protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            resultPanel.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton createNextButton;
    private javax.swing.JButton editRecordNumberButton;
    private javax.swing.JButton editTableRecordButton;
    private javax.swing.JPanel jPanel1;
    private canreg.client.gui.components.NavigationPanel navigationPanel;
    private canreg.client.gui.components.RangeFilterPanel rangeFilterPanel;
    private javax.swing.JTextField recordNumberTextField;
    private javax.swing.JButton refreshTableButton;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JScrollPane resultScrollPaneWiz;
    private javax.swing.JTable resultTableWiz;
    private javax.swing.JComboBox tableChooserComboBox;
    private canreg.client.gui.components.VariablesPanel variablesPanel1;
    // End of variables declaration//GEN-END:variables
    
}
