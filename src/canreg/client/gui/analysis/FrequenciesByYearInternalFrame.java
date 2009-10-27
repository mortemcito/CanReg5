/*
 * FrequenciesByYearInternalFrame.java
 *
 * Created on 06 August 2008, 16:03
 */
package canreg.client.gui.analysis;

import cachingtableapi.DistributedTableDescription;
import cachingtableapi.DistributedTableModel;
import canreg.client.CanRegClientApp;
import canreg.client.DistributedTableDataSourceClient;
import canreg.client.gui.CanRegClientView;
import canreg.common.DatabaseFilter;
import canreg.common.DatabaseVariablesListElement;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author  ervikm
 */
public class FrequenciesByYearInternalFrame extends javax.swing.JInternalFrame implements ActionListener {

    private DistributedTableDescription tableDatadescription;
    private DistributedTableDataSourceClient tableDataSource;
    private DistributedTableModel tableDataModel;
    private JDesktopPane dtp;
    private TableColumnModel tableColumnModel;
    private Set<DatabaseVariablesListElement> chosenVariables;
    private String tableName = null;
    private DistributedTableDescription tableDatadescriptionPopUp;
    private static int MAX_ENTRIES_DISPLAYED_ON_RIGHT_CLICK = 20;
    private TableInternalFrame tableInternalFrame;

    /** Creates new form FrequenciesByYearInternalFrame
     * @param dtp 
     */
    public FrequenciesByYearInternalFrame(JDesktopPane dtp) {
        this.dtp = dtp;
        initComponents();
        initOtherComponents();

        addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                close();
            }
        });
    }

    public void close() {
        tableInternalFrame.dispose();
        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rangeFilterPanel = new canreg.client.gui.components.RangeFilterPanel();
        variablesChooserPanel = new canreg.client.gui.components.VariablesChooserPanel();
        jButton1 = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        popOutTableButton = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(FrequenciesByYearInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        rangeFilterPanel.setName("rangeFilterPanel"); // NOI18N

        variablesChooserPanel.setName("variablesChooserPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(FrequenciesByYearInternalFrame.class, this);
        jButton1.setAction(actionMap.get("printTableAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        resultPanel.setName("resultPanel"); // NOI18N

        resultScrollPane.setName("resultScrollPane"); // NOI18N

        resultTable.setAutoCreateRowSorter(true);
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        resultTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        resultTable.setName("resultTable"); // NOI18N
        resultScrollPane.setViewportView(resultTable);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );

        popOutTableButton.setAction(actionMap.get("popOutTableAction")); // NOI18N
        popOutTableButton.setName("popOutTableButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resultPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rangeFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(popOutTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                            .addComponent(variablesChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rangeFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(variablesChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(popOutTableButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        rangeFilterPanel.initValues();
        rangeFilterPanel.setDeskTopPane(dtp);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton popOutTableButton;
    private canreg.client.gui.components.RangeFilterPanel rangeFilterPanel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTable resultTable;
    private canreg.client.gui.components.VariablesChooserPanel variablesChooserPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     * @return
     */
    @Action
    public Task refresh() {
        // navigationPanel.goToTopAction();
        resultScrollPane.setVisible(false);
        return new RefreshTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class RefreshTask extends org.jdesktop.application.Task<Object, Void> {

        DatabaseFilter filter = new DatabaseFilter();
        DistributedTableDescription newTableDatadescription = null;

        RefreshTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to RefreshTask fields, here.
            super(app);
            tableName = rangeFilterPanel.getSelectedTable();
            filter.setFilterString(rangeFilterPanel.getFilter().trim());
            filter.setRange(rangeFilterPanel.getRange());
            filter.setQueryType(DatabaseFilter.QueryType.FREQUENCIES_BY_YEAR);
            chosenVariables = variablesChooserPanel.getSelectedVariables();
            filter.setDatabaseVariables(chosenVariables);
        }

        @Override
        protected Object doInBackground() {

            String result = "OK";
            try {
                newTableDatadescription = canreg.client.CanRegClientApp.getApplication().getDistributedTableDescription(filter, tableName);
                Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.INFO, Runtime.getRuntime().freeMemory() + " free memory.");
            } catch (SQLException ex) {
                result = "Not valid";
            } catch (RemoteException ex) {
                Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                result = "Remote exception";
            } catch (SecurityException ex) {
                Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                result = "Security exception";
            } catch (InterruptedException ignore) {
                result = "Ignore";
            } catch (Exception ex) {
                Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                result = "Not OK";
            }
            return result;
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            boolean theResult = result.equals("OK");
            if (theResult) {

                // release old resultSet
                if (tableDatadescription != null) {
                    try {
                        CanRegClientApp.getApplication().releaseResultSet(tableDatadescription.getResultSetID());
                    } catch (SecurityException securityException) {
                        // TODO: Add handler
                    } catch (RemoteException remoteException) {
                        // TODO: Add handler
                    }
                }
                tableDataSource = null;

                tableDatadescription = newTableDatadescription;

                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.INFO, Runtime.getRuntime().freeMemory() + " free memory.");

                if (tableDatadescription != null) {
                    try {
                        tableDataSource = new DistributedTableDataSourceClient(tableDatadescription);
                    } catch (Exception ex) {
                        Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.INFO, Runtime.getRuntime().freeMemory() + " free memory.");
                }


                if (tableDataSource != null) {
                    try {
                        tableDataModel = new DistributedTableModel(tableDataSource);
                        // tableDataModel = new PagingTableModel(tableDataSource);
                        resultTable.setModel(tableDataModel);
                        tableColumnModel = resultTable.getColumnModel();
                        Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.INFO, Runtime.getRuntime().freeMemory() + " free memory.");
                        // setProgress(2, 0, 4);
                        resultTable.setColumnSelectionAllowed(false);
                        setProgress(4, 0, 4);
                        setMessage(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/FrequenciesByYearInternalFrame").getString("FINISHED"));
                        resultTable.setVisible(true);
                        resultScrollPane.setVisible(true);
                        resultScrollPane.revalidate();
                        resultScrollPane.repaint();
                        resultPanel.revalidate();
                        resultPanel.repaint();
                        resultPanel.setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else if (result.equals("Not valid")) {
                JOptionPane.showInternalMessageDialog(rootPane, java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/FrequenciesByYearInternalFrame").getString("NOT_A_VALID_FILTER."), java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/FrequenciesByYearInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            } else {
                Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, result);
            }
        }
    }

    private void initOtherComponents() {
        rangeFilterPanel.setActionListener(this);
        rangeFilterPanel.setTableChooserVisible(false);
        rangeFilterPanel.setRecordPanelvisible(false);
        rangeFilterPanel.setSortByVariableShown(false);
        resultScrollPane.setVisible(false);
        variablesChooserPanel.initPanel();
        tableInternalFrame = new TableInternalFrame();

        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // rowClicked(evt);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rowTableMousePressed(evt);
            }
        });
    }

    private void columnTableMousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            JTable target = (JTable) evt.getSource();
            int columnNumber = target.getSelectedColumn();

            JPopupMenu jpm = new JPopupMenu("" + columnNumber);
            jpm.add("Column " + tableColumnModel.getColumn(tableColumnModel.getColumnIndexAtX(evt.getX())).getHeaderValue());
            jpm.show(target, evt.getX(), evt.getY());
        }
    }

    private void rowTableMousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            showPopUpMenu(0, evt);
        }

    }

    /**
     * 
     * @param offset
     * @param evt
     */
    public void showPopUpMenu(int offset, java.awt.event.MouseEvent evt) {
        JTable target = (JTable) evt.getSource();
        int rowNumber = target.rowAtPoint(new Point(evt.getX(), evt.getY()));
        rowNumber = target.convertRowIndexToModel(rowNumber);

        JPopupMenu jpm = new JPopupMenu();
        jpm.add(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/FrequenciesByYearInternalFrame").getString("SHOW_IN_BROWSER"));
        TableModel tableModel = target.getModel();
        // resultTable.get
        // jpm.add("Column " + rowNumber +" " + tableColumnModel.getColumn(tableColumnModel.getColumnIndexAtX(evt.getX())).getHeaderValue());
        int year = Integer.parseInt((String) tableModel.getValueAt(rowNumber, 0));

        String filterString = "INCID >= '" + year * 10000 + "' AND INCID <'" + (year + 1) * 10000+"'";

        for (DatabaseVariablesListElement dvle : chosenVariables) {
            int columnNumber = tableColumnModel.getColumnIndex(dvle.getDatabaseVariableName().toUpperCase());
            String value = tableModel.getValueAt(rowNumber, columnNumber).toString();
            filterString += " AND " + dvle.getDatabaseVariableName().toUpperCase() + " = " + dvle.getSQLqueryFormat(value);
        }
        DatabaseFilter filter = new DatabaseFilter();
        filter.setFilterString(filterString);
        Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.INFO, "FilterString: " + filterString);
        try {
            tableDatadescriptionPopUp = canreg.client.CanRegClientApp.getApplication().getDistributedTableDescription(filter, tableName);
            Object[][] rows = canreg.client.CanRegClientApp.getApplication().retrieveRows(tableDatadescriptionPopUp.getResultSetID(), 0, MAX_ENTRIES_DISPLAYED_ON_RIGHT_CLICK);
            String[] variableNames = tableDatadescriptionPopUp.getColumnNames();
            for (Object[] row : rows) {
                String line = "";
                int i = 0;
                for (Object obj : row) {
                    if (obj != null) {
                        line += variableNames[i] + ": " + obj.toString() + ", ";
                    }
                    i++;
                }
                jpm.add(line);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrequenciesByYearInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        int cases = (Integer) tableModel.getValueAt(rowNumber, tableColumnModel.getColumnIndex("CASES"));
        if (MAX_ENTRIES_DISPLAYED_ON_RIGHT_CLICK < cases) {
            jpm.add("...");
        }
        MenuItem menuItem = new MenuItem();

        jpm.show(target, evt.getX(), evt.getY());
    }

    public void actionPerformed(ActionEvent e) {
        if ("refresh".equalsIgnoreCase(e.getActionCommand())) {
            Task refreshTask = refresh();
            refreshTask.execute();
        }
    }

    /**
     * 
     */
    @Action
    public void printTableAction() {
        try {
            if (!resultTable.print(JTable.PrintMode.NORMAL,
                    new MessageFormat(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/FrequenciesByYearInternalFrame").getString("CANREG_FREQUENCIES_BY_YEAR") + " - " + rangeFilterPanel.getFilter()),
                    null)) {
                System.err.println("User cancelled printing");
            }
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }

    @Action
    public void popOutTableAction() {
        resultScrollPane.setVisible(false);
        resultScrollPane = tableInternalFrame.setResultTable(resultTable);
        CanRegClientView.showAndCenterInternalFrame(dtp, tableInternalFrame);
        popOutTableButton.setEnabled(false);
    }
}
